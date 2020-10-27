package modifyingCommands;

public class DeleteOnHeadCommand implements MCommand {
    private int operator;

    public void setOperator(String operator) {
        this.operator = Integer.parseInt(operator);
    }

    @Override
    public String execute() {
        return editor.deleteOnHead(operator);
    }

    @Override
    public String toString() {
        return "d " + operator;
    }

}
