package core;




import core.modifyingCommands.MCommand;

import java.util.ArrayList;
import java.util.HashMap;


public class Switch {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    //    private final HashMap<String, QCommand> qCommandMap = new HashMap<>();
    private final ArrayList<StateNode> stateNodesList = new ArrayList<>();

    public void registerCommand(String commandName, Command Command) {
        commandMap.put(commandName, Command);
    }

//    public void registerQueryingCommand(String commandName, QCommand QCommand) {
//        qCommandMap.put(commandName, QCommand);
//    }

    public void execute(String instruction) {
        String[] instructions = instruction.split(" ");

        Command command = commandMap.get(instructions[0]);

        if(null == command)
            throw new IllegalStateException("NO core.modifyingCommands registered for " + instructions[0]);
        //TODO u, r, l and m
        command.setOperator(instructions[1]);
        String strState = command.execute();
//        if (command.getClass().isAssignableFrom(MCommand.class))
        if (command instanceof MCommand)
            stateNodesList.add(new StateNode(strState, command));


        //statesNodesList.add(MCommand);//TODO only push modifying MCommand
    }

    public ArrayList<StateNode> getStateNodesList() {
        return stateNodesList;
    }
}
