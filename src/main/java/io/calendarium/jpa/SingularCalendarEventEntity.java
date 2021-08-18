package io.calendarium.jpa;

import io.calendarium.core.CalendarEvent;
import io.calendarium.core.SingularCalendarEvent;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

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

    @NotNull
    @Column(columnDefinition="VARCHAR(36)")
    private UUID uuid;

    @Version
    private Long version;

    @Enumerated(EnumType.STRING)
    @Column(name = "PRECISION")
    private Precision precision;

    @Column(name="NAME")
    @Size(max=64)
    private String name;

    @Column(name="DESCRIPTION")
    @Size(max=255)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setPrecision(Precision precision) {
        this.precision = precision;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }
}
