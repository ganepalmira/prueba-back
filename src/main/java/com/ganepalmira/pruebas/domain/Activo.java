package com.ganepalmira.pruebas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "activos")
@Entity
public class Activo {

	@Id
    @Column(name = "cod_activo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "descripcion")
	private String nombre;

	@Column(name = "referencia")
	private String referencia;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca", referencedColumnName = "cod_marca")
    private Marca marca;

	@Column(name = "estado")
	private String estado;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ubicacion_actual", referencedColumnName = "cod_ubicacion")
    private Ubicacion ubicacionActual;  

	public Activo() {
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Ubicacion getUbicacionActual() {
		return ubicacionActual;
	}

	public void setUbicacionActual(Ubicacion ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}


}
