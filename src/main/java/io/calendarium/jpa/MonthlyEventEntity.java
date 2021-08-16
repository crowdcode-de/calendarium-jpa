package io.calendarium.jpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MONTHLY")
public class MonthlyEventEntity extends NMonthlyEventEntity {

    public MonthlyEventEntity() {
        setEveryNthMonth(1);
    }
}
