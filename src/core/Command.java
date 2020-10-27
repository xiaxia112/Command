package core;

public interface Command {
    void setOperator(String instruction);

    String execute();

//    Command clone();
}
