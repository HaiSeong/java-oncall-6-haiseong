package oncall.parser;

import java.util.Arrays;
import java.util.List;

public class MonthInfoParser {

    private static final String INVALID_FORMAT_ERROR = "잘못된 형식 입니다.";
    private static final String DELIMITER = ",";

    public List<String> parseDateInfo(String line) {
        try {
            return Arrays.stream(line.split(DELIMITER))
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
        }
    }
}
