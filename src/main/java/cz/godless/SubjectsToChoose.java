package cz.godless;

public enum SubjectsToChoose {
    MATHEMATICS("Mathematics"),
    MUSIC("Music"),
    SOCIAL_STUDIES("Social studies"),
    DRAMA("Drama"),
    COMPUTING("Computing"),
    LITERATURE("Literature"),
    SCIENCE("Science"),
    ART("Art"),
    GEOGRAPHY("Geography"),
    IT("IT"),
    GRAPHIC_DESIGN("Graphic design"),
    PHILOSOPHY("Philosophy"),
    P_E("P/E"),
    HISTORY("History"),
    LANGUAGES("Languages"),
    BIOLOGY("Biology"),
    CHEMISTRY("Chemistry"),
    ENGLISH("English");

    private final String description;

    SubjectsToChoose(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
