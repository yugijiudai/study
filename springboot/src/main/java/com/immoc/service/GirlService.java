package com.immoc.service;

import com.immoc.dao.GirlRepository;
import com.immoc.pojo.Girl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-27
 */
@Service
public class GirlService {

    @Resource
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girl1 = new Girl();
        girl1.setCupSize("G");
        girl1.setAge(16);
        girlRepository.save(girl1);
        Girl girl2 = new Girl();
        girl2.setCupSize("K Cup");
        girl2.setAge(17);
        girlRepository.save(girl2);
    }
}
