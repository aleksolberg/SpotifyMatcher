package no.solberg.backend.services.spotifyUser;

import no.solberg.backend.exceptions.ArtistNotFoundException;
import no.solberg.backend.exceptions.UserNotFoundException;
import no.solberg.backend.models.Artist;
import no.solberg.backend.models.SpotifyUser;
import no.solberg.backend.models.SpotifyUserArtist;
import no.solberg.backend.models.SpotifyUserArtistId;
import no.solberg.backend.repositories.ArtistRepository;
import no.solberg.backend.repositories.SpotifyUserArtistRepository;
import no.solberg.backend.repositories.SpotifyUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class SpotifyUserServiceImpl implements SpotifyUserService {
    private final SpotifyUserRepository spotifyUserRepository;
    private final ArtistRepository artistRepository;
    private final SpotifyUserArtistRepository spotifyUserArtistRepository;

    public SpotifyUserServiceImpl(SpotifyUserRepository spotifyUserRepository,
                                  ArtistRepository artistRepository,
                                  SpotifyUserArtistRepository spotifyUserArtistRepository) {
        this.spotifyUserRepository = spotifyUserRepository;
        this.artistRepository = artistRepository;
        this.spotifyUserArtistRepository = spotifyUserArtistRepository;
    }

    @Override
    public SpotifyUser findById(Integer id) {
        return spotifyUserRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Collection<SpotifyUser> findAll() {
        return spotifyUserRepository.findAll();
    }

    @Override
    public SpotifyUser add(SpotifyUser entity) {
        return spotifyUserRepository.save(entity);
    }

    @Transactional
    @Override
    public void addArtists(int id, String[] artistIds) {
        SpotifyUser spotifyUser = spotifyUserRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        for (int i = 0; i < artistIds.length; i++) {
            String artistId = artistIds[i];
            Artist artist = artistRepository.findById(artistIds[i])
                    .orElseThrow(() -> new ArtistNotFoundException(artistId)); // Perhaps add it instead?

            SpotifyUserArtist spotifyUserArtist = new SpotifyUserArtist();
            spotifyUserArtist.setId(new SpotifyUserArtistId(id, artist.getArtistId()));
            spotifyUserArtist.setSpotifyUser(spotifyUser);
            spotifyUserArtist.setArtist(artist);
            spotifyUserArtist.setArtistRank(i + 1);

            spotifyUserArtistRepository.save(spotifyUserArtist);
        }
    }
}
