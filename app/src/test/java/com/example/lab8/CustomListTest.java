package com.example.lab8;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity(){
        list = MockCityList();
        list.addCity(new City("Edmonton", "Alberta"));
        assertEquals(true, list.hasCity(new City("Edmonton", "Alberta")));
        assertEquals(false, list.hasCity(new City("Vancouver","British Columbia")));
        list.addCity(new City("Vancouver","British Columbia"));
        assertEquals(true, list.hasCity(new City("Vancouver","British Columbia")));
        assertEquals(false, list.hasCity(null));
    }

    @Test
    void testDelete(){
        list = MockCityList();
        list.addCity(new City("Vancouver","British Columbia"));
        Assertions.assertEquals(true, list.hasCity(new City("Vancouver","British Columbia")));
        list.delete(new City("Vancouver","British Columbia"));
        Assertions.assertEquals(false,list.hasCity(new City("Vancouver","British Columbia")));
        assertThrows( IllegalArgumentException.class, () -> {
            list.delete(new City("Victoria","British Columbia"));
        });
        assertThrows( IllegalArgumentException.class, () -> {
            list.delete(null);
        });
    }

    @Test
    void testCountCities(){
        list = MockCityList();
        Assertions.assertEquals(0, list.countCities());
        list.addCity(new City("Vancouver","British Columbia"));
        Assertions.assertEquals(1, list.countCities());
        list.delete(new City("Vancouver", "British Columbia"));
        Assertions.assertEquals(0, list.countCities());
    }
}
