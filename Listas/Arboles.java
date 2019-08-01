	public void interCont(Nodo p,Nodo pt,Nodo pt1){
		pt.sig = pt1.sig;
		pt1.sig = pt;
		if(raiz == pt)
			raiz = pt1;
		else	
			p.sig = pt1;	
	}
	
	public void interAlej(Nodo p,Nodo pt,Nodo aux,Nodo aux2,Nodo pt1){
		pt.sig = pt1.sig;
		pt1.sig = aux;
		aux2.sig = pt;
		if(raiz == pt)
			raiz = pt1;
		else	
			p.sig = pt1;	
	}
//*******************************************************************************************/
public class ImplementacionArbolBinarioBusqueda {
    public static void main(String[] args) {
		Arbol a = new Arbol();
		
		a.agregar(10);
		a.agregar(9);
		a.agregar(8);
		a.agregar(17);
		a.agregar(15);
		a.agregar(20);
		a.agregar(18);
		a.agregar(30);
	
//		System.out.println ("*menor *"+a.menmay(a.raiz));
		
		
//		a.preOrden_(a.raiz);
//		System.out.println ();
		a.preOrden(a.raiz);
		System.out.println ();
		a.eliminar(10);
		a.inOrden_(a.raiz);
		System.out.println ();
		a.inOrden(a.raiz);
		System.out.println ();
		a.postOrden(a.raiz);
		System.out.println ();
//		a.postOrden_(a.raiz);
//		System.out.println ();
		
//		a.amplitud(a.raiz);
		
//		a.eliminar(10);
//		a.eliminar(9);
//		a.eliminar(8);
//		a.eliminar(17);
//		a.eliminar(15);
//		a.eliminar(20);
//		a.eliminar(18);
//		a.eliminar(30);
//			
//		a.inOrden(a.raiz);
//		System.out.println ();
//		a.preOrden(a.raiz);
//		System.out.println ();
//		a.postOrden(a.raiz);
//		
//		a.niveles(a.raiz);
//		System.out.println ();
			
		
    }
}

class Arbol{
	public Nodo raiz;
	
	public Arbol(){
		raiz = null;
	}
	
	public Nodo agregar(Nodo r,int d){
		if (r==null)
		     r = new Nodo(d);
		else if (d>r.dato)
		     r.HijoDer=agregar(r.HijoDer,d);
		else if (d<r.dato)
		     r.HijoIzq=agregar(r.HijoIzq,d);
		return r;
	}
	
	public void agregar(int d){
		raiz=agregar(raiz,d);
	}
	
	public Nodo buscar(Nodo r, int clave){
		if (clave==r.dato)
		    r=elinodo(r);
		else if(clave>r.dato)
			r.HijoDer=buscar(r.HijoDer,clave);
		else 
			r.HijoIzq=buscar(r.HijoIzq,clave);
		return r;
	}
	
	public Nodo elinodo(Nodo r){
		if (r.HijoIzq==null && r.HijoDer==null)
			return null;
		else if(r.HijoIzq!=null && r.HijoDer==null)
		    return r.HijoIzq;
		else if(r.HijoIzq==null && r.HijoDer!=null)
		    return r.HijoDer;
		else{
	    	r.HijoDer=buscar(r.HijoDer,r.dato = menmay(r.HijoDer )/*mm*/);
	    	return r;
		}
	}
	
	public int menmay(Nodo r){
		if(r.HijoIzq==null)
		    return r.dato;
	    return menmay(r.HijoIzq);
	}
	
	public void eliminar(int clave){
		raiz=buscar(raiz,clave);
	}
	
	public int altura(Nodo r){
		if(r==null)
		    return 0;
	    return (1+Math.max(altura(r.HijoIzq),altura(r.HijoDer)));
	}
	
	public int sinhijos(Nodo r){
		if (r==null)
			return 0;
		else if(r.HijoIzq==null && r.HijoDer==null)
		    return 1;
		else return (sinhijos(r.HijoIzq)+sinhijos(r.HijoDer));
	}
	// emitir un reporte indicando la altura o profundidad de cada nodo
	// del arbol
	//nodo 10	altura=5
	//nodo 15	altura=3
	//nodo 38	altura=4
	public void niveles(Nodo r){
		if(r!=null){
			niveles(r.HijoIzq);
			System.out.print("\nNodo = "+r.dato+"\taltura = "+altura(r));
			niveles(r.HijoDer);
		}
	}
	public void preOrden(Nodo r){
		if(r==null)return;
		System.out.print(r.dato+",");
		preOrden(r.HijoIzq);
		preOrden(r.HijoDer);
	}
	
