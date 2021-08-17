package io.calendarium.jpa;

import io.calendarium.core.NMonthlyEvent;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static io.calendarium.core.NMonthlyEvent.isNMonthDue;

@Entity
@DiscriminatorValue("NMONTHLY")
public class NMonthlyEventEntity extends RecurringEventEntity implements NMonthlyEvent {

    @Column(name="EVERY_NTH_MONTH")
    private int everyNthMonth;

    @Override
    public boolean isDue(LocalDateTime dateTime) {
        final LocalDateTime dueDateTime = getDueDateTime();
        int everyNthMonth = this.everyNthMonth;

        return isNMonthDue(dateTime, dueDateTime, everyNthMonth, getRepeatUntil());
    }

    @Override
    public boolean isDue(LocalDate date) {
        final LocalDate localDate = getDueDateTime().toLocalDate();
        final int everyNthMonth = this.everyNthMonth;
        final LocalDateTime repeatUntil = getRepeatUntil();

        return isNMonthDue(date, localDate, everyNthMonth, repeatUntil);
    }

    public int getEveryNthMonth() {
        return everyNthMonth;
    }

    public void setEveryNthMonth(int everyNthMonth) {
        this.everyNthMonth = everyNthMonth;
    }
}
