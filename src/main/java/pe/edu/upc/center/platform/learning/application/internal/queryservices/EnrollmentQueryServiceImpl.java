package pe.edu.upc.center.platform.learning.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.platform.learning.domain.model.aggregates.Enrollment;
import pe.edu.upc.center.platform.learning.domain.model.queries.*;
import pe.edu.upc.center.platform.learning.domain.services.EnrollmentQueryService;
import pe.edu.upc.center.platform.learning.infrastructure.persistence.jpa.repositories.EnrollmentRepository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of EnrollmentQueryService
 *
 * <p>
 *     This class is the implementation of the EnrollmentQueryService interface.
 *     It is used by the EnrollmentContext to handle queries on the Enrollment aggregate.
 *     It uses the EnrollmentRepository to query the database.
 * </p>
 */
@Service
public class EnrollmentQueryServiceImpl implements EnrollmentQueryService {
  private final EnrollmentRepository enrollmentRepository;

  public EnrollmentQueryServiceImpl(EnrollmentRepository enrollmentRepository) {
    this.enrollmentRepository = enrollmentRepository;
  }

  /**
   * Query handler to get student enrollments
   *
   * @param query containing studentRecordId
   * @return List of Enrollments
   * @see Enrollment
   * @see GetAllEnrollmentsByStudentRecordIdQuery
   */
  @Override
  public List<Enrollment> handle(GetAllEnrollmentsByStudentRecordIdQuery query) {
    return enrollmentRepository.findAllByStudentRecordId(query.studentRecordId());
  }

  /**
   * Query handler to get enrollment by id
   *
   * @param query containing enrollmentId
   * @return Enrollment
   * @see Enrollment
   * @see GetEnrollmentByIdQuery
   */
  @Override
  public Optional<Enrollment> handle(GetEnrollmentByIdQuery query) {
    return enrollmentRepository.findById(query.enrollmentId());
  }

  /**
   * Query handler to get all enrollments
   *
   * @param query containing no parameters
   * @return List of Enrollments
   * @see Enrollment
   * @see GetAllEnrollmentsQuery
   */
  @Override
  public List<Enrollment> handle(GetAllEnrollmentsQuery query) {
    return enrollmentRepository.findAll();
  }

  /**
   * Query handler to get course enrollments
   *
   * @param query containing courseId
   * @return List of Enrollments
   * @see Enrollment
   * @see GetAllEnrollmentsByCourseIdQuery
   */
  @Override
  public List<Enrollment> handle(GetAllEnrollmentsByCourseIdQuery query) {
    return enrollmentRepository.findAllByCourseId(query.courseId());
  }

  @Override
  public Optional<Enrollment> handle(GetEnrollmentByStudentRecordIdAndCourseIdQuery query) {
    return enrollmentRepository.findByStudentRecordIdAndCourseId(query.studentRecordId(), query.courseId());
  }
}