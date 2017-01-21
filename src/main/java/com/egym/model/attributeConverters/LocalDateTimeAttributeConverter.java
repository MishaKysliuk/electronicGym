package com.egym.model.attributeConverters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by MichaelMAC on 13.01.17.
 */
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalTime, Time> {

    public Time convertToDatabaseColumn(LocalTime localTime) {
        return (localTime == null ? null : Time.valueOf(localTime));
    }

    public LocalTime convertToEntityAttribute(Time time) {
        return (time == null ? null : time.toLocalTime());
    }
}