	public void inOrden(Nodo r){
		if(r==null)return;
			inOrden(r.HijoIzq);
			System.out.print(r.dato+",");
			inOrden(r.HijoDer);
	}
	public void postOrden(Nodo r){
		if(r==null)return;
		postOrden(r.HijoIzq);
		postOrden(r.HijoDer);
		System.out.print(r.dato+",");
	}
	//FUNCIONES MUY IMPORTANTES PARA ARBOLES NO RECURSIVOS...
	//FUNCIONES MUY IMPORTANTES PARA ARBOLES NO RECURSIVOS...
	//FUNCIONES MUY IMPORTANTES PARA ARBOLES NO RECURSIVOS...
	public void amplitud(Nodo r) {
		Cola cola = new Cola(15);
		Nodo aux;
		cola.insertar(r);
		while(!cola.vacio()) {
			aux = cola.sacar();
			if(aux.HijoIzq!=null)
				cola.insertar(aux.HijoIzq);
			if(aux.HijoDer!=null)
				cola.insertar(aux.HijoDer);
			System.out.print(aux.dato+" ");
		}
	}
	
//	public void preOrden_(Nodo r){
//		Pila pila = new Pila(15);
//		pila.push(null);
//		Nodo ptr = r;
//		while(ptr!=null){
//			System.out.print (ptr.dato+",");
//			if(ptr.HijoDer!=null)
//				pila.push(ptr.HijoDer);
//			if(ptr.HijoIzq!=null)
//				ptr = ptr.HijoIzq;
//			else
//				ptr = pila.pop();
//		}
//	}	
	public void preOrden_(Nodo r){
		Pila pila = new Pila(15);
		Nodo ptr = r;
		pila.push(ptr);
		while(!pila.vacio()){
			System.out.print (ptr.dato+",");
			if(ptr.HijoDer!=null)
				pila.push(ptr.HijoDer);
			if(ptr.HijoIzq!=null)
				ptr = ptr.HijoIzq;
			else
				ptr = pila.pop();
		}
	}
	
//	public void inOrden_(Nodo r){//ESTO NO DA
//		Pila pila = new Pila(15);
//		pila.push(null);
//		Nodo ptr = r;
//		while(ptr!=null){
//			while(ptr!=null){
//				pila.push(ptr);
//				 ptr = ptr.HijoIzq;
//			}
//			ptr = pila.pop();
//			System.out.print (ptr.dato+",");
//			
//			if(ptr.HijoDer!=null)
//				ptr = ptr.HijoDer;
//			else
//				ptr = pila.pop();
//		}
//	}			
	public void inOrden_(Nodo r){//ESTO NO DA
		Pila pila = new Pila(15);
		pila.push(null);
		Nodo ptr = r;
		while(ptr!=null){
			while(ptr!=null){
				pila.push(ptr);
				 ptr = ptr.HijoIzq;
			}
			ptr = pila.pop();
			boolean tieneDer = false;
			while(ptr!=null&&!tieneDer){
				System.out.print (ptr.dato+",");
				if(ptr.HijoDer!=null){
					ptr = ptr.HijoDer;
					tieneDer = true;
				}else
					ptr = pila.pop();
			}
		}
	}			
		
//	public void postOrden_(Nodo r){
//		Nodo pt=r;
//		Pila pila = new Pila(15);
//		PilaNum control = new PilaNum(15);
//		pila.push(null);		
//		control.push(1);
//		while(pt!=null){
//			pila.push(pt);
//			if(pt.HijoDer!=null){
//				control.pop();
//				control.push(1);
//			}else{
//				control.pop();
//				control.push(0);
//			}
//			
//			pt = pt.HijoIzq;
//			if(pt==null){
//				pt=pila.EnTope();//talbes se POP
//				while(control.EnTope()==0){
//					System.out.print (pt.dato+",");
//					//pila.pop();//del cima---
//					pt=pila.pop();
//				}
//				control.pop();//--------verificar
//				control.push(0);
//				if(control.vacio())
//					pt = null;
//				else
//					pt = pt.HijoDer;
//			}
//		}
//	}
}

class Nodo{
	public Nodo HijoIzq;
	public Nodo HijoDer;
	public int dato;
	public Nodo(int d){
		dato = d;
		HijoIzq = HijoDer = null;
	}
	public Nodo(Nodo n){
		this.dato = n.dato;
		this.HijoDer = n.HijoDer;
		this.HijoIzq = n.HijoIzq;
	}
}

class Pila{
	private int tope;
	private Nodo p[];
	
