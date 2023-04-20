package org.example;

import org.junit.jupiter.api.*;

import java.nio.file.attribute.UserDefinedFileAttributeView;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private MyArrayList<String> list = new MyArrayList<>();
    private MyArrayList<Integer> list2 = new MyArrayList<>();

    @BeforeEach
    void setUp(){
        for(int i=0; i<15; i++){
            list.add("Element" + i);
        }

        for(int i=0; i<10; i++){
            list2.add(i);
        }
    }

    @AfterEach
    void clear(){
        list.clear();
    }

    @Test
    void testAdd(){
        Assertions.assertEquals(15, list.size());
        Assertions.assertEquals("Element0", list.get(0));
    }

    @Test
    void testGet() {
        assertEquals("Element0", list.get(0));
        assertEquals("Element1", list.get(1));
    }


    @Test
    void testContains() {
        list.add("Element1");
        list.add("Element2");
        assertTrue(list.contains("Element1"));
        assertThat(list.contains("Element111")).isFalse();
    }

    @Test
    void testIndexOf() {
        assertEquals(0, list.indexOf("Element0"));
        assertEquals(1, list.indexOf("Element1"));
        assertEquals(-1, list.indexOf("Element12312"));
    }

    @Test
    void testClear() {
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void testRemove() {
        assertEquals("Element1", list.remove(1));
        assertEquals(14, list.size());
    }

    @Test
    void testRemoveIf(){
        assertThat(list.size()).isEqualTo(15);
        assertThat(list.removeIf("Element2")).isTrue();
        assertThat(list.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("배열 크기 줄어드는지 확인")
    void testArraySizeReduce(){
        for(int i=0; i<3; i++){
            list2.remove(0);
        }

        for(int i=0; i<list2.size(); i++){
            System.out.println(list2.get(i));
        }
    }

    @Test
    void testIntegerMyArrayList() {

        assertThat(list2.size()).isEqualTo(10);
        assertThat(list2.add(111));
        assertThat(list2.size()).isEqualTo(11);
        assertThat(list2.contains(5)).isTrue();
        assertThat(list2.indexOf(2)).isEqualTo(2);

        assertThatThrownBy(() -> {
            list2.remove(11);
        }).isInstanceOf(IndexOutOfBoundsException.class);

        assertThat(list2.removeIf(1234)).isFalse();
    }
}