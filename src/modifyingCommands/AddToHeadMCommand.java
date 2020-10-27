package modifyingCommands;

public class AddToHeadMCommand implements MCommand {
    private String operator;

    public void setOperator(String operator) {
        this.operator = operator.replaceAll("\"", "");
    }

    @Override
    public String execute() {
        return editor.addToHead(operator);
    }

    @Override
    public String toString() {
        return "a " + operator;
    }
}
