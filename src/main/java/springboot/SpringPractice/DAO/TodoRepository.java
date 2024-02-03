package springboot.SpringPractice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.SpringPractice.entity.TodoEntity;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByAuthor_Pid(long pid);
}
