package oncall.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static final String READ_MONTH_INFO_INPUT_MESSAGE = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";

    public String readMonthInfo() {
        System.out.println(READ_MONTH_INFO_INPUT_MESSAGE);
        return readLine().trim();
    }
}
