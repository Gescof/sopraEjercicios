package curso.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonGetter;

@Entity
@Table(name="operaciones")
@XmlRootElement(name="operacion")
public class Operacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="tipo_operacion")
	private String tipoOperacion;
	@Column(name="operando1")
	private double operando1;
	@Column(name="operando2")
	private double operando2;
	@Column(name="resultado")
	private double resultado;
	
	@XmlAttribute
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@XmlElement(name="tipo_operacion")
	@JsonGetter("tipo_operacion")
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	
	@XmlElement
	public double getOperando1() {
		return operando1;
	}
	public void setOperando1(double operando1) {
		this.operando1 = operando1;
	}
	
	@XmlElement
	public double getOperando2() {
		return operando2;
	}
	public void setOperando2(double operando2) {
		this.operando2 = operando2;
	}
	
	@XmlElement
	public double getResultado() {
		return resultado;
	}
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
}
