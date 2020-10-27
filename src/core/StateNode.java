package core;

public class StateNode {
    private String strState;
    private Command command;

    public StateNode(String strState, Command command) {
        this.strState = strState;
        this.command = command;
    }

    public String getStrState() {
        return strState;
    }

    public void setStrState(String strState) {
        this.strState = strState;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }


}
