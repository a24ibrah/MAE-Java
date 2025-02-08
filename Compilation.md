# Compilation Instructions

## **Project Structure**
Ensure your project is structured as follows:
```
tic-tac-toe/
├── src/
│   ├── TicTacToe.java
│   ├── LearningAgent.java
│   ├── GameSimulator.java
└── README.md
```

---

## **1. Compilation Using Command Line (Terminal or Command Prompt)**

### **Step 1: Navigate to the Project Directory**
Open a terminal or command prompt and move to the project folder:
```bash
cd path/to/tic-tac-toe
```

### **Step 2: Compile All Java Files**
Run the following command to compile all Java files:
```bash
javac src/*.java -d bin/
```
This will generate `.class` files inside a `bin/` directory.

### **Step 3: Run the Game**
Execute the following command to run the `GameSimulator` class:
```bash
java -cp bin GameSimulator
```

---

## **2. Compilation Using an IDE (IntelliJ IDEA, Eclipse, VS Code)**

### **Option 1: IntelliJ IDEA**
1. Open IntelliJ IDEA.
2. Click **File** → **New** → **Project**.
3. Select **Java** and create the project.
4. Copy `TicTacToe.java`, `LearningAgent.java`, and `GameSimulator.java` into the `src/` directory.
5. Click the **Run** button or press `Shift + F10`.

### **Option 2: Eclipse**
1. Open Eclipse.
2. Click **File** → **New** → **Java Project**.
3. Name your project and create it.
4. Copy the `.java` files into the `src/` directory.
5. Right-click `GameSimulator.java` → **Run As** → **Java Application**.

### **Option 3: VS Code**
1. Install the **Java Extension Pack** from the VS Code marketplace.
2. Open the project folder in VS Code.
3. Copy the Java files into the `src/` directory.
4. Click **Run** → **Run Without Debugging** or press `Ctrl + F5`.

---

## **3. Troubleshooting**

### **"javac not found" error**
- Ensure Java is installed by running:
  ```bash
  java -version
  javac -version
  ```
- If not installed, download and install [JDK 11+](https://adoptopenjdk.net/).
- Add Java to the system's `PATH` variable.

### **"Could not find or load main class" error**
- Make sure you're in the correct project directory.
- Ensure `-cp bin` is specified when running the program.

### **Out of Memory Error**
- Increase Java heap size:
  ```bash
  java -Xmx512m -cp bin GameSimulator
  ```

---

## **4. Customizing the Training**
Modify training parameters in `GameSimulator.java`:
```java
for (int episode = 0; episode < 10000; episode++) {
    // Training logic
}
```

---

This setup ensures your Tic-Tac-Toe AI agents can train and improve their strategies effectively. Let me know if you have any issues! 🚀

