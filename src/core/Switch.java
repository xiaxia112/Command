package core;

import commands.Command;

import java.util.HashMap;

public class Switch {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void execute(String commandName, String operator){
        Command command = commandMap.get(commandName);
        command.setOperator(operator);

        if(null == command)
            throw new IllegalStateException("no commands registered for " + commandName);
        command.execute();
    }
}
