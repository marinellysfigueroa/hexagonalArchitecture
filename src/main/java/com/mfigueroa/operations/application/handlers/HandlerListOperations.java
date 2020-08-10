package com.intraway.mefa.fizzbuzz.aplicacion.manejadores;

import com.intraway.mefa.fizzbuzz.aplicacion.fabrica.FabricaOperacion;
import com.intraway.mefa.fizzbuzz.dominio.Operacion;
import com.intraway.mefa.fizzbuzz.dominio.servicio.ServicioListarOperaciones;
import com.intraway.mefa.fizzbuzz.infraestructura.persistencia.entidad.OperacionEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorListarOperaciones {
    private final ServicioListarOperaciones servicioListarOperaciones;
    private final FabricaOperacion fabricaOperacion;

    public ManejadorListarOperaciones(ServicioListarOperaciones servicioListarOperaciones, FabricaOperacion fabricaOperacion) {
        this.servicioListarOperaciones = servicioListarOperaciones;
        this.fabricaOperacion = fabricaOperacion;
    }

    public List<Operacion> listarOperaciones()
    {
        return  this.servicioListarOperaciones.listarOperaciones();
    }
}
