/**
 *	Algoritmos necesarios para el entendimiento del manejo de listas (estructura de datos dinamicas)
 *	Solo se tomora en Cuenta [Un Entero Como Campo de Informacion] Para Centrarnos mas En los algoritmos
 *	propios de las Listas...
 * 	A.A.C.C.
 **/
public class ImplementacionListaDobleCircular{
	public static void main (String[] args) {
		
		Lista l = new Lista();
		System.out.println (l.vacio());
		l.addF(1);
		l.addF(22); 
		l.addF(300);
		l.addF(4);
		l.addF(5);
		l.addF(5);
		/**
		 *true
			raiz <-> 1 <-> 22 <-> 300 <-> 4 <-> 5 <-> 5 <->
			|______________________________________________|
			false
		 **/
		/*
		l.eliminar(1);
		l.eliminar(5);
		l.eliminar(5);
		l.eliminar(300);
		l.eliminar(4);
		l.eliminar(22);
		*/
		l.mostrar();
		System.out.println (l.vacio());
//		l.eliminar(1);
//		l.mostrar();
//		
//		l.eliminar(300);
//		l.mostrar();
//		
//		l.eliminar(22);
//		l.mostrar();
		
	}
}


class Lista{
   	public Nodo raiz;
	public Lista(){
		raiz = new Nodo(Integer.MIN_VALUE);
	}
	
	public boolean vacio(){
//		raiz.sig == raiz.ant podria estar apuntando a un mismo nodo
		return raiz==raiz.ant&&raiz==raiz.sig;
	}
	
	public void addI(int d){
		Nodo nuevo = new Nodo(d);
		raiz.sig.ant = nuevo;
		nuevo.sig = raiz.sig;
		nuevo.ant = raiz; 
		raiz.sig = nuevo;
	}
	
	public void addF(int d){
		Nodo nuevo = new Nodo(d);
		Nodo pt = raiz.sig;
		while(pt.sig!=raiz)
			pt = pt.sig;
			
		pt.sig = nuevo;
		nuevo.ant = pt;
		nuevo.sig = raiz;
		raiz.ant = nuevo;	
	}
	
	
	public void addOrden(int d){
		Nodo nuevo = new Nodo(d);
		Nodo pt = raiz,pt1 = raiz.sig;
		while(pt1!=raiz && d>pt1.dato){
			pt = pt1;
			pt1 = pt1.sig;
		}
		pt.sig = nuevo;
		nuevo.ant = pt;
		pt1.ant = nuevo;
		nuevo.sig = pt1;
	}
	
	public int eliPrimero(){
		int dt = raiz.sig.dato;
		Nodo pt = raiz.sig;
		raiz.sig = pt.sig;
		pt.sig.ant = pt.ant;
		return dt;
	}
	
	public void eliminar(int d){
		Nodo pt = raiz.sig;
		while(pt!=raiz&&d!=pt.dato)
			pt = pt.sig;	
		pt.ant.sig = pt.sig;
		pt.sig.ant = pt.ant;
	}
	
	public void mostrar(){
		Nodo aux = raiz.sig;
		System.out.print ("raiz <-> ");
		String cad = "|_______";
		while(aux!=raiz){
			System.out.print (aux.dato+" <-> ");
			cad+=s((aux.dato+" <-> ").length());
			aux = aux.sig;
		}
		System.out.println ('\n'+cad+'|');
	}
	public String s(int n){
		String cad = "";
		while(n-->0)
			cad+='_';
		return cad;
	}
}

class Nodo{
	public Nodo ant;
	public Nodo sig;
	public int dato;
	
	public Nodo(int d){
		dato = d;
		ant = sig = this;
	} 
}