	public Pila(int n){		
		p = new Nodo[n];
		tope = -1;
	}
	public boolean vacio(){
		return tope == -1;
	}
	public Nodo EnTope(){
		return p[tope];
	}
	public void push(Nodo dato){
		p[++tope]=dato;
	}
	public Nodo pop(){
		return p[tope--];
	}
	public void Elimina(){
		while(!vacio())
			pop();
	}
}
/*
class PilaNum{
	private int tope;
	private int p[];
	
	public PilaNum(int n){		
		p = new int[n];
		tope = -1;
	}
	public boolean vacio(){
		return tope == -1;
	}
	public int EnTope(){
		return p[tope];
	}
	public void push(int dato){
		p[++tope]=dato;
	}
	public int pop(){
		return p[tope--];
	}
	public void Elimina(){
		while(!vacio())
			pop();
	}
}
*/
class Cola{
	private int primero;
	private int ultimo;
	private Nodo C[];
	
	public Cola(int n){
		primero = -1;
		ultimo = primero;
		C = new Nodo[n];
	}
	public boolean vacio(){
		return primero == -1;
	}
	public Nodo primero(){
		return C[primero];
	}
	public Nodo ultimo(){
		return C[ultimo];
	}
	public void insertar(Nodo d){
		if(vacio())
			primero = 0;
		C[++ultimo]=d;
	}
	public Nodo sacar(){
		Nodo dato = C[primero];
		if(primero==ultimo){
			primero = -1;
			ultimo = -1;
		}else
			primero++;
		return dato;
	}
	public void vaciar(){
		while(!vacio())
			sacar();
	}
	public int tamaño(){
		return C.length;
	}	
}
//*******************************************************************************************/
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
class Nodo {
	public int info;
	public Nodo HijoIzq;
	public Nodo HijoDer;
	public int fe;
	public Nodo(int valor) {
		info = valor;
		HijoIzq = HijoDer = null;
		fe = 0;
	}
	public Nodo(Nodo ramaHijoIzq, int valor, Nodo ramaHijoDer) {
		this(valor);
		HijoIzq = ramaHijoIzq;
		HijoDer = ramaHijoDer;
		fe = 0;
	}
}
class ArbolAvl {
	Nodo raiz;
	public ArbolAvl() {
		raiz = null;
	}
	public Nodo raizArbol() {
		return raiz;
	}
	private Nodo rotacionSimpleDerecha(Nodo n, Nodo n1) {//rotacionSimpleDerecha
		System.err.println("rotacionSimpleDerecha");
		n.HijoIzq = n1.HijoDer;
		n1.HijoDer = n;
		if (n1.fe == -1) { // se cumple en la inserción
			n.fe = 0;
			n1.fe = 0;
		} else {
			n.fe = -1;
			n1.fe = 1;
		}
		return n1;
	}
	private Nodo rotacionSimpleIzquierda(Nodo n, Nodo n1) {
		System.err.println("rotacionSimpleIzquierda");
		n.HijoDer = n1.HijoIzq;
		n1.HijoIzq = n;
		if (n1.fe == +1) { // se cumple en la inserción
			n.fe = 0;
			n1.fe = 0;
		} else {
			n.fe = +1;
			n1.fe = -1;
		}
		return n1;
	}
	private Nodo rotacionDobleDerecha(Nodo n, Nodo n1) {//rotacionDobleDerecha
		System.err.println("rotacionDobleDerecha");
		Nodo n2;
		n2 = n1.HijoDer;
		n.HijoIzq = n2.HijoDer;
		n2.HijoDer = n;
		n1.HijoDer = n2.HijoIzq;
		n2.HijoIzq = n1;
		if (n2.fe == +1)
			n1.fe = -1;
		else
			n1.fe = 0;
		if (n2.fe == -1)
			n.fe = 1;
		else
			n.fe = 0;
		n2.fe = 0;
		return n2;
	}
	private Nodo rotacionDobleIzquierda(Nodo n, Nodo n1) {//rotacionDobleIzquierda
		System.err.println("rotacionDobleIzquierda");
		Nodo n2;
		n2 = n1.HijoIzq;
		n.HijoDer = n2.HijoIzq;
		n2.HijoIzq = n;
		n1.HijoIzq = n2.HijoDer;
		n2.HijoDer = n1;
		if (n2.fe == +1)
			n.fe = -1;
		else
			n.fe = 0;
		if (n2.fe == -1)
			n1.fe = 1;
		else
			n1.fe = 0;
		n2.fe = 0;
		return n2;
	}
	public void insertar(int valor) throws Exception {
		Bool h = new Bool(false); // intercambia un valor booleano
		raiz = insertarAvl(raiz, valor, h);
	}
	private Nodo insertarAvl(Nodo raiz, int dt, Bool h) throws Exception {
		Nodo n1;
		if (raiz == null) {
			raiz = new Nodo(dt);
			h.v = true;
		} else if (dt < raiz.info) {
			Nodo iz;
			iz = insertarAvl(raiz.HijoIzq, dt, h);
			raiz.HijoIzq = iz;
			if (h.v) {// regreso por los nodos del camino de búsqueda
				switch (raiz.fe) {// decrementa el fe por aumentar la altura de rama izquierda
				case 1:
					raiz.fe = 0;
					h.v = false;
					break;
				case 0:
					raiz.fe = -1;
					break;
				case -1: // aplicar rotación a la izquierda
					n1 = raiz.HijoIzq;
					if (n1.fe == -1)
						raiz = rotacionSimpleDerecha(raiz, n1);
					else
						raiz = rotacionDobleDerecha(raiz, n1);
					h.v = false;;
				}
			}
		} else if (dt > raiz.info) {
			Nodo dr;
			dr = insertarAvl(raiz.HijoDer, dt, h);
			raiz.HijoDer = dr;
			if (h.v) {// regreso por los nodos del camino de búsqueda
				switch (raiz.fe) {// incrementa el fe por aumentar la altura de rama izquierda
				case 1: // aplicar rotación a la derecha
					n1 = raiz.HijoDer;
					if (n1.fe == +1)
						raiz = rotacionSimpleIzquierda(raiz, n1);
					else
						raiz = rotacionDobleIzquierda(raiz, n1);
					h.v = false;;
					break;
				case 0:
					raiz.fe = +1;
					break;
				case -1:
					raiz.fe = 0;
					h.v = false;;
				}
			}
		} else
			throw new Exception("No puede haber claves repetidas ");
		return raiz;
	}
	public void eliminar(int valor) throws Exception {
		Bool flag = new Bool(false);
		raiz = borrarAvl(raiz, valor, flag);
	}
	private Nodo borrarAvl(Nodo r,int clave, Bool cambiaAltura) throws Exception {
		if (r == null) {
			throw new Exception(" Nodo no encontrado ");
		} else if (clave<r.info) {
			Nodo iz;
			iz = borrarAvl(r.HijoIzq, clave, cambiaAltura);
			r.HijoIzq=iz;
			if (cambiaAltura.v)
				r = equilibrar1(r, cambiaAltura);
		} else if (clave>r.info) {
			Nodo dr;
			dr = borrarAvl(r.HijoDer, clave, cambiaAltura);
			r.HijoDer=dr;
			if (cambiaAltura.v)
				r = equilibrar2(r, cambiaAltura);
		} else {// Nodo encontrado
			Nodo q;
			q = r; // nodo a quitar del árbol
			if (q.HijoIzq == null) {
				r = q.HijoDer;
				cambiaAltura.v = true;
			} else if (q.HijoDer== null) {
				r =  q.HijoIzq;
				cambiaAltura.v = true;
			} else { // tiene rama izquierda y derecha
				Nodo iz;
				iz = reemplazar(r,r.HijoIzq, cambiaAltura);
				r.HijoIzq=iz;
				if (cambiaAltura.v)
					r = equilibrar1(r, cambiaAltura);
			}
			q = null;
		}
		return r;
	}
	private Nodo reemplazar(Nodo n, Nodo act, Bool cambiaAltura) {
		if (act.HijoDer != null) {
			Nodo d;
			d = reemplazar(n,act.HijoDer, cambiaAltura);
			act.HijoDer = d;
			if (cambiaAltura.v)
				act = equilibrar2(act, cambiaAltura);
		} else {
			n.info = act.info;
			n = act;
			act = act.HijoIzq;
			n = null;
			cambiaAltura.v = true;
		}
		return act;
	}
	private Nodo equilibrar1(Nodo n, Bool cambiaAltura) {
		Nodo n1;
		switch (n.fe) {
		case -1:
			n.fe = 0;
			break;
		case 0:
			n.fe = 1;
			cambiaAltura.v = false;;
			break;
		case +1: // se aplicar un tipo de rotación derecha
			n1 = (Nodo) n.HijoDer;
			if (n1.fe >= 0) {
				if (n1.fe == 0) // la altura no vuelve a disminuir
					cambiaAltura.v = false;;
				n = rotacionSimpleIzquierda(n, n1);
			} else
				n = rotacionDobleIzquierda(n, n1);
			break;
		}
		return n;
	}
	private Nodo equilibrar2(Nodo n, Bool cambiaAltura) {
		Nodo n1;
		switch (n.fe) {
		case -1: // Se aplica un tipo de rotación izquierda
			n1 = (Nodo) n.HijoIzq;
			if (n1.fe <= 0) {
				if (n1.fe == 0)
					cambiaAltura.v = false;;
				n = rotacionSimpleDerecha(n, n1);
			} else
				n = rotacionDobleDerecha(n, n1);
			break;
		case 0:
			n.fe = -1;
			cambiaAltura.v = false;;
			break;
		case +1:
			n.fe = 0;
			break;
		}
		return n;
	}
	public void inOrden(Nodo r) {
		if (r == null)
			return;
		inOrden((Nodo) r.HijoIzq);
		System.out.printf("[%d,%d], ", r.info, r.fe);
		inOrden((Nodo) r.HijoDer);
	}
	public void reporte() {
		inOrden(raiz);
		System.out.println();
	}
	
}
class Bool{
	public boolean v;
	public Bool(boolean v) {this.v = v;}
}
public class Principal {
	public static void main(String[] args) throws Exception {
		ArbolAvl a = new ArbolAvl();
		a.insertar(3);
		a.insertar(11);
		a.insertar(21);
		a.insertar(31);
		a.insertar(41);
		a.insertar(51);
		
		a.eliminar(31);
		a.eliminar(11);
		
		a.reporte();
	}
}
//*******************************************************************************************/
public class ImplementacionArbolBinarioExpreciones{

