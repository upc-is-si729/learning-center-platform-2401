package pe.edu.upc.center.platform.learning.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.center.platform.learning.domain.model.queries.GetAllEnrollmentsByStudentRecordIdQuery;
import pe.edu.upc.center.platform.learning.domain.model.valueobjects.StudentRecordId;
import pe.edu.upc.center.platform.learning.domain.services.EnrollmentQueryService;
import pe.edu.upc.center.platform.learning.interfaces.rest.resources.EnrollmentResource;
import pe.edu.upc.center.platform.learning.interfaces.rest.transform.EnrollmentResourceFromEntityAssembler;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * StudentsController
 *
 * <p>Controller that handles the endpoints for students.
 * It uses the {@link EnrollmentQueryService} to handle the queries
 * for enrollments.
 * <ul>
 *     <li>GET /api/v1/students/{studentRecordId}/enrollments</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping(value = "/api/v1/students/{studentRecordId}/enrollments", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Students")
public class StudentEnrollmentsController {
  private final EnrollmentQueryService enrollmentQueryService;


  public StudentEnrollmentsController(EnrollmentQueryService enrollmentQueryService) {
    this.enrollmentQueryService = enrollmentQueryService;
  }

  /**
   * GET /api/v1/students/{studentRecordId}/enrollments
   *
   * <p>Endpoint that returns the enrollments for a student</p>
   *
   * @param studentRecordId the student record ID
   * @return the enrollments for the student
   * @see EnrollmentResource
   */
  @GetMapping
  public ResponseEntity<List<EnrollmentResource>> getEnrollmentsForStudentWithStudentRecordId(@PathVariable String studentRecordId) {
    var studentRecordIdVar = new StudentRecordId(studentRecordId);
    var getAllEnrollmentsByAcmeStudentRecordIdQuery = new GetAllEnrollmentsByStudentRecordIdQuery(studentRecordIdVar);
    var enrollments = enrollmentQueryService.handle(getAllEnrollmentsByAcmeStudentRecordIdQuery);
    var enrollmentResources = enrollments.stream().map(EnrollmentResourceFromEntityAssembler::toResourceFromEntity).toList();
    return ResponseEntity.ok(enrollmentResources);
  }
}
