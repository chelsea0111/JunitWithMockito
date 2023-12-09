package com.roadjava.mockito;

import com.roadjava.mockito.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @Author xuxinyi
 * @create 2023/12/9 13:33
 * @Description
 */

@RunWith(MockitoJUnitRunner.class)
public class StubTest {
    @Mock
    private List<String> mockList;

    @Mock
    private UserServiceImpl mockUserServiceImpl;
    @Spy
    private UserServiceImpl spyUserServiceImpl;

    // 执行真正的方法
    @Test
    public void test7(){
        when(mockUserServiceImpl.getNumber()).thenCallRealMethod();
        Assertions.assertEquals(0,mockUserServiceImpl.getNumber());
    }

    // 多次插桩
    @Test
    public void test6(){
        // 第一次返回1，第二次2，后面都是3
        doReturn(1,2,3).when(mockList).size();
        Assertions.assertEquals(1,mockList.size());
        Assertions.assertEquals(2,mockList.size());
        Assertions.assertEquals(3,mockList.size());
        Assertions.assertEquals(3,mockList.size());
    }

    // 抛出异常
    @Test
    public void test5(){
        doThrow(RuntimeException.class).when(mockList).get(anyInt());
        try {
            mockList.get(3);
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof RuntimeException);
        }
    }

    // mock对象和spy对象的区别
    @Test
    public void test4(){
        when(mockUserServiceImpl.getNumber()).thenReturn(99);
        System.out.println(mockUserServiceImpl.getNumber()); // 99， mock对象不会调用真实方法，

        when(spyUserServiceImpl.getNumber()).thenReturn(99);
        System.out.println(spyUserServiceImpl.getNumber()); // 先打印getNumber， 再打印99。说明先调用写在when里面的真实方法
    }

    // 无返回值
    @Test
    public void test3(){
        // 调用mockList.clear()，什么也不做
        doNothing().when(mockList).clear();
        mockList.clear();
        // 验证调用了一次mockList.clear()
        verify(mockList,times(1)).clear();
    }

    // 返回值插桩方式二
    @Test
    public void test2() {
        when(mockList.get(1)).thenReturn("111");
        Assertions.assertEquals("111", mockList.get(1));
    }

    // 返回值插桩方式一
    @Test
    public void test1() {
        doReturn("000").when(mockList).get(0);
        Assertions.assertEquals("000", mockList.get(0));
    }
}
