package br.ufpe.cin.fastgradle;

public class MainTest {

    private static FastGradleExecutor fastGradleExecutor = new FastGradleExecutor();

    public static void main(String[] args) {
        System.out.print(MainTest.fastGradleExecutor.execute());
    }

}
