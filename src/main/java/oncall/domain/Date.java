package oncall.domain;

import oncall.enums.Day;
import oncall.enums.Month;
import oncall.enums.Type;

public class Date {
    private final Month month;
    private final int date;
    private final Day day;
    private final Type type;

    private Date(Month month, int date, Day day, Type type) {
        this.month = month;
        this.date = date;
        this.day = day;
        this.type = type;
    }

    public static Date createDate(Month month, int date, Day day) {
        Type type = day.getType();
        if (type == Type.WEEKDAY && month.isHoliday(date)) {
            type = Type.HOLIDAY;
        }
        return new Date(month, date, day, type);
    }

    @Override
    public String toString() {
        return "Date{" +
                "month=" + month +
                ", date=" + date +
                ", day=" + day +
                ", type=" + type +
                '}';
    }
}
