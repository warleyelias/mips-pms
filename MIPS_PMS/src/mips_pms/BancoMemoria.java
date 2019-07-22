
/*Copyright 2010 Warley Elias
 * Software distribuido sobre os termos da Licenla Publica Geral GNU
 *
 *
 * Este arquivo é parte do programa Foobar



    Foobar é um software livre; você pode redistribui-lo e/ou

    modifica-lo dentro dos termos da Licença Pública Geral GNU como

    publicada pela Fundação do Software Livre (FSF); na versão 2 da

    Licença, ou (na sua opnião) qualquer versão.



    Este programa é distribuido na esperança que possa ser  util,

    mas SEM NENHUMA GARANTIA; sem uma garantia implicita de ADEQUAÇÂO a qualquer

    MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a

    Licença Pública Geral GNU para maiores detalhes.



    Você deve ter recebido uma cópia da Licença Pública Geral GNU

    junto com este programa, se não, escreva para a Fundação do Software

    Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 *
 *
 * Sobre.java
 *
 * Created on 10/06/2010, 04:02:34
 */

package mips_pms;

import javax.swing.JOptionPane;

/** Classe referente ao Banco de Registradores e a Memoria
 *
 * @author Warley Jacinto Elias
 * Esta classe contem todos os registradores do banco de registradores,
 * contem também todas as posições da mémoria, e registradores de estado.
 * Além disso essa classe trata todas as entradas e saídas do banco de
 * registradores e da memória, tanto na área de dados, quanto na área
 * de instruções.
 */
public class BancoMemoria {
    static BancoMemoria instancia; /*!< instacia é uma variavel da classe
     BancoMemoria utilizada para que a classe não possua mais de uma instacia*/

    Interface layout; /*!<layout é uma variavel da classe Interface onde é
     utilizada para receber um instacia da classe Interface*/

    private int banco []; /*!< banco é um vetor de inteiro, onde cada posição
     refere-se a um registrador. Esta variavel faz um representação do banco
     de registradores existentes em processadores.*/

    private String memoria1 [];/*!<memoria1 é um vetor de String, onde cada
     posição refere-se a uma posição de memoria de instrução, esta variavel
     é utilizada juntamente com a variavel memoria2 que possui as posições da
     memoria de dados.*/

    private int memoria2 []; /*!<memoria2 é um vetor de ineteiros utilizado
     como referencia para as posições da memoria de dados. Trabalhando em
     conjunto com a variavel memoria1 para o usuario final essa separação não é
     vizualizada.*/

    private int PC; /*!<PC é uma variavel do tipo inteira que é utilizada para
     guardar o valor do contador de programa.*/

    private String RegMem; /*!<RegMem é um variavel do tipo String, utilizada
     como registrador de estado, onde para que a cada ciclo de clock a instrução
     lida na memoria e salva neste registrador para ser utilizada no proximo
     ciclo*/

    private int RegDado;/*!<RegDado é uma variavel do tipo int, utilizada como
     registrador de estado, onde é salvo o valor lido da memoria para que no
     proximo ciclo de clock este valor possa ser utilizado.*/

    private int RegA;/*!<RegA é uma variavel do tipo int, utilizada como
     registrador de estado, onde é salvo o valor lido do banco de registrador
     para ser utilizado no proximo ciclo de clock.*/

    private int RegB;/*!<RegB é uma variavel do tipo int, utilizada como
     registrador de estado, onde é salvo o valor lido do banco de registrador
     para ser utilizado no proximo ciclo de clock.*/

    private int RegULA;/*!<RegULA é uma variavel do tipo int, utilizada como
     registrador de estado, onde é salvo o valor calculado pela ULA (Unidade
     Logica e Aritimetica) para ser utilizado no proximo ciclo de clock.*/

    /** Construtor da Classe BancoMemoria
     Este Metodo inicializa as posições da variavel banco, zerando todas as 32
     posições deste vetor de inteiros, além disso este metodo inicializa também
     a variavel memoria1 e memoria2, colocando zero em todas as posições de
     de ambas variaveis, sobretudo na variavel memoria1 o zero colocado e na
     forma de string, ja que esta variavel e deste tipo. Este metodo zera também
     as variaveis PC, RegA, RegB, RegULA, RegDado e RegMem. A variavel layout
     e inicializada chamando o metodo getInstanciaInterface da classe Interface.
     *
     \não possui argumentos
     \não possui retorno

     */
    private BancoMemoria(){
        int x;
        banco = new int [32];
        for(x=0;x<32;x++){
            banco[x] = 0;
        }
        memoria1 = new String [50];
        memoria2 = new int [50];
        for(x=0;x<50;x++){
            memoria1[x] = "0";
        }
        for(x=0;x<50;x++){
            memoria2[x] = 0;
        }
        PC = 0;
        RegA = 0;
        RegB = 0;
        RegULA = 0;
        RegDado = 0;
        RegMem = "0";
        layout = Interface.getInstanciaInterface();
    }

