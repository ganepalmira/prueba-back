package com.ganepalmira.pruebas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ubicaciones")
public class Ubicacion {
    @Id
    @Column(name = "cod_ubicacion")
    private Long codUbicacion; 

    @Column(name = "descripcion")
    private String descripcion;

}