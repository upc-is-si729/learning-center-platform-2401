package pe.edu.upc.center.platform.learning.interfaces.rest.resources;

public record StudentResource(String studentId, Long profileId, Integer totalCompletedCourses,
                              Integer totalTutorials) {
}
