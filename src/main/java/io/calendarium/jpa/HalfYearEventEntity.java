package io.calendarium.jpa;

import io.calendarium.core.HalfYearEvent;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("HALF_YEAR")
public class HalfYearEventEntity extends NMonthlyEventEntity implements HalfYearEvent {

    public HalfYearEventEntity() {
        setEveryNthMonth(6);
    }
}
