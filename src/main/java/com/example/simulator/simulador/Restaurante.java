package com.example.simulator.simulador;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurante {
    public static final int MAX_CAPACITY = 20;
    public int ocuppetedTables = 0;
    public int comensalesEnRestaurante = 0;
    public boolean bufferComida = false;
    public int numCocineros = 2;
    public Queue<Orden> bufferOrdenes = new LinkedList();
    public Queue<> colaEspera = new LinkedList();

}
