import java.util.*;

class LearningAgent {
    private Map<String, Map<Integer, Double>> qTable;
    private double learningRate;
    private double discountFactor;
    private double explorationRate;
    private char symbol;
    private Random random;

    public LearningAgent(char symbol, double learningRate, double discountFactor, double explorationRate) {
        this.symbol = symbol;
        this.learningRate = learningRate;
        this.discountFactor = discountFactor;
        this.explorationRate = explorationRate;
        this.qTable = new HashMap<>();
        this.random = new Random();
    }

    public int chooseAction(TicTacToe game) {
        String state = game.getBoardState();
        List<Integer> availableMoves = game.getAvailableMoves();

        if (random.nextDouble() < explorationRate) {
            return availableMoves.get(random.nextInt(availableMoves.size()));
        }

        return getBestMove(state, availableMoves);
    }

    private int getBestMove(String state, List<Integer> availableMoves) {
        Map<Integer, Double> stateValues = qTable.computeIfAbsent(state, k -> new HashMap<>());
        double bestValue = Double.NEGATIVE_INFINITY;
        int bestMove = availableMoves.get(0);

        for (int move : availableMoves) {
            double value = stateValues.getOrDefault(move, 0.0);
            if (value > bestValue) {
                bestValue = value;
                bestMove = move;
            }
        }

        return bestMove;
    }

    public void learn(String state, int action, double reward, String nextState) {
        Map<Integer, Double> stateValues = qTable.computeIfAbsent(state, k -> new HashMap<>());
        Map<Integer, Double> nextStateValues = qTable.computeIfAbsent(nextState, k -> new HashMap<>());

        double oldValue = stateValues.getOrDefault(action, 0.0);
        double nextMax = nextStateValues.values().stream().mapToDouble(v -> v).max().orElse(0.0);

        double newValue = oldValue + learningRate * (reward + discountFactor * nextMax - oldValue);
        stateValues.put(action, newValue);
    }

    public void decreaseExplorationRate(double factor) {
        explorationRate *= factor;
    }

    public char getSymbol() {
        return symbol;
    }
}
