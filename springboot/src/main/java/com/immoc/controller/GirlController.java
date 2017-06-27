package com.immoc.controller;

import com.immoc.dao.GirlRepository;
import com.immoc.pojo.Girl;
import com.immoc.service.GirlService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-27
 */
@RestController
public class GirlController {

    @Resource
    private GirlRepository girlRepository;

    @Resource
    private GirlService girlService;

    /**
     * 查询所有女生列表
     */
    @GetMapping(value = "/listGirls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     */
    @PostMapping(value = "/addGirl")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 查询一个女生
     */
    @GetMapping(value = "/girls/{id}/getGirl")
    public Girl getGirlById(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 更新一个女生
     */
    @PutMapping(value = "/girls/updateGirl")
    public Girl updateGirl(@RequestBody Girl girl) {
        return girlRepository.save(girl);
    }

    /**
     * 删除一个女生
     */
    @DeleteMapping(value = "/girls/{id}/deleteGirl")
    public void deleteGirl(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    @GetMapping(value = "/girls/{before}/{after}/findGirlsByAge")
    public List<Girl> findGirlsByAge(@PathVariable("before") Integer before, @PathVariable("after") Integer after) {
        return girlRepository.findByAgeBeforeAndAgeAfter(before, after);
    }


    @PostMapping(value = "/girls/insertTwo")
    public void insertTwo(){
        girlService.insertTwo();
    }

}
