package libro.cap02.colecciones;
public class MiColeccion{
	private Object datos[] = null;
	private int len = 0;
	
	//Se indica la capacidad inicial en el constructor
	public MiColeccion(int capacidadInicial) {
		datos = new Object[capacidadInicial];
	}
	
	//retorna el i-esimo elemento de la coleccion
	public Object obtener(int i) {
		return datos[i];
	}
	
	//indica cuantos elementos tiene la coleccion
	public int cantidad() {
		return len;
	}
	
	public void insertar(Object elm, int i) {
		if(len == datos.length) {
			Object aux[] = datos;
			datos = new Object[datos.length*2];
			for(int j = 0; j < len; j++) {
				datos[j] = aux[j];
			}
			aux = null;
		}
		for(int j = len - 1; j >= i; j--) {
			datos[j+1] = datos[j];
		}
		datos[i] = elm;
		len++;
	}
	
	public int buscar(Object elm) {
		int i = 0;
		//mientras no pase del tope y mientras no encuentre...
		for( ; i < len && !datos[i].equals(elm); i++);
		return i<len ? i : -1;
	}
	
	public void agregar(Object elm) {
		insertar(elm,len);
	}
	
	//elimina un objeto desplazando los demas hacia arriba
	public Object eliminar(int i) {
		Object aux = datos[i];
		for(int j = i; j < len - 1; j++) {
			datos[j] = datos[j+1];
		}
		len--;
		return aux;
	}
}
