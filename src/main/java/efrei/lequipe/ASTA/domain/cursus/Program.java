package efrei.lequipe.ASTA.domain.cursus;

public enum Program {
    None(null, null),
    L1("L1", null),
    L1_INT("L1", "INT"),
    L2("L2", null),
    L2_INT("L2", "INT"),
    L3("L3", null),
    L3_INT("L3", "INT"),
    L3_APP("L3", "APP"),
    M1("M1", null),
    M1_INT("M1", "INT"),
    M1_APP("M1", "APP"),
    M2("M2", null),
    M2_INT("M2", "INT"),
    M2_APP("M2", "APP");

    private final String level;

    private final String type;

    Program(String level, String specificity) {
        this.level = level;
        this.type = specificity;
    }

    public String getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.level + '-' + this.type;
    }
}
