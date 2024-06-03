package pe.edu.upc.center.platform.learning.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

public record RequestEnrollmentResource(
        @NotNull
        String studentId,
        @NotNull
        Long courseId
) {
}
