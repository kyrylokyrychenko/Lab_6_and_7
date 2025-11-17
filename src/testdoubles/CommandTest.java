package testdoubles;

import commands.Command;

public class CommandTest implements Command {

    public boolean executed = false;
    public String desc;

    public CommandTest(String desc) {
        this.desc = desc;
    }

    @Override
    public void execute() {
        executed = true;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
