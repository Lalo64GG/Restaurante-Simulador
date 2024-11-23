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
            // Creación de la orden
            Orden orden = new Orden(this.restaurante.comensalesEnRestaurante);

            // Actualizamos el buffer
            this.restaurante.bufferOrdenes.offer(orden);

            // Agregamos un comensal a la cola
            this.restaurante.colaEspera.offer(new Comensal(this.restaurante, this.controller, this));

            // Si la capacidad de comensales o mesas es superior a la del restaurante hacemos que el comensal espere
            while(this.restaurante.comensalesEnRestaurante >= 20 || this.restaurante.ocuppetedTables >= 20 ){
                System.out.println("Restaurante lleno. Comensal esperando");
                this.restaurante.wait();
            }

            // Si hay espacio en el restaurante incrementamos los contadores
            ++this.restaurante.comensalesEnRestaurante; // Cola
            ++this.sum;
            ++this.restaurante.ocuppetedTables; // Cola

            // Actualizar el estado del comensal
            // this.controller.updateComensalStatus("COMENSAL " + this.sum);

            System.out.println("Comensal entrando al restaurante.  Comensales actuales en el restaurante" + this.restaurante.comensalesEnRestaurante + ". Mesas ocupadas: " + this.restaurante.ocuppetedTables);

            // Notificar que el restaurante tiene más espacio para comensales
            if(this.restaurante.comensalesEnRestaurante + 1 <20 && this.restaurante.ocuppetedTables + 1 < 20){
                this.restaurante.bufferComida = true;

                // Levantamos al hilo durmiendo
                this.restaurante.notify();
            }

        }
    }


    public void run() {
        while(true){
            try {
                Thread.sleep(1000L);
                System.out.println("Recepcionista abre las puertas del Restaurante");
                this.entrarComensal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
