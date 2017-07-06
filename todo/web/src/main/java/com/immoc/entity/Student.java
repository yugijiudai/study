package com.immoc.entity;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-06
 */
@Data
@Log4j2
public class Student {
    private Long id;

    private String name;


}
