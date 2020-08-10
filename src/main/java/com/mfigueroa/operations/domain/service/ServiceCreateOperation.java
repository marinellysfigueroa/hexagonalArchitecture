package com.intraway.mefa.fizzbuzz.dominio.servicio;

import com.intraway.mefa.fizzbuzz.dominio.Operacion;
import com.intraway.mefa.fizzbuzz.dominio.repositorio.RepositorioOperacion;
import com.intraway.mefa.fizzbuzz.infraestructura.persistencia.entidad.OperacionEntity;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearOperacion {
    private RepositorioOperacion repositorioOperacion;

    public ServicioCrearOperacion(RepositorioOperacion repositorioOperacion) {
        this.repositorioOperacion = repositorioOperacion;
    }
    public Operacion registrarOperacion(Operacion operacion){
        return this.repositorioOperacion.registrarOperacion(operacion);
    }
}
