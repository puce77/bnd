/*
 * BndBuilderPlugin for Gradle.
 *
 * <p>
 * This plugin applies the java plugin to a project and modifies the jar
 * task by adding the properties from the BundleTaskConvention and building
 * the jar file as a bundle.
 */

package aQute.bnd.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

public class BndBuilderPlugin implements Plugin<Project> {
  void apply(Project p) {
    p.configure(p) { project ->
      plugins.apply 'java'

      jar {
        description 'Assembles a bundle containing the main classes.'
        convention.plugins.bundle = new BundleTaskConvention(jar)
        doLast {
          Bundle.build(jar)
        }
      }
    }
  }
}
