package pe.edu.upc.center.platform.learning.domain.model.commands;

import pe.edu.upc.center.platform.learning.domain.model.valueobjects.AcmeStudentRecordId;

public record UpdateStudentMetricsOnTutorialCompletedCommand(AcmeStudentRecordId studentRecordId) {
}
