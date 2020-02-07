package com.springboot2.pruebajairvergeljpacruudapp.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	  private BigDecimal id;
	  private String nombre;
	  private String apellidos;
	  private int procesado;
	  public String getNombre() {
	    return nombre;
	  }
	  public void setNombre(String nombre) {
	    this.nombre = nombre;
	  }
	  public String getApellidos() {
	    return apellidos;
	  }
	  public void setApellidos(String apellidos) {
	    this.apellidos = apellidos;
	  }
	  public int getProcesado() {
	    return procesado;
	  }
	  public void setProcesado(int procesado) {
	    this.procesado = procesado;
	  }
	  public BigDecimal getId() {
			return id;
	  }
	  public void setId(BigDecimal id) {
			this.id = id;
	  }
	  public Usuario(String nombre, String apellidos, int procesado) {
	    super();
	    this.nombre = nombre;
	    this.apellidos = apellidos;
	    this.procesado = procesado;
	  }
	  public Usuario() {
	    super();
	  }
	  //private final static Logger LOGGER = Logger.getLogger("bitacora.subnivel.Utilidades");

	/*@SuppressWarnings("unchecked")
	public List<Usuario> findByProcesado(int procesado){
		  List<Usuario> usuario = null;
		  
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
		  
		  EntityManager em = emf.createEntityManager();
		  
		  try {
			  
			  usuario = em.createQuery("SELECT u FROM Usuario u WHERE u.procesado= :procesado").setParameter("procesado", procesado).getResultList();
			   
		  }catch (Exception e) {
			  LOGGER.log(Level.SEVERE, "ERROR");
		  }
		return usuario;	  
	  }*/
}