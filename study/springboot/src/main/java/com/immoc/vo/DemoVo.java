package com.immoc.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-07
 */
@Data
@NoArgsConstructor
public class DemoVo {

    private Integer id;

    private String name;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    private LocalDateTime updateTime;

    /**
     * 不序列化
     */
    @JSONField(serialize = false)
    private String remark;


    public DemoVo(Integer id, String name, Date createTime, LocalDateTime updateTime, String remark) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.remark = remark;
    }
}
