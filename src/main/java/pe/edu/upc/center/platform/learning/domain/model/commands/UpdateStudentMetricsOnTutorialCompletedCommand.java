package pe.edu.upc.center.platform.learning.domain.model.commands;

import pe.edu.upc.center.platform.learning.domain.model.valueobjects.StudentRecordId;

public record UpdateStudentMetricsOnTutorialCompletedCommand(StudentRecordId studentRecordId) {
}
