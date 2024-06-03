package pe.edu.upc.center.platform.learning.interfaces.rest.transform;

import pe.edu.upc.center.platform.learning.domain.model.commands.CreateStudentCommand;
import pe.edu.upc.center.platform.learning.interfaces.rest.resources.CreateStudentResource;

public class CreateStudentCommandFromResourceAssembler {

  public static CreateStudentCommand toCommandFromResource(CreateStudentResource resource) {
    return new CreateStudentCommand(
            resource.firstName(),
            resource.lastName(),
            resource.email(),
            resource.street(),
            resource.number(),
            resource.city(),
            resource.postalCode(),
            resource.country()
    );
  }
}
