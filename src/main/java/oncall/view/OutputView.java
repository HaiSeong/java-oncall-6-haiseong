package oncall.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s\n";


    public void printBlank() {
        System.out.println();
    }

    public void printError(String message) {
        System.out.printf(ERROR_MESSAGE_FORMAT, message);
    }

    public void printCalendar(List<String> strings) {
        printBlank();
        for (String string : strings) {
            System.out.printf(string);
        }
    }
}
