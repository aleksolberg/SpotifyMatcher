package no.solberg.backend.mappers;

import no.solberg.backend.models.SpotifyUser;
import no.solberg.backend.models.dtos.SpotifyUserGetDTO;
import no.solberg.backend.models.dtos.SpotifyUserPostDTO;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface SpotifyUserMapper {
    SpotifyUserGetDTO spotifyUserToSpotifyUserGetDTO(SpotifyUser spotifyUser);
    Collection<SpotifyUserGetDTO>  spotifyUsersToSpotifyUserGetDTOs(Collection<SpotifyUser> spotifyUsers);

    SpotifyUser spotifyUserPostDTOToSpotifyUser(SpotifyUserPostDTO spotifyUserPostDTO); // TODO: Use different DTO
}
