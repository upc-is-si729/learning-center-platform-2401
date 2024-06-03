package pe.edu.upc.center.platform.learning.domain.model.queries;

import pe.edu.upc.center.platform.learning.domain.model.valueobjects.StudentRecordId;

public record GetEnrollmentByStudentRecordIdAndCourseIdQuery(StudentRecordId studentRecordId, Long courseId) {
}
