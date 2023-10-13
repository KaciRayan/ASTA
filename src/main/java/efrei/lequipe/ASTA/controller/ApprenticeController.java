package efrei.lequipe.ASTA.controller;

import efrei.lequipe.ASTA.model.apprentice.*;
import efrei.lequipe.ASTA.service.apprentice.IApprenticeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping(ApprenticeController.PATH)
@Tag(name = ApprenticeController.NAME)
public class ApprenticeController {
    public final static String NAME = "Apprentices";
    public final static String PATH = "apprentices";
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
    public ResponseEntity<Iterable<ApprenticeResponse>> getAllApprentices() {
        var apprentices = apprenticeService.getApprentices();
        var apprenticesResponse = StreamSupport.stream(apprentices.spliterator(), false)
                        .map(ApprenticeResponse::FromDomain).toList();
        return ResponseEntity.ok(apprenticesResponse);
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

    @GetMapping("page/{pageNumber}")
    public Page<ApprenticeResponse> getAllApprenticesPaginated(@PathVariable int pageNumber) {
        return apprenticeService.getPaginatedApprentices(pageNumber).map(ApprenticeResponse::FromDomain);
    }

    @GetMapping("page/{pageNumber}/{tutorId}")
    public Page<ApprenticeResponse> getAllApprenticesPaginated(@PathVariable int pageNumber, @PathVariable String tutorId) {
        throw new NotImplementedException("pageNumber: " + pageNumber + ", tutorId: " + tutorId);
    }
}
