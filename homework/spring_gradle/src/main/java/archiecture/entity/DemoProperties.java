package com.easy.archiecture.entity;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DemoProperties {

    @Value("${demo.user.id}")
    private String id;

    @Value("${demo.user.name}")
    private String name;

    @Value("${demo.number.value1}")
    private int value1;

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public long getValue2() {
        return value2;
    }

    public void setValue2(long value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    @Value("${demo.number.value2}")
    private long value2;

    @Value("${demo.number.value3}")
    private String value3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
