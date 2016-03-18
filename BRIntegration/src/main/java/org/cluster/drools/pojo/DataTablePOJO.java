/**
 * 
 */
package org.cluster.drools.pojo;

/**
 * @author root
 *
 */
public class DataTablePOJO {

	

	public DataTablePOJO(String cedulaUsuario, String codigoNivelEducativo,
			int codigoGestacion, int polio) {
		super();
		this.cedulaUsuario = cedulaUsuario;
		this.codigoNivelEducativo = codigoNivelEducativo;
		this.codigoGestacion = codigoGestacion;
		this.polio = polio;
	}

	private String cedulaUsuario;
	private String codigoNivelEducativo;
	private int codigoGestacion;
	private int polio;

	public String getCodigoNivelEducativo() {
		return codigoNivelEducativo;
	}

	public void setCodigoNivelEducativo(String codigoNivelEducativo) {
		this.codigoNivelEducativo = codigoNivelEducativo;
	}

	public int getCodigoGestacion() {
		return codigoGestacion;
	}

	public void setCodigoGestacion(int codigoGestacion) {
		this.codigoGestacion = codigoGestacion;
	}

	public int getPolio() {
		return polio;
	}

	public void setPolio(int polio) {
		this.polio = polio;
	}

	public String getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

}
