import java.util.Scanner;

public class iPhone {
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        var option = -1;

        do {
            System.out.println();
            System.out.println();
            System.out.println(">>>>>>>>>>> iPhone <<<<<<<<<<<");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Reprodutor de música");
            System.out.println("2 - Telefone");
            System.out.println("3 - Navegador de internet");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Deve ser informado um número!");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }

            switch (option) {
                case 1:
                    reproduzirMusica(scanner);
                    option = -1;
                    break;
                case 2:
                    telefonar(scanner);
                    option = -1;
                    break;
                case 3:
                    navegarInternet(scanner);
                    option = -1;
                    break;
                case 0:
                    System.out.println(">>>>>>> Desligando... <<<<<<<");
                    break;
                default:
                    System.out.println("====== Opção inválida! ======");
                    break;
            }
        } while (option != 0);

        scanner.close();
    }

    private static void reproduzirMusica(Scanner scanner) {
        String musica = "Music.mp3";
        var option = -1;
    
        do {
            System.out.println();
            System.out.println();
            System.out.println(">>>>>>>>>>> Música <<<<<<<<<<<");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Reproduzir música");
            System.out.println("2 - Pausar");
            System.out.println("3 - Escolher música");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
    
            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Deve ser informado um número!");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
    
            switch (option) {
                case 1:
                    ReprodutorMusical.tocar();
                    break;
                case 2:
                    ReprodutorMusical.pausar();;
                    break;
                case 3:
                    ReprodutorMusical.selecionarMusica(musica);;
                    break;
                case 0:
                    break;
                default:
                    System.out.println("====== Opção inválida! ======");
                    break;
            }
        } while (option != 0);
    }
    private static void telefonar(Scanner scanner) {
        String numero = "(99)9999-9999";
        var option = -1;
    
        do {
            System.out.println();
            System.out.println();
            System.out.println(">>>>>>>>>> Telefone <<<<<<<<<<");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Ligar");
            System.out.println("2 - Atender ligação");
            System.out.println("3 - Ouvir correio de voz");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
    
            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Deve ser informado um número!");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
    
            switch (option) {
                case 1:
                    AparelhoTelefonico.ligar();
                    break;
                case 2:
                    AparelhoTelefonico.atender();
                    break;
                case 3:
                    AparelhoTelefonico.iniciarCorreioVoz(numero);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("====== Opção inválida! ======");
                    break;
            }
        } while (option != 0);
    }
    private static void navegarInternet(Scanner scanner) {
        String url = "https://google.com";
        var option = -1;
        
        do {
            System.out.println();
            System.out.println();
            System.out.println(">>>>>>>>>> Internet <<<<<<<<<<");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Abrir nova aba");
            System.out.println("2 - Exibir página");
            System.out.println("3 - Atualizar página");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
        
            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Deve ser informado um número!");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        
            switch (option) {
                case 1:
                    NavegadorInternet.adicionarNovaAba();
                    break;
                case 2:
                    NavegadorInternet.exibirPagina(url);
                    break;
                case 3:
                    NavegadorInternet.atualizarPagina();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("====== Opção inválida! ======");
                    break;
            }
        } while (option != 0);
    }
}
