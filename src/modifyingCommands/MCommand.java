package modifyingCommands;

import core.Command;
import core.Editor;

public interface MCommand extends Command {
    Editor editor = new Editor();

}