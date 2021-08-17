package io.calendarium.jpa;

import io.calendarium.core.DailyEvent;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static io.calendarium.core.DailyEvent.isDailyDue;

@Entity
@DiscriminatorValue("DAILY")
public class DailyEventEntity extends RecurringEventEntity implements DailyEvent {


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
