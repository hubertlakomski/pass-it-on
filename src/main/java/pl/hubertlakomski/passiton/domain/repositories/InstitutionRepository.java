package pl.hubertlakomski.passiton.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hubertlakomski.passiton.domain.models.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
