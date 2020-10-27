package core;




import modifyingCommands.MCommand;
import queryingCommands.UndoCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Switch {
    public static final Editor editor0 = new Editor();
    private final HashMap<String, Command> commandMap = new HashMap<>();
    public static final Editor editor = new Editor();

    public Switch() {
        stateNodesList.add(new StateNode("", new UndoCommand()));
    }

    private final ArrayList<StateNode> stateNodesList = new ArrayList<>();

    private StateNode currentNode;

    public void registerCommand(String commandName, Command Command) {
        commandMap.put(commandName, Command);
    }

    public void execute(String instruction) {
        String[] instructions = instruction.split(" ");

        Command command = commandMap.get(instructions[0]);

        if(null == command) {
            Logger.getLogger(Switch.class.getName()).log(
                   Level.WARNING ,"NO command registered for " + instructions[0]);
            return;
        }
        //TODO u, r and m
        if (instructions.length > 1)
            command.setOperator(instructions[1]);

        String strState = command.execute();

        if (command instanceof MCommand) {
            currentNode = new StateNode(strState, command);
            stateNodesList.add(currentNode);//TODO only push modifying MCommand
        }
    }

    public ArrayList<StateNode> getStateNodesList() {
        return stateNodesList;
    }


    public StateNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(StateNode currentNode) {
        this.currentNode = currentNode;
    }

}
