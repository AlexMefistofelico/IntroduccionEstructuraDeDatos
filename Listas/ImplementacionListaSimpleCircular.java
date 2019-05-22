/**
 *	Algoritmos necesarios para el entendimiento del manejo de listas (estructura de datos dinamicas)
 *	Solo se tomora en Cuenta [Un Entero Como Campo de Informacion] Para Centrarnos mas En los algoritmos
 *	propios de las Listas...
 * 	A.A.C.C.
 **/
public class ImplementacionListaSimpleCircular {
	public Nodo raiz;
	
	public ImplementacionListaSimpleCircular() {
		raiz = new Nodo(Integer.MIN_VALUE);
		raiz.sig = raiz;
	}
	
	public boolean esvacio() {
		return raiz.sig == raiz;
	}
	
	public void agregar(int info){
		Nodo nuevo = new Nodo(info);
		nuevo.sig = raiz.sig;
		raiz.sig = nuevo;
	}
	
	public void mostrar() {
		Nodo aux = raiz.sig;
		System.out.print("raiz -> ");
		while(aux!=raiz) {
			System.out.print(aux.info+" -> ");
			aux = aux.sig;
		}
	}

	public void agregarf(int info){
		Nodo nuevo = new Nodo(info);
		Nodo aux = raiz.sig;
		while(aux.sig != raiz)
			aux = aux.sig;
		
		aux.sig = nuevo;
		nuevo.sig = raiz;
	}
	

	public void agregarO(int dato){
		Nodo pt=raiz,pt1=raiz.sig,nuevo = new Nodo(dato);
		while (pt1!=raiz && dato>pt1.info){
			pt=pt1;
			pt1=pt1.sig;
		}
		nuevo.sig=pt1;
		pt.sig=nuevo;
	}
	
	public int eliminarP(){
		Nodo pt = raiz.sig;
	  	int dato = pt.info;
	    raiz.sig = pt.sig;
	    return dato;
	}
	
	public int eliminarU(){
		Nodo pt=raiz,pt1=raiz.sig;
		while (pt1.sig!=raiz){
			pt=pt1;
			pt1=pt1.sig;
		}
		int dato = pt1.info;
		pt.sig = pt1.sig;
		return dato;
	}
	
	public void eliminar(int dato){
		Nodo pt=raiz,pt1=raiz.sig;
		while (pt1!=raiz&&dato!=pt1.info){
		  		pt=pt1;
		  		pt1=pt1.sig;
		}
		if (pt1!=raiz)
			 pt.sig=pt1.sig;
	}
	
	public boolean buscar(int info) {
		Nodo aux = raiz.sig;
		while(aux!=raiz) {
			if(aux.info == info)
				return true;
			aux = aux.sig;
		}
		return false;
	}
	

	public static void main(String[] args) {
		ImplementacionListaSimpleCircular listC;
		listC = new ImplementacionListaSimpleCircular();
		
		listC.agregarO(4);
		listC.agregarO(5);
		listC.agregarO(6);
		listC.agregarO(1);
		listC.agregarO(2);
		listC.agregarO(3);
		
		System.out.println (listC.eliminarP());
		System.out.println (listC.eliminarU());
		
		listC.mostrar();	
	}
}

class Nodo{
	public int info;
	public Nodo sig;
	public Nodo(int info) {
		this.info = info;
		sig = null;
	}
}