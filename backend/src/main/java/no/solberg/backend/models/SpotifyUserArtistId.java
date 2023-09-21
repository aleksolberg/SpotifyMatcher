package no.solberg.backend.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SpotifyUserArtistId implements Serializable {

    private int spotifyUserId;
    private String artistId;

    public SpotifyUserArtistId() {}

    public SpotifyUserArtistId(int spotifyUserId, String artistId) {
        this.artistId = artistId;
        this.spotifyUserId = spotifyUserId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpotifyUserArtistId that = (SpotifyUserArtistId) o;
        return spotifyUserId == that.spotifyUserId && artistId == that.artistId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(spotifyUserId, artistId);
    }
}
