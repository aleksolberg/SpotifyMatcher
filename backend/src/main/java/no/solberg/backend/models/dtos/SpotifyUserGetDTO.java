package no.solberg.backend.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpotifyUserGetDTO {
    private String name;

    private String email;

    private String accessToken;
}
