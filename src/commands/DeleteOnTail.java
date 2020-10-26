package commands;

public class DeleteOnTail implements Command {
    private int operator;

    public void setOperator(String operator) {
        this.operator = Integer.parseInt(operator);
    }

    @Override
    public void execute() {
        editor.deleteOnTail(operator);
    }
}
