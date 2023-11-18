package Commands;

import java.util.Stack;

public class displayUndoRedoCommand implements Command {
    private Stack<Command> undos, redos;
    private Stack<Command> tempStack = new Stack<>();

    public displayUndoRedoCommand(Stack<Command> undos, Stack<Command> redos) {
        this.undos = undos;
        this.redos = redos;
    }

    public void execute() {

        System.out.println("Undo List");
        // Transfer items from input stack to temporary stack
        while (!undos.isEmpty()) {
            tempStack.push(undos.pop());
        }

        // Print items from temporary stack (in reverse order)
        while (!tempStack.isEmpty()) {
            Command item = tempStack.pop();
            System.out.println(item);
            undos.push(item);
        }
        System.out.println("-- End of undo list --\nRedo List");
        // Transfer items from input stack to temporary stack
        while (!redos.isEmpty()) {
            tempStack.push(redos.pop());
        }

        // Print items from temporary stack (in reverse order)
        while (!tempStack.isEmpty()) {
            Command item = tempStack.pop();
            System.out.println(item);
            redos.push(item);
        }
        System.out.println("-- End of redo list --");
    }

    public void undo() {

    }

    public void redo() {

    }

    public String toString() {
        return null;
    }

}