	public Cola aCola(String cad){
		Cola c = new Cola(cad.length()+1);
		String aux = "";
		int i=0;
		while(i<cad.length()){
			if(Character.isDigit(cad.charAt(i))||cad.charAt(i)=='.'){
				aux+=cad.charAt(i);
				if(i==cad.length()-1)
					c.insertar(aux);
			}else{
				if(aux!="")
					c.insertar(aux);
				c.insertar(String.valueOf(cad.charAt(i)));
				aux="";
			}		
			i++;
		}
		return c;
	}
	
	public Arbol aArbolExp(Cola colainf){
		_Pila pilaO = new _Pila(colainf.tamaño()+1);
		PILA_ pilaN = new PILA_(colainf.tamaño()+1);
		
		Arbol a = new Arbol();
		String x,aux;
		Nodo nodo;
		while(!colainf.vacio()){
			x = colainf.sacar();
			switch(x){
				case "(":
					pilaO.push(x);
				break;
				case ")":
					while(!pilaO.EnTope().equals("(")){
						nodo = new Nodo(pilaO.pop());
						nodo.HijoDer = pilaN.pop();
						nodo.HijoIzq = pilaN.pop();
						pilaN.push(nodo);
					}
					pilaO.pop();//sacando "parentecis"
				break;
				case "^":
				case "/":
				case "*":
				case "-":
				case "+":
					while(!pilaO.vacio()&&prioriadad(x)<=prioriadad(pilaO.EnTope())){
						nodo = new Nodo(pilaO.pop());
						nodo.HijoDer = pilaN.pop();
						nodo.HijoIzq = pilaN.pop();
						pilaN.push(nodo);	
					}
					pilaO.push(x);
				break;
				default : pilaN.push(new Nodo(x));
			}		
		}
		while(!pilaO.vacio()){
			nodo = new Nodo(pilaO.pop());
			nodo.HijoDer = pilaN.pop();
			nodo.HijoIzq = pilaN.pop();
			pilaN.push(nodo);
		}
		a.raiz = pilaN.pop();
		return a;
	}

