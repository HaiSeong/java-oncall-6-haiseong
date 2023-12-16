package oncall.domain;

import java.util.ArrayList;
import java.util.List;
import oncall.enums.Day;
import oncall.enums.Month;

public class Calendar {

    private final List<Date> dates;

    private Calendar(List<Date> dates) {
        this.dates = dates;
    }

    public static Calendar createCalendar(MonthInfo monthInfo) {

        Month month = monthInfo.getMonth();
        Day day = monthInfo.getDay();

        List<Date> dates = new ArrayList<>();
        for (int date = 1; date <= month.getMaxDate(); date++) {
            dates.add(Date.createDate(month, date, day));
            day = Day.getNextDay(day);
        }
        return new Calendar(dates);
    }

    public Member getMember(int input) {
        return dates.stream()
                .filter(date -> date.getDate() == input)
                .map(Date::getMember)
                .findFirst()
                .orElse(null);
    }

    public List<Date> getDates() {
        return dates;
    }

    public List<String> getDateInfos() {
        return dates.stream().map(Date::toString).toList();
    }

}
