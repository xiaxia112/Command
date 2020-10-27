package core;

import modifyingCommands.*;
import queryingCommands.*;

import java.util.Scanner;

public class Main {
    public static Switch mySwitch;

    public static void main(String[] args) {
        mySwitch = new core.Switch();
        mySwitch.registerCommand("A", new AddToTailMCommand());
        mySwitch.registerCommand("a", new AddToHeadMCommand());
        mySwitch.registerCommand("D", new DeleteOnTailCommand());
        mySwitch.registerCommand("d", new DeleteOnHeadCommand());

        mySwitch.registerCommand("l", new LatestCommand());
        mySwitch.registerCommand("u", new UndoCommand());
        mySwitch.registerCommand("r", new RedoCommand());

        Scanner scanner = new Scanner(System.in);
        String instruction;
        while(true){
            instruction = scanner.nextLine();
            if (!instruction.equals(""))
                mySwitch.execute(instruction);
        }
    }
}
