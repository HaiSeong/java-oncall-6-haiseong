package oncall.controller;


import java.util.List;
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
        System.out.println("dateInfo = " + monthInfo);
        List<Members> membersList = getMembers();
        Members weekdayMembers = membersList.get(0);
        Members weekendMembers = membersList.get(1);
        System.out.println("weekdayMembers = " + weekdayMembers);
        System.out.println("weekendMembers = " + weekendMembers);
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

    private List<Members> getMembers() {
        MembersParser membersParser = new MembersParser();

        while (true) {
            try {
                String weekdayMembersLine = inputView.readWeekdayMembers();
                Members weekdayMembers = new Members(membersParser.parseMembers(weekdayMembersLine));
                String weekendMembersLine = inputView.readWeekendMembers();
                Members weekendMembers = new Members(membersParser.parseMembers(weekendMembersLine));
                Members.checkSameMembers(weekdayMembers, weekendMembers);
                return List.of(weekdayMembers, weekdayMembers);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}

