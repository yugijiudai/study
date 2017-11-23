package com.immoc.vo;

import com.github.pagehelper.Page;
import lombok.Data;

import java.util.List;

/**
 * @author yugi
 * @apiNote
 * @since 2017-11-10
 */
@Data
public class PageVo<E> {

    private int pageSize;

    private int pageNum;

    private List<E> list;

    public PageVo(Page<E> list) {
        this.list = list.getResult();
        this.pageSize = list.getPageSize();
        this.pageNum = list.getPageNum();
    }
}
