package oncall.domain;

import oncall.enums.Day;
import oncall.enums.Month;
import oncall.enums.Type;

public class Date {
    private static final String DATE_FORMAT = "%d월 %d일 %s%s %s\n";
    private static final String INVALID_DATE_ERROR_MESSAGE = "존재하지 않는 날짜입니다.";

    private final Month month;
    private final int date;
    private final Day day;
    private final Type type;
    private Member member;

    private Date(Month month, int date, Day day, Type type) {
        validate(date, month);
        this.month = month;
        this.date = date;
        this.day = day;
        this.type = type;
    }

    private void validate(int date, Month month) {
        if (date < 1 || date > month.getMaxDate()) {
            throw new IllegalArgumentException(INVALID_DATE_ERROR_MESSAGE);
        }
    }

    public static Date createDate(Month month, int date, Day day) {
        Type type = day.getType();
        if (type == Type.WEEKDAY && month.isHoliday(date)) {
            type = Type.HOLIDAY;
        }
        return new Date(month, date, day, type);
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public int getDate() {
        return date;
    }

    public Member getMember() {
        return member;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format(DATE_FORMAT, month.getMonth(), date, day.getName(), type.getDescription(), member.getName());
    }

}
