package com.egym.model.converters;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by MichaelMAC on 15.01.17.
 */

/**
 * Class converts local time to string that is used in spring.
 */
public class LocalTimeToString implements Converter<LocalTime, String> {

    /**
     * Converts local time to string
     * @param localTime local time
     * @return string
     */
    public String convert(LocalTime localTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return localTime.format(formatter);
    }
}
