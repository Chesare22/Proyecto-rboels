package arbolesBTrails;

public class ArbolBinarioBusqueda {

    private NodoArbolBinario nodoRaiz;

    public ArbolBinarioBusqueda() {
        nodoRaiz = null;
    }

    public void insertar(int iElemento) {
        if (nodoRaiz == null) //Árbol vacío
        {
            nodoRaiz = new NodoArbolBinario(iElemento);
        } else {
            nodoRaiz.insertar(iElemento);
        }
    }

    public NodoArbolBinario buscar(int iElemento) {
        return buscar(iElemento, nodoRaiz);
    }

    private NodoArbolBinario buscar(int iElemento, NodoArbolBinario nodo) {
        int iNivel = 1;
        while (nodo != null) {
            if (iElemento < nodo.dato) {
                nodo = nodo.nodoIzquierdo;
            } else if (iElemento > nodo.dato) {
                nodo = nodo.nodoDerecho;
            } else { //Encontramos el elemento
                System.out.println(iElemento + " encontrado en el nivel " + iNivel);
                return nodo;
            }
            iNivel++;
        }
        System.out.println(iElemento + " no encontrado");
        return null; //Elemento no encontrado
    }

    public void eliminar(int iElemento) {
        nodoRaiz = eliminar(iElemento, nodoRaiz);
    }

    public NodoArbolBinario eliminar(int iElemento, NodoArbolBinario nodo) {
        if (nodo == null) {
            System.out.println(iElemento + " no encontrado");
            return null;
        }
        if (iElemento < nodo.dato) {
            nodo.nodoIzquierdo = eliminar(iElemento, nodo.nodoIzquierdo);
        } else if (iElemento > nodo.dato) {
            nodo.nodoDerecho = eliminar(iElemento, nodo.nodoDerecho);
        } else if (nodo.nodoIzquierdo != null && nodo.nodoDerecho != null) { //Dos hijos
            nodo.dato = nodoMin(nodo.nodoDerecho).dato;
            nodo.nodoDerecho = eliminarMin(nodo.nodoDerecho);
        } else { //Un hijo
            if (nodo.nodoIzquierdo != null) {
                nodo = nodo.nodoIzquierdo;
            } else {
                nodo = nodo.nodoDerecho;
            }
        }
        return nodo;
    }

    private NodoArbolBinario eliminarMin(NodoArbolBinario nodo) {
        if (nodo == null) {
            return null;
        }
        if (nodo.nodoIzquierdo != null) {
            nodo.nodoIzquierdo = eliminarMin(nodo.nodoIzquierdo);
        } else //No hay nodo izquierdo, el padre será el nodo derecho
        {
            nodo = nodo.nodoDerecho;
        }
        return nodo;
    }

    public NodoArbolBinario nodoMin(NodoArbolBinario nodo) {
        if (nodo == null) {
            return null;
        }
        while (nodo.nodoIzquierdo != null) {
            nodo = nodo.nodoIzquierdo;
        }
        return nodo;
    }

    public NodoArbolBinario nodoMax(NodoArbolBinario nodo) {
        if (nodo == null) {
            return null;
        }
        while (nodo.nodoDerecho != null) {
            nodo = nodo.nodoDerecho;
        }
        return nodo;
    }

    public void recorridoPreorden() {
        ayudantePreorden(nodoRaiz);
    }

    private void ayudantePreorden(NodoArbolBinario nodo) {
        if (nodo == null) {
            return;
        }
        System.out.print(nodo.dato + " ");
        ayudantePreorden(nodo.nodoIzquierdo);
        ayudantePreorden(nodo.nodoDerecho);
    }

    public void recorridoInorden() {
        ayudanteInorden(nodoRaiz);
    }

    private void ayudanteInorden(NodoArbolBinario nodo) {
        if (nodo == null) {
            return;
        }
        ayudanteInorden(nodo.nodoIzquierdo);
        System.out.print(nodo.dato + " ");
        ayudanteInorden(nodo.nodoDerecho);
    }

    public void recorridoPostorden() {
        ayudantePostorden(nodoRaiz);
    }

    private void ayudantePostorden(NodoArbolBinario nodo) {
        if (nodo == null) {
            return;
        }
        ayudantePostorden(nodo.nodoIzquierdo);
        ayudantePostorden(nodo.nodoDerecho);
        System.out.print(nodo.dato + " ");
    }

    public void imprimir() {
        imprimir(nodoRaiz, 0);
    }

    private void imprimir(NodoArbolBinario nodo, int iAltura) {
        char c[] = new char[iAltura];
        for (int i = 0; i < c.length; i++) {
            c[i] = '-';
        }
        if (nodo == null) {
            return;
        }
        System.out.println(new String(c) + nodo.dato);
        iAltura++;
        imprimir(nodo.nodoIzquierdo, iAltura);
        imprimir(nodo.nodoDerecho, iAltura);
    }

    public boolean estaVacio() {
        return nodoRaiz == null;
    }

    public void vaciar() {
        nodoRaiz = null;
    }
}

class NodoArbolBinario {

    public NodoArbolBinario nodoIzquierdo;
    public NodoArbolBinario nodoDerecho;
    public int dato;

    public NodoArbolBinario(int dato) {
        this.dato = dato;
        nodoIzquierdo = nodoDerecho = null;
    }

    public synchronized void insertar(int iElemento) {
        if (iElemento < dato) {//Insertar en subárbol izquierdo
//Insertar nuevo NodoArbolBinario
            if (nodoIzquierdo == null) {
                nodoIzquierdo = new NodoArbolBinario(iElemento);
            } else //Continuar recorriendo subárbol izquierdo
            {
                nodoIzquierdo.insertar(iElemento);
            }
        } else if (iElemento > dato) {//Insertar en subárbol derecho
//Insertar nuevo NodoArbolBinario
            if (nodoDerecho == null) {
                nodoDerecho = new NodoArbolBinario(iElemento);
            } else //Continuar recorriendo subárbol derecho
            {
                nodoDerecho.insertar(iElemento);
            }
        }
    }
}
