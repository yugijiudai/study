package com.immoc.service;

import com.immoc.dao.GirlRepository;
import com.immoc.enums.ResultEnum;
import com.immoc.exception.GirlException;
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


    public void getAge(Integer id) {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 13) {
            // 返回萝莉
            throw new GirlException(ResultEnum.LOLY);
        }
        if (age > 13 && age < 17) {
            throw new GirlException(ResultEnum.JK);
        }
    }

    /**
     * 通过id查询一个女生信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
