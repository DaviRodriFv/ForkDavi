package com.VitorsosterF.exercicioPraticoAPIREST.service;

import com.VitorsosterF.exercicioPraticoAPIREST.model.Moto;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class MotoFilaService {

    private final BlockingQueue<Moto> fila = new LinkedBlockingQueue<>();

    public void enfileirar(Moto moto) {
        fila.offer(moto);
        System.out.println("[FILA] Moto enfileirada para notificação: " + moto.getModelo());
    }

    public BlockingQueue<Moto> getFila() {
        return fila;
    }
}