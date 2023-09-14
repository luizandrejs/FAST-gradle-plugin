package br.ufpe.cin.fastgradle;

import org.gradle.internal.impldep.org.eclipse.jgit.api.Git;

import java.io.File;
import java.nio.file.Paths;

public class FastGradleExecutor {

    private CmdProvider cmdProvider = new CmdProvider();

    private String fastMavenPluginFlagCMD = "[" + "\u001B[34m" + "\033[0;1m" + "FAST-gradle-plugin" + "\033[0;0m" + "\u001B[0m" + "] ";

    public String execute(FastPluginExtension extension) {
        if (checkValidAlgorithm(extension.getAlgorithm())) {
            cloneRepo();
            return cmdProvider.executeCommand("python3 /Users/luizandre/.m2/repository/br/ufpe/cin/fastgradle/FAST/py/prioritize.py " + extension.getProjectPath() + " " + extension.getAlgorithm());
        } else {
            return "Invalid Algorithm.";
        }
    }

    private static boolean checkValidAlgorithm(String algorithm) {
        if (algorithm.equals("FAST-pw") || algorithm.equals("FAST-one") || algorithm.equals("FAST-log") || algorithm.equals("FAST-sqrt") || algorithm.equals("FAST-all")) {
            return true;
        } else {
            return false;
        }
    }

    private static String getPluginDir() {
        String userDir = System.getProperty("user.home");
        String groupId = "br.ufpe.cin.fastgradle".replace(".", "/");
        String pluginDir = String.format("%s/.m2/repository/%s", userDir, groupId);
        return pluginDir;
    }

    public void cloneRepo()  {
        String repoUrl = "https://github.com/FAST-tool/maven-FAST";

        String cloneDirectoryPath = getPluginDir() + "/FAST";

        File dir = new File(cloneDirectoryPath);
        if (dir.exists() && dir.isDirectory()){
            System.out.println(fastMavenPluginFlagCMD + "FAST repository already present");
        } else {
            try {
                System.out.println(fastMavenPluginFlagCMD + "Cloning FAST repository ("+ repoUrl + ") in this Maven environment");
                Git.cloneRepository()
                        .setURI(repoUrl)
                        .setDirectory(Paths.get(cloneDirectoryPath).toFile())
                        .call();
                System.out.println(fastMavenPluginFlagCMD + "Completed Cloning");
            } catch (Exception e) {
                System.out.println(fastMavenPluginFlagCMD + "Exception occurred while cloning repo");
                e.printStackTrace();
            }
        }
    }
}
