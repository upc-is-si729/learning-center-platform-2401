package pe.edu.upc.center.platform.learning.domain.services;

import pe.edu.upc.center.platform.learning.domain.model.queries.*;
import pe.edu.upc.center.platform.learning.domain.model.aggregates.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentQueryService {
  List<Enrollment> handle(GetAllEnrollmentsByStudentRecordIdQuery query);
  Optional<Enrollment> handle(GetEnrollmentByIdQuery query);
  List<Enrollment> handle(GetAllEnrollmentsQuery query);
  List<Enrollment> handle(GetAllEnrollmentsByCourseIdQuery query);
  Optional<Enrollment> handle(GetEnrollmentByStudentRecordIdAndCourseIdQuery query);
}
