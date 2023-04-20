package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {


    private MyHashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    void testPut() {
        assertNull(map.put("Key1", 1));
        assertEquals(1, map.size());
    }

    @Test
    void testPutReplace() {
        map.put("Key1", 1);
        assertEquals(Integer.valueOf(2), map.put("Key1", 2));
        assertEquals(1, map.size());
    }

    @Test
    void testGet() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertEquals(Integer.valueOf(1), map.get("Key1"));
        assertEquals(Integer.valueOf(2), map.get("Key2"));
    }

    @Test
    void testRemove() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        Assertions.assertThat(map.remove("Key2")).isEqualTo(2);
        assertNull(map.remove("Key3"));
        assertEquals(1, map.size());
    }

    @Test
    void testSize() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        map.put("Key3", 3);
        assertEquals(3, map.size());
    }

    @Test
    void testContainsKey() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertTrue(map.containsKey("Key1"));
        assertFalse(map.containsKey("Key3"));
    }

    @Test
    void testContainsValue() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        assertTrue(map.containsValue(1));
        assertFalse(map.containsValue(3));
    }

    @Test
    void testClear() {
        map.put("Key1", 1);
        map.put("Key2", 2);
        map.put("Key3", 3);
        map.clear();
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    @DisplayName("크기 줄어드는지 확인하기")
    void testSizeReduce(){
        for(int i=0; i<6; i++){
            map.put("Key"+i, i);
        }
        Assertions.assertThat(map.size()).isEqualTo(6);
        map.remove("Key1");
        map.remove("Key2");
        map.remove("Key3");
        Assertions.assertThat(map.size()).isEqualTo(3);

    }
}