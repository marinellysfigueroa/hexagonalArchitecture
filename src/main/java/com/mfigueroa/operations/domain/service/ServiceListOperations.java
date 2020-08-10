package com.intraway.mefa.fizzbuzz.dominio.servicio;

import com.intraway.mefa.fizzbuzz.dominio.Operacion;
import com.intraway.mefa.fizzbuzz.dominio.repositorio.RepositorioOperacion;
import com.intraway.mefa.fizzbuzz.infraestructura.persistencia.entidad.OperacionEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioListarOperaciones {
    private RepositorioOperacion repositorioOperacion;

    public ServicioListarOperaciones(RepositorioOperacion repositorioOperacion) {
        this.repositorioOperacion = repositorioOperacion;
    }
    public List<Operacion> listarOperaciones(){
        return this.repositorioOperacion.listarOperaciones();
    }
}
