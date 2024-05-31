package pe.edu.upc.center.platform.learning.domain.services;

import pe.edu.upc.center.platform.learning.domain.model.commands.CreateStudentCommand;
import pe.edu.upc.center.platform.learning.domain.model.commands.UpdateStudentMetricsOnTutorialCompletedCommand;
import pe.edu.upc.center.platform.learning.domain.model.valueobjects.AcmeStudentRecordId;

public interface StudentCommandService {
  AcmeStudentRecordId handle(CreateStudentCommand command);
  AcmeStudentRecordId handle(UpdateStudentMetricsOnTutorialCompletedCommand command);
}