	public int prioriadad(String o){
		switch (o){
		    case "+":
		    case "-": return 1;
		    case "*": 
		    case "/": return 2;
		    case "^": return 3;
		    default : return 0;
		}
	}
		
	public static void main (String[] args) {
		ImplementacionArbolBinarioExpreciones ex;
		ex = new ImplementacionArbolBinarioExpreciones();
//		String exp = "((123/(15.15+1.123*4))/((15.15*1.123)/(123+1.123*15.15-1.123)))+15.15-4";	
//		String exp = "((4-1)*5)+(64/(2^5))";
		String exp = "((b+((b^2-a*c)^(1/2)))/(d*a))/((b+a)/(c+b*d))";
//		String exp = "((3.0+((3.0^2-1.6*5)^(1/2)))/(15.15*1.6))/((3.0+5)/(5+3.0*15.15))";
		Cola colaexp = ex.aCola(exp);
		Arbol arbol = ex.aArbolExp(colaexp);
		arbol.preOrden(arbol.raiz);
		System.out.println ();
		arbol.inOrden(arbol.raiz);
		System.out.println ();
		arbol.postOrden(arbol.raiz);
		System.out.println ("\n\n");	
	}
}

class Arbol{
	public Nodo raiz;
	public Arbol(){
		raiz = null;
	}
	public void inOrden(Nodo r){
		if(r==null)return;
		inOrden(r.HijoIzq);
		System.out.print(r.dato+" ");
		inOrden(r.HijoDer);
	}
	public void preOrden(Nodo r){
		if(r==null)return;
		System.out.print(r.dato+" ");
		preOrden(r.HijoIzq);
		preOrden(r.HijoDer);
	}
	public void postOrden(Nodo r){
		if(r==null)return;
		postOrden(r.HijoIzq);
		postOrden(r.HijoDer);
		System.out.print(r.dato+" ");
	}
}

