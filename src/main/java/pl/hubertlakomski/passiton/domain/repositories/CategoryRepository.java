package pl.hubertlakomski.passiton.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hubertlakomski.passiton.domain.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
