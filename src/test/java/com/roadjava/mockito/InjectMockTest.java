package com.roadjava.mockito;

import com.roadjava.mockito.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @Author xuxinyi
 * @create 2023/12/9 14:10
 * @Description
 */
@RunWith(MockitoJUnitRunner.class)
public class InjectMockTest {
    @InjectMocks
    private UserService userService;
    @Test
    public void test1(){

    }
}
