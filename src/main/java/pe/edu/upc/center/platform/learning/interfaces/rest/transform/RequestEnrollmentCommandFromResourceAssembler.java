package pe.edu.upc.center.platform.learning.interfaces.rest.transform;

import pe.edu.upc.center.platform.learning.domain.model.commands.RequestEnrollmentCommand;
import pe.edu.upc.center.platform.learning.domain.model.valueobjects.StudentRecordId;
import pe.edu.upc.center.platform.learning.interfaces.rest.resources.RequestEnrollmentResource;

public class RequestEnrollmentCommandFromResourceAssembler {

  public static RequestEnrollmentCommand toCommandFromResource(RequestEnrollmentResource resource) {
    return new RequestEnrollmentCommand(new StudentRecordId(resource.studentId()), resource.courseId());
  }
}
