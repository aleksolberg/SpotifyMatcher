package no.solberg.backend.models.dtos.artist;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
public class ArtistPostDTO {
    private String artistId;
    private String artistName;
    private int popularity;
    private URL imageUrl;
    private URL externalUrl;
}
