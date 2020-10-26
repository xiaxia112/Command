package commands;

public class AddToTailCommand implements Command {
    private String operator;

    public void setOperator(String operator) {
        this.operator = operator.replaceAll("\"", "");
    }

    @Override
    public void execute() {
        editor.addToTail(operator);
    }
}
