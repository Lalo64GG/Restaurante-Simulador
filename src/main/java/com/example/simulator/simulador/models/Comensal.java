package com.example.simulator.simulador.models;

import com.example.simulator.simulador.HelloController;
import com.example.simulator.simulador.Restaurante;

public class Comensal implements Runnable {
    private Restaurante restaurante;
    private HelloController controller;

    public Comensal(Restaurante _restaurante, HelloController _controller) {
        this.restaurante = _restaurante;
        this.controller = _controller;
    }

    public void run() {
        while(true){
            try {

            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private synchronized void entrarRestaurante()throws InterruptedException {
        // Funcion para aceptar comensal

    }


}
