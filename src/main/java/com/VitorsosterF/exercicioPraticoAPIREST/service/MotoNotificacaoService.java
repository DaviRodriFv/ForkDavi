package com.VitorsosterF.exercicioPraticoAPIREST.service;

import com.VitorsosterF.exercicioPraticoAPIREST.model.Moto;
import org.springframework.stereotype.Service;

@Service
public class MotoNotificacaoService {

    public void enviarNotificacao(Moto moto) {
        // Simulação de envio de notificação (e-mail, push, log, etc.)
        System.out.println("====================================");
        System.out.println("[NOTIFICAÇÃO] Nova moto cadastrada!");
        System.out.println("Modelo: " + moto.getModelo());
        System.out.println("Marca: " + moto.getMarca());
        System.out.println("Ano: " + moto.getAno());
        System.out.println("Preço: R$ " + moto.getPreco());
        System.out.println("Cilindrada: " + moto.getCilindrada() + "cc");
        System.out.println("====================================");
    }
}