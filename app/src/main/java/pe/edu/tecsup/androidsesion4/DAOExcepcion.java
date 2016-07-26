package pe.edu.tecsup.androidsesion4;

/**
 * Created by Renzo on 26/07/2016.
 */
public class DAOExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOExcepcion() {
		super();
	}

	public DAOExcepcion(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public DAOExcepcion(String detailMessage) {
		super(detailMessage);
	}

	public DAOExcepcion(Throwable throwable) {
		super(throwable);
	}

}
