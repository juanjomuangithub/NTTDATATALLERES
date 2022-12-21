package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Juanjo ENTIDAD DE TABLA T_CONTRATO
 */

@Entity
@Table(name = "T_CONTRATO")
public class Contrato extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long contratoId;

	/** Fecha de vigencia */
	private Calendar fechaVigencia;

	/** Fecha de caducidad */
	private Calendar fechaCaducidad;

	/** Precio mensual */
	private double precioMensual;

	/** Cliente asociado al contrato */
	private Cliente cliente;

	/**
	 * 
	 * @return contratoId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_CONTRATO_ID")
	public Long getContratoId() {
		return contratoId;
	}

	/**
	 * 
	 * @param contratoId. The clientId to set
	 */
	public void setContratoId(Long contratoId) {
		this.contratoId = contratoId;
	}

	/**
	 * 
	 * @return fechaVigencia
	 */
	@Column(name = "C_FECHA_VIGENCIA", nullable = false)
	public Calendar getFechaVigencia() {
		return fechaVigencia;
	}

	/**
	 * 
	 * @param fechaVigencia. The fechaVigencia to set.
	 */
	public void setFechaVigencia(Calendar fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	/**
	 * 
	 * @return fechaCaducidad
	 */
	@Column(name = "C_FECHA_CADUCIDAD", nullable = false)
	public Calendar getFechaCaducidad() {
		return fechaCaducidad;
	}

	/**
	 * 
	 * @param fechaCaducidad. The fechaCaducidad to set.
	 */
	public void setFechaCaducidad(Calendar fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	/**
	 * 
	 * @return precioMensual
	 */
	@Column(name = "C_PRECIO_MENSUAL", nullable = false)
	public double getPrecioMensual() {
		return precioMensual;
	}

	/**
	 * 
	 * @param precioMensual. The precioMensual to set
	 */
	public void setPrecioMensual(double precioMensual) {
		this.precioMensual = precioMensual;
	}

	/**
	 * 
	 * @return cliente
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "C_CLIENTE_ID")
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * 
	 * @param cliente. The cliente to set.
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public Long getId() {
		return this.contratoId;
	}

	@Override
	public void setId(Long id) {
		this.contratoId = id;

	}

	@Override
	public String toString() {
		return "Contrato [contratoId=" + contratoId + ", fechaVigencia=" + fechaVigencia + ", fechaCaducidad="
				+ fechaCaducidad + ", precioMensual=" + precioMensual + ", cliente=" + cliente + "]";
	}

}
