package efrei.lequipe.ASTA.service.apprentice;

import efrei.lequipe.ASTA.domain.user.Apprentice;
import efrei.lequipe.ASTA.repository.IApprenticeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ApprenticeService implements IApprenticeService {

    private final IApprenticeRepository apprenticeRepository;
    private final static int APPRENTICE_PER_PAGE = 5;

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
        return apprenticeRepository.existsById(apprentice.getId()) ? apprenticeRepository.save(apprentice) : null;
    }

    @Override
    public Iterable<Apprentice> getApprentices() {
        return apprenticeRepository.findAll();
    }

    @Override
    public Page<Apprentice> getPaginatedApprentices(int pageNumber) {
        return apprenticeRepository.findAll(PageRequest.of(pageNumber, APPRENTICE_PER_PAGE));
    }
}
