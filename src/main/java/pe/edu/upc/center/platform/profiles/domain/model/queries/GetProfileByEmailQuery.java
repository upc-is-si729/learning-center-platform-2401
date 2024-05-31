package pe.edu.upc.center.platform.profiles.domain.model.queries;

import pe.edu.upc.center.platform.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}