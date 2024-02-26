package cz.godless.subjects;

public enum SubjectsToChoose {
    MATHEMATICS("Mathematics", 1),
    MUSIC("Music", 2),
    SOCIAL_STUDIES("Social studies", 3),
    DRAMA("Drama", 4),
    COMPUTING("Computing", 5),
    LITERATURE("Literature", 6),
    SCIENCE("Science", 7),
    ART("Art", 8),
    GEOGRAPHY("Geography", 9),
    IT("IT", 10),
    GRAPHIC_DESIGN("Graphic design", 11),
    PHILOSOPHY("Philosophy", 12),
    P_E("P/E", 13),
    HISTORY("History", 14),
    LANGUAGES("Languages", 15),
    BIOLOGY("Biology", 16),
    CHEMISTRY("Chemistry", 17),
    ENGLISH("English", 18);

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
