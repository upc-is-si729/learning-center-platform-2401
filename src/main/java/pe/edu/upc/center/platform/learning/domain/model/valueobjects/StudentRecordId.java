package pe.edu.upc.center.platform.learning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.util.UUID;

/**
 * Value object representing the Student record id.
 */
@Embeddable
public record StudentRecordId(String studentId) {
  public StudentRecordId() {
    this(UUID.randomUUID().toString());
  }

  public StudentRecordId {
    if (studentId == null || studentId.isBlank()) {
      throw new IllegalArgumentException("Acme student record profileId cannot be null or blank");
    }
  }
}
