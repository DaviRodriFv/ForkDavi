package com.VitorsosterF.exercicioPraticoAPIREST.queue;

import com.VitorsosterF.exercicioPraticoAPIREST.model.Carro;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CarroIntegracaoWorker {

    @Autowired
    private com.VitorsosterF.exercicioPraticoAPIREST.queue.CarroIntegracaoQueue queue;

    @PostConstruct
    public void iniciar() {
        Thread worker = new Thread(() -> {
            System.out.println("[WORKER] Iniciado — aguardando carros na fila...");

            while (true) {
                try {
                    Carro carro = queue.consumir();
                } catch (InterruptedException e) {
                    System.err.println("[WORKER] Thread interrompida: " + e.getMessage());
                    Thread.currentThread().interrupt();
                    break;
                } catch (Exception e) {
                    System.err.println("[WORKER] Erro ao processar integração: " + e.getMessage());
                }
            }
        });

        worker.setName("carro-integracao-worker");
        worker.setDaemon(true);
        worker.start();
    }

    private void processarIntegracao(Carro carro) throws InterruptedException {
        System.out.println("[WORKER] Processando integração do carro ID=" + carro.getId()
                + " | " + carro.getMarca() + " " + carro.getModelo() + " (" + carro.getAno() + ")");
        Thread.sleep(1500);


        System.out.println("[WORKER] ✓ Integração concluída para carro ID=" + carro.getId());
    }
}