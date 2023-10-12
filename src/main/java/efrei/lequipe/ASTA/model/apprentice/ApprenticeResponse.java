package efrei.lequipe.ASTA.model.apprentice;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.lang.NonNull;

public record ApprenticeResponse(@Schema(example = "162ad04a-1859-4bc6-aef1-3976daa675f5") @NonNull String id,
                                 @Schema(example = "Minh-Tri") @NonNull String firstName,
                                 @Schema(example = "NGUYEN") @NonNull String lastName,
                                 @Schema(example = "M1-APP") String program,
                                 @Schema(example = "LSI") String major,
                                 @Schema(example = "minh-tri@domain.com") String email,
                                 @Schema(example = "06.47.59.58.52") String phoneNumber,
                                 @Schema(example = "false") boolean archived) {
    public static ApprenticeResponse FromDomain(efrei.lequipe.ASTA.domain.user.Apprentice apprentice) {
        return new ApprenticeResponse(
                apprentice.getId(),
                apprentice.getProgram(),
                apprentice.getMajor(),
                apprentice.getLastName(),
                apprentice.getFirstName(),
                apprentice.getEmail(),
                apprentice.getPhoneNumber(),
                apprentice.isArchived()
        );
    }
}
