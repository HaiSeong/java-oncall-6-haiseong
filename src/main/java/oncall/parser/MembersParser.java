package oncall.parser;

import java.util.Arrays;
import java.util.List;
import oncall.domain.Member;

public class MembersParser {

    private static final String INVALID_FORMAT_ERROR = "잘못된 형식 입니다.";
    private static final String DELIMITER = ",";

    public List<Member> parseMembers(String line) {
        try {
            return Arrays.stream(line.split(DELIMITER))
                    .map(String::trim)
                    .map(Member::new)
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
        }
    }
}
