package core;

import core.modifyingCommands.*;
import core.Editor;
import core.Switch;
import core.queryingCommands.LatestCommand;

import java.util.Scanner;

public class Main {
    public static Switch mySwitch;
    public static void main(String[] args) {
        Editor editor = new Editor("012345");

        mySwitch = new core.Switch();
        mySwitch.registerCommand("A", new AddToTailMCommand());
        mySwitch.registerCommand("a", new AddToHeadMCommand());
        mySwitch.registerCommand("D", new DeleteOnTail());
        mySwitch.registerCommand("d", new DeleteOnHead());

        mySwitch.registerCommand("l", new LatestCommand());
//        mySwitch.registerCommand();

        Scanner scanner = new Scanner(System.in);
        String instruction;
        while(true){
            instruction = scanner.nextLine();
            if (!instruction.equals(""))
                mySwitch.execute(instruction);
        }
    }
}
