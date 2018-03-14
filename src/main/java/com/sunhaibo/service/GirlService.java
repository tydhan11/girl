package com.sunhaibo.service;

import com.sunhaibo.domain.Girl;
import com.sunhaibo.domain.Result;
import com.sunhaibo.enums.ResultEnum;
import com.sunhaibo.exception.GirlException;
import com.sunhaibo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 根据ID查单个女生
     * @param id
     * @return Girl
     */
    public Girl girlfindOne(Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 根据年龄查女生
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 全查
     * @return
     */
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }



    public void  getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();

        if(age<10){
            //xiaoxue
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age>10 && age <16){
            //chuzhong
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     *通过id查询一个女生信息
     * @param id
     * @return
     */
    public  Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }





}
