/* Projeto...: Oredenação
 * Autor.....: Professor Dreco
 * Biblioteca: Vetor de até 1.000.000 posições
 * Classe....: Vetor_Geral
 * Objetivo..: Criação do nó (elemento) que será utilizado nos projetos
 */
package vetorgeral;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VetorGeral
{
    private int vetor[] = new int[1000000];
    
    private int tamanho = 1000000;
    
    private int limite  = 1000000; 
    
    public int[] getVetor(){
        return this.vetor;
    }
    public void setPosicao (Integer pos, Integer valor)
    {
        vetor[pos] = valor;
    }

    public Integer getPosicao(Integer pos)
    {
        return vetor[pos];
    }
    
    public void setTamanho (Integer tam)
    {
        tamanho = tam;
    }

    public Integer getTamanho()
    {
        return tamanho;
    }
    
    public void setLimite (Integer lim)
    {
        limite = lim;
    }

    public Integer getLimite()
    {
        return limite;
    }

    public void mostra_Vetor (int limite)
    {
        int i = 0;
        String limite_texto = "   1000";
        
        switch (limite)
        {
            case 10000:
                limite_texto = "  10000";
            case 100000:
                limite_texto = " 100000";
            case 1000000:
                limite_texto = "1000000";
        }

        System.out.println("+---------+------------------+");
        System.out.println("| Vetor de "+limite_texto+" posições  |");
        System.out.println("+---------+------------------+");
        System.out.println("| Posicao | Valor            |");
        System.out.println("+---------+------------------+");
        
        for (i = 0; i < limite; i++)
        {
            System.out.format ("| %7d | %16d |\n", i, vetor[i]);
        }
        System.out.println("+---------+------------------+");
    }

    public void inicializarVetor()
    {
        int t = this.tamanho;
        int i = 0;
        
        for (i = 0; i <= t; i++)
        {
            this.vetor[i] = 0;
        }
    }

    public void troca_de_Lugar(int o, int d)
    {
        int temp = this.vetor[d];
        this.vetor[d] = this.vetor[o];
        this.vetor[o] = temp;
    }

    public void troca_de_Prioridade(int o, int d)
    {
        int temp = this.vetor[o];
        int i = 0;
        
        if (o < d)
        {
            for (i = o; i < d; i++)
            {
                this.vetor[i] = this.vetor[i+1];
            }
        }
        else
        {
            for (i = o; i > d; i--)
            {
                this.vetor[i] = this.vetor[i-1];
            }
        }
        this.vetor[d] = temp;
    }

    public Integer gera_Numeros (Integer quantidade)
    {
        MsgVetor.msg_central ("Iniciando a geração de números aleatórios para a lista.");
        
        int numero = 0;
        int gerados = 0;
        
        if (quantidade <= 0)
        {
            quantidade = 1000;
        }
        else
        {
            quantidade++;
        }
        
        Random r = new Random();
        
        for (gerados = 1; gerados < quantidade; gerados++)
        {
            numero = r.nextInt();
            
            this.vetor[gerados-1] = numero;
        }
        
        gerados--;
        
        this.setTamanho(gerados);
        this.setLimite(gerados);
        
        this.consultar_geral();
        
        return gerados;
    }

    public void ordena_BubbleSort()
    {
        int aux = 0;
        int i = 0;
        MsgVetor.msg_central ("Ordenação por BubbleSort");
        for(i = 0; i<this.getTamanho(); i++){
            for(int j = 0; j<(this.getTamanho()-1); j++){
                if(this.vetor[j] > this.vetor[j + 1]){
                    aux = this.vetor[j];
                    this.vetor[j] = this.vetor[j+1];
                    this.vetor[j+1] = aux;
                }
            }
        }
        System.out.println("Vetor organizado:");
    
        for(i = 0; i<(this.getTamanho()); i++){
            System.out.println(" "+this.vetor[i]);
        }
    }

    public void ordena_SelectionSort()
    {
        int i = 0;
        MsgVetor.msg_central ("Ordenação por Selection");
        for ( i = 0; i < (this.getTamanho() - 1); i++){  
            int index = i;  
            for (int j = i + 1; j < this.getTamanho(); j++){  
                if (this.vetor[j] < this.vetor[index]){  
                    index = j;
                }  
            }  
            int smallerNumber = this.vetor[index];   
            this.vetor[index] = this.vetor[i];  
            this.vetor[i] = smallerNumber;  
        }
        System.out.println("Vetor organizado:");
    
        for(i = 0; i<(this.getTamanho()); i++){
            System.out.println(" "+this.vetor[i]);
        }
    } 

    public void ordena_InsertionSort()
    {
        int i = 0;
        MsgVetor.msg_central ("Ordenação InsertionSort");
        for(i=0;i<this.getTamanho();++i){

        int j = i;
        
            while(j > 0 && this.vetor[j-1]>this.vetor[j]){

                int key = this.vetor[j];
                this.vetor[j] = this.vetor[j-1];
                this.vetor[j-1] = key;
                j = j-1;

            }
        }
        System.out.println("Vetor organizado:");
    
        for(i = 0; i<(this.getTamanho()); i++){
            System.out.println(" "+this.vetor[i]);
        }
    } 
    
    void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m;
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++;
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    void ordena_Merge(int arr[], int l, int r)
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            ordena_Merge(arr, l, m); 
            ordena_Merge(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    }
    
    public void ordena_MergeSort(int arr[], int l, int r)
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            ordena_Merge(arr, l, m); 
            ordena_Merge(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 

    public void ordena_ShellSort()
    {
        MsgVetor.msg_central ("Ordenação ShellSort.");
        int h = 1;
        int n = this.getTamanho();
    
        while(h < n) {
            h = h * 3 + 1;
        }
    
        h = h / 3;
        int c, j;
    
        while (h > 0) {
            for (int i = h; i < n; i++) {
                c = this.vetor[i];
                j = i;
                while (j >= h && this.vetor[j - h] > c) {
                    this.vetor[j] = this.vetor[j - h];
                    j = j - h;
                }
                this.vetor[j] = c;
            }
            h = h / 2;
        }
        System.out.println("Vetor organizado:");
        int i = 0;
        for(i = 0; i<(this.getTamanho()); i++){
            System.out.println(" "+this.vetor[i]);
        }
    } 
    
    int partition(int vetor[], int low, int high){ 
        int pivot = this.vetor[high];  
        int i = (low-1);
        for (int j=low; j<high; j++) 
        { 
            if (this.vetor[j] < pivot) 
            { 
                i++; 
  
                int temp = this.vetor[i]; 
                this.vetor[i] = this.vetor[j]; 
                this.vetor[j] = temp; 
            } 
        } 
   
        int temp = this.vetor[i+1]; 
        this.vetor[i+1] = this.vetor[high]; 
        this.vetor[high] = temp; 
  
        return i+1; 
        }
    void sort(int vetor[], int low, int high){
        if (low < high){ 
           
            int pi = partition(this.vetor, low, high); 
  
            sort(this.vetor, low, pi-1); 
            sort(this.vetor, pi+1, high); 
        }
    }
    public void ordena_QuickSort(int vetor[], int low, int high)
    {
        MsgVetor.msg_central ("Ordenação QuickSort.");
        if (low < high){ 
           
            int pi = partition(this.vetor, low, high); 
  
            sort(this.vetor, low, pi-1); 
            sort(this.vetor, pi+1, high); 
        }
    } 

    public void ordena_HeapSort()
    {
         MsgVetor.msg_central ("HeapSort - Aguarde implantação.");
    } 

    public void ordena_DrecoSort()
    {
         MsgVetor.msg_central ("DrecoSort - Aguarde implantação.");
         
         int menor = 0;
         int pos_menor = 0;
         int pivo = 0;
         
         for(pivo = 0;pivo < 9;pivo++)
         {
             for(menor = this.vetor[pivo];pos_menor < 9;pos_menor++)
             {
                 if(this.vetor[pos_menor] < menor)
                 {
                     menor = this.vetor[pos_menor];
                 }
             }
             this.troca_de_Lugar(pivo, pos_menor);
             pos_menor = pivo+1;
         }
    } 

    public void ordena_ProcessoX()
    {
        
        int xtamanho = this.tamanho - 1;
        int troca = 0;

        do
        {
            troca = 0;
  
            for(int i = 0; i < xtamanho; i++ )
            {
                if(vetor[i] > vetor[i+1])
                {
                    this.troca_de_Lugar(i, i+1);
                    troca++;
                }
            }   
        } while (troca!=0);
         
    }

    public void ordena_ProcessoY()
    {
         MsgVetor.msg_central ("Processo Y - Aguarde implantação.");
    } 
    
    // Objetivo: carregar/salvar dados em arquivos
    
    public String xarq_escolhe_nome_arquivo (String texto)
    {
        Scanner s = new Scanner(System.in);
        String dados = " ";

        do
        {
            MsgVetor.limpatela();

            try
            {
                MsgVetor.msg_nl ("Digite o nome do arquivo para carga da ["+texto+"] ou x para não dar carga - não pode ser vazio: ");
                dados = s.nextLine();
            }
            catch(Exception e)
            {
                MsgVetor.msg_nl ("Erro de digitação, não deixe a informação vazia:");
            }
        } while (dados.isEmpty());

        return dados;
    }
    
    public int xarq_tamanho_arquivo(String nome_arquivo)
    {
        //
        // Esta função lê o arquivo de dados e conta quantos registros ele possui.
        // A quantidade de registros é retornada e poderá ser utilizada como argumento
        // na criação do vetor de trabalho
        //
        int tamanho = 0;
        boolean prossegue = true;

        FileInputStream stream = null;

        try
        {
            stream = new FileInputStream(nome_arquivo);
            
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line = null;
            MsgVetor.msg_central ("Arquivo aberto!");
            //
            // Levantamento do tamanho do arquivo em termos de linhas
            //
            try
            {
                while ((line = reader.readLine()) != null)
                {
                    tamanho++;
                }

                try
                {
                    reader.close();
                }
                catch (IOException ioe)
                {
                    MsgVetor.msg_central ("Erro no fechamento do arquivo de leitura!");
                }

                try
                {
                    streamReader.close();
                }
                catch (IOException ioe)
                {
                    MsgVetor.msg_central ("Erro no fechamento do arquivo de stream reader!");
                }

                try
                {
                    stream.close();
                }
                catch (IOException ioe)
                {
                    MsgVetor.msg_central ("Erro no fechamento do arquivo stream!");
                }
            }
            catch (IOException ioe)
            {
                prossegue = false;
                MsgVetor.msg_central ("Arquivo com problemas na leitura!");
            }
        }
        catch (FileNotFoundException fe)
        {
            MsgVetor.msg_central ("Arquivo não encontrado!");
            prossegue = false;
        }

        return tamanho;
    }

    public int xarq_abre_arquivo (String texto)
    {
        //
        // Esta função lê o arquivo de dados e cria um vetor cujo tamanho é a
        // quantidade de registros do arquivo. O vetor, após ser populado, é devolvido
        // como resposta para o processo chamador.
        //
        MsgVetor.msg_central ("Preparação do arquivo de entrada para carga da ["+texto+"]");

        String nome_arquivo = this.xarq_escolhe_nome_arquivo(texto);

        int tv = 0;

        if (nome_arquivo.equals("x"))
        {
            MsgVetor.msg_central ("Não será utilizado arquivo para entrada de dados para a ["+texto+"].");
        }
        else
        {
            tv = this.xarq_tamanho_arquivo(nome_arquivo);

            if (tv != 0)
            {
                int i = 0;

                boolean prossegue = true;

                if (prossegue)
                {
                    MsgVetor.msg_central ("Gravando dados na ["+texto+"]......");

                    try
                    {
                        FileInputStream stream = null;
                        InputStreamReader streamReader;
                        BufferedReader reader;
                        String line = null;
                        stream = new FileInputStream(nome_arquivo);
                        streamReader = new InputStreamReader(stream);
                        reader = new BufferedReader(streamReader);
                        line = null;
                        ArrayList<String> linha = new ArrayList<String>();

                        if (prossegue)
                        {
                            try
                            {
                                while ((line = reader.readLine()) != null)
                                {
                                    String[] elemento = line.split(";");

                                    MsgVetor.msg_central ("...Carregando Número: ["+line+"] ["+elemento[0]+"]");

                                    this.setPosicao(i, Integer.valueOf(elemento[0]));

                                    i++;
                                }
                            }
                            catch (IOException ioe)
                            {
                                prossegue = false;
                                MsgVetor.msg_central ("Arquivo com problemas na leitura!");
                            }

                            try
                            {
                                reader.close();
                            }
                            catch (IOException ioe)
                            {
                                MsgVetor.msg_central ("Erro no fechamento do arquivo de leitura!");
                            }

                            try
                            {
                                streamReader.close();
                            }
                            catch (IOException ioe)
                            {
                                MsgVetor.msg_central ("Erro no fechamentdo do arquivo de stream reader!");
                            }

                            try
                            {
                                stream.close();
                            }
                            catch (IOException ioe)
                            {
                                MsgVetor.msg_central ("Erro no fechamento do arquivo stream!");
                            }
                        }
                        else
                        {
                            tv = 0;
                        }
                    }
                    catch (FileNotFoundException fe)
                    {
                        prossegue = false;
                        MsgVetor.msg_central ("Arquivo não encontrado!");
                    }
                }

                MsgVetor.msg_central ("Tamanho do arquivo utilizado para a ["+texto+"]: ["+(i+1)+"] linhas!");
            }
        }
        MsgVetor.enter();
        
        return tv;
    }

    public void xarq_salvar_arquivo (String texto)
    {
        //
        // Esta função recebe um vetor populado e, para cada posição (coluna), grava
        // um registro no arquivo de resposta, cujo nome é informado na função.
        //
        MsgVetor.msg_central ("Gravando arquivo de saída da ["+texto+"]");

        String nome_arquivo = this.xarq_escolhe_nome_arquivo(texto);

        int t = nome_arquivo.length();
        
        if ((nome_arquivo.contains("x")) && (t == 1))
        {
            MsgVetor.msg_central ("Não será utilizado arquivo para gravação de dados da ["+texto+"].");
        }
        else
        {
            FileWriter fileWriter = null;

            try
            {
                fileWriter = new FileWriter(nome_arquivo);
            }
            catch (IOException ex)
            {
                MsgVetor.msg_central ("Erro na gravação!");
            }

            PrintWriter writer = new PrintWriter(fileWriter);

            int i = 0;

            do
            {
                writer.write(this.getPosicao(i)+"\n");
                i++;
            }
            while (i < this.limite);

            writer.close();

            try
            {
                fileWriter.close();
                MsgVetor.msg_central ("Arquivo gravado da ["+texto+"] com ["+this.limite+"] linhas!");
            }
            catch (IOException ex)
            {
                MsgVetor.msg_central ("Erro no fechamento do arquivo!");
            }
        }
    }
    
    void consultar_geral()
    {
        System.out.println();
        System.out.println("+--------------------------+");
        System.out.format ("| Limite do Vetor: %7d |\n", this.limite);
        System.out.println("+---------+----------------+");
        System.out.println("| Posicao |         Número |");
        System.out.println("+---------+----------------+");
            
        for (int posicao = 0; posicao < this.limite; posicao++)
        {
            System.out.format ("| %7d | %14d |\n", posicao, this.vetor[posicao]);
        }    

        System.out.println("+---------+----------------+");
        MsgVetor.enter();
    }
    
    void consultar_posicao(int posicao)
    {
        System.out.println();
        System.out.println("+--------------------------+");
        System.out.format ("| Limite do Vetor: %7d |", this.limite);
        System.out.println("+---------+----------------+");
        System.out.println("| Posicao |         Número |");
        System.out.println("+---------+----------------+");
        System.out.format ("| %7d | %14d |", posicao, this.vetor[posicao]);
        System.out.println("+---------+----------------+");
    }
    
    void consultar_conteudo(int conteudo)
    {
        int posicao = 0;
        
        System.out.println();
        System.out.println("+--------------------------+");
        System.out.format ("| Limite do Vetor: %7d |", this.limite);
        System.out.println("+---------+----------------+");
        System.out.println("| Posicao |         Número |");
        System.out.println("+---------+----------------+");
        
        for (posicao = 0; (posicao < this.limite) && (this.vetor[posicao] != conteudo); posicao++)
        {
        }
        
        if (posicao != this.limite)
        {
            System.out.format ("| %7d | %14d |", posicao, this.vetor[posicao]);
        }
        else
        {
            System.out.println("| Conteúdo não existente.  |");
        }
        System.out.println("+---------+----------------+");
    }

    public VetorGeral()
    {
        int i = 0;
        
        for (i = 0; i < 1000000; i++)
        {
            vetor[i] = 0;
        }
        
        tamanho = 0;
        limite  = 0;        
    }
}