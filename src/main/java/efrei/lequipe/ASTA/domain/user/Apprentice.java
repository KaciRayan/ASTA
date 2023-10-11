package efrei.lequipe.ASTA.domain.user;

import efrei.lequipe.ASTA.domain.cursus.Major;
import efrei.lequipe.ASTA.domain.cursus.Program;
import jakarta.persistence.*;

@Entity
public class Apprentice extends User {
    private Program program;
    private Major major;
    private boolean archived;

    public Apprentice(String id, Program program, Major major, String lastName, String firstName, String email, String phoneNumber, boolean archived) {
        super(id, lastName, firstName, email, phoneNumber);
        this.program = program;
        this.major = major;
        this.archived = archived;
    }

    public Apprentice() {
    }

    public Program getProgram() {
        return program;
    }

    public Major getMajor() {
        return major;
    }

    public boolean isArchived() {
        return archived;
    }

    public void archived(){
        this.archived = true;
    }
}
