package oncall.enums;

import java.util.Arrays;
import java.util.List;

public enum Month {
    JANUARY(1, 31, List.of(1)),
    FEBRUARY(2, 28, List.of()),
    MARCH(3, 31, List.of(1)),
    APRIL(4, 30, List.of()),
    MAY(5, 31, List.of(5)),
    JUNE(6, 30, List.of(6)),
    JULY(7, 31, List.of()),
    AUGUST(8, 31, List.of(15)),
    SEPTEMBER(9, 30, List.of()),
    OCTOBER(10, 31, List.of(3, 9)),
    NOVEMBER(11, 30, List.of()),
    DECEMBER(12, 31, List.of(25)),
    ;

    private static final String NO_SUCH_MONTH_ERROR = "존재하지 않는 달 입니다.";

    private final int month;
    private final int maxDate;
    private final List<Integer> holidays;

    Month(int month, int maxDate, List<Integer> holidays) {
        this.month = month;
        this.maxDate = maxDate;
        this.holidays = holidays;
    }

    public static Month findByNumber(int input) {
        return Arrays.stream(Month.values())
                .filter(month -> input == month.month)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_MONTH_ERROR));
    }

    public int getMonth() {
        return month;
    }

    public int getMaxDate() {
        return maxDate;
    }

    public boolean isHoliday(int date) {
        return holidays.contains(date);
    }
}
