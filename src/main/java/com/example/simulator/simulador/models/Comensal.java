package com.example.simulator.simulador.models;

import com.example.simulator.simulador.HelloController;
import com.example.simulator.simulador.Restaurante;
import javafx.application.Platform;

import java.util.Random;

public class Comensal implements Runnable {
    private Restaurante restaurante;
    private HelloController controller;
    private Recepcionista recepcionista;

    public Comensal(Restaurante _restaurante, HelloController _controller, Recepcionista _recepcionista) {
        this.restaurante = _restaurante;
        this.controller = _controller;
        this.recepcionista = _recepcionista;
    }

    public void run() {
        while(true){
            try {
                this.entrarRestaurante();
                if(this.controller != null){
                    // Si controller existe, llamar al mesero
                    //Platform.runLater(() -> this.controller.updateMeseroStatus("Llamando al mesero"));
                }

                Thread.sleep(5000L);
                // Generar un tiempo aleatorio de comida del comensal
                int tiempoComida = (new Random()).nextInt(5000) + 3000;

                // Dormimos al hilo el tiempo mientras el comensal come
                Thread.sleep((long)tiempoComida);
                if (this.controller != null){
                    // Platform.runLater(() -> this.controller.updateComensalStatus("Saliendo del restaurante"));
                }

                return;
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private synchronized void entrarRestaurante()throws InterruptedException {
        // Funcion para aceptar comensal
        this.recepcionista.entrarComensal();

    }
}
