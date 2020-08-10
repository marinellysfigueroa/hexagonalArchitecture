package com.intraway.mefa.fizzbuzz.dominio;

import java.sql.Clob;

public class Operacion {
    private Long id;
    private Long timestamp;
    private String description;
    private String list;
    private String code;
    private int min;
    private int max;



    public Operacion(Long id, Long timestamp, String description, String list, int min, int max,String code) {
        this.id=id;
        this.timestamp = timestamp;
        this.description = description;
        this.list = list;
        this.min = min;
        this.max = max;
        this.code=code;
    }

    public Operacion(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Long getId() {
        return id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    public String getList() {
        return list;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public String getCode() {
        return code;
    }
}
