package com.intraway.mefa.fizzbuzz.testdatabuilder;

import com.intraway.mefa.fizzbuzz.aplicacion.comando.ComandoOperacion;
import com.intraway.mefa.fizzbuzz.dominio.Operacion;
import com.intraway.mefa.fizzbuzz.infraestructura.persistencia.entidad.OperacionEntity;

public class OperacionTestDataBuilder {

    private static final String DESCRIPCION= "Se encontraron múltiplos de 3";
    private static final String LIST = "2,Fizz";
    private static final int MIN = 2;
    private static final int MAX = 3;

    private String description;
    private String list;
    private int min;
    private int max;

    public OperacionTestDataBuilder() {
        this.description = DESCRIPCION;
        this.list = LIST;
        this.min = MIN;
        this.max = MAX;
    }

    public Operacion build()
    {
        return new Operacion(this.min,this.max);
    }
    public ComandoOperacion buildComando()
    {
        return new ComandoOperacion(this.min,this.max);
    }

}
