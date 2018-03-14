package com.sunhaibo.controller;

import com.sunhaibo.aspect.HttpAspect;
import com.sunhaibo.domain.Result;
import com.sunhaibo.repository.GirlRepository;
import com.sunhaibo.domain.Girl;
import com.sunhaibo.service.GirlService;
import com.sunhaibo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询女生列表
     * @return Result
     */
    @GetMapping(value = "/girls")
    public Result girlList() {
        logger.info("girlList");//日志式输出

        return ResultUtil.success(girlService.girlList());
    }

    /**
     * 添加女生对象
     * @param girl
     * @param bindingResult
     * @return Result
     */
    @PostMapping(value = "/girls")
    //@Valid 表示验证对象girl 验证的结果在BindingResult中
    public Result<Girl> girlAdd(@Valid  Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return null;
            //return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Result<Girl> girlfindOne(@PathVariable("id") Integer id) {
        return ResultUtil.success(girlService.girlfindOne(id));
        //return girlRepository.findOne(id);
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public Result girlFindByAge(@PathVariable("age") Integer age) {
       // return girlRepository.findByAge(age);
        return ResultUtil.success(girlService.findByAge(age));
    }


    /**
     *
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);
    }


    /**
     *
     * @param id
     * @throws Exception
     */
    @GetMapping(value = "girls/getAge/{id}")
    public  void getAge(@PathVariable("id") Integer id)throws Exception{
        girlService.getAge(id);
    }

    /**
     * 删除
     */
    @DeleteMapping(value = "/girl/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }
}
