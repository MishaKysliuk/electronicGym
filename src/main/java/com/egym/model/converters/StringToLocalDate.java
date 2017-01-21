package com.egym.model.converters;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by MichaelMAC on 15.01.17.
 */
public class StringToLocalDate implements Converter<String, LocalDate> {

    public LocalDate convert(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(s, formatter);
    }
}
