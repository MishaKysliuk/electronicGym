package com.egym.model.converters;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by MichaelMAC on 15.01.17.
 */

/**
 * Class converts string to local time that is used in spring.
 */
public class StringToLocalTime implements Converter<String, LocalTime> {

    /**
     * Convets string to local time
     * @param s string
     * @return local time
     */
    public LocalTime convert(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String time = s.substring(0,5);
        return LocalTime.parse(time, formatter);
    }
}
