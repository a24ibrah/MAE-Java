# Self-Learning Tic-Tac-Toe Agents

## Overview
This project implements reinforcement learning agents that learn to play Tic-Tac-Toe using Q-learning. The agents train by playing against each other and improve their strategies over time.

## Features
- **Reinforcement Learning**: Uses Q-learning for self-improvement.
- **Game Environment**: A fully functional Tic-Tac-Toe game implemented in Java.
- **Training & Simulation**: Agents learn from experience and optimize their gameplay.
- **Customizable Parameters**: Learning rate, discount factor, and exploration rate can be adjusted.

## Prerequisites
- Java Development Kit (JDK) 11 or higher.
- A terminal or command prompt.
- A text editor or an IDE (e.g., IntelliJ IDEA, Eclipse, VS Code).

## Project Structure
```
tic-tac-toe/
├── src/
│   ├── TicTacToe.java
│   ├── LearningAgent.java
│   └── GameSimulator.java
└── README.md
```

## How to Compile and Run

### Using Command Line
```bash
javac src/*.java -d bin/
java -cp bin GameSimulator
```

### Using an IDE
1. **IntelliJ IDEA**
   - Create a new Java project.
   - Copy the Java files into the `src` directory.
   - Run `GameSimulator.java`.
2. **Eclipse**
   - Create a new Java project.
   - Copy the Java files into the `src` directory.
   - Right-click `GameSimulator.java` → Run As → Java Application.
3. **VS Code**
   - Install "Extension Pack for Java".
   - Open the project folder.
   - Click Run → Run Without Debugging.

## Customizing Training
Modify training parameters in `GameSimulator.java`:
```java
for (int episode = 0; episode < 10000; episode++) {
    // Training logic
}
```

## Troubleshooting
- **"javac not found" error**: Ensure Java is installed and added to the system's PATH.
- **"could not find or load main class" error**: Check that the compiled class files are in the correct directory.
- **Memory issues**: Increase Java heap size:
  ```bash
  java -Xmx512m -cp bin GameSimulator
  ```

## Future Improvements
- Implement a neural network for function approximation.
- Add a graphical user interface for visual interaction.
- Save and load Q-values for persistence.

## License
This project is open-source and licensed under the MIT License.

## Author
[Your Name] - Passionate about AI and machine learning.

---

Feel free to contribute or experiment with different parameters to improve the learning process!

