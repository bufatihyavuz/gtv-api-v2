package org.gtvapi.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateUtil {

    public static LocalDateTime toLocalTime(String utcString ){

        // UTC tarihini sistem local timezone'a göre çevir
        Instant instant2 = Instant.parse(utcString);
        return LocalDateTime.ofInstant(instant2, ZoneId.systemDefault());

    }

}
