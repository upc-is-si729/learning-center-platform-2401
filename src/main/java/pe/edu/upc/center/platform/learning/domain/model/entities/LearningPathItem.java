package pe.edu.upc.center.platform.learning.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pe.edu.upc.center.platform.learning.domain.model.aggregates.Course;
import pe.edu.upc.center.platform.shared.domain.model.entities.AuditableModel;

/**
 * Represents an item in the learning path.
 */
@Getter
@Entity
public class LearningPathItem extends AuditableModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "course_id")
  @NotNull
  private Course course;

  @NotNull
  private Long tutorialId;

  @ManyToOne
  @JoinColumn(name = "next_item_id")
  private LearningPathItem nextItem;

  public LearningPathItem(Course course, Long tutorialId, LearningPathItem nextItem) {
    this.course = course;
    this.tutorialId = tutorialId;
    this.nextItem = nextItem;
  }

  public LearningPathItem() {
    this.tutorialId = 0L;
    this.nextItem = null;
  }

  /**
   * Updates the next item in the learning path.
   * @param nextItem The next item.
   */
  public void updateNextItem(LearningPathItem nextItem) {
    this.nextItem = nextItem;
  }
}
