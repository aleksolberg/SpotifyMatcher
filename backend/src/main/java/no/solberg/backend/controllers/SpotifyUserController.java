package no.solberg.backend.controllers;

import no.solberg.backend.mappers.SpotifyUserMapper;
import no.solberg.backend.models.SpotifyUser;
import no.solberg.backend.models.dtos.artist.ArtistPostDTO;
import no.solberg.backend.models.dtos.spotifyUser.SpotifyUserPostDTO;
import no.solberg.backend.services.spotifyUser.SpotifyUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@CrossOrigin("http://localhost:3000")
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
                spotifyUserMapper.spotifyUsersToSpotifyUserListDTOs(spotifyUserService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable String id) {
        return ResponseEntity.ok(
                spotifyUserMapper.spotifyUserToSpotifyUserGetDTO(spotifyUserService.findById(id))
        );
    }

    // TODO: Check if user exists in database already, update access token if necessary
    @PostMapping
    public ResponseEntity add(@RequestBody SpotifyUserPostDTO entity) throws URISyntaxException {
        SpotifyUser spotifyUser = spotifyUserService.add(spotifyUserMapper.spotifyUserPostDTOToSpotifyUser(entity));
        URI uri = new URI("api/v1/users/" + spotifyUser.getSpotifyUserId());
        return ResponseEntity.created(uri).build();
    }

    // add top artists for a user. Artists must come in correct order.
    @PutMapping ("{id}/artists")
    public ResponseEntity addTopArtists(@PathVariable String id, @RequestBody String[] artistIds) {
        spotifyUserService.addArtists(id, artistIds);
        return ResponseEntity.noContent().build();
    }

    // TODO: Get artist for user
    // TODO: Get genres for user
    // TODO: Add genres when artist is added

    @PostMapping("{id}/artists")
    public ResponseEntity addTopArtists(@PathVariable String id, @RequestBody ArtistPostDTO[] entity) {
        spotifyUserService.addArtists(id, entity);
        return ResponseEntity.noContent().build();
    }
}