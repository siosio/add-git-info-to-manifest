package siosio

import org.gradle.api.Plugin
import org.gradle.api.Project

class AddGitInfoToManifest implements Plugin<Project> {

  @Override
  void apply(Project project) {
    def revision = 'git rev-parse HEAD'.execute().text.trim()
    project.with {
      jar {
        manifest {
          attributes 'git-revision': revision
        }
      }
    }
  }
}
