package pe.edu.upc.center.platform.learning.interfaces.rest.transform;

import pe.edu.upc.center.platform.learning.domain.model.commands.UpdateCourseCommand;
import pe.edu.upc.center.platform.learning.interfaces.rest.resources.UpdateCourseResource;

public class UpdateCourseCommandFromResourceAssembler {

  public static UpdateCourseCommand toCommandFromResource(Long courseId, UpdateCourseResource resource) {
    return new UpdateCourseCommand(courseId, resource.title(), resource.description());
  }
}
