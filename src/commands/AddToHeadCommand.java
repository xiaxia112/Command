package commands;

public class AddToHeadCommand implements Command {
    private String operator;

    public void setOperator(String operator) {
        this.operator = operator.replaceAll("\"", "");
    }

    @Override
    public void execute() {
        editor.addToHead(operator);
    }
}
