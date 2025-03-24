package main;

import models.AreaVerde;
import models.Avaliacao;
import services.AreaVerdeService;
import services.AvaliacaoService;
import utils.InputUtils;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static AreaVerdeService areaVerdeService = new AreaVerdeService();
    private static AvaliacaoService avaliacaoService = new AvaliacaoService();
    private static Scanner scanner = new Scanner(System.in);
    private static InputUtils input = new InputUtils(scanner);

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE MAPEAMENTO DE ÁREAS VERDES DE JOINVILLE ===");

        // Verifica se deseja criar dados de exemplo para teste
        if (input.confirmar("Deseja criar alguns dados de exemplo para testar o sistema?")) {
            criarDadosExemplo();
        }

        int opcao;
        do {
            exibirMenu();
            opcao = input.lerInteiroComLimite("Digite a opção desejada: ", 0, 4);

            switch (opcao) {
                case 1:
                    listarAreasVerdes();
                    break;
                case 2:
                    avaliarAreaVerde();
                    break;
                case 3:
                    verDetalheAreaVerde();
                    break;
                case 4:
                    cadastrarAreaVerde();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            if (opcao != 0) {
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1- Listar Áreas Verdes");
        System.out.println("2- Avaliar Área Verde");
        System.out.println("3- Ver detalhe de uma Área Verde");
        System.out.println("4- Cadastrar nova Área Verde");
        System.out.println("0- Sair");
    }

    private static void listarAreasVerdes() {
        System.out.println("\n=== ÁREAS VERDES CADASTRADAS ===");
        List<AreaVerde> areas = areaVerdeService.listarAreasVerdes();

        if (areas.isEmpty()) {
            System.out.println("Nenhuma área verde cadastrada.");
            return;
        }

        for (AreaVerde area : areas) {
            System.out.println(area.dadosListagem());
        }
    }

    private static void avaliarAreaVerde() {
        System.out.println("\n=== AVALIAR ÁREA VERDE ===");

        listarAreasVerdes();

        if (areaVerdeService.listarAreasVerdes().isEmpty()) {
            return;
        }

        int idArea = input.lerInteiro("Digite o ID da área verde que deseja avaliar: ");
        AreaVerde area = areaVerdeService.buscarAreaVerdePorId(idArea);

        if (area == null) {
            System.out.println("Área verde não encontrada!");
            return;
        }

        System.out.println("Avaliando: " + area.getNome());
        System.out.println("Por favor, dê uma nota de 1 a 5 para cada critério:");

        int notaArvores = input.lerInteiroComLimite("Quantidade de árvores: ", 1, 5);
        int notaAr = input.lerInteiroComLimite("Qualidade do ar: ", 1, 5);
        int notaSonora = input.lerInteiroComLimite("Ausência de poluição sonora: ", 1, 5);
        int notaResiduos = input.lerInteiroComLimite("Coleta de resíduos: ", 1, 5);
        int notaTransporte = input.lerInteiroComLimite("Facilidade de transporte público: ", 1, 5);

        Avaliacao avaliacao = avaliacaoService.avaliarAreaVerde(
                idArea, notaArvores, notaAr, notaSonora, notaResiduos, notaTransporte
        );

        if (avaliacao != null) {
            System.out.println("Avaliação registrada com sucesso!");
            System.out.println("Média da avaliação: " + String.format("%.2f", avaliacao.calcularMediaAvaliacao()));
        } else {
            System.out.println("Erro ao registrar avaliação.");
        }
    }

    private static void verDetalheAreaVerde() {
        System.out.println("\n=== DETALHES DA ÁREA VERDE ===");

        listarAreasVerdes();

        if (areaVerdeService.listarAreasVerdes().isEmpty()) {
            return;
        }

        int idArea = input.lerInteiro("Digite o ID da área verde que deseja visualizar: ");
        AreaVerde area = areaVerdeService.buscarAreaVerdePorId(idArea);

        if (area == null) {
            System.out.println("Área verde não encontrada!");
            return;
        }

        System.out.println(area.dadosDetalhados());
    }

    private static void cadastrarAreaVerde() {
        System.out.println("\n=== CADASTRAR NOVA ÁREA VERDE ===");

        String nome = input.lerTexto("Nome da área verde: ");
        String tipoVegetacao = input.lerTexto("Tipo de vegetação (árvores, arbustos, grama): ");
        String horario = input.lerTexto("Horário de funcionamento: ");
        double latitude = input.lerDecimal("Latitude: ");
        double longitude = input.lerDecimal("Longitude: ");

        AreaVerde area = areaVerdeService.cadastrarAreaVerde(nome, tipoVegetacao, horario, latitude, longitude);

        if (area != null) {
            System.out.println("Área verde cadastrada com sucesso! ID: " + area.getId());

            // Adicionar atividades
            boolean continuarAddAtividades = true;
            while (continuarAddAtividades) {
                String atividade = input.lerTexto("Digite uma atividade disponível (ou deixe em branco para finalizar): ");

                if (atividade.isEmpty()) {
                    continuarAddAtividades = false;
                } else {
                    areaVerdeService.adicionarAtividade(area.getId(), atividade);
                }
            }
        } else {
            System.out.println("Erro ao cadastrar área verde.");
        }
    }

    private static void criarDadosExemplo() {
        // Parque da Cidade
        AreaVerde parqueCidade = areaVerdeService.cadastrarAreaVerde(
                "Parque da Cidade",
                "Árvores nativas e gramado",
                "Diariamente, das 6h às 22h",
                -26.3045,
                -48.8456
        );
        areaVerdeService.adicionarAtividade(parqueCidade.getId(), "Caminhada");
        areaVerdeService.adicionarAtividade(parqueCidade.getId(), "Ciclismo");
        areaVerdeService.adicionarAtividade(parqueCidade.getId(), "Parquinho infantil");

        // Praça da Harmonia
        AreaVerde pracaHarmonia = areaVerdeService.cadastrarAreaVerde(
                "Praça da Harmonia",
                "Arbustos ornamentais e flores",
                "24 horas",
                -26.3125,
                -48.8389
        );
        areaVerdeService.adicionarAtividade(pracaHarmonia.getId(), "Piquenique");
        areaVerdeService.adicionarAtividade(pracaHarmonia.getId(), "Quadra de vôlei de areia");

        // Reserva Verde
        AreaVerde reservaVerde = areaVerdeService.cadastrarAreaVerde(
                "Reserva Verde Joinville",
                "Mata Atlântica preservada",
                "Das 8h às 17h, exceto segundas",
                -26.2945,
                -48.8512
        );
        areaVerdeService.adicionarAtividade(reservaVerde.getId(), "Trilhas ecológicas");
        areaVerdeService.adicionarAtividade(reservaVerde.getId(), "Observação de aves");

        // Adicionar algumas avaliações
        avaliacaoService.avaliarAreaVerde(parqueCidade.getId(), 5, 4, 3, 4, 5);
        avaliacaoService.avaliarAreaVerde(parqueCidade.getId(), 4, 5, 4, 4, 5);

        avaliacaoService.avaliarAreaVerde(pracaHarmonia.getId(), 3, 4, 5, 3, 4);

        avaliacaoService.avaliarAreaVerde(reservaVerde.getId(), 5, 5, 5, 4, 2);

        System.out.println("Dados de exemplo criados com sucesso!");
    }
}