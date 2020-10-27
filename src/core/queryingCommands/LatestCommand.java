package core.queryingCommands;

import core.StateNode;

import java.util.ArrayList;
import static core.Main.mySwitch;

public class LatestCommand implements QCommand{
    int operator;
    @Override
    public void setOperator(String operator) {
        this.operator = Integer.parseInt(operator);
    }

    @Override
    public String execute() {
        ArrayList<StateNode> stateNodesList = mySwitch.getStateNodesList();
        int length = stateNodesList.size();
        operator = Math.min(length, operator);
        for (int i = 1; i <= operator; i++)
            System.out.println(i + " " + stateNodesList.get(length - i).getCommand().toString());
        return "";
    }
}
