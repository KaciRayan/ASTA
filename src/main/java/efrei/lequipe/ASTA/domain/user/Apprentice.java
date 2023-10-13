package efrei.lequipe.ASTA.domain.user;

import jakarta.persistence.*;

@Entity
public class Apprentice extends User {
    private String program;
    private String major;
    private boolean archived;

    public Apprentice(
            String id,
            String firstName,
            String lastName,
            String program,
            String major,
            String email,
            String phoneNumber,
            boolean archived) {
        super(id, firstName, lastName, email, phoneNumber);
        this.program = program;
        this.major = major;
        this.archived = archived;
    }

    public Apprentice() {
    }

    public String getProgram() {
        return program;
    }

    public String getMajor() {
        return major;
    }

    public boolean isArchived() {
        return archived;
    }

    public void archived() {
        this.archived = true;
    }
}
