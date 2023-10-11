package efrei.lequipe.ASTA.repository;

import efrei.lequipe.ASTA.domain.user.Apprentice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IApprenticeRepository extends JpaRepository<Apprentice, String> {
}
