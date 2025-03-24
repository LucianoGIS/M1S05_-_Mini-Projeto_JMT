package models;

import java.util.ArrayList;
import java.util.List;
import repositories.AvaliacaoRepository;
import repositories.LocalizacaoRepository;

public class AreaVerde {
    private int id;
    private String nome;
    private String tipoVegetacao;
    private String horarioFuncionamento;
    private List<String> atividadesDisponiveis;

    public AreaVerde() {
        this.atividadesDisponiveis = new ArrayList<>();
    }

    public AreaVerde(int id, String nome, String tipoVegetacao, String horarioFuncionamento) {
        this.id = id;
        this.nome = nome;
        this.tipoVegetacao = tipoVegetacao;
        this.horarioFuncionamento = horarioFuncionamento;
        this.atividadesDisponiveis = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoVegetacao() {
        return tipoVegetacao;
    }

    public void setTipoVegetacao(String tipoVegetacao) {
        this.tipoVegetacao = tipoVegetacao;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public List<String> getAtividadesDisponiveis() {
        return atividadesDisponiveis;
    }

    public void setAtividadesDisponiveis(List<String> atividadesDisponiveis) {
        this.atividadesDisponiveis = atividadesDisponiveis;
    }

    public void adicionarAtividade(String atividade) {
        this.atividadesDisponiveis.add(atividade);
    }

    public Localizacao getLocalizacao() {
        return LocalizacaoRepository.buscarPorAreaVerdeId(this.id);
    }

    public List<Avaliacao> getAvaliacoes() {
        return AvaliacaoRepository.buscarPorAreaVerdeId(this.id);
    }

    public double calcularMediaAvaliacoes() {
        List<Avaliacao> avaliacoes = getAvaliacoes();
        if (avaliacoes.isEmpty()) {
            return 0;
        }

        double somaMedias = 0;
        for (Avaliacao avaliacao : avaliacoes) {
            somaMedias += avaliacao.calcularMediaAvaliacao();
        }

        return somaMedias / avaliacoes.size();
    }

    public String dadosListagem() {
        return "ID: " + id + " | Nome: " + nome + " | Tipo de Vegetação: " + tipoVegetacao +
                " | Média das Avaliações: " + String.format("%.2f", calcularMediaAvaliacoes());
    }

    public String dadosDetalhados() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DETALHES DA ÁREA VERDE ===\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Tipo de Vegetação: ").append(tipoVegetacao).append("\n");
        sb.append("Horário de Funcionamento: ").append(horarioFuncionamento).append("\n");

        Localizacao loc = getLocalizacao();
        if (loc != null) {
            sb.append("Localização: ").append(loc).append("\n");
        } else {
            sb.append("Localização: Não cadastrada\n");
        }

        sb.append("Atividades Disponíveis: ");
        if (atividadesDisponiveis.isEmpty()) {
            sb.append("Nenhuma atividade cadastrada");
        } else {
            sb.append("\n");
            for (int i = 0; i < atividadesDisponiveis.size(); i++) {
                sb.append("  - ").append(atividadesDisponiveis.get(i)).append("\n");
            }
        }

        sb.append("Média das Avaliações: ").append(String.format("%.2f", calcularMediaAvaliacoes())).append("\n");

        List<Avaliacao> avaliacoes = getAvaliacoes();
        sb.append("Quantidade de Avaliações: ").append(avaliacoes.size());

        return sb.toString();
    }
}