package JavaApp.questionApp.repos;

import JavaApp.questionApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
