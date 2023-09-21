package no.solberg.backend.mappers;

import no.solberg.backend.models.Artist;
import no.solberg.backend.models.SpotifyUser;
import no.solberg.backend.models.SpotifyUserArtist;
import no.solberg.backend.models.dtos.spotifyUser.SpotifyUserGetDTO;
import no.solberg.backend.models.dtos.spotifyUser.SpotifyUserListDTO;
import no.solberg.backend.models.dtos.spotifyUser.SpotifyUserPostDTO;
import org.mapstruct.*;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface SpotifyUserMapper {
    @Named(value = "spotifyUserArtistsToArtistIds")
    default Set<String> map(Set<SpotifyUserArtist> value) {
        if(value == null)
            return null;
        return value.stream()
                .map(SpotifyUserArtist::getArtist)
                .map(Artist::getArtistId)
                .collect(Collectors.toSet());
    }

    @Mapping(source = "spotifyUserArtists", target = "artistIds", qualifiedByName = "spotifyUserArtistsToArtistIds")
    SpotifyUserGetDTO spotifyUserToSpotifyUserGetDTO(SpotifyUser spotifyUser);

    Collection<SpotifyUserListDTO>  spotifyUsersToSpotifyUserListDTOs(Collection<SpotifyUser> spotifyUsers);

    SpotifyUser spotifyUserPostDTOToSpotifyUser(SpotifyUserPostDTO spotifyUserPostDTO); // TODO: Use different DTO
}
