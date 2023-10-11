package efrei.lequipe.ASTA.service.apprentice;

import efrei.lequipe.ASTA.domain.user.Apprentice;
import efrei.lequipe.ASTA.repository.IApprenticeRepository;
import org.springframework.stereotype.Service;

@Service
public class ApprenticeService implements IApprenticeService {

    private final IApprenticeRepository apprenticeRepository;

    public ApprenticeService(IApprenticeRepository apprenticeRepository) {
        this.apprenticeRepository = apprenticeRepository;
    }

    @Override
    public Apprentice createApprentice(Apprentice apprentice) {
        return apprenticeRepository.save(apprentice);
    }

    @Override
    public Apprentice getApprenticeFromId(String apprenticeId) {
        return apprenticeRepository.findById(apprenticeId).orElse(null);
    }

    @Override
    public Apprentice updateApprentice(Apprentice apprentice) {
        var apprenticeFromRepository = getApprenticeFromId(apprentice.getId());
        if(apprenticeFromRepository == null){
            return null;
        }

        return apprenticeRepository.save(apprentice);
    }

    @Override
    public Apprentice archiveApprentice(Apprentice apprentice) {
        var apprenticeFromRepository = getApprenticeFromId(apprentice.getId());
        if(apprenticeFromRepository == null){
            return null;
        }

        apprenticeFromRepository.archived();
        return apprenticeRepository.save(apprenticeFromRepository);
    }
}
