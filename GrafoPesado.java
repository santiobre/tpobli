package tp4.pesados.model;

import tp4.pesados.interfaces.IGrafoPesado;
import java.util.*;

public class GrafoPesado<T> implements IGrafoPesado<T> {

    private List<T> vertices;
    private int[][] matrizPesos;
    private List<Arista> aristas;

    public GrafoPesado(int capacidad) {
        vertices = new ArrayList<>();
        matrizPesos = new int[capacidad][capacidad];
        aristas = new ArrayList<>();
    }

    @Override
    public void agregarVertice(T vertice) {
        vertices.add(vertice);
    }

    @Override
    public void agregarArista(T origen, T destino, int peso) {
        int o = vertices.indexOf(origen);
        int d = vertices.indexOf(destino);

        matrizPesos[o][d] = peso;
        matrizPesos[d][o] = peso;

        aristas.add(new Arista(o, d, peso));
    }

    @Override
    public void mostrarMatrizPesos() {
        System.out.println("=== Matriz de Pesos ===");
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                System.out.printf("%3d ", matrizPesos[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public void aplicarKruskal() {
        System.out.println("\n=== Algoritmo de Kruskal (MST) ===");

        Collections.sort(aristas);

        UnionFind uf = new UnionFind(vertices.size());
        int costoTotal = 0;

        for (Arista a : aristas) {
            int o = a.getOrigen();
            int d = a.getDestino();

            if (uf.find(o) != uf.find(d)) {
                uf.union(o, d);
                costoTotal += a.getPeso();
                System.out.println("Arista incluida: " + a);
            }
        }

        System.out.println("\nCosto total del MST: " + costoTotal);
    }
}
