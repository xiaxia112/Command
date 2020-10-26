package commands;

import core.Editor;

public interface Command {
    Editor editor = new Editor();
    void setOperator(String operator);
    void execute();
}
