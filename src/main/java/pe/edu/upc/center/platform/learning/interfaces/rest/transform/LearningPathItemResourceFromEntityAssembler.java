package pe.edu.upc.center.platform.learning.interfaces.rest.transform;

import pe.edu.upc.center.platform.learning.domain.model.entities.LearningPathItem;
import pe.edu.upc.center.platform.learning.interfaces.rest.resources.LearningPathItemResource;

public class LearningPathItemResourceFromEntityAssembler {

  public static LearningPathItemResource toResourceFromEntity(LearningPathItem entity) {
    return new LearningPathItemResource(entity.getId(), entity.getCourse().getId(), entity.getTutorialId());
  }
}
