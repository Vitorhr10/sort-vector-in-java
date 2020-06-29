/*
 * Projeto.: Ordenação em Vetores
 * Autor...: Vitor
 * Classe..: MsgVetor
 * Objetivo: Biblioteca para mensagens de interação com o usuário
 */
package vetorgeral;
import java.util.Scanner;

public class MsgVetor
{
    public static String x_linha = "--------------------------------------------------------------------------------";
    public static int    t_linha = 80;

    // Objetivo: simular a limpeza da tela para despoluir a área
    //           de saída (resultados) dos projetos
    //
    public static void limpatela()
    {
        for (int i=0; i<50; i++)
        {
            msg_pl (" ");
        }
        msg_nl (x_linha);
        msg_nl (">>>>>>>>>>>>>>>>>>  Métodos de Ordenação aplicados a Vetores  <<<<<<<<<<<<<<<<<<");
        msg_nl (x_linha);
    }
    
    // Objetivo: apresentar mensagens interativas ao usuário sobre
    //           caminhar dos processos nos projetos - com salto de linha antes
    //
    public static void msg_pl (String mensagem)
    {
        System.out.println("\n"+mensagem);
    }

    // Objetivo: apresentar mensagens interativas ao usuário sobre
    //           caminhar dos processos nos projetos - com salto de linha antes
    //
    public static void msg_nl (String mensagem)
    {
        System.out.println(mensagem);
    }

    // Objetivo: apresentar mensagens interativas ao usuário sobre
    //           caminhar dos processos nos projetos - com layout central
    //
    public static void msg_central (String mensagem)
    {
        int t = mensagem.length();
        
        if (t < 80)
        {
            int d = (80 - t) / 2;
            int r = t % 2;

            for (int p = 1; p <= d; p++)
            {
                mensagem = " "+mensagem;
            }

            if (r == 1) 
            {
                mensagem = " "+mensagem;
            }
        }
        
        msg_nl(x_linha);
        msg_nl(mensagem);
        msg_nl(x_linha);
    }

    // Objetivo: possibilitar uma ação interativa para com o usuário
    //           visando chamar a atenção para algumas mensagens
    //
    public static void enter ()
    {
        Scanner s = new Scanner(System.in);
        msg_central ("Pressione <enter> para prosseguir");

        String tecla = s.nextLine();

        limpatela();
    }

    // Objetivo: menu padrão para as atividades de consulta
    //           relacionadas às listas
    //
    public static void menu_consulta()
    {
        limpatela();
        msg_central ("Menu Consulta - Escolha sua opcao");
        msg_nl ("1. Geral");
        msg_nl ("2. Por posição");
        msg_nl ("3. Por conteúdo");
        msg_nl ("0. Retornar");
        msg_nl (x_linha);
    }

    // Objetivo: menu padrão para as atividades de escolha de listas
    //           
    //
    public static void menu_lista()
    {
        limpatela();
        msg_central ("Menu de Vetores - Escolha sua opcao");
        msg_nl ("1. Vetor 1");
        msg_nl ("2. Vetor 2");
        msg_nl ("3. Vetor 3");
        msg_nl ("0. Retornar");
        msg_nl (x_linha);
    }

    // Objetivo: menu padrão para as atividades principais
    //           relacionadas às listas
    //
    public static void menu_principal()
    {
        limpatela();
        msg_central ("Menu Principal - Escolha a sua opção");
        msg_nl (" 1. Não disponível                    8. Gerar vetor de números");
        msg_nl (" 2. Não disponível                    9. Ordenação ");
        msg_nl (" 3. Consultar                        10. Listar dois vetores simultâneamente");
        msg_nl (" 4. Inicializar                      11. Copiar um vetor para outro");
        msg_nl (" 5. Tamanho");
        msg_nl (" 6. Troca de Lugar");
        msg_nl (" 7. Troca de Prioridade               0. Finalizar");
        msg_nl (x_linha);
    }

    // Objetivo: menu padrão para as atividades principais
    //           relacionadas às listas
    //
    public static void menu_ordenacao()
    {
        limpatela();
        msg_central ("Menu Ordenação - Escolha a sua opção");
        msg_nl ("   1. Bubble                          6. Quick");
        msg_nl ("   2. Selection                       7. Heap");
        msg_nl ("   3. Insertion                       8. Dreco Sort");
        msg_nl ("   4. Merge                           9. Processo 9");
        msg_nl ("   5. Shell                          10. Processo Dreco");
        msg_nl ("                                      0. Finalizar");
        msg_nl ("-------------------------------------------------------------");
    }


