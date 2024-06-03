package pe.edu.upc.center.platform.learning.interfaces.rest.transform;

import pe.edu.upc.center.platform.learning.domain.model.commands.CreateCourseCommand;
import pe.edu.upc.center.platform.learning.interfaces.rest.resources.CreateCourseResource;

public class CreateCourseCommandFromResourceAssembler {

  public static CreateCourseCommand toCommandFromResource(CreateCourseResource resource) {
    return new CreateCourseCommand(resource.title(), resource.description());
  }
}