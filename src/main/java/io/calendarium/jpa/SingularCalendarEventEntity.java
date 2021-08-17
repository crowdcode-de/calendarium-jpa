package io.calendarium.jpa;

import io.calendarium.core.CalendarEvent;
import io.calendarium.core.SingularCalendarEvent;
import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Singular event. This is a single event with no recurring
 */
@Entity
@Table(name = "SINGULAR_EVENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", columnDefinition = "VARCHAR(32)")
public class SingularCalendarEventEntity implements SingularCalendarEvent {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @Enumerated(EnumType.STRING)
    @Column(name = "PRECISION")
    private Precision precision;

    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="CREATED")
    private LocalDateTime created;

    @Column(name="DUE_DATE_TIME")
    private LocalDateTime dueDateTime;

    @Override
    public boolean isDue(LocalDateTime dateTime) {
        return isDue(dueDateTime, dateTime, precision);
    }

    @Override
    public boolean isDue(LocalDate date) {
        return isDue(dueDateTime.toLocalDate(), date, precision);
    }

    @Override
    public Precision getPrecision() {
        return precision;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }
}
