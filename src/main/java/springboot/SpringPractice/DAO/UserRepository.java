package springboot.SpringPractice.DAO;

import springboot.SpringPractice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    Boolean existsByEmail(String email);
}
