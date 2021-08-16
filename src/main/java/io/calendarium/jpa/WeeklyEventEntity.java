package io.calendarium.jpa;

import io.calendarium.core.WeeklyEvent;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static io.calendarium.core.WeeklyEvent.isWeeklyDue;

@Entity
@DiscriminatorValue("WEEKLY")
public class WeeklyEventEntity extends RecurringEventEntity implements WeeklyEvent {

    @Column(name="DAY_OF_WEEK", columnDefinition = "VARCHAR(10)")
    @Enumerated
    private DayOfWeek dayOfWeek;

    @Override
    public boolean isDue(LocalDateTime dateTime) {
        final LocalDateTime dueDateTime = getDueDateTime();
        final DayOfWeek dayOfWeek = this.dayOfWeek;
        return isWeeklyDue(dateTime, dueDateTime, dayOfWeek);
    }

    @Override
    public boolean isDue(LocalDate date) {
        final LocalDate dueDate = getDueDateTime().toLocalDate();
        final DayOfWeek dayOfWeek = this.dayOfWeek;
        return isWeeklyDue(date, dueDate, dayOfWeek);
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
