package pl.hubertlakomski.passiton.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hubertlakomski.passiton.domain.models.security.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
