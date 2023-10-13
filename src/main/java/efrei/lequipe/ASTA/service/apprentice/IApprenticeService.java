package efrei.lequipe.ASTA.service.apprentice;

import efrei.lequipe.ASTA.domain.user.Apprentice;
import org.springframework.data.domain.Page;

public interface IApprenticeService {

    Apprentice createApprentice(Apprentice apprentice);

    Apprentice getApprenticeFromId(String apprenticeId);

    Apprentice updateApprentice(Apprentice apprentice);

    Iterable<Apprentice> getApprentices();

    Page<Apprentice> getPaginatedApprentices(int pageNumber);
}
