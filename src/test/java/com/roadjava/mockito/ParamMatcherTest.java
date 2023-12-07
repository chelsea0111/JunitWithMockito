package com.roadjava.mockito;

import com.roadjava.mockito.bean.req.UserUpdateReq;
import com.roadjava.mockito.bean.vo.UserVO;
import com.roadjava.mockito.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xuxinyi
 * @create 2023/12/7 23:12
 * @Description
 */

@RunWith(MockitoJUnitRunner.class)
public class ParamMatcherTest {
    @Mock
    private UserService mockUserService;

    @Test
    public void test4() {
        List<String> features = new ArrayList<>();
        mockUserService.add("zs", "1111", features);

        // 验证 mock对象 是否按照指定的参数 调用了add方法 且次数为1
        // 如果是 则通过 否则 不通过
        Mockito.verify(mockUserService, Mockito.times(1)).add("zs", "1111", features);
        Mockito.verify(mockUserService, Mockito.times(1)).add(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyList());
    }


    // 插桩
    @Test
    public void test3() {
        UserUpdateReq userUpdateReq1 = new UserUpdateReq();
        userUpdateReq1.setId(1L);
        userUpdateReq1.setPhone("1111");

        UserUpdateReq userUpdateReq2 = new UserUpdateReq();
        userUpdateReq2.setId(2L);
        userUpdateReq2.setPhone("2222");

        // 拦截任意的UserUpdateReq对象
        Mockito.doReturn(99).when(mockUserService).modifyById(ArgumentMatchers.any());

        int result1 = mockUserService.modifyById(userUpdateReq1);
        System.out.println("result1 = " + result1); // 返回99
        int result2 = mockUserService.modifyById(userUpdateReq2);
        System.out.println("result2 = " + result2); // 返回99

    }

    //插桩
    @Test
    public void test2() {
        UserUpdateReq userUpdateReq1 = new UserUpdateReq();
        userUpdateReq1.setId(1L);
        userUpdateReq1.setPhone("1111");

        UserUpdateReq userUpdateReq2 = new UserUpdateReq();
        userUpdateReq2.setId(2L);
        userUpdateReq2.setPhone("2222");

        // doXxx().when(obj).someMethod(),obj是mock或spy对象
        // 当调用 mockUserService 的 modifyById 方法，并且传入 userUpdateReq1 参数时，应该返回值 99
        Mockito.doReturn(99).when(mockUserService).modifyById(userUpdateReq1);

        int result1 = mockUserService.modifyById(userUpdateReq1);
        System.out.println("result1 = " + result1); // 返回99
        int result2 = mockUserService.modifyById(userUpdateReq2);
        System.out.println("result2 = " + result2); // 返回0，而不是null
    }

    @Test
    public void test1() {
        UserVO userVO = mockUserService.selectById(1L);
        // 直接调用mock对象的方法，返回是null
        System.out.println("userVO = " + userVO);
    }
}
