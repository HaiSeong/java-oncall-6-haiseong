package oncall.domain;

import java.util.Objects;

public class Member {
    private static final String INVALID_LENGTH_ERROR_MESSAGE = "이름은 최대 5글자 입니다.";
    private static final int EMPTY_NAME_LENGTH = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Member(String name) {
        validateLength(name.length());
        this.name = name;
    }


    private void validateLength(int length) {
        if (length == EMPTY_NAME_LENGTH || length > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Member member = (Member) o;
        return Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
