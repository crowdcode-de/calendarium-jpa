package io.calendarium.jpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("QUARTERLY")
public class QuartelyEventEntity extends NMonthlyEventEntity {

    public QuartelyEventEntity() {
        setEveryNthMonth(3);
    }
}
