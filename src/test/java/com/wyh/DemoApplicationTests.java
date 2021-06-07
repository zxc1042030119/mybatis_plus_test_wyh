package com.wyh;

import com.wyh.mapper.UserMapper;
import com.wyh.pojo.User;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void insertTest(){
        final User user = new User();
        user.setName("wyh_自动填充测试");
        userMapper.insert(user);
    }

    @Test
    void updateTest(){
        final User user = new User();
        user.setId("f4fe895acca54bdcaaa0289635c1d59f");
        user.setName("自动填充修改测试222");
        final int i = userMapper.updateById(user);
        System.out.println(user);
        System.out.println(i);
    }

    @Test
    void deleteTest(){
        final int i = userMapper.deleteById("f4fe895acca54bdcaaa0289635c1d59f");

    }

    @Test
    void deleteTest1(){
        final List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        final int i = userMapper.deleteBatchIds(strings);

    }

    @Test
    void deleteTest2(){

        final HashMap<String, Object> map = new HashMap<>();
        // 条件
        map.put("name","111");
        map.put("age","11");
        final int i = userMapper.deleteByMap(map);

    }

    @Test
    void updateVersionTest(){
        final User user = userMapper.selectById("f4fe895acca54bdcaaa0289635c1d59f");
        user.setName("测试乐观锁1");
        final int i = userMapper.updateById(user);
        System.out.println(user);
        System.out.println(i);
    }





}
