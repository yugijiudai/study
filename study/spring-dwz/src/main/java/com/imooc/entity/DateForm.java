package com.imooc.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-22
 */
@Data
public class DateForm {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate localDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime localTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime localDateTime;
}
