package com.egym.model.converters;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by MichaelMAC on 15.01.17.
 */
public class LocalDateToString implements Converter<LocalDate, String> {

    public String convert(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return localDate.format(formatter);
    }
}
