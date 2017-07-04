package com.immoc.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-27
 */
@Entity
@Data
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private String cupSize;

    @Min(value = 18, message = "未成年啊")
    private Integer age;

    @NotNull(message = "金额必传")
    private Double money;


}
