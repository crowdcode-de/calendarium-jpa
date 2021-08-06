package io.calendarium.jpa;

import io.calendarium.core.CalendarEvent;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Base class of recurring events. A recurring event will recur until the repeatUntil date has been reached
 */
@Entity
@Table(name="CLD_RECURRING_EVENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", columnDefinition = "VARCHAR(32)")
public abstract class RecurringEventEntity implements CalendarEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @Enumerated(EnumType.STRING)
    @Column(name = "PRECISION")
    private Precision precision;

    @Column(name="NAME")
    @NotNull
    private String name;

    @Column(name="DESCRIPTION")
    @Size(max = 255)
    private String description;

    @Column(name="CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created;

    @Column(name = "DUE_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dueDateTime;

    @Column(name="REPEAT_UNTIL")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime repeatUntil;


    @Override
    public abstract boolean isDue(LocalDateTime dateTime);

    @Override
    public abstract boolean  isDue(LocalDate date) ;

    @Override
    public Precision getPrecision() {
        return precision;
    }

    public void setPrecision(Precision precision) {
        this.precision = precision;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public LocalDateTime getRepeatUntil() {
        return repeatUntil;
    }

    public void setRepeatUntil(LocalDateTime repeatUntil) {
        this.repeatUntil = repeatUntil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
