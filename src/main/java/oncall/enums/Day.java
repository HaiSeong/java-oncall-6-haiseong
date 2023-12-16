package oncall.enums;

import java.util.Arrays;


public enum Day {

    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    public static final String NO_SUCH_COMMEND_ERROR = "존재하지 않는 요일 입니다.";

    private final String name;

    Day(String name) {
        this.name = name;
    }

    public static Day findByName(String input) {
        return Arrays.stream(Day.values())
                .filter(day -> input.equals(day.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_COMMEND_ERROR));
    }

    public String getName() {
        return name;
    }
}
