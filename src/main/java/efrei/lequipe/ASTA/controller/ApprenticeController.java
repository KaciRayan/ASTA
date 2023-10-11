package efrei.lequipe.ASTA.controller;

import efrei.lequipe.ASTA.model.Apprentice;
import efrei.lequipe.ASTA.response.ResponseObject;
import efrei.lequipe.ASTA.service.apprentice.IApprenticeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apprentice")
public class ApprenticeController {
    private final IApprenticeService apprenticeService;

    public ApprenticeController(IApprenticeService apprenticeService) {
        this.apprenticeService = apprenticeService;
    }

    @PostMapping("/create/")
    public ResponseEntity<Object> createApprentice(@RequestBody Apprentice apprentice) {
        var newApprentice = apprenticeService.createApprentice(Apprentice.ToDomain(apprentice));

        return newApprentice != null
                ? ResponseObject.build(HttpStatus.OK, Apprentice.FromDomain(newApprentice))
                : ResponseObject.build(HttpStatus.NOT_FOUND, null);
    }

    @GetMapping("/read/{apprenticeId}")
    public ResponseEntity<Object> getApprentice(@PathVariable String apprenticeId) {
        var apprentice = apprenticeService.getApprenticeFromId(apprenticeId);

        return apprentice != null
                ? ResponseObject.build(HttpStatus.OK, Apprentice.FromDomain(apprentice))
                : ResponseObject.build(HttpStatus.NOT_FOUND, null);
    }

    @PutMapping("/update/")
    public ResponseEntity<Object> updateApprentice(@RequestBody Apprentice apprentice) {
        var newApprentice = apprenticeService.updateApprentice(Apprentice.ToDomain(apprentice));

        return newApprentice != null
                ? ResponseObject.build(HttpStatus.OK, Apprentice.FromDomain(newApprentice))
                : ResponseObject.build(HttpStatus.NOT_FOUND, null);
    }

    @PutMapping("/archive/")
    public ResponseEntity<Object> archiveApprentice(@RequestBody Apprentice apprentice) {
        var newApprentice = apprenticeService.updateApprentice(Apprentice.ToDomain(apprentice));

        return newApprentice != null
                ? ResponseObject.build(HttpStatus.OK, Apprentice.FromDomain(newApprentice))
                : ResponseObject.build(HttpStatus.NOT_FOUND, null);
    }
}
