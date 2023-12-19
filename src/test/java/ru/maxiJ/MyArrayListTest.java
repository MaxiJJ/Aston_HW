package ru.maxiJ;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MyArrayListTest {

    private MyArrayList<String> myArrayList = new MyArrayList<>();
    private List<String> list = new ArrayList<>();

    @BeforeEach
    public void initEach() {

        String s1 = "Viktor";
        String s2 = "Ivan";
        String s3 = "Nikolay";

        myArrayList.add(s1);
        myArrayList.add(s2);
        myArrayList.add(s3);

        list.add(s1);
        list.add(s2);
        list.add(s3);
    }


    @Test
    @DisplayName("Test add method")
    void add() {
        Assertions.assertEquals(myArrayList.get(1), list.get(1));
    }

    @Test
    @DisplayName("Test delete method")
    void delete() {
        myArrayList.delete(1);
        list.remove(1);
        Assertions.assertEquals(myArrayList.get(1), list.get(1));
    }

    @Test
    @DisplayName("Test get of index method")
    void get() {
        String expected = myArrayList.get(1);
        String actual = list.get(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Count element of collection method test")
    void size() {
        int expected = myArrayList.size();
        int actual = list.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for rewrite element by index")
    void update() {
        myArrayList.update(1, "Olga");
        list.set(1, "Olga");
        Assertions.assertEquals(myArrayList.get(1), list.get(1));
    }
}