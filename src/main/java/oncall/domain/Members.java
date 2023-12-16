package oncall.domain;

import java.util.HashSet;
import java.util.List;

public class Members {
    private static final String DUPLICATED_MEMBER_ERROR_MESSAGE = "이름이 중복되었습니다.";
    public static final String ILLEGAL_SIZE_ERROR_MESSAGE = "올바르지 않은 인원수 입니다.";
    public static final String INVALID_ORDER_ERROR_MESSAGE = "올바르지 않은 입력 입니다.";
    public static final int MIN_SIZE = 5;
    public static final int MAX_SIZE = 35;

    private final List<Member> members;
    private int index;

    public Members(List<Member> members) {
        validate(members);
        this.members = members;
        index = 0;
    }

    private void validate(List<Member> members) {
        validateSize(members.size());
        validateDuplicated(members);
    }

    private void validateSize(int size) {

        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(ILLEGAL_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicated(List<Member> members) {
        int size = new HashSet<>(members).size();
        if (size != members.size()) {
            throw new IllegalArgumentException(DUPLICATED_MEMBER_ERROR_MESSAGE);
        }
    }

    public static void checkSameMembers(Members weekdayMembers, Members weekendMembers) {
        for (Member member : weekdayMembers.members) {
            if (!weekendMembers.contains(member)) {
                throw new IllegalArgumentException(INVALID_ORDER_ERROR_MESSAGE);
            }
        }
        for (Member member : weekendMembers.members) {
            if (!weekdayMembers.contains(member)) {
                throw new IllegalArgumentException(INVALID_ORDER_ERROR_MESSAGE);
            }
        }
    }

    public Member next() {
        return members.get((index++) % members.size());
    }

    private boolean contains(Member member) {
        return members.contains(member);
    }

}
