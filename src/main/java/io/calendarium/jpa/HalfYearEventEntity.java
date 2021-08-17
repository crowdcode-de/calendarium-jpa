package io.calendarium.jpa;

import io.calendarium.core.HalfYearEvent;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("HALF_YEAR")
public class HalfYearEventEntity extends NMonthlyEventEntity implements HalfYearEvent {

    public HalfYearEventEntity() {
        setEveryNthMonth(6);
    }
}
