package com.immoc.service;

import com.immoc.mapper.DemoMapper;
import com.immoc.pojo.Demo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-12
 */
@Service
public class DemoService {

    @Resource
    private DemoMapper demoMapper;

    @Transactional
    public void saveDemo(Demo demo) {
        demoMapper.saveDemo(demo);
    }

    public Demo getById(Long id){
        return demoMapper.getById(id);
    }

    public List<Demo> getByName(String name) {
        return demoMapper.getByName(name);
    }
}
