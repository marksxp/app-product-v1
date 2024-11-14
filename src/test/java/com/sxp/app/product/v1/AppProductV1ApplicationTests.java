package com.sxp.app.product.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AppProductV1ApplicationTests {

    @Test
    void demo() {
        assertEquals(200, Integer.valueOf("200"));
    }
}
