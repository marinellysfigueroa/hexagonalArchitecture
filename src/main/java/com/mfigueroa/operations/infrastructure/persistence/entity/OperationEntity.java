package com.intraway.mefa.fizzbuzz.infraestructura.persistencia.entidad;

import javax.persistence.*;
import java.sql.Clob;


@Entity(name = "Operacion")
@NamedQuery(name = "Operacion.listAll", query = "SELECT operacion FROM Operacion operacion")
@NamedQuery(name = "Operacion.findByTimestamp", query = "SELECT operacion FROM Operacion operacion WHERE operacion.timestamp = :timestamp")
public class OperacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long timestamp;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    @Lob
    private String list;
    @Column(nullable = false)
    private int min;
    @Column(nullable = false)
    private int max;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }


}
