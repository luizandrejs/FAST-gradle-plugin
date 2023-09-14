/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package br.ufpe.cin.fastgradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import javax.inject.Inject;

public class FASTGradlePlugin implements Plugin<Project> {

    private FastGradleExecutor fastGradleExecutor = new FastGradleExecutor();

    @Override
    public void apply(Project project) {
        FastPluginExtension extension = project.getExtensions()
                .create("prioritize", FastPluginExtension.class);

        project.getTasks().register("prioritize", task -> {
            task.doLast(s -> {
                long start = System.currentTimeMillis();
                System.out.print(fastGradleExecutor.execute(extension));
                long end = System.currentTimeMillis();
                System.out.println("Elapsed time in milliseconds: " + (end - start));
            });
        });
    }
}
