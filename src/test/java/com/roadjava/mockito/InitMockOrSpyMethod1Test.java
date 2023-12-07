package com.roadjava.mockito;

import com.roadjava.mockito.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @Author xuxinyi
 * @create 2023/12/7 23:02
 * @Description
 */

@RunWith(MockitoJUnitRunner.class)
public class InitMockOrSpyMethod1Test {
    @Mock
    private UserService mockUserService;
    @Spy
    private UserService userService;

    @Test
    public void test1(){
        // 是否是mock对象
        MockingDetails mockingDetails = Mockito.mockingDetails(mockUserService);
        System.out.println(mockingDetails.isMock());

        // 是否是spy对象
        System.out.println(Mockito.mockingDetails(userService).isSpy());
    }
}
