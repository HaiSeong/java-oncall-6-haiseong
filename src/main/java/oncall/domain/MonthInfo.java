package oncall.domain;

import java.util.List;
import oncall.enums.Day;

public class MonthInfo {
    private static final String INVALID_SIZE_ERROR_MESSAGE = "입력 형식이 잘못되었 습니다";

    private final int Month;
    private final Day day;


    public MonthInfo(int month, Day day) {
        Month = month;
        this.day = day;
    }

    public static MonthInfo createDateInfo(List<String> input) {
        validateInputSize(input.size());
        int month = Integer.parseInt(input.get(0));
        Day day = Day.findByName(input.get(1));
        return new MonthInfo(month, day);
    }

    private static void validateInputSize(int size) {
        if (size != 2) {
            throw new IllegalArgumentException(INVALID_SIZE_ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "DateInfo{" +
                "Month=" + Month +
                ", day='" + day + '\'' +
                '}';
    }
}
