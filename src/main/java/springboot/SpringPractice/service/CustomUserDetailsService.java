package springboot.SpringPractice.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springboot.SpringPractice.DAO.UserRepository;
import springboot.SpringPractice.DTO.CustomUserDetails;
import springboot.SpringPractice.entity.UserEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userData = userRepository.findByEmail(username);

        if (userData != null){
            return new CustomUserDetails(userData);
        }

        return null;
    }
}
