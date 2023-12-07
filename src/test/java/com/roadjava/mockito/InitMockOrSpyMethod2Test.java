package com.roadjava.mockito;

import com.roadjava.mockito.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

/**
 * @Author xuxinyi
 * @create 2023/12/7 23:02
 * @Description
 */

public class InitMockOrSpyMethod2Test {
    private UserService mockUserService;
    private UserService spyUserService;

    @BeforeEach
    public void init(){
        mockUserService = Mockito.mock(UserService.class);
        spyUserService = Mockito.spy(UserService.class);
    }
    @Test
    public void test2(){
        // 是否是mock对象
        System.out.println(Mockito.mockingDetails(mockUserService).isMock());

        // 是否是spy对象
        System.out.println(Mockito.mockingDetails(spyUserService).isSpy());
    }
}
