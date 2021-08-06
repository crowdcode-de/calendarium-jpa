package io.calendarium.jpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("YEARLY")
public class YearlyEventEntity extends NMonthlyEventEntity {

    public YearlyEventEntity() {
        setEveryNthMonth(12);
    }
}
