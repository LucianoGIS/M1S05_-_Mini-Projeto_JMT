package repositories;

import models.Avaliacao;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoRepository {
    private static List<Avaliacao> AVALIACOES = new ArrayList<>();
    private static int nextId = 1;

    public static Avaliacao adicionar(Avaliacao avaliacao) {
        avaliacao.setId(nextId++);
        AVALIACOES.add(avaliacao);
        return avaliacao;
    }

    public static List<Avaliacao> listarTodos() {
        return new ArrayList<>(AVALIACOES);
    }

    public static Avaliacao buscarPorId(int id) {
        for (Avaliacao avaliacao : AVALIACOES) {
            if (avaliacao.getId() == id) {
                return avaliacao;
            }
        }
        return null;
    }

    public static List<Avaliacao> buscarPorAreaVerdeId(int areaVerdeId) {
        List<Avaliacao> avaliacoesAreaVerde = new ArrayList<>();
        for (Avaliacao avaliacao : AVALIACOES) {
            if (avaliacao.getAreaVerdeId() == areaVerdeId) {
                avaliacoesAreaVerde.add(avaliacao);
            }
        }
        return avaliacoesAreaVerde;
    }

    public static boolean atualizar(Avaliacao avaliacao) {
        for (int i = 0; i < AVALIACOES.size(); i++) {
            if (AVALIACOES.get(i).getId() == avaliacao.getId()) {
                AVALIACOES.set(i, avaliacao);
                return true;
            }
        }
        return false;
    }

    public static boolean remover(int id) {
        return AVALIACOES.removeIf(avaliacao -> avaliacao.getId() == id);
    }
}