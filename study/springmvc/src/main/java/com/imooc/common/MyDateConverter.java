package com.imooc.common;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-22
 */
public class MyDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(source);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
