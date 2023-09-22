package no.solberg.backend.mappers;

import no.solberg.backend.models.Artist;
import no.solberg.backend.models.SpotifyUser;
import no.solberg.backend.models.SpotifyUserArtist;
import no.solberg.backend.models.dtos.artist.ArtistGetDTO;
import no.solberg.backend.models.dtos.artist.ArtistListDTO;
import no.solberg.backend.models.dtos.artist.ArtistPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ArtistMapper {
    @Named(value = "spotifyUserArtistsToSpotifyUserIds")
    default Set<String> map(Set<SpotifyUserArtist> value) {
        if(value == null)
            return null;
        return value.stream()
                .map(SpotifyUserArtist::getSpotifyUser)
                .map(SpotifyUser::getSpotifyUserId)
                .collect(Collectors.toSet());
    }

    @Mapping(source = "spotifyUserArtists", target = "spotifyUserIds", qualifiedByName = "spotifyUserArtistsToSpotifyUserIds")
    ArtistGetDTO artistToArtistGetDTO(Artist entity);

    Collection<ArtistListDTO> artistsToArtistListDTOs(Collection<Artist> artists);

    Artist artistPostDTOToArtist(ArtistPostDTO artistPostDTO);
}
