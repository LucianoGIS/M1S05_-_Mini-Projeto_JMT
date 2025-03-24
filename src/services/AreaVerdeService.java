package services;

import models.AreaVerde;
import models.Localizacao;
import repositories.AreaVerdeRepository;
import java.util.List;

public class AreaVerdeService {
    private LocalizacaoService localizacaoService;

    public AreaVerdeService() {
        this.localizacaoService = new LocalizacaoService();
    }

    public AreaVerde cadastrarAreaVerde(String nome, String tipoVegetacao, String horarioFuncionamento,
                                        double latitude, double longitude) {

        AreaVerde areaVerde = new AreaVerde();
        areaVerde.setNome(nome);
        areaVerde.setTipoVegetacao(tipoVegetacao);
        areaVerde.setHorarioFuncionamento(horarioFuncionamento);

        AreaVerde areaSalva = AreaVerdeRepository.adicionar(areaVerde);

        localizacaoService.cadastrarLocalizacao(latitude, longitude, areaSalva.getId());

        return areaSalva;
    }

    public boolean adicionarAtividade(int id, String atividade) {
        AreaVerde areaVerde = AreaVerdeRepository.buscarPorId(id);
        if (areaVerde == null) {
            return false;
        }

        areaVerde.adicionarAtividade(atividade);
        return AreaVerdeRepository.atualizar(areaVerde);
    }

    public List<AreaVerde> listarAreasVerdes() {
        return AreaVerdeRepository.listarTodos();
    }

    public AreaVerde buscarAreaVerdePorId(int id) {
        return AreaVerdeRepository.buscarPorId(id);
    }

    public boolean atualizarAreaVerde(int id, String nome, String tipoVegetacao, String horarioFuncionamento) {
        AreaVerde areaVerde = buscarAreaVerdePorId(id);
        if (areaVerde == null) {
            return false;
        }

        areaVerde.setNome(nome);
        areaVerde.setTipoVegetacao(tipoVegetacao);
        areaVerde.setHorarioFuncionamento(horarioFuncionamento);

        return AreaVerdeRepository.atualizar(areaVerde);
    }

    public boolean removerAreaVerde(int id) {
        // Busca a localização associada e remove
        Localizacao localizacao = localizacaoService.buscarLocalizacaoPorAreaVerdeId(id);
        if (localizacao != null) {
            localizacaoService.removerLocalizacao(localizacao.getId());
        }

        return AreaVerdeRepository.remover(id);
    }
}