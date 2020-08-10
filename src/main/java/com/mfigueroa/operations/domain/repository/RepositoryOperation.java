package com.intraway.mefa.fizzbuzz.dominio.repositorio;

import com.intraway.mefa.fizzbuzz.dominio.Operacion;
import com.intraway.mefa.fizzbuzz.infraestructura.persistencia.entidad.OperacionEntity;

import java.util.List;

public interface RepositorioOperacion {
    OperacionEntity findByTimestamp(Long timestamp);
    List<Operacion> listarOperaciones();
    Operacion registrarOperacion(Operacion operacion);
}
