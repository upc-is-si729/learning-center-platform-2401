package pe.edu.upc.center.platform.iam.interfaces.rest.transform;

import java.util.ArrayList;
import pe.edu.upc.center.platform.iam.domain.model.commands.SignUpCommand;
import pe.edu.upc.center.platform.iam.domain.model.entities.Role;
import pe.edu.upc.center.platform.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {

  public static SignUpCommand toCommandFromResource(SignUpResource resource) {
    var roles = resource.roles() != null
        ? resource.roles().stream().map(name -> Role.toRoleFromName(name)).toList()
        : new ArrayList<Role>();
    return new SignUpCommand(resource.username(), resource.password(), roles);
  }
}
