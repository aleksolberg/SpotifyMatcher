package no.solberg.backend.services.user;

import no.solberg.backend.models.User;
import no.solberg.backend.repositories.UserRepository;

import java.util.Collection;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(User entity) {
        return null;
    }
}
