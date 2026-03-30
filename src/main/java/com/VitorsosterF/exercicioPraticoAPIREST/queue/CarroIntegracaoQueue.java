package com.VitorsosterF.exercicioPraticoAPIREST.queue;

import com.VitorsosterF.exercicioPraticoAPIREST.model.Carro;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class CarroIntegracaoQueue {

    private final BlockingQueue<Carro> fila = new LinkedBlockingQueue<>();

    public void enfileirar(Carro carro) {
        fila.offer(carro);
        System.out.println("[FILA] Carro enfileirado para integração: " + carro.getMarca() + " " + carro.getModelo());
    }

    public Carro consumir() throws InterruptedException {
        return fila.take();
    }
}