package no.solberg.backend.controllers;

import no.solberg.backend.mappers.SpotifyUserMapper;
import no.solberg.backend.models.SpotifyUser;
import no.solberg.backend.models.dtos.SpotifyUserPostDTO;
import no.solberg.backend.services.user.SpotifyUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("api/v1/users")
public class SpotifyUserController {
    private final SpotifyUserService spotifyUserService;
    private final SpotifyUserMapper spotifyUserMapper;

    public SpotifyUserController(SpotifyUserService spotifyUserService, SpotifyUserMapper spotifyUserMapper) {
        this.spotifyUserService = spotifyUserService;
        this.spotifyUserMapper = spotifyUserMapper;
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(
                spotifyUserMapper.spotifyUsersToSpotifyUserGetDTOs(spotifyUserService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(
                spotifyUserMapper.spotifyUserToSpotifyUserGetDTO(
                        spotifyUserService.findById(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity add(@RequestBody SpotifyUserPostDTO entity) throws URISyntaxException { // TODO: use different dto
        SpotifyUser spotifyUser = spotifyUserService.add(spotifyUserMapper.spotifyUserPostDTOToSpotifyUser(entity));
        URI uri = new URI("api/v1/users/" + spotifyUser.getId());
        return ResponseEntity.created(uri).build();
    }
}
