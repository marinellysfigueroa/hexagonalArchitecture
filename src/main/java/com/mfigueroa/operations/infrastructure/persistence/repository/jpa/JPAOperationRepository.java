package com.intraway.mefa.fizzbuzz.infraestructura.persistencia.repositorio.jpa;

import com.intraway.mefa.fizzbuzz.dominio.Operacion;

import java.util.List;

public interface RepositorioOperacionJPA {
    List<Operacion> listarOperaciones();
}
