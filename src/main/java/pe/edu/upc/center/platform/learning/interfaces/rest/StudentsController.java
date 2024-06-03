package pe.edu.upc.center.platform.learning.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.center.platform.learning.domain.model.queries.GetStudentByStudentRecordIdQuery;
import pe.edu.upc.center.platform.learning.domain.model.valueobjects.StudentRecordId;
import pe.edu.upc.center.platform.learning.domain.services.StudentCommandService;
import pe.edu.upc.center.platform.learning.domain.services.StudentQueryService;
import pe.edu.upc.center.platform.learning.interfaces.rest.resources.CreateStudentResource;
import pe.edu.upc.center.platform.learning.interfaces.rest.resources.StudentResource;
import pe.edu.upc.center.platform.learning.interfaces.rest.transform.CreateStudentCommandFromResourceAssembler;
import pe.edu.upc.center.platform.learning.interfaces.rest.transform.StudentResourceFromEntityAssembler;

/**
 * StudentsController
 *
 * <p>Controller that handles the endpoints for students.
 * It uses the {@link StudentCommandService} and {@link StudentQueryService} to handle the commands and queries
 * for students.
 * <ul>
 *     <li>POST /api/v1/students</li>
 *     <li>GET /api/v1/students/{studentRecordId}</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping(value = "/api/v1/students", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Students", description = "Student Management Endpoints")
public class StudentsController {
  private final StudentCommandService studentCommandService;
  private final StudentQueryService studentQueryService;

  public StudentsController(StudentCommandService studentCommandService, StudentQueryService studentQueryService) {
    this.studentCommandService = studentCommandService;
    this.studentQueryService = studentQueryService;
  }

  /**
   * POST /api/v1/students
   *
   * <p>Endpoint that creates a student</p>
   *
   * @param resource the resource with the information to create the student
   * @return the created student
   * @see CreateStudentResource
   * @see StudentResource
   */
  @PostMapping
  public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource) {
    var createStudentCommand = CreateStudentCommandFromResourceAssembler.toCommandFromResource(resource);
    var studentRecordId = studentCommandService.handle(createStudentCommand);

    if (studentRecordId.studentId().isEmpty()) {
      return ResponseEntity.badRequest().build();
    }
    var getStudentByStudentRecordIdQuery = new GetStudentByStudentRecordIdQuery(studentRecordId);
    var student = studentQueryService.handle(getStudentByStudentRecordIdQuery);

    if (student.isEmpty()) {
      return ResponseEntity.badRequest().build();
    }
    var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
    return new ResponseEntity<>(studentResource, HttpStatus.CREATED);

  }

  /**
   * GET /api/v1/students/{studentRecordId}
   *
   * <p>Endpoint that gets a student by its student record id</p>
   *
   * @param studentRecordId the student record id
   * @return the student resource
   * @see StudentResource
   */
  @GetMapping("/{studentRecordId}")
  public ResponseEntity<StudentResource> getStudentByStudentRecordId(@PathVariable String studentRecordId) {
    var StudentRecordIdVar = new StudentRecordId(studentRecordId);
    var getStudentByStudentRecordIdQuery = new GetStudentByStudentRecordIdQuery(StudentRecordIdVar);
    var student = studentQueryService.handle(getStudentByStudentRecordIdQuery);

    if (student.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
    return ResponseEntity.ok(studentResource);
  }
}
