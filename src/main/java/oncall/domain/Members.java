package oncall.domain;

import java.util.HashSet;
import java.util.List;

public class Members {
    private static final String DUPLICATED_MEMBER_ERROR_MESSAGE = "이름이 중복되었습니다.";
    public static final String INVALID_ORDER_ERROR_MESSAGE = "올바르지 않은 순번 입니다.";

    private final List<Member> members;

    public Members(List<Member> members) {
        validate(members);
        this.members = members;
    }

    private void validate(List<Member> members) {
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

    private boolean contains(Member member) {
        return members.contains(member);
    }

    @Override
    public String toString() {
        return "WeekdayMembers{" +
                "members=" + members +
                '}';
    }
}
