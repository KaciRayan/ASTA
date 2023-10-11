package efrei.lequipe.ASTA.domain.cursus;

public enum Major {
    None(null),
    DIGITAL_TRANSFORMATION("Digital Transformation"),
    SOFTWARE_ENGINEERING("Software Engineering"),
    NETWORK("Network"),
    CYBER_SECURITY("CyberSecurity");

    private final String majorName;

    Major(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return majorName;
    }
}
