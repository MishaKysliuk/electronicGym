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

/**
 * Class converts local time and sql time while saving or retrieving data from database.
 */
@Converter(autoApply = true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, Time> {

    /**
     * Converts local time to sql time
     * @param localTime local time
     * @return sql time
     */
    public Time convertToDatabaseColumn(LocalTime localTime) {
        return (localTime == null ? null : Time.valueOf(localTime));
    }

    /**
     * Converts sql time to local time
     * @param time sql time
     * @return local time
     */
    public LocalTime convertToEntityAttribute(Time time) {
        return (time == null ? null : time.toLocalTime());
    }
}
