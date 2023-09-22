package no.solberg.backend.models.dtos.spotifyUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpotifyUserPostDTO {
    private String spotifyUserId;
    private String name;
    private String email;
    private String accessToken;
}