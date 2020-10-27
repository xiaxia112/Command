package queryingCommands;

import core.StateNode;
import modifyingCommands.MCommand;

import java.util.logging.Level;
import java.util.logging.Logger;

import static core.Main.mySwitch;

public class UndoCommand implements QCommand {
    @Override
    public void setOperator(String instruction) {
        //Empty Body
    }

    @Override
    public String execute() {
        StateNode currentNode = mySwitch.getCurrentNode();
        int index = mySwitch.getStateNodesList().indexOf(currentNode);

        if (index == 0)
            Logger.getLogger(UndoCommand.class.getName()).log(Level.INFO, "No command to undo");
        else {
            currentNode = mySwitch.getStateNodesList().get(index -1);

            mySwitch.setCurrentNode(currentNode);

            String currentStr = currentNode.getStrState();
            MCommand.editor.setS(currentStr);
            System.out.println(currentStr);
        }

        return "";
    }
}
