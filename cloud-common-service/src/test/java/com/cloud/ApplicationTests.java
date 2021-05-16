package com.cloud;

import com.cloud.utils.CloudDateTimeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(CloudDateTimeUtil.getNow(CloudDateTimeUtil.FORMAT_ALL));
    }

    public static void main(String[] args) {
        String string = "456";
        Optional<String> string1 = Optional.ofNullable(string);
//        string1.
        System.out.println(string1.orElse("123"));

    }

}
