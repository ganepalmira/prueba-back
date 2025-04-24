package com.ganepalmira.pruebas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;;

@Entity
@Table(name = "movimientos")
public class Movimiento {
    @Id
    @Column(name = "cod_movimiento")
    private Long codMovimiento;  

    @Column(name = "fecha_mov")
    private LocalDateTime fechaMov;

    @ManyToOne
    @JoinColumn(name = "origen", referencedColumnName = "cod_ubicacion")
    private Ubicacion origen;

    @ManyToOne
    @JoinColumn(name = "destino", referencedColumnName = "cod_ubicacion")
    private Ubicacion destino;

    @ManyToOne
    @JoinColumn(name = "cod_activo", referencedColumnName = "cod_activo")
    private Activo activo;

    public Movimiento() {
    }

    public Long getCodMovimiento() {
        return codMovimiento;
    }
    
    public void setCodMovimiento(Long codMovimiento) {
        this.codMovimiento = codMovimiento;
    }
    
    public LocalDateTime getFechaMov() {
        return fechaMov;
    }
    
    public void setFechaMov(LocalDateTime fechaMov) {
        this.fechaMov = fechaMov;
    }
    
    public Ubicacion getOrigen() {
        return origen;
    }
    
    public void setOrigen(Ubicacion origen) {
        this.origen = origen;
    }
    
    public Ubicacion getDestino() {
        return destino;
    }
    
    public void setDestino(Ubicacion destino) {
        this.destino = destino;
    }
    
    public Activo getActivo() {
        return activo;
    }
    
    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    
}