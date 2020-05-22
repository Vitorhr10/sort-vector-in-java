/*
 * Projeto.: Ordenação em Vetores
 * Autor...: Professor Dreco
 * Classe..: Estatistica
 * Objetivo: Apuração quantitativa de dados sobre os processos de ordenação.
 */

package vetorgeral;

/**
 *
 * @author andrel.ded
 */
public class Estatistica
{
    long interacoes = 0;
    long condicoes = 0;
    long trocas = 0;
   
    long tExec = 0;

    public long tempoInicio ()
    {
        long tempoInicial = System.currentTimeMillis();
        return tempoInicial;
    }
    public long tempoFinal ()
    {
        long tempoFinal = System.currentTimeMillis();
        return tempoFinal;
    }
    public void mostrar(int elementos, long ti, long tf)
    {
        long dt = tf - ti;
        
        System.out.println();
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.println("|       Elementos |      Interações |       Condições |          Trocas |     Tempo inic  |     Tempo final |        Execução |");
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.format ("| %15d | %15d | %15d | %15d | %15d | %15d | %15d |",
                elementos, this.interacoes, this.condicoes, this.trocas, ti, tf, dt);
        System.out.println();
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
    }
}
