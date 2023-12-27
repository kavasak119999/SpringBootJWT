package dev.max.service;

import dev.max.dto.User;
import dev.max.entity.RoleEntity;
import dev.max.entity.UserEntity;
import dev.max.exception.RegistrationException;
import dev.max.repository.RoleRepository;
import dev.max.repository.UserRepository;
import dev.max.utils.DtoToEntity;
import dev.max.utils.EntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void saveUser(String username, String password) {
        if (userRepository.findByUsername(username).isPresent())
            throw new RegistrationException(
                    "Client with username: " + username + " already registered");

        User user = User.builder()
                .username(username)
                .password(password)
                .build();

        RoleEntity roleUser = roleRepository.findByName("ROLE_USER");

        userRepository.save(DtoToEntity.userDtoToEntity(user, roleUser));
    }

    public User getByUsername(String username) {
        Optional<UserEntity> optionalUserEntity = userRepository
                .findByUsername(username);
        if (optionalUserEntity.isEmpty()) {
            throw new UsernameNotFoundException(
                    "User with login: " + username + " not found");
        } else {
            return EntityToDto.userEntityToDto(optionalUserEntity.get());
        }
    }
}