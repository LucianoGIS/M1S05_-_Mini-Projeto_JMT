package models;

public class Avaliacao {
    private int id;
    private int areaVerdeId;
    private int notaQuantidadeArvores;
    private int notaQualidadeAr;
    private int notaAusenciaPoluicaoSonora;
    private int notaColetaResiduos;
    private int notaFacilidadeTransportePublico;

    public Avaliacao() {
    }

    public Avaliacao(int id, int areaVerdeId, int notaQuantidadeArvores, int notaQualidadeAr,
                     int notaAusenciaPoluicaoSonora, int notaColetaResiduos, int notaFacilidadeTransportePublico) {
        this.id = id;
        this.areaVerdeId = areaVerdeId;
        this.notaQuantidadeArvores = notaQuantidadeArvores;
        this.notaQualidadeAr = notaQualidadeAr;
        this.notaAusenciaPoluicaoSonora = notaAusenciaPoluicaoSonora;
        this.notaColetaResiduos = notaColetaResiduos;
        this.notaFacilidadeTransportePublico = notaFacilidadeTransportePublico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAreaVerdeId() {
        return areaVerdeId;
    }

    public void setAreaVerdeId(int areaVerdeId) {
        this.areaVerdeId = areaVerdeId;
    }

    public int getNotaQuantidadeArvores() {
        return notaQuantidadeArvores;
    }

    public void setNotaQuantidadeArvores(int notaQuantidadeArvores) {
        this.notaQuantidadeArvores = notaQuantidadeArvores;
    }

    public int getNotaQualidadeAr() {
        return notaQualidadeAr;
    }

    public void setNotaQualidadeAr(int notaQualidadeAr) {
        this.notaQualidadeAr = notaQualidadeAr;
    }

    public int getNotaAusenciaPoluicaoSonora() {
        return notaAusenciaPoluicaoSonora;
    }

    public void setNotaAusenciaPoluicaoSonora(int notaAusenciaPoluicaoSonora) {
        this.notaAusenciaPoluicaoSonora = notaAusenciaPoluicaoSonora;
    }

    public int getNotaColetaResiduos() {
        return notaColetaResiduos;
    }

    public void setNotaColetaResiduos(int notaColetaResiduos) {
        this.notaColetaResiduos = notaColetaResiduos;
    }

    public int getNotaFacilidadeTransportePublico() {
        return notaFacilidadeTransportePublico;
    }

    public void setNotaFacilidadeTransportePublico(int notaFacilidadeTransportePublico) {
        this.notaFacilidadeTransportePublico = notaFacilidadeTransportePublico;
    }

    public double calcularMediaAvaliacao() {
        return (notaQuantidadeArvores + notaQualidadeAr + notaAusenciaPoluicaoSonora +
                notaColetaResiduos + notaFacilidadeTransportePublico) / 5.0;
    }

    @Override
    public String toString() {
        return "Avaliação [ID: " + id +
                "\nÁrea Verde ID: " + areaVerdeId +
                "\nNota Quantidade de Árvores: " + notaQuantidadeArvores +
                "\nNota Qualidade do Ar: " + notaQualidadeAr +
                "\nNota Ausência de Poluição Sonora: " + notaAusenciaPoluicaoSonora +
                "\nNota Coleta de Resíduos: " + notaColetaResiduos +
                "\nNota Facilidade de Transporte Público: " + notaFacilidadeTransportePublico +
                "\nMédia da Avaliação: " + String.format("%.2f", calcularMediaAvaliacao()) + "]";
    }
}