package com.imooc.common;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-22
 */
public class MyDateFormatter implements Formatter<Date> {

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(text);
    }

    @Override
    public String print(Date date, Locale locale) {
        return null;
    }
}
