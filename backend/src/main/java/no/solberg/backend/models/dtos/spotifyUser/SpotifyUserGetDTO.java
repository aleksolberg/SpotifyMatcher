package no.solberg.backend.models.dtos.spotifyUser;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SpotifyUserGetDTO {
    private int id;
    private String name;
    private String email;
    private String accessToken;
    private Set<String> artistIds;
}
