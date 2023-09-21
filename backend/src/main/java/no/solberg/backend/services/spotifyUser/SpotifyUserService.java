package no.solberg.backend.services.spotifyUser;

import no.solberg.backend.models.SpotifyUser;
import no.solberg.backend.services.CRUDService;

public interface SpotifyUserService extends CRUDService<SpotifyUser, Integer> {
    public void addArtists(int id, String[] artistIds);
}
