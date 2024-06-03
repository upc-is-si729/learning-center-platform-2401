package pe.edu.upc.center.platform.learning.interfaces.rest.transform;

import pe.edu.upc.center.platform.learning.domain.model.aggregates.Course;
import pe.edu.upc.center.platform.learning.interfaces.rest.resources.CourseResource;

public class CourseResourceFromEntityAssembler {

  public static CourseResource toResourceFromEntity(Course entity) {
    return new CourseResource(entity.getId(), entity.getTitle(), entity.getDescription());
  }
}
