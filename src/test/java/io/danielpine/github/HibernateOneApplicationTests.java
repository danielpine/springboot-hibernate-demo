package io.danielpine.github;

import java.util.concurrent.ConcurrentMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.common.collect.Maps;

@SpringBootTest
class HibernateOneApplicationTests {

    @Test
    void contextLoads() {
	ConcurrentMap<String, Integer> newConcurrentMap = Maps.newConcurrentMap();
    }

}
