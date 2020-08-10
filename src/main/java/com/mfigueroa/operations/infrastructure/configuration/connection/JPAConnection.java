package com.intraway.mefa.fizzbuzz.infraestructura.configuracion.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJPA {
    private static final String DATA_BASE = "fizzbuzz";
    private static EntityManagerFactory entityManagerFactory;

    public ConexionJPA() {
        entityManagerFactory = Persistence.createEntityManagerFactory(DATA_BASE);
    }

    public EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
