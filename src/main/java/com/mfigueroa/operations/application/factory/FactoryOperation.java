package com.intraway.mefa.fizzbuzz.aplicacion.fabrica;

import com.intraway.mefa.fizzbuzz.aplicacion.comando.ComandoOperacion;
import com.intraway.mefa.fizzbuzz.dominio.Operacion;
import org.springframework.stereotype.Component;

@Component
public class FabricaOperacion {
    public Operacion crearOperacion(ComandoOperacion comandoOperacion)
    {
        return new Operacion(comandoOperacion.getMin(),comandoOperacion.getMax());
    }
}
