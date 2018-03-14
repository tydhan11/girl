package com.sunhaibo;

import com.sunhaibo.domain.Girl;
import com.sunhaibo.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: 孙海波
 * @Description: 测试GirlService
 * @Date: Created in 2017/12/5 9:09
 * @Modified:
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(8);
        Assert.assertEquals(new Integer(5), girl.getAge());
    }

}
