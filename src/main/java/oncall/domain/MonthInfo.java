package oncall.domain;

import java.util.List;
import oncall.enums.Day;
import oncall.enums.Month;

public class MonthInfo {
    private static final String INVALID_SIZE_ERROR_MESSAGE = "입력 형식이 잘못되었습니다";

    private final Month month;
    private final Day day;


    private MonthInfo(Month month, Day day) {
        this.month = month;
        this.day = day;
    }

    public static MonthInfo createDateInfo(List<String> input) {
        validateInputSize(input.size());
        Month month = Month.findByNumber(Integer.parseInt(input.get(0)));
        Day day = Day.findByName(input.get(1));
        return new MonthInfo(month, day);
    }

    private static void validateInputSize(int size) {
        if (size != 2) {
            throw new IllegalArgumentException(INVALID_SIZE_ERROR_MESSAGE);
        }
    }

    public Month getMonth() {
        return month;
    }

    public Day getDay() {
        return day;
    }

}
