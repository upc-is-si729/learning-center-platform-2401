package pe.edu.upc.center.platform.learning.interfaces.rest.resources;

public record EnrollmentResource(Long enrollmentId, String studentId, Long courseId,
                                 String status) {
}
