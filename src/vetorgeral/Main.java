/*
 * Projeto.: Lista Duplamente Ligada
 * Autor...: Professor Dreco
 * Classe..: ED2Ordenacao
 * Objetivo: Projeto Lista Duplamente Ligada
 */
package vetorgeral;

public class Main
{
    public static void listagem_Simultanea (VetorGeral v1, VetorGeral v2, int nx, int ny)
    {
        MsgVetor.limpatela();
        
        int flagc = 0;
        int p = 0;
        
        do
        {
            if (flagc == 0)
            {
                System.out.println();
                System.out.println("+-----------------------------------------------------+");
                System.out.format( "|                 | Vetor %1d         | Vetor %1d         |", nx, ny);
                System.out.println();
                System.out.println("|                 | Elementos       | Elementos       |");
                System.out.format( "|                 | %15d | %15d |\n", v1.getTamanho(), v2.getTamanho());
                System.out.println("| Posicao         |          Número |          Número |");
                System.out.println("| --------------- | --------------- | --------------- |");
                flagc = 1;
            }

            System.out.format("| %15d | %15d | %15d |\n", p, v1.getPosicao(p), v2.getPosicao(p));
            flagc = 1;
            p++;
        } while (p < v1.getTamanho());

        System.out.println("+-----------------------------------------------------+");
    }

    
    public static void main(String[] args)
    {
        VetorGeral vetorG1 = new VetorGeral();
        VetorGeral vetorG2 = new VetorGeral();
        VetorGeral vetorG3 = new VetorGeral();
        VetorGeral vetorGx = new VetorGeral();        
        
        int posicao = 0;
        int pos1 = 0;
        int pos2 = 0;
        int qtd = 0;
        int qual_vetor = 0;
        int conteudo = 0;
        
        
        vetorG1.setTamanho(vetorG1.xarq_abre_arquivo("Vetor 1"));

        vetorG2.setTamanho(vetorG2.xarq_abre_arquivo("Vetor 2"));

        vetorG3.setTamanho(vetorG3.xarq_abre_arquivo("Vetor 3"));
        
        vetorG1.setLimite(vetorG1.getTamanho());
        
        vetorG2.setLimite(vetorG2.getTamanho());
        
        vetorG3.setLimite(vetorG3.getTamanho());
        
        int opc = MsgVetor.opcao_principal();

        while (opc != 0)
        {
            if ((opc != 10) && (opc != 11))
            {
                qual_vetor = MsgVetor.opcao_vetor ("trabalho");

                switch (qual_vetor)
                {
                    case 1:
                    {
                        vetorGx = vetorG1;
                        break;
                    }   
                    case 2:
                    {
                        vetorGx = vetorG2;
                        break;
                    }   
                    case 3:
                    {
                        vetorGx = vetorG3;
                        break;
                    }   
                }
            }
            
            switch (opc)
            {
                case 1:
                {
                    MsgVetor.msg_nl ("Opção ainda não disponível. Aguarde!");
                    break;
                }
                case 2:
                {
                    MsgVetor.msg_nl ("Opção ainda não disponível. Aguarde!");
                    break;
                }
                case 3:
                    MsgVetor.limpatela();

                    if (vetorGx.getTamanho() == 0)
                    {
                        MsgVetor.msg_central ("O vetor está vazio, consulta não processada!");
                        MsgVetor.enter();
                    }
                    else
                    {
                        opc = MsgVetor.opcao_consulta();

                        MsgVetor.limpatela();

                        switch (opc)
                        {
                            case 1:
                                vetorGx.consultar_geral();
                                break;

                            case 2:
                                posicao = MsgVetor.solicita_posicao();

                                while (posicao < 1 || posicao > vetorGx.getTamanho())
                                {
                                    MsgVetor.msg_nl ("Posição inválida, escolha entre [1:"+vetorGx.getTamanho()+"]");
                                    posicao = MsgVetor.solicita_posicao();
                                }
                                
                                vetorGx.consultar_posicao(posicao);

                                MsgVetor.enter();
                                break;

                            case 3:
                                conteudo = MsgVetor.solicita_conteudo();

                                vetorGx.consultar_conteudo(conteudo);

                                MsgVetor.enter();
                                break;
                               
                            default:
                                MsgVetor.limpatela();
                                MsgVetor.msg_central ("Opção inválida, retornando...");
                                MsgVetor.enter();
                        }
                    }
                    break;

                case 4:
                    MsgVetor.limpatela();

                    if (vetorGx.getTamanho()==0)
                    {
                        MsgVetor.msg_central ("A lista está vazia, inicialização não processada!");
                    }
                    else
                    {
                        vetorGx.inicializarVetor();
                    }
                    MsgVetor.enter();
                    break;

                case 5:
                    MsgVetor.limpatela();

                    if (vetorGx.getTamanho() == 0)
                    {
                        MsgVetor.msg_central ("O tamanho não foi calculado, a lista está vazia!");
                    }
                    else
                    {
                        MsgVetor.msg_central (">> O tamanho da lista é: ["+vetorGx.getTamanho()+"]\n\n");
                    }
                    MsgVetor.enter();
                    break;

                case 6:
                    MsgVetor.limpatela();

                    if (vetorGx.getTamanho() == 0)
                    {
                        MsgVetor.msg_central ("A lista está vazia, não há como trocar elementos de lugar!");
                    }
                    else
                    {
                        if (vetorGx.getTamanho() == 1)
                        {
                            MsgVetor.msg_central ("A lista possui apenas um elemento, não há como trocar de lugar!");
                        }
                        else
                        {
                            MsgVetor.msg_nl ("Escolha a posicão de origem: ");
                            pos1 = MsgVetor.solicita_posicao();
                            
                            while (pos1 < 0 || pos1 > vetorGx.getTamanho())
                            {
                                MsgVetor.msg_nl ("Posição de origem inválida, corrija: ");
                                pos1 = MsgVetor.solicita_posicao();
                            }
                            
                            if (pos1 == 0)
                            {
                                MsgVetor.msg_central ("Você desistiu da troca de lugar, retornando para o menu principal.");
                            }
                            else
                            {
                                MsgVetor.msg_nl ("Escolha a posicão de destino: ");
                                pos2 = MsgVetor.solicita_posicao();
                             
                                while ((pos2 < 0 || pos2 > vetorGx.getTamanho()) || (pos2 == pos1 && pos2 != 0))
                                {
                                    MsgVetor.msg_nl ("Posição inválida! Escolha a posicão de destino: ");
                                    pos2 = MsgVetor.solicita_posicao();
                                }
                                        
                                if (pos2 == 0)
                                {
                                    MsgVetor.msg_central ("Você desistiu da troca de lugar, retornando para o menu principal.");
                                }
                                else
                                {
                                    vetorGx.troca_de_Lugar(pos1, pos2);
                                }
                            }
                        }
                    }
                    MsgVetor.enter();
                    break;

                case 7:
                    MsgVetor.limpatela();

                    if (vetorGx.getTamanho() == 0)
                    {
                        MsgVetor.msg_central ("A lista está vazia, não há como trocar prioridade de elemento!");
                    }
                    else
                    {
                        if (vetorGx.getTamanho() == 1)
                        {
                            MsgVetor.msg_central ("A lista possui apenas um elemento, não há como trocar de prioridade!");
                        }
                        else
                        {
                            MsgVetor.msg_nl ("Escolha a posicão de origem: ");
                            pos1 = MsgVetor.solicita_posicao();
                            
                            while (pos1 < 0 || pos1 > vetorGx.getTamanho())
                            {
                                MsgVetor.msg_nl ("Posição de origem inválida, corrija: ");
                                pos1 = MsgVetor.solicita_posicao();
                            }
                            
                            if (pos1 == 0)
                            {
                                MsgVetor.msg_central ("Você desistiu da troca de prioridade, retornando para o menu principal.");
                            }
                            else
                            {
                                MsgVetor.msg_nl ("Escolha a posicão de destino: ");
                                pos2 = MsgVetor.solicita_posicao();
                             
                                while ((pos2 < 0 || pos2 > vetorGx.getTamanho()) || (pos2 == pos1 && pos2 != 0))
                                {
                                    MsgVetor.msg_nl ("Posição inválida! Escolha a posicão de destino: ");
                                    pos2 = MsgVetor.solicita_posicao();
                                }
                                        
                                if (pos2 == 0)
                                {
                                    MsgVetor.msg_central ("Você desistiu da troca de prioridade, retornando para o menu principal.");
                                }
                                else
                                {
                                    vetorGx.troca_de_Prioridade(pos1, pos2);
                                }
                            }
                        }
                    }
                    MsgVetor.enter();
                    break;

                case 8:
                    
                    qtd = MsgVetor.solicita_quantidade();
                    qtd = vetorGx.gera_Numeros(qtd);
                    MsgVetor.msg_central("Foram gerados ["+qtd+"] números.");
                    MsgVetor.enter();
                                        
                    break;
                
                case 9:
                    
                    if (vetorGx.getTamanho() == 0)
                    {
                        MsgVetor.msg_central ("Lista vazia!");
                    }
                    else
                    {
                        opc = MsgVetor.opcao_ordenacao();
                    
                        switch (opc)
                        {
                            case  1:
                                
                                vetorGx.ordena_BubbleSort();
                                break;
                                
                            case  2:
                                
                                vetorGx.ordena_SelectionSort();
                                break;

                            case  3:
                                
                                vetorGx.ordena_InsertionSort();
                                break;

                            case  4:
                                
                                vetorGx.ordena_MergeSort(vetorGx.getVetor(), 0, (vetorGx.getTamanho()-1));
                                System.out.println("Vetor organizado:");
                                if(0<1){
                                    int vetor[] = vetorGx.getVetor();
                                    for(int i = 0; i<(vetorGx.getTamanho()); i++){
                                        System.out.println(" "+vetor[i]);
                                    }
                                }
                                break;

                            case  5:
                                
                                vetorGx.ordena_ShellSort();
                                break;

                            case  6:
                                
                                vetorGx.ordena_MergeSort(vetorGx.getVetor(), 0, (vetorGx.getTamanho()-1));
                                System.out.println("Vetor organizado:");
                                if(0<1){
                                    int vetor[] = vetorGx.getVetor();
                                    for(int i = 0; i<(vetorGx.getTamanho()); i++){
                                        System.out.println(" "+vetor[i]);
                                    }
                                }
                                break;

                            case  7:
                                
                                vetorGx.ordena_HeapSort();
                                break;

                            case  8:
                                
                                vetorGx.ordena_DrecoSort();
                                break;

                            case  9:
                                
                                vetorGx.ordena_ProcessoX();
                                break;

                            case 10:
                                
                                vetorGx.ordena_ProcessoY();
                                break;
                        }
                    }
                    MsgVetor.enter();
                    break;

                case 10:
                    pos1 = MsgVetor.opcao_vetor("coluna 1");

                    if (pos1 == 0)
                    {
                        MsgVetor.msg_nl("Cancelando a listagem dupla...");
                    }
                    else
                    {
                        pos2 = MsgVetor.opcao_vetor("coluna 2");
                        
                        if (pos2 == 0)
                        {
                            MsgVetor.msg_nl("Cancelando a listagem dupla...");
                        }
                        else
                        {
                            while (pos1 == pos2)
                            {
                                MsgVetor.msg_nl ("As listas não podem ser iguais, escolha outra: ");
                                pos2 = MsgVetor.opcao_vetor("coluna 2");
                            }

                            if (pos1 == 1)
                            {
                                if (pos2 == 2)
                                {
                                    listagem_Simultanea(vetorG1, vetorG2, 1, 2);
                                }
                                else
                                {
                                    listagem_Simultanea(vetorG1, vetorG3, 1, 3);
                                }
                            }
                            else
                            {
                                if (pos1 == 2)
                                {
                                    if (pos2 == 1)
                                    {
                                        listagem_Simultanea(vetorG2, vetorG1, 2, 1);
                                    }
                                    else
                                    {
                                        listagem_Simultanea(vetorG2, vetorG3, 2, 3);
                                    }
                                }
                                else
                                {
                                    if (pos2 == 1)
                                    {
                                        listagem_Simultanea(vetorG3, vetorG1, 3, 1);
                                    }
                                    else
                                    {
                                        listagem_Simultanea(vetorG3, vetorG2, 3, 2);
                                    }
                                }
                            }
                        }
                    }
                    MsgVetor.enter();
                    break;

                case 11:
                    pos1 = MsgVetor.opcao_vetor("*** DESTINO ***");
                    
                    if (pos1 == 0)
                    {
                        MsgVetor.msg_nl("Cancelando a cópia...");
                    }
                    else
                    {
                        pos2 = MsgVetor.opcao_vetor("*** ORIGEM ***");
                        
                        if(pos2 == 0)
                        {
                            MsgVetor.msg_nl("Cancelando a cópia...");
                        }
                        else
                        {
                            while (pos1 == pos2)
                            {
                                MsgVetor.msg_nl ("As listas não podem ser iguais, escolha outra: ");
                                pos2 = MsgVetor.opcao_vetor("origem");
                            }

                            if (pos1 == 1)
                            {
                                if (pos2 == 2)
                                {
                                    MsgVetor.msg_central ("Copiando lista2 para a lista1.");
                                    vetorG1 = vetorG2;
                                }
                                else
                                {
                                    MsgVetor.msg_central ("Copiando lista3 para a lista1.");
                                    vetorG1 = vetorG3;
                                }
                            }
                            else
                            {
                                if (pos1 == 2)
                                {
                                    if (pos2 == 1)
                                    {
                                        MsgVetor.msg_central ("Copiando lista1 para a lista2.");
                                        vetorG2 = vetorG1;
                                    }
                                    else
                                    {
                                        MsgVetor.msg_central ("Copiando lista3 para a lista1.");
                                        vetorG2 = vetorG3;
                                    }
                                }
                                else
                                {
                                    if (pos2 == 1)
                                    {
                                        MsgVetor.msg_central ("Copiando lista1 para a lista3.");
                                        vetorG3 = vetorG1;
                                    }
                                    else
                                    {
                                        MsgVetor.msg_central ("Copiando lista2 para a lista3.");
                                        vetorG3 = vetorG2;
                                    }
                                }
                            }
                        }
                    }
                    MsgVetor.enter();
                    break;
                    
                case 0:
                    
                    break;

                default:
                    MsgVetor.limpatela();
                    MsgVetor.msg_central ("Opção inválida, retornando...");
                    MsgVetor.enter();
            }

            switch (qual_vetor)
            {
                case 1:
                {
                    vetorG1 = vetorGx;
                    break;
                }   
                case 2:
                {
                    vetorG2 = vetorGx;
                    break;
                }   
                case 3:
                {
                    vetorG3 = vetorGx;
                    break;
                }   
            }

            opc = MsgVetor.opcao_principal();
        }

        MsgVetor.limpatela();

        if (vetorG1.getTamanho() == 0)
        {
            MsgVetor.msg_central ("Lista 1 vazia - não haverá gravação de arquivo.");
        }
        else
        {
            MsgVetor.msg_central ("Atenção! Verificando gravação da lista 1,");

            if (vetorG1.getTamanho() == 0)
            {
               MsgVetor.msg_central (">>> O programa encerrou com a lista vazia!");
            }
            else
            {
                MsgVetor.msg_central ("Antes de encerrar, mostraremos a lista 1 atual.");
                vetorG1.consultar_geral();
                vetorG1.xarq_salvar_arquivo("Lista 1");
            }
        }

        MsgVetor.enter();
        MsgVetor.limpatela();

        if (vetorG2.getTamanho() == 0)
        {
            MsgVetor.msg_central ("Lista 2 vazia - não haverá gravação de arquivo.");
        }
        else
        {
            MsgVetor.msg_central ("Atenção! Verificando gravação da lista 2.");

            if (vetorG2.getTamanho() == 0)
            {
               MsgVetor.msg_central (">>> O programa encerrou com a lista vazia!");
            }
            else
            {
                MsgVetor.msg_central ("Antes de encerrar, mostraremos a lista 2 atual.");
                vetorG2.consultar_geral();
                vetorG2.xarq_salvar_arquivo("Lista 2");
            }
        }

        MsgVetor.enter();
        MsgVetor.limpatela();

        if (vetorG1.getTamanho() == 0)
        {
            MsgVetor.msg_central ("Lista 3 vazia - não haverá gravação de arquivo.");
        }
        else
        {
            MsgVetor.msg_central ("Atenção! Verificando gravação da lista 3.");

            if (vetorG3.getTamanho() == 0)
            {
               MsgVetor.msg_central (">>> O programa encerrou com a lista vazia!");
            }
            else
            {
                MsgVetor.msg_central ("Antes de encerrar, mostraremos a lista 3 atual.");
                vetorG3.consultar_geral();
                vetorG3.xarq_salvar_arquivo("Lista 3");
            }
        }

        MsgVetor.enter();
    }
}
