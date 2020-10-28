package queryingCommands;

import core.Command;
import core.StateNode;
import modifyingCommands.MacroCommand;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static core.Main.mySwitch;


public class MergeCommand implements QCommand {
    private int count;
    private String commandName;

    @Override
    public void setOperator(String instruction) {
        String[] instructions = instruction.split(" ");
        count = Integer.parseInt(instructions[0]);
        commandName = instructions[1];
    }

    @Override
    public String execute() {
        if (mySwitch.getCommandMap().containsKey(commandName)) {
            Logger.getLogger(MergeCommand.class.getName()).log(
                    Level.WARNING, "Conflict macroCommand name");
            return "";
        }

        StateNode currentNode = mySwitch.getCurrentNode();
        ArrayList<StateNode> stateNodesList = mySwitch.getStateNodesList();
        int currentPos = stateNodesList.indexOf(currentNode);
        count = Math.min(currentPos, count);

        Command[] macroCommands = new Command[count];
        //from head to tail
        for (int i = 0; i < count; i++) {
            macroCommands[i] = stateNodesList.get(currentPos - count + i + 1).getCommand();
        }

        mySwitch.registerCommand(commandName, new MacroCommand(macroCommands, commandName));
        return "";
    }

    public String toString() {
        return commandName;
    }
}
