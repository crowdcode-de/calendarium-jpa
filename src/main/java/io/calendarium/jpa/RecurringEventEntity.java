package io.calendarium.jpa;

import io.calendarium.core.RecurringEvent;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base class of recurring events. A recurring event will recur until the repeatUntil date has been reached
 */
@Entity
@Table(name="RECURRING_EVENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", columnDefinition = "VARCHAR(32)")
public abstract class RecurringEventEntity extends AbstractEventEntity implements RecurringEvent {


    @Column(name = "DUE_DATE_TIME")
    private LocalDateTime dueDateTime;

    @Column(name="REPEAT_UNTIL")
    private LocalDateTime repeatUntil;

    @Override
    public abstract boolean isDue(LocalDateTime dateTime);

    @Override
    public abstract boolean  isDue(LocalDate date) ;


    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public LocalDateTime getRepeatUntil() {
        return repeatUntil;
    }

    public void setRepeatUntil(LocalDateTime repeatUntil) {
        this.repeatUntil = repeatUntil;
    }


}
