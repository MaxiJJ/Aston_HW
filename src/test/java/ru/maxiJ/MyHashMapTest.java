package ru.maxiJ;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    private MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
    private Map<Integer, String> map = new HashMap<>();

    @BeforeEach
    public void initEach() {
        myHashMap.put(1, "a");
        myHashMap.put(2, "b");
        myHashMap.put(3, "c");

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
    }

    @Test
    void put() {
        Assertions.assertEquals(myHashMap.get(1), map.get(1));
    }

    @Test
    void get() {
        var excepted = myHashMap.get(2);
        var actual = map.get(2);
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void remove() {
        myHashMap.remove(2);
        map.remove(2);
        Assertions.assertEquals(myHashMap.get(2), map.get(2));
    }
}