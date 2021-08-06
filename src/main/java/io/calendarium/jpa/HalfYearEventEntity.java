package io.calendarium.jpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("HALF_YEAR")
public class HalfYearEventEntity extends NMonthlyEventEntity {

    public HalfYearEventEntity() {
        setEveryNthMonth(6);
    }
}
