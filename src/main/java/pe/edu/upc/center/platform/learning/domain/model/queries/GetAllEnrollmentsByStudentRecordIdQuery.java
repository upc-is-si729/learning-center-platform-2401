package pe.edu.upc.center.platform.learning.domain.model.queries;

import pe.edu.upc.center.platform.learning.domain.model.valueobjects.StudentRecordId;

public record GetAllEnrollmentsByStudentRecordIdQuery(StudentRecordId studentRecordId) {
}
