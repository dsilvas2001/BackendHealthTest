package com.gestion.empleados.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class Test {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "pregunta1", length = 200)
	private String pregunta1;
	
	@Column(name = "pregunta2", length = 200)
	private String pregunta2;
	
	@Column(name = "pregunta3", length = 200)
	private String pregunta3;
	
	@Column(name = "pregunta4", length = 200)
	private String pregunta4;
	
	@Column(name = "pregunta5", length = 200)
	private String pregunta5;
	
	@Column(name = "pregunta6", length = 200)
	private String pregunta6;
	
	@Column(name = "pregunta7", length = 200)
	private String pregunta7;
	
	@Column(name = "pregunta8", length = 200)
	private String pregunta8;
	
	@Column(name = "pregunta9", length = 200)
	private String pregunta9;
	
	@Column(name = "pregunta10", length = 200)
	private String pregunta10;
	
	@Column(name = "pregunta11", length = 200)
	private String pregunta11;
	
	@Column(name = "pregunta12", length = 200)
	private String pregunta12;

	@Column(name = "opcion1", length = 60)
	private String opcion1;
	
	@Column(name = "opcion2", length = 60)
	private String opcion2;
	
	@Column(name = "opcion3", length = 60)
	private String opcion3;
	
	@Column(name = "opcion4", length = 60)
	private String opcion4;
	
	@Column(name = "opcion5", length = 60)
	private String opcion5;
	
	@Column(name = "opcion6", length = 60)
	private String opcion6;
	
	@Column(name = "opcion7", length = 60)
	private String opcion7;
	
	@Column(name = "opcion8", length = 60)
	private String opcion8;
	
	@Column(name = "opcion9", length = 60)
	private String opcion9;
	
	@Column(name = "opcion10", length = 60)
	private String opcion10;
	
	@Column(name = "opcion11", length = 60)
	private String opcion11;
	
	@Column(name = "opcion12", length = 60)
	private String opcion12;

	@Column(name = "usuario", length = 60)
	private String usuario;
	
	@Column(name = "tipotest", length = 60)
	private String tipotest;

	public Test() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPregunta1() {
		return pregunta1;
	}

	public void setPregunta1(String pregunta1) {
		this.pregunta1 = pregunta1;
	}

	public String getPregunta2() {
		return pregunta2;
	}

	public void setPregunta2(String pregunta2) {
		this.pregunta2 = pregunta2;
	}

	public String getPregunta3() {
		return pregunta3;
	}

	public void setPregunta3(String pregunta3) {
		this.pregunta3 = pregunta3;
	}

	public String getPregunta4() {
		return pregunta4;
	}

	public void setPregunta4(String pregunta4) {
		this.pregunta4 = pregunta4;
	}

	public String getPregunta5() {
		return pregunta5;
	}

	public void setPregunta5(String pregunta5) {
		this.pregunta5 = pregunta5;
	}

	public String getPregunta6() {
		return pregunta6;
	}

	public void setPregunta6(String pregunta6) {
		this.pregunta6 = pregunta6;
	}

	public String getPregunta7() {
		return pregunta7;
	}

	public void setPregunta7(String pregunta7) {
		this.pregunta7 = pregunta7;
	}

	public String getPregunta8() {
		return pregunta8;
	}

	public void setPregunta8(String pregunta8) {
		this.pregunta8 = pregunta8;
	}

	public String getPregunta9() {
		return pregunta9;
	}

	public void setPregunta9(String pregunta9) {
		this.pregunta9 = pregunta9;
	}

	public String getPregunta10() {
		return pregunta10;
	}

	public void setPregunta10(String pregunta10) {
		this.pregunta10 = pregunta10;
	}

	public String getPregunta11() {
		return pregunta11;
	}

	public void setPregunta11(String pregunta11) {
		this.pregunta11 = pregunta11;
	}

	public String getPregunta12() {
		return pregunta12;
	}

	public void setPregunta12(String pregunta12) {
		this.pregunta12 = pregunta12;
	}

	public String getOpcion1() {
		return opcion1;
	}

	public void setOpcion1(String opcion1) {
		this.opcion1 = opcion1;
	}

	public String getOpcion2() {
		return opcion2;
	}

	public void setOpcion2(String opcion2) {
		this.opcion2 = opcion2;
	}

	public String getOpcion3() {
		return opcion3;
	}

	public void setOpcion3(String opcion3) {
		this.opcion3 = opcion3;
	}

	public String getOpcion4() {
		return opcion4;
	}

	public void setOpcion4(String opcion4) {
		this.opcion4 = opcion4;
	}

	public String getOpcion5() {
		return opcion5;
	}

	public void setOpcion5(String opcion5) {
		this.opcion5 = opcion5;
	}

	public String getOpcion6() {
		return opcion6;
	}

	public void setOpcion6(String opcion6) {
		this.opcion6 = opcion6;
	}

	public String getOpcion7() {
		return opcion7;
	}

	public void setOpcion7(String opcion7) {
		this.opcion7 = opcion7;
	}

	public String getOpcion8() {
		return opcion8;
	}

	public void setOpcion8(String opcion8) {
		this.opcion8 = opcion8;
	}

	public String getOpcion9() {
		return opcion9;
	}

	public void setOpcion9(String opcion9) {
		this.opcion9 = opcion9;
	}

	public String getOpcion10() {
		return opcion10;
	}

	public void setOpcion10(String opcion10) {
		this.opcion10 = opcion10;
	}

	public String getOpcion11() {
		return opcion11;
	}

	public void setOpcion11(String opcion11) {
		this.opcion11 = opcion11;
	}

	public String getOpcion12() {
		return opcion12;
	}

	public void setOpcion12(String opcion12) {
		this.opcion12 = opcion12;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipotest() {
		return tipotest;
	}

	public void setTipotest(String tipotest) {
		this.tipotest = tipotest;
	}

	public Test(Long id, String pregunta1, String pregunta2, String pregunta3, String pregunta4, String pregunta5,
			String pregunta6, String pregunta7, String pregunta8, String pregunta9, String pregunta10,
			String pregunta11, String pregunta12, String opcion1, String opcion2, String opcion3, String opcion4,
			String opcion5, String opcion6, String opcion7, String opcion8, String opcion9, String opcion10,
			String opcion11, String opcion12, String usuario, String tipotest) {
		super();
		this.id = id;
		this.pregunta1 = pregunta1;
		this.pregunta2 = pregunta2;
		this.pregunta3 = pregunta3;
		this.pregunta4 = pregunta4;
		this.pregunta5 = pregunta5;
		this.pregunta6 = pregunta6;
		this.pregunta7 = pregunta7;
		this.pregunta8 = pregunta8;
		this.pregunta9 = pregunta9;
		this.pregunta10 = pregunta10;
		this.pregunta11 = pregunta11;
		this.pregunta12 = pregunta12;
		this.opcion1 = opcion1;
		this.opcion2 = opcion2;
		this.opcion3 = opcion3;
		this.opcion4 = opcion4;
		this.opcion5 = opcion5;
		this.opcion6 = opcion6;
		this.opcion7 = opcion7;
		this.opcion8 = opcion8;
		this.opcion9 = opcion9;
		this.opcion10 = opcion10;
		this.opcion11 = opcion11;
		this.opcion12 = opcion12;
		this.usuario = usuario;
		this.tipotest = tipotest;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", pregunta1=" + pregunta1 + ", pregunta2=" + pregunta2 + ", pregunta3=" + pregunta3
				+ ", pregunta4=" + pregunta4 + ", pregunta5=" + pregunta5 + ", pregunta6=" + pregunta6 + ", pregunta7="
				+ pregunta7 + ", pregunta8=" + pregunta8 + ", pregunta9=" + pregunta9 + ", pregunta10=" + pregunta10
				+ ", pregunta11=" + pregunta11 + ", pregunta12=" + pregunta12 + ", opcion1=" + opcion1 + ", opcion2="
				+ opcion2 + ", opcion3=" + opcion3 + ", opcion4=" + opcion4 + ", opcion5=" + opcion5 + ", opcion6="
				+ opcion6 + ", opcion7=" + opcion7 + ", opcion8=" + opcion8 + ", opcion9=" + opcion9 + ", opcion10="
				+ opcion10 + ", opcion11=" + opcion11 + ", opcion12=" + opcion12 + ", usuario=" + usuario
				+ ", tipotest=" + tipotest + "]";
	}
	
	
	
}