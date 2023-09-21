package no.solberg.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class SpotifyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String accessToken;

    // Relationships
    @OneToMany(mappedBy = "spotifyUser")
    private Set<SpotifyUserArtist> spotifyUserArtists;
}