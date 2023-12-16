package oncall.controller;

import oncall.domain.Calendar;
import oncall.domain.Computer;
import oncall.domain.MonthInfo;
import oncall.domain.Members;
import oncall.parser.MonthInfoParser;
import oncall.parser.MembersParser;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        MonthInfo monthInfo = getMonthInfo();

        Calendar calendar = Calendar.createCalendar(monthInfo);

        Computer computer = getComputer(calendar);
        computer.run();

        outputView.printCalendar(calendar.getDateInfos());
    }

    private MonthInfo getMonthInfo() {
        MonthInfoParser monthInfoParser = new MonthInfoParser();

        while (true) {
            try {
                String line = inputView.readMonthInfo();
                return MonthInfo.createDateInfo(monthInfoParser.parseDateInfo(line));
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private Computer getComputer(Calendar calendar) {
        MembersParser membersParser = new MembersParser();

        while (true) {
            try {
                String weekdayMembersLine = inputView.readWeekdayMembers();
                Members weekdayMembers = new Members(membersParser.parseMembers(weekdayMembersLine));
                String weekendMembersLine = inputView.readWeekendMembers();
                Members weekendMembers = new Members(membersParser.parseMembers(weekendMembersLine));
                Members.checkSameMembers(weekdayMembers, weekendMembers);

                return Computer.createComputer(calendar, weekdayMembers, weekendMembers);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

}

