package topMusic;
/**
 * 
 * @author Rafael Delgado Peña
 * @version 1.0
 *
 */
public class Cancion {
	/**
	 * Titulo de la cancion
	 */
	String titulo;
	/**
	 * Artista de la cancion
	 */
	String artista;
	/**
	 * Año de grabacion
	 */
	int anoGrabacion;

	/**
	 * Constructor de la cancion
	 * 
	 * @param titulo
	 * @param artista
	 * @param anoGrabacion
	 */
	private Cancion(String titulo, String artista, int anoGrabacion) {
		setTitulo(titulo);
		setArtista(artista);
		setAnoGrabacion(anoGrabacion);
	}
	
	/**
	 * getInstance, se encarga de controlar que la información le llege de forma correcta al constructor
	 * @param titulo
	 * @param artista
	 * @param anoGrabacion
	 * @return
	 */
	public static Cancion getInstance(String titulo, String artista, int anoGrabacion){
		String anno=Integer.toString(anoGrabacion);
		if(titulo.matches("^.{2,}") && artista.matches("^.{2,}") && anno.matches("19[0-9]{2}|200[0-9]|201[0-7]")){
			return new Cancion(titulo, artista, anoGrabacion);
		}
		return null;
	}

	/**
	 * Constructor solo con un titulo
	 * 
	 * @param titulo
	 */
	public Cancion(String titulo) {
		setTitulo(titulo);
	}

	/**
	 * Obtiene el titulo de la cancion
	 * 
	 * @return
	 */
	private String getTitulo() {
		return titulo;
	}

	/**
	 * Modifica el titulo de la cancion
	 * 
	 * @param titulo
	 */
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Obtiene el artista
	 * 
	 * @return
	 */
	private String getArtista() {
		return artista;
	}

	/**
	 * Modifica el valor de artista
	 * 
	 * @param artista
	 */
	private void setArtista(String artista) {
		this.artista = artista;
	}

	/**
	 * Obtiene el año de grabacion
	 * 
	 * @return
	 */
	private int getAnoGrabacion() {
		return anoGrabacion;
	}

	/**
	 * Modifica el valor de año de grabacion
	 * 
	 * @param anoGrabacion2
	 */
	private void setAnoGrabacion(int anoGrabacion2) {
		this.anoGrabacion = anoGrabacion2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + getTitulo() + ", por " + getArtista() + " (" + getAnoGrabacion() + ")";
	}
}