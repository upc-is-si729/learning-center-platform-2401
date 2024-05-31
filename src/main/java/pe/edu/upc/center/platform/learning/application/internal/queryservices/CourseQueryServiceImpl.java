package pe.edu.upc.center.platform.learning.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.learning.domain.model.aggregates.Course;
import pe.edu.upc.center.platform.learning.domain.model.entities.LearningPathItem;
import pe.edu.upc.center.platform.learning.domain.model.queries.GetAllCoursesQuery;
import pe.edu.upc.center.platform.learning.domain.model.queries.GetCourseByIdQuery;
import pe.edu.upc.center.platform.learning.domain.model.queries.GetLearningPathItemByCourseIdAndTutorialIdQuery;
import pe.edu.upc.center.platform.learning.domain.services.CourseQueryService;
import pe.edu.upc.center.platform.learning.infrastructure.persistence.jpa.repositories.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseQueryServiceImpl implements CourseQueryService {

  private final CourseRepository courseRepository;

  public CourseQueryServiceImpl(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  @Override
  public Optional<Course> handle(GetCourseByIdQuery query) {
    return courseRepository.findById(query.courseId());
  }

  @Override
  public List<Course> handle(GetAllCoursesQuery query) {
    return courseRepository.findAll();
  }

  @Override
  public Optional<LearningPathItem> handle(GetLearningPathItemByCourseIdAndTutorialIdQuery query) {
    return courseRepository.findById(query.courseId()).map(course -> course.getLearningPath().getLearningPathItemWithTutorialId(query.tutorialId()));
  }
}
