package com.VitorsosterF.exercicioPraticoAPIREST.service;

import com.VitorsosterF.exercicioPraticoAPIREST.model.Moto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoWorker {

    @Autowired
    private MotoFilaService motoFilaService;

    @Autowired
    private MotoNotificacaoService motoNotificacaoService;

    @PostConstruct
    public void iniciarWorker() {
        Thread worker = new Thread(() -> {
            System.out.println("[WORKER] Worker de notificação de motos iniciado.");
            while (true) {
                try {
                    // Fica bloqueado até chegar uma moto na fila
                    Moto moto = motoFilaService.getFila().take();
                    System.out.println("[WORKER] Processando notificação para: " + moto.getModelo());
                    motoNotificacaoService.enviarNotificacao(moto);
                } catch (InterruptedException e) {
                    System.err.println("[WORKER] Worker interrompido: " + e.getMessage());
                    Thread.currentThread().interrupt();
                    break;
                } catch (Exception e) {
                    System.err.println("[WORKER] Erro ao processar notificação: " + e.getMessage());
                    // Continua processando mesmo com erro (fallback)
                }
            }
        });

        worker.setName("moto-notificacao-worker");
        worker.setDaemon(true); // Encerra junto com a aplicação
        worker.start();
    }
}