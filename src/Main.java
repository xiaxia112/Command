import commands.*;
import core.Editor;
import core.Switch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor("012345");

        Switch mySwitch = new core.Switch();
        mySwitch.register("A", new AddToTailCommand());
        mySwitch.register("a", new AddToHeadCommand());
        mySwitch.register("D", new DeleteOnTail());
        mySwitch.register("d", new DeleteOnHead());

        Scanner scanner = new Scanner(System.in);
        String[] instruction;
        while(true){
            instruction = scanner.nextLine().split(" ");
            if (instruction[0].equals(""))
                continue;
            mySwitch.execute(instruction[0], instruction[1]);
        }
    }
}
