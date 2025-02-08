class GameSimulator {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        LearningAgent agentX = new LearningAgent('X', 0.1, 0.9, 0.3);
        LearningAgent agentO = new LearningAgent('O', 0.1, 0.9, 0.3);

        System.out.println("Training phase started...");
        for (int episode = 0; episode < 10000; episode++) {
            game.reset();
            playGame(game, agentX, agentO, true);

            if (episode % 1000 == 0) {
                agentX.decreaseExplorationRate(0.95);
                agentO.decreaseExplorationRate(0.95);
            }
        }
        System.out.println("Training completed!");

        System.out.println("\nTest phase - Playing learned strategy:");
        game.reset();
        playGame(game, agentX, agentO, false);
    }

    private static void playGame(TicTacToe game, LearningAgent agentX, LearningAgent agentO, boolean training) {
        while (true) {
            if (!training) {
                game.displayBoard();
            }

            String currentState = game.getBoardState();
            LearningAgent currentAgent = (game.getCurrentPlayer() == 'X') ? agentX : agentO;

            int move = currentAgent.chooseAction(game);
            game.makeMove(move);

            char opponent = (currentAgent.getSymbol() == 'X') ? 'O' : 'X';
            if (game.checkWin(currentAgent.getSymbol())) {
                if (!training) {
                    game.displayBoard();
                    System.out.println("Player " + currentAgent.getSymbol() + " wins!");
                }
                if (training) {
                    currentAgent.learn(currentState, move, 1.0, game.getBoardState());
                }
                break;
            } else if (game.checkWin(opponent)) {
                if (!training) {
                    game.displayBoard();
                    System.out.println("Player " + opponent + " wins!");
                }
                if (training) {
                    currentAgent.learn(currentState, move, -1.0, game.getBoardState());
                }
                break;
            } else if (game.isBoardFull()) {
                if (!training) {
                    game.displayBoard();
                    System.out.println("It's a draw!");
                }
                if (training) {
                    currentAgent.learn(currentState, move, 0.5, game.getBoardState());
                }
                break;
            }

            if (training) {
                currentAgent.learn(currentState, move, 0.1, game.getBoardState());
            }
        }
    }
}
