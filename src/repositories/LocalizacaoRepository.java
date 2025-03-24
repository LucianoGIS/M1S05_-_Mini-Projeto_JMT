package repositories;

import models.Localizacao;
import java.util.ArrayList;
import java.util.List;

public class LocalizacaoRepository {
    private static List<Localizacao> LOCALIZACOES = new ArrayList<>();
    private static int nextId = 1;

    public static Localizacao adicionar(Localizacao localizacao) {
        localizacao.setId(nextId++);
        LOCALIZACOES.add(localizacao);
        return localizacao;
    }

    public static List<Localizacao> listarTodos() {
        return new ArrayList<>(LOCALIZACOES);
    }

    public static Localizacao buscarPorId(int id) {
        for (Localizacao localizacao : LOCALIZACOES) {
            if (localizacao.getId() == id) {
                return localizacao;
            }
        }
        return null;
    }

    public static Localizacao buscarPorAreaVerdeId(int areaVerdeId) {
        for (Localizacao localizacao : LOCALIZACOES) {
            if (localizacao.getAreaVerdeId() == areaVerdeId) {
                return localizacao;
            }
        }
        return null;
    }

    public static boolean atualizar(Localizacao localizacao) {
        for (int i = 0; i < LOCALIZACOES.size(); i++) {
            if (LOCALIZACOES.get(i).getId() == localizacao.getId()) {
                LOCALIZACOES.set(i, localizacao);
                return true;
            }
        }
        return false;
    }

    public static boolean remover(int id) {
        return LOCALIZACOES.removeIf(localizacao -> localizacao.getId() == id);
    }
}