class Nodo{
	public String dato;
	public Nodo HijoIzq;
	public Nodo HijoDer;

	public Nodo(String d){
		dato = d;
	}
}

class _Pila{
	private int tope;
	private String p[];
	
	public _Pila(int n){		
		p = new String[n];
		tope = -1;
	}
	public boolean vacio(){
		return tope == -1;
	}
	public String EnTope(){
		return p[tope];
	}
	public void push(String dato){
		p[++tope]=dato;
	}
	public String pop(){
		return p[tope--];
	}
	public void Elimina(){
		while(!vacio())
			pop();
	}
}



class PILA_{
	private int tope;
	private Nodo p[];
	
	public PILA_(int n){		
		p = new Nodo[n];
		tope = -1;
	}
	public boolean vacio(){
		return tope == -1;
	}
	public Nodo EnTope(){
		return p[tope];
	}
	public void push(Nodo dato){
		p[++tope]=dato;
	}
	public Nodo pop(){
		return p[tope--];
	}
	public void Elimina(){
		while(!vacio())
			pop();
	}
}

class Cola{
	private int primero;
	private int ultimo;
	private String C[];
	
	public Cola(int n){
		primero = -1;
		ultimo = primero;
		C = new String[n];
	}
	public boolean vacio(){
		return primero == -1;
	}
	public String primero(){
		return C[primero];
	}
	public String ultimo(){
		return C[ultimo];
	}
	public void insertar(String d){
		if(vacio())
			primero = 0;
		C[++ultimo]=d;
	}
	public String sacar(){
		String dato = C[primero];
		if(primero==ultimo){
			primero = -1;
			ultimo = -1;
		}else
			primero++;
		return dato;
	}
	public void vaciar(){
		while(!vacio())
			sacar();
	}
	public int tamaño(){
		return C.length;
	}	
}
//*******************************************************************************************/
import java.util.Scanner;
public class ImplementacionMatrizDinamica{
	public static Scanner stdin = new Scanner(System.in);

	public static void main (String[] args) {
		MatrizDinamica A = new MatrizDinamica(10,5);
		A.set(1,0,0);A.set(-2,1,1);
		A.set(10,2,2);A.set(2,3,3);
		A.set(-1,4,4);A.set(3,9,4);

//		A.set(1,0,0);A.set(-2,0,1);
//		/*A.set(0,1,0);*/A.set(2,1,1);
//		A.set(-1,2,0);A.set(3,2,1);
		MatrizDinamica B = new MatrizDinamica(5,15);
		B.set(2,0,0);B.set(-1,1,1);B.set(10,2,2);B.set(4,3,3);
		B.set(1,4,4);B.set(2,4,14);B.set(3,0,14);B.set(-2,4,0);
//		B.set(2,0,0);B.set(-1,0,1);/*B.set(0,0,2);*/B.set(4,0,3);
//		B.set(1,1,0);B.set(2,1,1);B.set(3,1,2);B.set(-2,1,3);

		A.mostrar();
		System.out.println ();
		B.mostrar();
		System.out.println ("Multiplicacion...");
		MatrizDinamica C = A.multiplicacion(A,B);
		C.mostrarL();
		
	}	
}

class MatrizDinamica{
	public int filas;
	public int columnas;
	public Nodo raiz;
	
	public MatrizDinamica(int n,int m){
		raiz = null;
		filas = n;
		columnas = m;
	}
	
	public MatrizDinamica(MatrizDinamica matriz){
		raiz = matriz.raiz;
		filas = matriz.filas;
		columnas = matriz.columnas;
	}
	
	public void mostrarL(){
		for(Nodo i = raiz;i!=null;i=i.abajo){
			for(Nodo j=i;j!=null;j=j.sig){
				System.out.print(j.dato+"\t");
			}
			System.out.println ();
		}
	}
	
	public void mostrar(){
		for(int i = 0;i<this.filas;i++){
			for(int j=0;j<this.columnas;j++){
				System.out.print(get(i,j)+"\t");
			}
			System.out.println ();
		}
	}
	
