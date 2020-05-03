package pl.sda.javagdy2.database.model;

public enum Fault {
    KLOCKI_HAMULCOWE ("Klocki hamulcowe"),
    WYMIANA_OPON("Wymiana opon"),
    TARCZE_HAMULCOWE("Tarcze hamulcowe");
//    ROZRZAD,
//    SWIECE,
//    AMORTYZATORY,
//    FILTRY,
//    WYMIANA_OLEJU;
    private String description;

    Fault(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
