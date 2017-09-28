package com.imooc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;


/**
 * @author yugi
 * @apiNote
 * @since 2017-06-21
 */
// @Data
@ToString
@Setter
@XmlRootElement(name = "admin")
public class Admin {


    private String name;

    private Integer age;

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    @XmlElement(name = "age")
    public Integer getAge() {
        return age;
    }

}