	public void llenar(){
		int dato;
		for(int i = 0;i<this.filas;i++){
			for(int j=0;j<this.columnas;j++){
				System.out.print("["+i+","+j+"]:");
				dato = ImplementacionMatrizDinamica.stdin.nextInt();
				if(dato!=0)
					set(dato,i,j);
			}
		}
	}
	
	public MatrizDinamica suma(MatrizDinamica A,MatrizDinamica B){
		int dato;
		MatrizDinamica C = new MatrizDinamica(A.filas,A.columnas);
		for(int i = 0;i<C.filas;i++){
			for(int j=0;j<C.columnas;j++){
				dato = A.get(i,j)+B.get(i,j);
				if(dato!=0)
					C.set(dato,i,j);
			}
		}
		return C;
	}
	
	public MatrizDinamica multiplicacion(MatrizDinamica A,MatrizDinamica B){
		MatrizDinamica C = new MatrizDinamica(A.filas,B.columnas);
		int dato;
		for(int i=0;i<C.filas;i++){
			for(int j=0;j<C.columnas;j++){
				dato = 0;
				for(int k=0;k<B.filas;k++){
					dato += (A.get(i,k)*B.get(k,j));
				}
				if(dato!=0)
					C.set(dato,i,j);
			}	
		}
		return C;
	}
	
	
	public void set(int d,int f,int c){
		if(c>columnas||f>filas)
			System.err.println ("Error...");
		if(d!=0)
			addEnFil(d,f,c);
	}
	
	public int get(int f,int c){
		Nodo aux=raiz;
		while(aux!=null&&f>aux.fila)
			aux = aux.abajo;
		while(aux!=null&&c>aux.columna)
			aux = aux.sig;
		if(aux!=null)
			if(aux.columna==c&&aux.fila==f)
				return aux.dato;
		return 0;
	}
	
	public void addEnFil(int d,int f,int c){
		Nodo nuevo = new Nodo(d,f,c);
		Nodo pt = null;
		Nodo pt1 = raiz;
		while(pt1!=null&&f>pt1.fila){//solo cambiar <
			pt = pt1;
			pt1 = pt1.abajo;
		}
		if(pt1!=null)
			if(f==pt1.fila){
				nuevo = addEnCol(d,f,c,pt1);
				nuevo.abajo = pt1.abajo;
			}else{
				nuevo.abajo = pt1;
			}				
		if(pt==null)
			raiz = nuevo;
		else
			pt.abajo = nuevo;
	}	
	public Nodo addEnCol(int d,int f,int c,Nodo r){
		Nodo nuevo = new Nodo(d,f,c);
		Nodo pt = null;
		Nodo pt1 = r;
		while(pt1!=null&&c>pt1.columna){//solo cambiar <
			pt = pt1;
			pt1 = pt1.sig;
		}
		if(pt1!=null)
			if(c==pt1.columna){
				nuevo.sig = pt1.sig;
			}else{
				nuevo.sig = pt1;
			}				
		if(pt==null)
			r = nuevo;
		else
			pt.sig = nuevo;
		return r;
	}			
}

class Nodo{
	public int dato;
	public int fila;
	public int columna;
	
	public Nodo sig;
	public Nodo abajo;
	public Nodo(int dato,int f,int c){
		this.dato = dato;
		this.fila = f;
		this.columna = c;
		sig = abajo = null;
	}
	public Nodo(int dato){
		this.dato = dato;
		sig = abajo = null;
	}	
}
//*******************************************************************************************/
public class ImplementacionPostfijoEvalucion{
	public Cola aCola(String cad){
		Cola c = new Cola(cad.length()+1);
		String aux = "";
		for(int i=0;i<cad.length();i++){
			if(Character.isDigit(cad.charAt(i))||cad.charAt(i)=='.'){
				aux+=cad.charAt(i);
				if(i==cad.length()-1)
					c.insertar(aux);
			}else{
				if(aux!="")
					c.insertar(aux);
				c.insertar(String.valueOf(cad.charAt(i)));
				aux="";
			}		
		}
		return c;
	}
	
	public int prioriadad(String o){
		switch (o) {
		    case "+":
		    case "-": return 1;
		    case "*": 
		    case "/": return 2;
		    case "^": return 3;
		    default : return 0;
		}
	}
	
