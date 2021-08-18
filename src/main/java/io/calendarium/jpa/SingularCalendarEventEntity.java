package io.calendarium.jpa;

import io.calendarium.core.CalendarEvent;
import io.calendarium.core.SingularCalendarEvent;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Singular event. This is a single event with no recurring
 */
@Entity
@Table(name = "SINGULAR_EVENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", columnDefinition = "VARCHAR(32)")
public class SingularCalendarEventEntity extends AbstractEventEntity implements SingularCalendarEvent {


    @Column(name="DUE_DATE_TIME")
    private LocalDateTime dueDateTime;

    @Override
    public boolean isDue(LocalDateTime dateTime) {
        return isDue(dueDateTime, dateTime, getPrecision());
    }

    @Override
    public boolean isDue(LocalDate date) {
        return isDue(dueDateTime.toLocalDate(), date, getPrecision());
    }

    @Override
    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }
}
