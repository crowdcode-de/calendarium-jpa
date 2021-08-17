package io.calendarium.jpa;

import io.calendarium.core.QuartelyEvent;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("QUARTERLY")
public class QuartelyEventEntity extends NMonthlyEventEntity implements QuartelyEvent {

    public QuartelyEventEntity() {
        setEveryNthMonth(3);
    }
}
