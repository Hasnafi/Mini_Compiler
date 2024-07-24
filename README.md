Functioning of the Interpreter:
---

The user enters their program line by line (a line is called a command line). A command line cannot contain more than one command and cannot be written across multiple lines. When the user presses the enter key on the keyboard, the entered command line is analyzed by the interpreter. If it contains no errors, the interpreter returns the execution result. This result can be:
- Displaying "ok" if the instruction is a let command
- Displaying the value of a variable or a mathematical expression in the case of a print command
- In the case where the command line contains an error, an error message is displayed to the user specifying the type of error made
