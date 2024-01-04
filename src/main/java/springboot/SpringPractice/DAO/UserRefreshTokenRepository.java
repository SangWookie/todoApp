package springboot.SpringPractice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.SpringPractice.entity.UserRefreshToken;

import java.util.Optional;

public interface UserRefreshTokenRepository extends JpaRepository<UserRefreshToken, Long> {
    Optional<UserRefreshToken> findByEmail(String email);
}
