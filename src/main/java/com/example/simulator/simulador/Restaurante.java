package com.example.simulator.simulador;

import com.example.simulator.simulador.models.Comensal;


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

    public Restaurante() {}

    public synchronized void verificarOrdenLista() throws InterruptedException {

    }

}
