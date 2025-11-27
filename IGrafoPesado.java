package tp4.pesados.interfaces;

public interface IGrafoPesado<T> {
    void agregarVertice(T vertice);
    void agregarArista(T origen, T destino, int peso);
    void mostrarMatrizPesos();
    void aplicarKruskal();
}
