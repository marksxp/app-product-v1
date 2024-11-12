package karate;

import com.intuit.karate.junit5.Karate;

public class ApiProductV1Test {

    @Karate.Test
    Karate testAll() {
        return Karate.run("classpath:features/api-product-v1-test.feature");
    }

}
