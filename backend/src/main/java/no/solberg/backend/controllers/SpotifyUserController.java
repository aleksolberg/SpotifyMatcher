package no.solberg.backend.controllers;

import no.solberg.backend.mappers.SpotifyUserMapper;
import no.solberg.backend.models.SpotifyUser;
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
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(
                spotifyUserMapper.spotifyUserToSpotifyUserGetDTO(spotifyUserService.findById(id))
        );
    }

    @PostMapping
    public ResponseEntity add(@RequestBody SpotifyUserPostDTO entity) throws URISyntaxException { // TODO: use different dto
        SpotifyUser spotifyUser = spotifyUserService.add(spotifyUserMapper.spotifyUserPostDTOToSpotifyUser(entity));
        URI uri = new URI("api/v1/users/" + spotifyUser.getId());
        return ResponseEntity.created(uri).build();
    }

    // add top artists for a user. Artists must come in correct order.
    @PutMapping ("{id}/artists")
    public ResponseEntity addTopArtists(@PathVariable int id, @RequestBody String[] artistIds) {
        spotifyUserService.addArtists(id, artistIds);
        return ResponseEntity.noContent().build();
    }

    // TODO: Get artist for user
    // TODO: Get genres for user


    // Post mapping, gets an array of artists  {"id", "name",  "genres", "popularity", "image_url", "external_url"}
    // Should check if artist exists already, update it? Add if not.
    // Check if genres exists already, add if not
    // Add artist-genre relationship
    // Check if user exists, throw error if not
    // Add user-artist relationship
    /*@PostMapping("{id}/artists")
    public ResponseEntity addTopArtists(@RequestBody ArtistPostDTO entity) {

    }*/
}