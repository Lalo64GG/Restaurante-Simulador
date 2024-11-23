package com.example.simulator.simulador.models;

import com.example.simulator.simulador.HelloController;
import com.example.simulator.simulador.Orden;
import com.example.simulator.simulador.Restaurante;

public class Recepcionista implements Runnable {
    private Restaurante restaurante;
    private HelloController controller;
    private int sum = 0;

    public Recepcionista(Restaurante restaurante, HelloController controller) {
        this.restaurante = restaurante;
        this.controller = controller;
    }

    public synchronized void entrarComensal() throws InterruptedException {
        synchronized (this.restaurante) {
            Orden orden = new Orden(this.restaurante.comensalesEnRestaurante);
            this.restaurante.bufferOrdenes.offer(orden);
        }
    }

}
