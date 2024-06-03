package pe.edu.upc.center.platform.learning.domain.services;

import pe.edu.upc.center.platform.learning.domain.model.queries.GetStudentByStudentRecordIdQuery;
import pe.edu.upc.center.platform.learning.domain.model.queries.GetStudentByProfileIdQuery;
import pe.edu.upc.center.platform.learning.domain.model.aggregates.Student;

import java.util.Optional;

public interface StudentQueryService {
  Optional<Student> handle(GetStudentByProfileIdQuery query);
  Optional<Student> handle(GetStudentByStudentRecordIdQuery query);
}
