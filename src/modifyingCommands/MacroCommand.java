package modifyingCommands;

import core.Command;

public class MacroCommand implements MCommand {
    private final Command[] commands;
    private final String commandName;

    public MacroCommand(Command[] commands, String commandName) {
        this.commands = commands;
        this.commandName = commandName;
    }

    @Override
    public void setOperator(String instruction) {
        //Empty Body
    }

    @Override
    public String execute() {
        String tempStrState = "";
        for (Command command : commands) {
            tempStrState = command.execute();//state lost
        }
        return tempStrState;
    }

    public String toString() {
        return commandName;
    }
}
