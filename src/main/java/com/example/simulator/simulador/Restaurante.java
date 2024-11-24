package com.example.simulator.simulador;

import com.example.simulator.simulador.models.Comensal;
import com.example.simulator.simulador.models.Comida;


import java.util.LinkedList;
import java.util.Queue;

public class Restaurante {
    public static final int MAX_CAPACITY = 20;
    public int ocuppetedTables = 0;
    public int comensalesEnRestaurante = 0;
    public boolean bufferComida = false;
    public int numCocineros = 2;
    public Queue<Orden> bufferOrdenes = new LinkedList();
    public Queue<Comensal> colaEspera = new LinkedList();
    public static final int SIZE_FOOD_BUFFER = 5;

    public Queue<Comida> bufferComidas = new LinkedList<>();

    public Restaurante() {
        this.numCocineros = (int) (CAPACIDAD_MAXIMA * 0.1);
    }

    public synchronized void verificarOrdenLista() throws InterruptedException {
        // Espera hasta que haya comida en el buffer de comidas
        while (bufferComidas.isEmpty()) {
            wait();
        }

        // Simular tiempo de verificar la orden
        Thread.sleep(1000);

        // Tomar la comida del buffer y notificar a los meseros que la orden está lista
        Comida comida = bufferComidas.poll();
        System.out.println("Mesero, la orden está lista para ser servida.");
        // Notificar a los meseros que la comida está lista
        notifyAll();
    }
}
