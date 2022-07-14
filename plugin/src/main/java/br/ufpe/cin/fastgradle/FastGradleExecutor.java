package br.ufpe.cin.fastgradle;

public class FastGradleExecutor {

    private CmdProvider cmdProvider = new CmdProvider();

    public String execute() {
        return cmdProvider.executeCommand("pwd");
    }

}
