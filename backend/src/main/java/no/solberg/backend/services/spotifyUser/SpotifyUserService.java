package no.solberg.backend.services.spotifyUser;

import no.solberg.backend.models.SpotifyUser;
import no.solberg.backend.models.dtos.artist.ArtistPostDTO;
import no.solberg.backend.services.CRUDService;

public interface SpotifyUserService extends CRUDService<SpotifyUser, String> {
    public void addArtists(String id, String[] artistIds);
    public void addArtists(String  id, ArtistPostDTO[] artists);
}
