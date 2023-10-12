package efrei.lequipe.ASTA.service.apprentice;

import efrei.lequipe.ASTA.domain.user.Apprentice;

import java.util.List;

public interface IApprenticeService {

    Apprentice createApprentice(Apprentice apprentice);

    Apprentice getApprenticeFromId(String apprenticeId);

    Apprentice updateApprentice(Apprentice apprentice);

    List<Apprentice> getApprentices();
}
