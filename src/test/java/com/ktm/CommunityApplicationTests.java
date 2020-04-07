package com.ktm;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CommunityApplicationTests {

    @Test
    void contextLoads() {
        String[] arr = new String[5];
        int n=5;
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(i);
        }

        List<String> list = Arrays.asList(arr);
        System.out.println(list);
    }



    @Test
    void test1() {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("菜");
        objects.add("鸟");
        objects.add("教");
        objects.add("程");
        String[] arr = new String[0];
        String[] strings = objects.toArray(arr);
        for (String string : strings) {
            System.out.println(string);
        }
    }






}
