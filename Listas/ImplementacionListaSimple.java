/**
 *	Algoritmos necesarios para el entendimiento del manejo de listas (estructura de datos dinamicas)
 *	Solo se tomora en Cuenta [Un Entero Como Campo de Informacion] Para Centrarnos mas En los algoritmos
 *	propios de las Listas...
 * 	A.A.C.C.
 **/
public class ImplementacionListaSimple{
	public static void main (String[] args) {
		
		Lista l = new Lista();
		/*
		l.add(19); 
		l.add(1); 
		l.add(17); 
		l.add(20); 
		l.add(7); 
		l.add(8); 
		l.add(9); 
		l.add(10); 
		l.add(11); 
		l.add(3); 
		l.add(4); 
		l.add(5); 
		l.add(6); 
		l.add(15); 
		l.add(16); 
		l.add(13); 
		l.add(12); 
		l.add(2); 
		l.add(18); 
		l.add(14); 
		*/
		l.addOrden(19); 
		l.addOrden(1); 
		l.addOrden(17); 
		l.addOrden(20); 
		l.addOrden(7); 
		l.addOrden(8); 
		l.addOrden(9); 
		l.addOrden(10); 
		l.addOrden(10); 
		l.addOrden(11); 
		l.addOrden(3); 
		l.addOrden(4); 
		l.addOrden(5); 
		l.addOrden(6); 
		l.addOrden(15); 
		l.addOrden(16); 
		l.addOrden(13); 
		l.addOrden(12); 
		l.addOrden(2); 
		l.addOrden(18); 
		l.addOrden(14); 
		
		l.addOrden(0);
		l.addOrden(10);
		l.addOrden(21);
		/*
		l.add(3); 
		l.add(2); 
		l.add(5); 
		l.add(4); 
		l.add(1); 
		*/
		/*l.mostrar();
		l.ordenar();
		l.mostrar();
		*/
		l.mostrar();
	
		
	}
}


class Lista{
	public Nodo raiz;
	public Lista(){
		raiz = null;	
	}
	
	public void add(int d){
		Nodo nuevo = new Nodo(d);
		nuevo.sig = raiz;
		raiz = nuevo;
	}
	
	public void addFinal(int d){
		Nodo aux = raiz;
		if(aux==null){
			raiz  = new Nodo(d);
		}else{
			while(aux.sig != null)
			aux = aux.sig;
			aux.sig = new Nodo(d);
		}	
	}
	public void addOrden(int d){
		Nodo nuevo = new Nodo(d);
		Nodo pt = null;
		Nodo pt1 = raiz;
		
		while(pt1!=null&&d>pt1.dato){//solo cambiar <
			pt = pt1;
			pt1 = pt1.sig;
		}
//*************************
		if(pt1!=null)
			nuevo.sig = (d==pt1.dato)?pt1.sig:pt1;
//*************************
		if(pt==null)
			raiz = nuevo;
		else
			pt.sig = nuevo;
	}	
		
	public void eliminar(int d){
		Nodo pt = null;
		Nodo pt1 = raiz;
		while(pt1!=null&&d!=pt1.dato){
			pt = pt1;
			pt1 = pt1.sig;
		}
		if(pt1==null)
			System.out.println ("El dato no existe");
		else if(pt==null)
			raiz = pt1.sig;
		else
			pt.sig = pt1.sig;
	}
	
	public void modificar(int da,int dn){
		Nodo aux = raiz;
		while(aux!=null){
			if(aux.dato==da){
				aux.dato = dn;
				System.out.println ("dato modificado");
				return;
			}
			aux=aux.sig;
		}
		System.out.println ("No se encontro "+da);
	}
	
	public void mostrar(){
		System.out.print ("raiz->");
		Nodo aux = raiz;
		while(aux!=null){
			System.out.print (aux.dato+"->");
			aux = aux.sig;
		}
		System.out.println ("null");
	}
	
}

class Nodo{
	public Nodo sig;
	public int dato;
	
	public Nodo(int d){
		dato = d;
		sig = null;
	} 
}
