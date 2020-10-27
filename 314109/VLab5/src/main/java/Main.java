import tools.CommandListener;

public class Main {
    public static void main(String[] args) {
        String a = "123";

        System.out.println(a.substring(0,1));

        CommandListener commandListener = new CommandListener();

        commandListener.readCommands();
    }
}
