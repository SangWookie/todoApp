package springboot.SpringPractice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.SpringPractice.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
