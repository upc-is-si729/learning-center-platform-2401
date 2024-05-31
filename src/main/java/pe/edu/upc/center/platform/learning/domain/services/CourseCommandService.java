package pe.edu.upc.center.platform.learning.domain.services;

import pe.edu.upc.center.platform.learning.domain.model.aggregates.Course;
import pe.edu.upc.center.platform.learning.domain.model.commands.UpdateCourseCommand;
import pe.edu.upc.center.platform.learning.domain.model.commands.AddTutorialToCourseLearningPathCommand;
import pe.edu.upc.center.platform.learning.domain.model.commands.CreateCourseCommand;
import pe.edu.upc.center.platform.learning.domain.model.commands.DeleteCourseCommand;

import java.util.Optional;

public interface CourseCommandService {
  Long handle(CreateCourseCommand command);
  Optional<Course> handle(UpdateCourseCommand command);
  void handle(DeleteCourseCommand command);

  void handle(AddTutorialToCourseLearningPathCommand command);
}
