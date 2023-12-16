package oncall.domain;

import java.util.List;
import oncall.enums.Type;

public class Computer {
    private final Calendar calendar;
    private final Members weekdayMembers;
    private final Members weekendMembers;
    private final TemporaryQueue weekdayTemporaryQueue;
    private final TemporaryQueue weekendTemporaryQueue;

    private Computer(Calendar calendar, Members weekdayMembers, Members weekendMembers,
                    TemporaryQueue weekdayTemporaryQueue, TemporaryQueue weekendTemporaryQueue) {
        this.calendar = calendar;
        this.weekdayMembers = weekdayMembers;
        this.weekendMembers = weekendMembers;
        this.weekdayTemporaryQueue = weekdayTemporaryQueue;
        this.weekendTemporaryQueue = weekendTemporaryQueue;
    }

    public static Computer createComputer(Calendar calendar, Members weekdayMembers, Members weekendMembers) {
        return new Computer(calendar, weekdayMembers, weekendMembers,
                TemporaryQueue.createTemporaryQueue(), TemporaryQueue.createTemporaryQueue());
    }

    public void run() {
        List<Date> dates = calendar.getDates();
        for (Date date : dates) {
            Members members = getMembers(date.getType());
            TemporaryQueue temporaryQueue = getTemporaryQueue(date.getType());
            if (temporaryQueue.isNotEmpty()) {
                date.setMember(temporaryQueue.offer());
                continue;
            }
            Member member = members.next();
            if (temporaryQueue.isEmpty() && member.equals(calendar.getMember(date.getDate() - 1))) {
                temporaryQueue.add(member);
                date.setMember(members.next());
                continue;
            }
            date.setMember(member);
        }
    }

    private Members getMembers(Type type) {
        if (type == Type.WEEKDAY) {
            return weekdayMembers;
        }
        return weekendMembers;
    }

    private TemporaryQueue getTemporaryQueue(Type type) {
        if (type == Type.WEEKDAY) {
            return weekdayTemporaryQueue;
        }
        return weekendTemporaryQueue;
    }
}
