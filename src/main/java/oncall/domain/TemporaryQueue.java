package oncall.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class TemporaryQueue {

    private final List<Member> temporaryQueue;

    public TemporaryQueue(List<Member> temporaryQueue) {
        this.temporaryQueue = temporaryQueue;
    }

    public static TemporaryQueue createTemporaryQueue() {
        return new TemporaryQueue(new LinkedList<>());
    }


    public void add(Member member) {
        temporaryQueue.add(member);
    }

    public Member offer() {
        return temporaryQueue.remove(0);
    }

    public boolean isNotEmpty() {
        return temporaryQueue.size() != 0;
    }

    public boolean isEmpty() {
        return temporaryQueue.size() == 0;
    }

    public Stream<Member> stream() {
        return temporaryQueue.stream();
    }
}
