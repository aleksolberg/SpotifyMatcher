package no.solberg.backend.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGetDTO {
    private String name;

    private String email;

    private String accessToken;
}
