package br.ufpe.cin.fastgradle;

public class MainTest {

    private static FastGradleExecutor fastGradleExecutor = new FastGradleExecutor();

    public static void main(String[] args) {

        FastPluginExtension extension = new FastPluginExtension();
        extension.setProjectPath("teste");
        extension.setAlgorithm("FAST-pw");
        extension.setRepetitions("3");

        System.out.print(MainTest.fastGradleExecutor.execute(extension));
    }

}
