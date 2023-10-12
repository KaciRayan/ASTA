package efrei.lequipe.ASTA.controller;

import efrei.lequipe.ASTA.model.apprentice.*;
import efrei.lequipe.ASTA.service.apprentice.IApprenticeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/apprentices")
public class ApprenticeController {
    private final IApprenticeService apprenticeService;

    public ApprenticeController(IApprenticeService apprenticeService) {
        this.apprenticeService = apprenticeService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apprentice created."),
            @ApiResponse(responseCode = "400", description = "Bad request body."),
    })
    @PostMapping()
    public ResponseEntity<ApprenticeResponse> createApprentice(@RequestBody ApprenticeCreateRequest apprentice) {
        var newApprentice = apprenticeService.createApprentice(ApprenticeCreateRequest.ToDomain(apprentice));

        return newApprentice != null
                ? ResponseEntity.ok(ApprenticeResponse.FromDomain(newApprentice))
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apprentices fetched."),
            @ApiResponse(responseCode = "404", description = "No apprentice available."),
    })
    @GetMapping()
    public ResponseEntity<Stream<ApprenticeResponse>> getAllApprentices() {
        var apprentices = apprenticeService.getApprentices();

        return !apprentices.isEmpty()
                ? ResponseEntity.ok(apprentices.stream().map(ApprenticeResponse::FromDomain))
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apprentice fetched."),
            @ApiResponse(responseCode = "404", description = "Apprentice not found."),
    })
    @GetMapping("{apprenticeId}")
    public ResponseEntity<ApprenticeResponse> getApprentice(@PathVariable String apprenticeId) {
        var apprentice = apprenticeService.getApprenticeFromId(apprenticeId);

        return apprentice != null
                ? ResponseEntity.ok(ApprenticeResponse.FromDomain(apprentice))
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apprentice updated."),
            @ApiResponse(responseCode = "404", description = "Apprentice not found."),
            @ApiResponse(responseCode = "400", description = "URI's id differ from request body's id."),
    })
    @PutMapping("{apprenticeId}")
    public ResponseEntity<ApprenticeResponse> updateApprentice(@PathVariable String apprenticeId, @RequestBody ApprenticeUpdateRequest apprentice) {
        if (!apprenticeId.equals(apprentice.id()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        var apprenticeToUpdate = apprenticeService.updateApprentice(ApprenticeUpdateRequest.ToDomain(apprentice));

        return apprenticeToUpdate != null
                ? ResponseEntity.ok(ApprenticeResponse.FromDomain(apprenticeToUpdate))
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apprentice archived."),
            @ApiResponse(responseCode = "404", description = "Apprentice not found or already archived."),
            @ApiResponse(responseCode = "400", description = "URI's id differ from request body's id."),
    })
    @PutMapping("{apprenticeId}/archive")
    public ResponseEntity<ApprenticeResponse> archiveApprentice(@PathVariable String apprenticeId) {
        var apprenticeToArchive = apprenticeService.getApprenticeFromId(apprenticeId);

        if (apprenticeToArchive == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (apprenticeToArchive.isArchived())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        apprenticeToArchive.archived();
        apprenticeToArchive = apprenticeService.updateApprentice(apprenticeToArchive);
        return ResponseEntity.ok(ApprenticeResponse.FromDomain(apprenticeToArchive));
    }
}
