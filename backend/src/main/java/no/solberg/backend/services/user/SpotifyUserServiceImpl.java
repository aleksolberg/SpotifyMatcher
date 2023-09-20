package no.solberg.backend.services.user;

import no.solberg.backend.models.SpotifyUser;
import no.solberg.backend.repositories.SpotifyUserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SpotifyUserServiceImpl implements SpotifyUserService {
    private final SpotifyUserRepository spotifyUserRepository;

    public SpotifyUserServiceImpl(SpotifyUserRepository spotifyUserRepository) {
        this.spotifyUserRepository = spotifyUserRepository;
    }

    @Override
    public SpotifyUser findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<SpotifyUser> findAll() {
        return spotifyUserRepository.findAll();
    }

    @Override
    public SpotifyUser add(SpotifyUser entity) {
        return spotifyUserRepository.save(entity);
    }
}
