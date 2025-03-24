package services;

import models.Localizacao;
import repositories.LocalizacaoRepository;
import java.util.List;

public class LocalizacaoService {

    public Localizacao cadastrarLocalizacao(double latitude, double longitude, int areaVerdeId) {
        Localizacao localizacao = new Localizacao();
        localizacao.setLatitude(latitude);
        localizacao.setLongitude(longitude);
        localizacao.setAreaVerdeId(areaVerdeId);

        return LocalizacaoRepository.adicionar(localizacao);
    }

    public List<Localizacao> listarLocalizacoes() {
        return LocalizacaoRepository.listarTodos();
    }

    public Localizacao buscarLocalizacaoPorId(int id) {
        return LocalizacaoRepository.buscarPorId(id);
    }

    public Localizacao buscarLocalizacaoPorAreaVerdeId(int areaVerdeId) {
        return LocalizacaoRepository.buscarPorAreaVerdeId(areaVerdeId);
    }

    public boolean atualizarLocalizacao(int id, double latitude, double longitude) {
        Localizacao localizacao = buscarLocalizacaoPorId(id);
        if (localizacao == null) {
            return false;
        }

        localizacao.setLatitude(latitude);
        localizacao.setLongitude(longitude);

        return LocalizacaoRepository.atualizar(localizacao);
    }

    public boolean removerLocalizacao(int id) {
        return LocalizacaoRepository.remover(id);
    }
}