package com.egym.model.attributeConverters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by MichaelMAC on 13.01.17.
 */

/**
 * Class converts local date and sql date while saving or retrieving data from database.
 */
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    /**
     * Converts local date to sql date
     * @param locDate local date
     * @return sql date
     */
    public Date convertToDatabaseColumn(LocalDate locDate) {
        return (locDate == null ? null : Date.valueOf(locDate));
    }

    /**
     * Converts sql date to local date
     * @param sqlDate sql date
     * @return local date
     */
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        return (sqlDate == null ? null : sqlDate.toLocalDate());
    }
}
