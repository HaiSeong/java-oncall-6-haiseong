package oncall.domain;

import java.util.LinkedList;
import java.util.List;

public class TemporaryQueue {
    private static final int EMPTY_QUEUE_SIZE = 0;

    private final List<Member> temporaryQueue;

    private TemporaryQueue(List<Member> temporaryQueue) {
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
        return temporaryQueue.size() != EMPTY_QUEUE_SIZE;
    }

    public boolean isEmpty() {
        return temporaryQueue.size() == EMPTY_QUEUE_SIZE;
    }
}
