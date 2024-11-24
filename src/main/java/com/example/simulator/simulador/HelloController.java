package com.example.simulator.simulador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    public void updateConsole(String message) {
        Platform.runLater(() -> {
            consoleTextArea.appendText(message + "\n");
        });
    }

    public synchronized void updateBufferComidaTextArea(String message) {
        Platform.runLater(() -> {
            bufferComidaLabel.setText(message);
        });
    }

    public synchronized void updateBufferOrdenesTextArea(String message) {
        Platform.runLater(() -> {
            bufferOrdenesLabel.setText(message);
        });
    }

    public synchronized void updateChefStatus(String status) {
        Platform.runLater(() -> cocineroTextArea.appendText("Chef: " + status + "\n"));
    }

    public synchronized void updateMeseroStatus(String status) {
        if(status!="clear"){
            Platform.runLater(() -> meseroTextArea.appendText("Mesero: " + status + "\n"));
        }else{
            Platform.runLater(() -> meseroTextArea.clear());
        }
    }

    public synchronized void updateComensalStatus(String status) {
        if(status!="clear"){
            Platform.runLater(() -> comensalTextArea.appendText("Comensal: " + status + "\n"));
        }else{
            Platform.runLater(() -> comensalTextArea.deleteText(0, 21));
        }
    }
    public void updateRecepcionistaStatus(String status) {
        // Platform.runLater(() -> recepcionistaLabel.setText("Recepcionista: " + status));
    }

    public void redirectSystemOutput() {
        OutputStream out = new OutputStream() {
            private StringBuilder buffer = new StringBuilder();

            @Override
            public void write(int b) throws IOException {
                if (b == '\n') {
                    updateConsole(buffer.toString());
                    //updateBufferComidaTextArea(bufferComidaLabel.toString());
                    buffer.setLength(0); // Limpia el buffer después de cada nueva línea
                } else {
                    buffer.append((char) b);
                }
            }
        };
        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }

}

