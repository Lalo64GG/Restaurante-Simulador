package com.example.simulator.simulador.models;

import com.example.simulator.simulador.HelloController;
import com.example.simulator.simulador.Orden;
import com.example.simulator.simulador.Restaurante;

public class Chef implements Runnable {
    private Restaurante restaurante;
    private HelloController controller;
    private volatile boolean running = true;

    public Chef(Restaurante _restaurante, HelloController _controller){
        this.restaurante = _restaurante;
        this.controller = _controller;
    }


    public void cocinar() throws InterruptedException {
        synchronized (this.restaurante){

            // Mientras el buffer de comida este vacio, el cocinero esperara
            while(this.restaurante.bufferOrdenes.isEmpty()){
                this.restaurante.wait();
            }

            // Logica para despertar al chef
            if(false){

            } else if(false){
                // Tiempo para preparar platillo
                Thread.sleep(4000L);

                for (int i = 0; i<5; i++){
                    Orden orden = (Orden)this.restaurante.bufferOrdenes.poll();
                    // Comida
                    // buffer comida
                }

                System.out.println("Chef ha cocinado la orden. Comidas en el buffer restantes: ");
            }
        }
    }

    public void run(){
        while(this.running){
           try {
               this.cocinar();
               if(this.controller != null) {
                   // Metodos para actualizar el controller
               }
           } catch (InterruptedException e){
               e.printStackTrace();
           }
        }
    }

    public void stopRunning(){ this.running = false;}

}
