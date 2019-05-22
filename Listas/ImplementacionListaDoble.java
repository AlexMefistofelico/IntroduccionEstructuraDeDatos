/**
 *	Algoritmos necesarios para el entendimiento del manejo de listas (estructura de datos dinamicas)
 *	Solo se tomora en Cuenta [Un Entero Como Campo de Informacion] Para Centrarnos mas En los algoritmos
 *	propios de las Listas...
 * 	A.A.C.C.
 **/
public class ImplementacionListaDoble{
	public static void main (String[] args) {
		
		Lista l = new Lista();
		l.addOrden(1); 
		l.addOrden(22); 
		l.addOrden(300); 
		l.addOrden(4); 
		l.addOrden(5); 
		l.addOrden(5); 
		l.mostrarI();
		l.eliminar(1);
		l.mostrarI();
		l.eliminar(300);
		l.mostrarI();
		l.eliminar(22);
		l.mostrarI();
		
	}
}


class Lista{
	public Nodo raizi,raizd;
	public Lista(){
		raizi = raizd = null;
	}
	
	public void addI(int d){
		Nodo nuevo = new Nodo(d);
		if(vacio())
			raizi = raizd = nuevo;
		else{
			nuevo.sig = raizi;
			raizi.ant = nuevo;
			raizi = nuevo;
		}
	}
	
	public void addD(int d){
		Nodo nuevo = new Nodo(d);
		if(vacio())
			raizi = raizd = nuevo;
		else{
			nuevo.ant = raizd;
			raizd.sig = nuevo;
			raizd = nuevo;
		}
	}
	
	public void addOrden(int d){
		Nodo nuevo = new Nodo(d);
		if(vacio())
			raizi = raizd = nuevo;
		else{
			Nodo pt = null,pt1 = raizi;
			while(pt1!=null && d>pt1.dato){
				pt = pt1;
				pt1 = pt1.sig;
			}
			if(pt==null){
				nuevo.sig = raizi;
				raizi.ant = nuevo;
				raizi = nuevo;
			}else if(pt1==null){
				nuevo.ant = raizd;
				raizd.sig  = nuevo;
				raizd = nuevo; 
			}else{
				nuevo.sig = pt1;
				nuevo.ant = pt;
				pt1.ant = nuevo;
				pt.sig = nuevo;
			}	
		}	
	}
	
	public int eliPrimero(){
		int dt = raizi.dato;
		if(raizd==raizi)
			raizi = raizd = null;
		else{
			raizi = raizi.sig;
			raizi.ant = null;
		}
		return dt;
	}
	
	public int eliUltimo(){
		int dt = raizd.dato;
		if(raizd==raizi)
			raizi = raizd = null;
		else{
			raizd = raizd.ant;
			raizd.sig = null;
		}
		return dt;
	}
	
	public void eliminar(int d){
		Nodo pt = raizi;
		while(pt!=null&&d!=pt.dato)
			pt = pt.sig;
		if(pt==null)
			System.out.println ("El dato es inexistente");
		else if(raizd==raizi)
			raizi = raizd = null;
		else{
			Nodo pta = pt.ant,pts = pt.sig;
			if(pta==null){
				raizi = pts;
				pts.ant = null;	
			}else if(pts==null){
				raizd = pta;
				pta.sig = null;
			}else{
				pta.sig = pts;
				pts.ant = pta;
			}
		}
	}
	
	public void mostrarI(){
		Nodo aux = raizi;
		System.out.print ("raizi -> ");
		while(aux!=null){
			System.out.print (aux.dato+" -> ");
			aux = aux.sig;
		}
		System.out.println ("null");
	}
	
	public void mostrarD(){
		Nodo aux = raizd;
		System.out.print ("raizd -> ");
		while(aux!=null){
			System.out.print (aux.dato+" -> ");
			aux = aux.ant;
		}
		System.out.println ("null");
	}
	
	
	public boolean vacio(){
		return raizi==null;
	}
}

class Nodo{
	public Nodo ant;
	public Nodo sig;
	public int dato;
	
	public Nodo(int d){
		dato = d;
		ant = sig = null;
	} 
}
