package pl.hubertlakomski.passiton.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hubertlakomski.passiton.domain.models.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}
