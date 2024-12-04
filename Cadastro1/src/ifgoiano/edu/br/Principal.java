package ifgoiano.edu.br;

import java.util.Scanner;

public class Principal {
    private EstadoDAO estadoDAO;
    private DeputadoDAO deputadoDAO;
    private Scanner s;

    public Principal() {
        estadoDAO = new EstadoDAO();
        deputadoDAO = new DeputadoDAO();
        s = new Scanner(System.in);

        while (true) {
            System.out.println("O que você deseja fazer? \n" +
                    "1 - Estado \n" +
                    "2 - Deputado \n" +
                    "3 - Sair");
            int es = s.nextInt();

            switch (es) {
                case 1:
                    while (true) {
                        System.out.println("O que você deseja fazer com o estado? \n" +
                                "1 - Registrar \n" +
                                "2 - Excluir \n" +
                                "3 - Alterar \n" +
                                "4 - Voltar ao menu principal");
                        int op = s.nextInt();

                        switch (op) {
                            case 1:
                                estadoDAO.cadastrar();
                                System.out.println("Estado cadastrado com sucesso!");
                                break;
                            case 2:
                                estadoDAO.remove();
                                System.out.println("Estado excluído com sucesso!");
                                break;
                            case 3:
                            	estadoDAO.update();
                                System.out.println("Estado alterado com sucesso!");
                                break;
                            case 4:
                            	System.out.println("Você voltou!");
                            	break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }

                        if (op == 4) {
                            break;
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("O que você deseja fazer com o deputado? \n" +
                                "1 - Registrar \n" +
                                "2 - Excluir \n" +
                                "3 - Alterar \n" +
                                "4 - Voltar ao menu principal");
                        int op = s.nextInt();

                        switch (op) {
                            case 1:
                                deputadoDAO.cadastrar();
                                System.out.println("Deputado cadastrado com sucesso!");
                                break;
                            case 2:
                                deputadoDAO.remove();
                                System.out.println("Deputado excluído com sucesso!");
                                break;
                            case 3:
                            	deputadoDAO.update();
                                System.out.println("Deputado alterado com sucesso!");
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }

                        if (op == 4) {
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Obrigado por trabalhar conosco, até logo!");
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new Principal();
    }
}
