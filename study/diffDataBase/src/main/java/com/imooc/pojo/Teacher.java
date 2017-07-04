package com.imooc.pojo;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/1/18.
 */
@Table(name = "t_teacher")
@Entity
@Data
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tid;

    private String tName;


}
