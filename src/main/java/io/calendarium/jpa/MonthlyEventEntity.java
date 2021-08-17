package io.calendarium.jpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MONTHLY")
public class MonthlyEventEntity extends NMonthlyEventEntity {

    public MonthlyEventEntity() {
        setEveryNthMonth(1);
    }
}
