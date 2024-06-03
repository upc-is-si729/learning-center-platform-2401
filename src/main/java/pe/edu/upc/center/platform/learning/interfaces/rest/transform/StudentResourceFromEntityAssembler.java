package pe.edu.upc.center.platform.learning.interfaces.rest.transform;

import pe.edu.upc.center.platform.learning.domain.model.aggregates.Student;
import pe.edu.upc.center.platform.learning.interfaces.rest.resources.StudentResource;

public class StudentResourceFromEntityAssembler {

  public static StudentResource toResourceFromEntity(Student student) {
    return new StudentResource(
            student.getStudentId(),
            student.getProfileId(),
            student.getTotalCompletedCourses(),
            student.getTotalTutorials()
    );
  }
}
