package pieritz.prince.CRMAPP.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pieritz.prince.CRMAPP.domain.Role;
import pieritz.prince.CRMAPP.domain.User;
import pieritz.prince.CRMAPP.dto.UserResponse;
import pieritz.prince.CRMAPP.repositories.RoleRepository;
import pieritz.prince.CRMAPP.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImplementation implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }



    public List<String> getAllUsernames() {
        return userRepository.findAllUsernames();
    }

    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        return entitiesToResponses(users);
    }

    private List<UserResponse> entitiesToResponses(List<User> users) {
        List<UserResponse> clientsResponse = new ArrayList<>();

        for (User user : users) {
            clientsResponse.add(entityToResponse(user));
        }
        return clientsResponse;
    }

    private UserResponse entityToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .build();
    }

    public UserResponse getUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            User user = userRepository.findById(id).get();
            return UserResponse.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .firstname(userRepository.findById(id).get().getFirstname())
                    .lastname(userRepository.findById(id).get().getLastname())
                    .roles(getUserRoles(user))
                    .build();
        }
        return new UserResponse();
    }

    private Set<String> getUserRoles(User user) {
        return user.getRoles().stream().map(Role::getName).collect(Collectors.toSet());
    }
}