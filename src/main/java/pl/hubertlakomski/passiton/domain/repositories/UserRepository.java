package pl.hubertlakomski.passiton.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.hubertlakomski.passiton.domain.models.security.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u INNER JOIN u.roles")
    List<User> findAllWithRoles();
}
