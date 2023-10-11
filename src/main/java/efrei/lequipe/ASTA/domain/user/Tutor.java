package efrei.lequipe.ASTA.domain.user;

import jakarta.persistence.Entity;

@Entity
public class Tutor extends User{
    private String jobName;
    private String remarks;

    public Tutor(String id, String lastName, String firstName, String email, String phoneNumber, String jobName, String remarks) {
        super(id, lastName, firstName, email, phoneNumber);
        this.jobName = jobName;
        this.remarks = remarks;
    }

    public Tutor() {
    }

    public String getJobName() {
        return jobName;
    }

    public String getRemarks() {
        return remarks;
    }
}