	public Cola aPostfijo(Cola colainf){
		Cola cola = new Cola(colainf.tamaño()+1);
		Pila pila = new Pila(colainf.tamaño()+1);
		String x;
		
		while(!colainf.vacio()){
			x = colainf.sacar();
			switch (x) {
			    case "(": 
			    	pila.push(x);
			    break;
			    case ")": 
			    	while(!pila.EnTope().equals("("))
			    		cola.insertar(pila.pop());
			    	
			    	pila.pop();
			    break;
			    
			    case "^": 
			    case "/": 
			    case "*": 
			    case "-": 
			    case "+":
			    	while(!pila.vacio()&&prioriadad(x)<=prioriadad(pila.EnTope()))
			    		cola.insertar(pila.pop());
			    	
			    	pila.push(x); 
			    break;
			    default : cola.insertar(x); break;
			}		
		}
		while(!pila.vacio())
			cola.insertar(pila.pop());
		return cola;
	}
	
	public double eValuar(Cola colapostf){
		Pila pila = new Pila(colapostf.tamaño()+1);
		double x,y,z;
		x = y = z = 0;
		String aux;
		while(!colapostf.vacio()){
			aux = colapostf.sacar();
			switch (aux) {
			    case "^":
			    case "/":
			    case "*":
			    case "-":
			    case "+":
			    	y = Double.parseDouble(pila.pop());
			    	x = Double.parseDouble(pila.pop());
			    	switch (aux) {
					    case "^":
					    	z = Math.pow(x,y);
					    break;
					    case "/":
					    	z = x/y;
					    break;
					    case "*":
					    	z = x*y;
					    break;
					    case "-":
					    	z = x-y;
					    break;	
					    case "+":
					    	z = x+y;
					    break;
					}
					pila.push(String.valueOf(z));
			    break;
			    default : pila.push(aux);
			}
			
		}
		return Double.parseDouble(pila.pop());
	}
		
	
	
	
	public static void main (String[] args) {
		ImplementacionPostfijoEvalucion IPE = new ImplementacionPostfijoEvalucion();
//		String exp = "((a/(b+c*d))/((b*c)/(a+d*b-c)))+b-d";	
//		String exp = "((2/(1+3*2))/((1*3)/(2+2*1-3)))+1-2";	
//		String exp = "123+4*1.8-56.321/2.5";	
//		String exp = "((123/(15.15+1.123*4))/((15.15*1.123)/(123+1.123*15.15-1.123)))+15.15-4";	
//		String exp = "((4-1)*5)+(64/(2^5))";
		String exp = "((b+((b^2-a*c)^(1/2)))/(d*a))/((b+a)/(c+b*d))";
//		String exp = "((3.0+((3.0^2-1.6*5)^(1/2)))/(15.15*1.6))/((3.0+5)/(5+3.0*15.15))";
		Cola cola1 = IPE.aCola(exp);
		cola1 = IPE.aPostfijo(cola1);
		
		Cola cola2;
		
		System.out.print ("PostFijo: ");
		
		while(!cola1.vacio())
			System.out.print (cola1.sacar());
		
		System.out.println ();
		
		
		exp = "((3.0+((3.0^2-1.6*5)^(1/2)))/(15.15*1.6))/((3.0+5)/(5+3.0*15.15))";
		cola1 = IPE.aCola(exp);
		cola2 = IPE.aCola(exp);
		cola1 = IPE.aPostfijo(cola1);
		cola2 = IPE.aPostfijo(cola2);
		
		System.out.print ("PostFijo: ");
			
		while(!cola1.vacio())
			System.out.print (cola1.sacar());
		
		System.out.println ();
		
		System.out.printf ("Evaluacion: %.5f\n",IPE.eValuar(cola2));
		
	}
}


class Pila{
	private int tope;
	private String p[];
	
	public Pila(int n){		
		p = new String[n];
		tope = -1;
	}
	
	public boolean vacio(){
		return tope == -1;
	}
	
	public String EnTope(){
		return p[tope];
	}
	
	public void push(String dato){
		p[++tope]=dato;
	}
	
	public String pop(){
		return p[tope--];
	}
	
	public void Elimina(){
		while(!vacio())
			pop();
	}
}

class Cola{
	private int primero;
	private int ultimo;
	private String C[];
	
	public Cola(int n){
		primero = -1;
		ultimo = primero;
		C = new String[n];
	}
	
	public boolean vacio(){
		return primero == -1;
	}
	
	public String primero(){
		return C[primero];
	}
	
	public String ultimo(){
		return C[ultimo];
	}
	
	public void insertar(String d){
		if(vacio())
			primero = 0;
		C[++ultimo]=d;
	}
	
	public String sacar(){
		String dato = C[primero];
		if(primero==ultimo)
			primero = ultimo = -1;
		else
			primero++;
		return dato;
	}
	
	public void vaciar(){
		while(!vacio())
			sacar();
	}
	
	public int tamaño(){
		return C.length;
	}
	
}

