package oncall.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static final String READ_MONTH_INFO_INPUT_MESSAGE = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    public static final String READ_WEEKDAY_MEMBERS_INFO_INPUT_MESSAGE = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    public static final String READ_WEEKEND_MEMBERS_INFO_INPUT_MESSAGE = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";

    public String readMonthInfo() {
        System.out.printf(READ_MONTH_INFO_INPUT_MESSAGE);
        return readLine().trim();
    }

    public String readWeekdayMembers() {
        System.out.printf(READ_WEEKDAY_MEMBERS_INFO_INPUT_MESSAGE);
        return readLine().trim();
    }

    public String readWeekendMembers() {
        System.out.printf(READ_WEEKEND_MEMBERS_INFO_INPUT_MESSAGE);
        return readLine().trim();
    }
}
