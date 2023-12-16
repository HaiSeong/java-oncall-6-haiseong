package oncall.enums;

public enum Type {
    WEEKDAY(""),
    WEEKEND(""),
    HOLIDAY("(휴일)"),
    ;

    private final String description;

    Type(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
