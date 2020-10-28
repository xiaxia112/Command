package core;




import modifyingCommands.MCommand;
import queryingCommands.UndoCommand;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Switch {
    private final HashMap<String, Command> commandMap = new HashMap<>();
    private final ArrayList<StateNode> stateNodesList = new ArrayList<>();
    private StateNode currentNode;
    public static final Editor editor = new Editor();

    /* Caution! the arrayList contains a security head.
     * */
    public Switch() {//Caution! the arrayList contains a security head.
        currentNode = new StateNode("", new UndoCommand());
        stateNodesList.add(currentNode);
    }



    public void registerCommand(String commandName, Command Command) {
        commandMap.put(commandName, Command);
    }

    public void execute(String instruction) {
        if (instruction.charAt(0) == '$')
            instruction = instruction.substring(1);
        String[] instructions = instruction.split(" ");
        Command command = commandMap.get(instructions[0]);
        if (null == command) {
            Logger.getLogger(Switch.class.getName()).log(
                    Level.WARNING, "NO command registered for " + instructions[0]);
            displayCurrentStr();
            return;
        } else if (instructions.length > 1) {
            try {
                command = command.getClass().getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                Logger.getLogger(Switch.class.getName()).log(
                        Level.WARNING, "Inflection failed");
                System.exit(-1);
            }
            command.setOperator(instruction.substring(2));
        }
        // for a A d D l m_set


        String strState = command.execute();

        if (command instanceof MCommand) {
            StateNode tempNode = new StateNode(strState, command);
            int currentPos = stateNodesList.indexOf(currentNode);
            //only push modifying MCommand
            stateNodesList.add(currentPos + 1, tempNode);
            currentNode = tempNode;
            displayCurrentStr();
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

    public HashMap<String, Command> getCommandMap() {
        return commandMap;
    }

    private void displayCurrentStr() {
        System.out.println(currentNode.getStrState());
    }
}