    // Objetivo: função para receber e tratar a opção em relação às consultas
    //           
    //
    public static int opcao_consulta()
    {
        Scanner s = new Scanner(System.in);
        int opc  = 0;
        int erro = 0;

        menu_consulta();
        msg_nl ("Digite a opção desejada: ");

        try
        {
            opc = s.nextInt();
        }
        catch (Exception e)
        {
            opc  = 99;
            erro = 1;
        }

        while ((opc < 0 || opc > 3) && (erro != 1))
        {
            menu_consulta();
            msg_nl ("Opção inválida, corrija: ");

            try
            {
                opc = s.nextInt();
            }
            catch (Exception e)
            {
                opc  = 99;
                erro = 1;
            }
        }
        return opc;
    }

    // Objetivo: função para receber e tratar a opção em relação às consultas
    //           
    //
    public static int opcao_vetor(String tipo)
    {
        Scanner s = new Scanner(System.in);
        int opc  = 0;
        int erro = 0;

        menu_lista();
        msg_nl ("Digite o vetor desejado para "+tipo+": ");

        try
        {
            opc = s.nextInt();
        }
        catch (Exception e)
        {
            opc  = 99;
            erro = 1;
        }

        while ((opc < 0 || opc > 3) && (erro != 1))
        {
            menu_lista();
            msg_nl ("Vetor inválido, corrija para "+tipo+": ");

            try
            {
                opc = s.nextInt();
            }
            catch (Exception e)
            {
                opc  = 99;
                erro = 1;
            }
        }
        return opc;
    }

    // Objetivo: função para receber e tratar a opção em relação ao menu
    //           principal das atividades relacionadas às listas
    //
    public static int opcao_principal()
    {
        Scanner s = new Scanner(System.in);
        int opc  = 0;
        int erro = 0;

        menu_principal();
        msg_nl ("Digite a opção desejada: ");

        try
        {
            opc = s.nextInt();
        }
        catch (Exception e)
        {
            opc  = 99;
            erro = 1;
        }

        while ((opc < 0 || opc > 11) && (erro != 1))
        {
            menu_principal();
            msg_nl ("Opção inválida, corrija: ");

            try
            {
                opc = s.nextInt();
            }
            catch (Exception e)
            {
                opc  = 99;
                erro = 1;
            }
        }
        return opc;
    }


    // Objetivo: função para receber e tratar a opção em relação ao menu
    //           principal das atividades relacionadas às listas
    //
    public static int opcao_ordenacao()
    {
        Scanner s = new Scanner(System.in);
        int opc  = 0;
        int erro = 0;

        menu_ordenacao();
        msg_nl ("Digite a opção desejada: ");

        try
        {
            opc = s.nextInt();
        }
        catch (Exception e)
        {
            opc  = 99;
            erro = 1;
        }

        while ((opc < 0 || opc > 10) && (erro != 1))
        {
            menu_principal();
            msg_nl ("Opção inválida, corrija: ");

            try
            {
                opc = s.nextInt();
            }
            catch (Exception e)
            {
                opc  = 99;
                erro = 1;
            }
        }
        return opc;
    }

    // Objetivo: função para receber o valor de uma posição para
    //           as atividades relacionadas ao vetor e que a requeiram
    //
    public static int solicita_posicao()
    {
        Scanner s = new Scanner(System.in);
        int posicao = 0;

        try
        {
            msg_nl ("Digite a posicao desejada ou zero para retornar: ");
            posicao = s.nextInt();
        }
        catch(Exception e)
        {
            posicao = 0;
        }
        return posicao;
    }

    // Objetivo: função para receber o valor de um conteúdo para
    //           as atividades relacionadas ao vetor e que o requeiram
    //
    public static int solicita_conteudo()
    {
        Scanner s = new Scanner(System.in);
        int conteudo = 0;

        try
        {
            msg_nl ("Digite o conteudo a ser pesquisado ou tecle <enter> para retornar: ");
            conteudo = s.nextInt();
        }
        catch(Exception e)
        {
            msg_nl ("Erro de digitação, retornando ao menu principal...");
            conteudo = 0;
        }
        return conteudo;
    }

    // Objetivo: função para receber a quantidade de número randomicos
    //           para serem inseridos como elementos
    //
    public static int solicita_quantidade()
    {
        Scanner s = new Scanner(System.in);
        int quantidade = 0;

        try
        {
            msg_nl ("Digite a quantidade desejada de elementos para");
            msg_nl ("gerar o vetor ou zero para retornar: ");
            quantidade = s.nextInt();
        }
        catch(Exception e)
        {
            quantidade = 0;
        }
        return quantidade;
    }
}
