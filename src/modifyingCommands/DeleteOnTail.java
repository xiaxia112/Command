package modifyingCommands;

public class DeleteOnTail implements MCommand {
    private int operator;

    public void setOperator(String operator) {
        this.operator = Integer.parseInt(operator);
    }

    @Override
    public String execute() {
        return editor.deleteOnTail(operator);
    }

    @Override
    public String toString() {
        return "D " + operator;
    }
}
