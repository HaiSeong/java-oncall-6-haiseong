package oncall.enums;

import static oncall.enums.Type.*;

import java.util.Arrays;


public enum Day {
    MONDAY("월", WEEKDAY, 0),
    TUESDAY("화", WEEKDAY, 1),
    WEDNESDAY("수", WEEKDAY, 2),
    THURSDAY("목", WEEKDAY, 3),
    FRIDAY("금", WEEKDAY, 4),
    SATURDAY("토", WEEKEND, 5),
    SUNDAY("일", WEEKEND, 6);

    public static final String NO_SUCH_COMMEND_ERROR = "존재하지 않는 요일 입니다.";
    public static final int WEEK_SIZE = 7;

    private final String name;
    private final Type type;
    private final int code;

    Day(String name, Type type, int code) {
        this.name = name;
        this.type = type;
        this.code = code;
    }

    public static Day findByName(String input) {
        return Arrays.stream(Day.values())
                .filter(day -> input.equals(day.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_COMMEND_ERROR));
    }

    public static Day findByCode(int input) {
        return Arrays.stream(Day.values())
                .filter(day -> input == day.code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_COMMEND_ERROR));
    }

    public static Day getNextDay(Day day) {
        return findByCode((day.code + 1) % WEEK_SIZE);
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
