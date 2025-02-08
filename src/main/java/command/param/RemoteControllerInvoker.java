package command.param;


public class RemoteControllerInvoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        System.out.println("按下按钮");
        command.execute();
    }

    public void undoButton() {
        System.out.println("按下撤销按钮");
        command.undo();
    }
}
