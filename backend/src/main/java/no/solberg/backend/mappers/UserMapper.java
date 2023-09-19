package no.solberg.backend.mappers;

import no.solberg.backend.models.User;
import no.solberg.backend.models.dtos.UserGetDTO;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(componentModel="spring")
public interface UserMapper {
    UserGetDTO userToUserGetDTO(User user);
    Collection<UserGetDTO>  usersToUserGetDTOs(Collection<User> users);

    User userGetDTOToUser(UserGetDTO userGetDTO); // TODO: Use different DTO
}