    /** Cria ou retorna uma instacia da classe BancoMemoria
     Este metodo cria ou retorna uma instacia da classe BancoMemoria, se ja
     existir uma instacia a classe apenas retorna a que ja existe para garantir
     que o software possua apenas uma instacia dessa classe e que ela seja a
     mesma em todas as suas utilizações. Este metodo chama-se SingleTool.

     / nao possui argumentos
     / retorna um objeto da classe BancoMemoria
     */
    public static BancoMemoria getInstanciaBanco() {
		if (instancia == null){
			instancia = new BancoMemoria();
                }
		return instancia;
    }

    /** Retorna o valor da variavel PC

     /nao possui argumento
     /retorna o valor inteiro da variavel inteira PC
     */
    public int getPC(){
        return(PC);
    }

    /** Modifica o valor da variavel PC pelo valor recebido

     /recebe um valor inteiro
     /nao possui retorno
     */
    public void setPC(int valor){
        PC = valor;
    }

    /**Retorna o valor da variavel RegMem

     /nao possui argumento
     /retorna o valor do tipo String da variavel RegMem
     */
    public String getRegMem(){
        return(RegMem);
    }

    /** Modifica o valor da variavel RegMem pelo valor recebido

     /recebe uma String
     /nao possui retorno
     */
    public void setRegMem(String valor){
        RegMem = valor;
    }

    /** Retorna o valor da variavel RegDado

     /nao possui argumento
     /retorna o valor da variavel inteira RegDado
     */
    public int getRegDado(){
        return(RegDado);
    }

    /** Modifica o valor da variavel RegDado pelo valor recebido

     /recebe um valor inteiro
     /nao possui retorno
     */
    public void setRegDado(int valor){
        RegDado = valor;
    }

    /** Retorna o valor da variavel RegA

     /nao possui argumento
     /retorna o valor da variavel inteira RegA
     */
    public int getRegA(){
        return(RegA);
    }

    /** Modifica o valor da variavel RegA pelo valor recebido

     /recebe um valor inteiro
     /nao possui retorno
     */
    public void setRegA(int valor){
        RegA = valor;
    }

    /** Retorna o valor da variavel RegB

     /nao possui argumento
     /retorna o valor da variavel inteira RegB
     */
    public int getRegB(){
        return(RegB);
    }

    /** Modifica o valor da variavel RegB pelo valor recebido

     /recebe um valor inteiro
     /nao possui retorno
     */
    public void setRegB(int valor){
        RegB = valor;
    }

    /** Retorna o valor da variavel RegULA

     /nao possui argumento
     /retorna o valor da variavel inteira RegULA
     */
    public int getRegULA(){
        return(RegULA);
    }

    /** Modifica o valor da variavel RegULA pelo valor recebido

     /recebe um valor inteiro
     /nao possui retorno
     */
    public void setRegULA(int valor){
        RegULA = valor;
    }

    /** Retorna o valor de uma posicao da variavel banco

     /recebe um inteiro contendo a posição a ser retornada
     /retorna o valor inteiro da posicao escolhida da variavel banco
     */
    public int getBanco(int posicao){
        return(banco[posicao]);
    }

    /** Modifica o valor de uma posicao da variavel banco

     /recebe um inteiro contendo a posicao e um inteiro contendo o valor
     /retorna o valor iteiro da posicao desejada da variavel banco
     */
    public void setBanco(int posicao, int valor){
        banco[posicao] = valor;
    }

    /** Retorna o valor de uma posicao da variavel memoria1

     /recebe um inteiro contendo a posicao a ser acessada na variavel memoria1
     /retorna um valor do tipo String da posicao desejada da variavel memoria1
     */
    public String getMemoria1(int posicao){
        return(memoria1[posicao]);
    }

    /** Retorna o valor de uma posicao da variavel memoria2

     /recebe um inteiro contendo a posicao a ser acessada na variavel memoria2
     /retorna um valor do tipo inteiro da posicao desejada da variavel memoria2
     */
    public int getMemoria2(int posicao){
        posicao = posicao - 50;
        return(memoria2[posicao]);
    }

    /** Modifica o valor de uma determinada posicao da variavel memoria2

     /recebe um inteiro contendo a posicao e um inteiro com o valor
     /nao possui retorno
     */
    public void setMemoria2(int posicao, int valor){
        posicao = posicao / 4;
        if(posicao > 49 && posicao < 100){
            posicao = posicao - 50;
            memoria2[posicao] = valor;
        }
        else{
            JOptionPane.showMessageDialog(null,"Endereço de Memória Inválido","Memória",JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Modifica o valor de uma determinada posicao da variavel memoria1

     /recebe um inteiro contendo a posicao e uma String com o valor a ser modificado
     /nao possui retorno
     */
    public void setMemoria1(int posicao, String valor){
        memoria1[posicao] = valor;
    }

}
