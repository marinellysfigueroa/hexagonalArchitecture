package com.intraway.mefa.fizzbuzz.aplicacion.comando;

public class ComandoOperacion {

    private int min;
    private int max;


    public ComandoOperacion(int min, int max){

        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
