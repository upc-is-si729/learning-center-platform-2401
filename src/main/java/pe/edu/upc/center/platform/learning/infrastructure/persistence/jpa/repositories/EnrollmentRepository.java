package pe.edu.upc.center.platform.learning.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.center.platform.learning.domain.model.aggregates.Enrollment;
import pe.edu.upc.center.platform.learning.domain.model.valueobjects.AcmeStudentRecordId;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
  List<Enrollment> findAllByAcmeStudentRecordId(AcmeStudentRecordId acmeStudentRecordId);
  List<Enrollment> findAllByCourseId(Long courseId);
  Optional<Enrollment> findByAcmeStudentRecordIdAndCourseId(AcmeStudentRecordId acmeStudentRecordId, Long courseId);
}
