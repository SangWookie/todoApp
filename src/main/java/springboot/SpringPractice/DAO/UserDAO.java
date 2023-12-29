package springboot.SpringPractice.DAO;

import springboot.SpringPractice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserEntity, Long> {
}
