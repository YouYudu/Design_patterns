package command;

import java.util.ArrayList;

public class Waitor {
    private ArrayList<Command> commands;
    public Waitor() {
        commands = new ArrayList<>();
    }

    public void setCommand(Command command) {
        this.commands.add(command);
    }

    public void orderUp() {
        System.out.println("叮咚，大厨，新订单来了.......");
        for (Command cmd : commands) {
            if (cmd != null) {
                cmd.execute();
            }
        }
    }
}
