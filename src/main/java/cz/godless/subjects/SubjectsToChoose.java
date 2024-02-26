package cz.godless.subjects;

public enum SubjectsToChoose {
    MATHEMATICS("Mathematics", 0),
    MUSIC("Music", 1),
    SOCIAL_STUDIES("Social studies", 2),
    DRAMA("Drama", 3),
    COMPUTING("Computing", 4),
    LITERATURE("Literature", 5),
    SCIENCE("Science", 6),
    ART("Art", 7),
    GEOGRAPHY("Geography", 8),
    IT("IT", 9),
    GRAPHIC_DESIGN("Graphic design", 10),
    PHILOSOPHY("Philosophy", 11),
    P_E("P/E", 12),
    HISTORY("History", 13),
    LANGUAGES("Languages", 14),
    BIOLOGY("Biology", 15),
    CHEMISTRY("Chemistry", 16),
    ENGLISH("English", 17);

    private final String description;
    private final int subjectCount;

    SubjectsToChoose(String description, int subjectCount){
        this.description = description;
        this.subjectCount = subjectCount;
    }

    public String getDescription() {
        return description;
    }

    public int getSubjectCount() {
        return subjectCount;
    }
}
