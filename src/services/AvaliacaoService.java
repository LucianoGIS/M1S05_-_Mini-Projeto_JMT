package services;

import models.Avaliacao;
import repositories.AvaliacaoRepository;
import repositories.AreaVerdeRepository;
import java.util.List;

public class AvaliacaoService {

    public Avaliacao avaliarAreaVerde(int areaVerdeId, int notaQuantidadeArvores, int notaQualidadeAr,
                                      int notaAusenciaPoluicaoSonora, int notaColetaResiduos,
                                      int notaFacilidadeTransportePublico) {

        // Verifica se a área verde existe
        if (AreaVerdeRepository.buscarPorId(areaVerdeId) == null) {
            return null;
        }

        // Validação das notas (1-5)
        notaQuantidadeArvores = validarNota(notaQuantidadeArvores);
        notaQualidadeAr = validarNota(notaQualidadeAr);
        notaAusenciaPoluicaoSonora = validarNota(notaAusenciaPoluicaoSonora);
        notaColetaResiduos = validarNota(notaColetaResiduos);
        notaFacilidadeTransportePublico = validarNota(notaFacilidadeTransportePublico);

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setAreaVerdeId(areaVerdeId);
        avaliacao.setNotaQuantidadeArvores(notaQuantidadeArvores);
        avaliacao.setNotaQualidadeAr(notaQualidadeAr);
        avaliacao.setNotaAusenciaPoluicaoSonora(notaAusenciaPoluicaoSonora);
        avaliacao.setNotaColetaResiduos(notaColetaResiduos);
        avaliacao.setNotaFacilidadeTransportePublico(notaFacilidadeTransportePublico);

        return AvaliacaoRepository.adicionar(avaliacao);
    }

    private int validarNota(int nota) {
        if (nota < 1) return 1;
        if (nota > 5) return 5;
        return nota;
    }

    public List<Avaliacao> listarAvaliacoes() {
        return AvaliacaoRepository.listarTodos();
    }

    public Avaliacao buscarAvaliacaoPorId(int id) {
        return AvaliacaoRepository.buscarPorId(id);
    }

    public List<Avaliacao> buscarAvaliacoesPorAreaVerde(int areaVerdeId) {
        return AvaliacaoRepository.buscarPorAreaVerdeId(areaVerdeId);
    }

    public double calcularMediaAvaliacoesPorAreaVerde(int areaVerdeId) {
        List<Avaliacao> avaliacoes = buscarAvaliacoesPorAreaVerde(areaVerdeId);

        if (avaliacoes.isEmpty()) {
            return 0;
        }

        double somaMedias = 0;
        for (Avaliacao avaliacao : avaliacoes) {
            somaMedias += avaliacao.calcularMediaAvaliacao();
        }

        return somaMedias / avaliacoes.size();
    }
}