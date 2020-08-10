package com.intraway.mefa.fizzbuzz.infraestructura.configuracion.sistema;

import com.intraway.mefa.fizzbuzz.dominio.repositorio.RepositorioOperacion;
import com.intraway.mefa.fizzbuzz.infraestructura.configuracion.conexion.ConexionJPA;
import com.intraway.mefa.fizzbuzz.infraestructura.persistencia.repositorio.RepositorioOperacionPersistente;

import javax.persistence.EntityManager;

public class SistemaDePersistencia {
    private EntityManager entityManager;

    public SistemaDePersistencia() {
        this.entityManager = new ConexionJPA().createEntityManager();
    }
    public RepositorioOperacion obtenerRepositorioOperacion()
    {
        return new RepositorioOperacionPersistente(entityManager) ;
    }
    public void iniciar() {
        entityManager.getTransaction().begin();
    }

    public void terminar() {
        entityManager.getTransaction().commit();
    }
}
