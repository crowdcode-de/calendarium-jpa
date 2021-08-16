package io.calendarium.jpa;

import io.calendarium.core.YearlyEvent;
import io.calendarium.core.impl.YearlyEventImpl;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("YEARLY")
public class YearlyEventEntity extends NMonthlyEventEntity implements YearlyEvent {

    public YearlyEventEntity() {
        setEveryNthMonth(12);
    }
}
