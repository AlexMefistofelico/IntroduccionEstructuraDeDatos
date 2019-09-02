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
