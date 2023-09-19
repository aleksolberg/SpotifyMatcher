package no.solberg.backend.controllers;

import no.solberg.backend.mappers.UserMapper;
import no.solberg.backend.models.User;
import no.solberg.backend.models.dtos.UserGetDTO;
import no.solberg.backend.services.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.net.URISyntaxException;

@RequestMapping("api/v1/users/")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(
                userMapper.usersToUserGetDTOs(userService.findAll()));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody UserGetDTO entity) throws URISyntaxException { // TODO: use different dto
        User user = userService.add(userMapper.userGetDTOToUser(entity));
        URI uri = new URI("api/v1/users/" + user.getId());
        return ResponseEntity.created(uri).build();
    }
}
