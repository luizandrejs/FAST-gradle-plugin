/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package br.ufpe.cin.fastgradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import javax.inject.Inject;

public class FASTGradlePlugin implements Plugin<Project> {

    private FastGradleExecutor fastGradleExecutor = new FastGradleExecutor();

    public void apply(Project project) {
        project.getTasks().register("prioritize", task -> {
            task.doLast(s -> System.out.print(fastGradleExecutor.execute()));
        });
    }
}
