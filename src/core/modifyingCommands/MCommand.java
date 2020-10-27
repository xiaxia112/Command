package core.modifyingCommands;

import core.Command;
import core.Editor;

public interface MCommand extends Command {
    Editor editor = new Editor();

//    void setOperator(String operator);
//    String execute();
    String toString();
}