package com.immoc.controller;

import com.immoc.dao.GirlRepository;
import com.immoc.pojo.Girl;
import com.immoc.service.GirlService;
import com.imooc.enums.ResultEnum;
import com.imooc.util.ResultUtil;
import com.imooc.vo.ResultVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-27
 */
@RestController
@Log4j2
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


    @GetMapping(value = "/listGirls2")
    public ResultVo girlList2() {
        List<Girl> girls = girlRepository.findAll();
        return ResultUtil.buildSuccess(girls);
    }

    /**
     * 添加一个女生
     */
    @PostMapping(value = "/addGirl")
    public ResultVo girlAdd(@Valid Girl girl, BindingResult result) {
        if (result.hasErrors()) {
            return ResultUtil.buildError(ResultEnum.UNKNOWN_ERROR, result.getFieldError().getDefaultMessage());
        }
        return ResultUtil.buildSuccess(girlRepository.save(girl));
    }

    /**
     * return
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
    public void insertTwo() {
        girlService.insertTwo();
    }


    @GetMapping(value = "/girls/{id}/getAge")
    public void getAge(@PathVariable("id") Integer id) {
        girlService.getAge(id);
    }

}
