package oncall.controller;


import oncall.domain.MonthInfo;
import oncall.parser.MonthInfoParser;
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
}

