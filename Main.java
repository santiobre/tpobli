package tp4.pesados.main;

import tp4.pesados.model.GrafoPesado;

public class Main {

    public static void main(String[] args) {

        GrafoPesado<String> grafo = new GrafoPesado<>(6);

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");
        grafo.agregarVertice("F");

        grafo.agregarArista("A", "B", 4);
        grafo.agregarArista("A", "C", 2);
        grafo.agregarArista("B", "C", 1);
        grafo.agregarArista("B", "D", 5);
        grafo.agregarArista("C", "D", 8);
        grafo.agregarArista("C", "E", 10);
        grafo.agregarArista("D", "E", 2);
        grafo.agregarArista("D", "F", 6);
        grafo.agregarArista("E", "F", 3);

        grafo.mostrarMatrizPesos();

        grafo.aplicarKruskal();
    }
}
