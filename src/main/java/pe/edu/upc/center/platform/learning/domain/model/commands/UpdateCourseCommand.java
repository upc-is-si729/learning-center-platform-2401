package pe.edu.upc.center.platform.learning.domain.model.commands;

public record UpdateCourseCommand(Long id, String title, String description) {
}
