package pe.edu.upc.center.platform.learning.domain.services;

import pe.edu.upc.center.platform.learning.domain.model.commands.CreateStudentCommand;
import pe.edu.upc.center.platform.learning.domain.model.commands.UpdateStudentMetricsOnTutorialCompletedCommand;
import pe.edu.upc.center.platform.learning.domain.model.valueobjects.StudentRecordId;

public interface StudentCommandService {
  StudentRecordId handle(CreateStudentCommand command);
  StudentRecordId handle(UpdateStudentMetricsOnTutorialCompletedCommand command);
}