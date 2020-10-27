package core.modifyingCommands;

public class AddToTailMCommand implements MCommand {
    private String operator;

    public void setOperator(String operator) {
        this.operator = operator.replaceAll("\"", "");
    }

    @Override
    public String execute() {
        return editor.addToTail(operator);
    }

    @Override
    public String toString() {
        return "A " + operator;
    }

}
