package com.egym.model.converters;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by MichaelMAC on 15.01.17.
 */
public class StringToLocalTime implements Converter<String, LocalTime> {

    public LocalTime convert(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String time = s.substring(0,5);
        return LocalTime.parse(time, formatter);
    }
}
