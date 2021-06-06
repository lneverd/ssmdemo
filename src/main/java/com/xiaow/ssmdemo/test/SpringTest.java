package com.xiaow.ssmdemo.test;

import com.xiaow.ssmdemo.model.PnumBean;
import com.xiaow.ssmdemo.service.PnumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@ComponentScan(basePackages = "com.xiaow.ssmdemo")
public class SpringTest {
    @Autowired
    PnumService mapper;
    @Test
    public void Test(){
        mapper.insert(new PnumBean());
    }
}
