package io.calendarium.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static io.calendarium.core.DailyEvent.isDailyDue;

public class DailyEventEntity extends RecurringEventEntity {


    @Override
    public boolean isDue(LocalDateTime dateTime) {
        final LocalDateTime dueDateTime = getDueDateTime();
        final LocalDateTime repeatUntil = getRepeatUntil();
        return isDailyDue(dateTime, dueDateTime, repeatUntil);
    }

    @Override
    public boolean isDue(LocalDate date) {
        final LocalDate dueDate = getDueDateTime().toLocalDate();
        final LocalDateTime repeatUntil = getRepeatUntil();
        return isDailyDue(date, dueDate, repeatUntil);
    }
}
