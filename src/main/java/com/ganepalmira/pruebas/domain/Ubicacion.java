package com.ganepalmira.pruebas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "ubicaciones")
public class Ubicacion {
    @Id
    @Column(name = "cod_ubicacion")
    private Long codUbicacion; 

    @Column(name = "descripcion")
    private String descripcion;

    public Ubicacion() {
    }
    
    public Long getCodUbicacion() {
        return codUbicacion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
  
    public void setCodUbicacion(Long codUbicacion) {
        this.codUbicacion = codUbicacion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}