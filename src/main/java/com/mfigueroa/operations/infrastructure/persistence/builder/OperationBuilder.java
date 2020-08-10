package com.intraway.mefa.fizzbuzz.infraestructura.persistencia.builder;

import com.intraway.mefa.fizzbuzz.dominio.Operacion;
import com.intraway.mefa.fizzbuzz.infraestructura.persistencia.entidad.OperacionEntity;

import java.sql.Clob;
import java.util.Date;
import java.util.Formatter;

public class OperacionBuilder {
    public static final String MULTIPLO_TRES = "Fizz";
    public static final String MULTIPLO_CINCO = "Buzz";
    public static final String MULTIPLO_TRES_CINCO = "FizzBuzz";

    public static final String DES_MULTIPLO_TRES = "Se encontraron múltiplos de 3";
    public static final String DES_MULTIPLO_CINCO = "Se encontraron múltiplos de 5";
    public static final String DES_MULTIPLO_TRES_CINCO = "Se encontraron múltiplos de 3 y de 5";
    public static final String DES_MULTIPLO_NINGUNO = "No se encontraron múltiplos de 3 ni de 5";

    public OperacionBuilder() {

    }

    public static Operacion convertirADominio(OperacionEntity operacionEntity) {
        Operacion operacion = null;
        if (operacionEntity != null) {
            operacion = new Operacion(operacionEntity.getId(), operacionEntity.getTimestamp(), operacionEntity.getDescription(), operacionEntity.getList(), operacionEntity.getMin(), operacionEntity.getMax(), getCode(operacionEntity.getId()));
        }
        return operacion;
    }

    public static OperacionEntity convertirAEntity(Operacion operacion) {

        OperacionEntity operacionEntity = new OperacionEntity();
        operacionEntity.setTimestamp(getTimestamp());
        operacionEntity.setDescription(getDescription(operacion.getMin(),operacion.getMax()));
        operacionEntity.setList(getList(operacion.getMin(),operacion.getMax()));
        operacionEntity.setMin(operacion.getMin());
        operacionEntity.setMax(operacion.getMax());
        return operacionEntity;
    }

    private static Long getTimestamp() {
        Date date = new Date();
        long epochTime = date.getTime();
        return epochTime;
    }


    private static String getDescription(int min,int max) {
        boolean multiplosTres = false;
        boolean multiplosCinco = false;
        String descripcion = "";

        for (int i = min; i <= max; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                multiplosTres = true;
                multiplosCinco = true;
            } else if (i % 3 == 0) {
                multiplosTres = true;
            } else if (i % 5 == 0) {
                multiplosCinco = true;
            }
        }
        if (multiplosTres && multiplosCinco) {
            descripcion = DES_MULTIPLO_TRES_CINCO;
        } else if (multiplosTres) {
            descripcion = DES_MULTIPLO_TRES;
        } else if (multiplosCinco) {
            descripcion = DES_MULTIPLO_CINCO;
        } else {
            descripcion = DES_MULTIPLO_NINGUNO;
        }
        return descripcion;
    }

    private static String getList(int min, int max) {
        String list = "";
        for (int i = min; i <= max; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                if (!"".equals(list)) {
                    list = list +","+MULTIPLO_TRES_CINCO;
                } else {
                    list = MULTIPLO_TRES_CINCO;
                }

            } else if (i % 3 == 0) {

                if (!"".equals(list)) {
                    list = list +"," +MULTIPLO_TRES;
                } else {
                    list = MULTIPLO_TRES;
                }

            } else if (i % 5 == 0) {

                if (!"".equals(list)) {
                    list = list +","+MULTIPLO_CINCO;
                } else {
                    list = MULTIPLO_CINCO;
                }

            } else {
                if (!"".equals(list)) {
                    list = list + "," + i;
                } else {
                    list = list + i;
                }
            }
        }
        return list;
    }

    private static String getCode(Long id) {
        Formatter fmt = new Formatter();
        fmt.format("%03d", id);
        return fmt.toString();
    }

}
