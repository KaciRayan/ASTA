package efrei.lequipe.ASTA.model;

import efrei.lequipe.ASTA.domain.cursus.Major;
import efrei.lequipe.ASTA.domain.cursus.Program;
public record Apprentice(String id, Program program, Major major, String lastName, String firstName, String email, String phoneNumber, boolean archived) {
    public static Apprentice FromDomain(efrei.lequipe.ASTA.domain.user.Apprentice apprentice){
        return new Apprentice(
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
    public static efrei.lequipe.ASTA.domain.user.Apprentice ToDomain(Apprentice apprentice){
        return new efrei.lequipe.ASTA.domain.user.Apprentice(
                apprentice.id,
                apprentice.program,
                apprentice.major,
                apprentice.lastName,
                apprentice.firstName,
                apprentice.email,
                apprentice.phoneNumber,
                apprentice.archived
        );
    }
}
