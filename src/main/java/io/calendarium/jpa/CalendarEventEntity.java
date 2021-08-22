package io.calendarium.jpa;

import io.calendarium.core.CalendarEvent;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Abstract superclass to all event types to unify all properties which are
 * required by the event entities
 */
@Entity
@Table(name = "CALENDAR_EVENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", columnDefinition = "VARCHAR(32)")
public class CalendarEventEntity implements CalendarEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @Enumerated(EnumType.STRING)
    @Column(name = "PRECISION")
    private Precision precision;

    @NotNull
    @Column(columnDefinition = "VARCHAR(36)", name = "UUID")
    private UUID uuid;

    @Column(columnDefinition = "VARCHAR(64)", name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED")
    private LocalDateTime created;

    @Column(name = "LAST_MODIFIED")
    private LocalDateTime lastModified;

    @Column(name = "NAME")
    @NotNull
    @Size(max = 64)
    private String name;

    @Column(name = "DESCRIPTION")
    @Size(max = 255)
    private String description;

    @Column(name = "EVENT_TYPE")
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name = "DUE_DATE_TIME")
    private LocalDateTime dueDateTime;

    @Column(name = "REPEAT_UNTIL")
    private LocalDateTime repeatUntil;

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

    @Override
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
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
    public Precision getPrecision() {
        return precision;
    }

    public void setPrecision(Precision precision) {
        this.precision = precision;
    }

    @Override
    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    @Override
    public LocalDateTime getRepeatUntil() {
        return repeatUntil;
    }

    public void setRepeatUntil(LocalDateTime repeatUntil) {
        this.repeatUntil = repeatUntil;
    }
}
