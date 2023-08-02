package com.gap.test.cases;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@WebMvcTest
public class Sample {

    @Test
    public void test(){
        System.out.print("This is test-------");
    }
}
