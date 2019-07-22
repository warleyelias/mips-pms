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
 * Created on 23/06/2010, 04:02:34
 */
package mips_pms;

import javax.swing.JOptionPane;

/** Classe que trata da execução das instruções do simulador. A classe contem
 * todas os metodos de cada instrução, que e utilizado para executar cada uma
 * das instruções.
 *
 * @author Warley Jacinto Elias
 */
public class Execucao extends Thread {
    BancoMemoria banco;/*!< Objeto da classe BancoMemoria, utilizada para
     acessar os metodos publicos da classe BancoMemoria*/
    Interface layout;/*!<Objeto da classe Interface, utilizada para acessar
     os metodos publicos da classe Interface*/
    boolean fimexecucao = false; /*!<Variavel do tipo booleana utiliza para
     realizar a verificação da finalização de uma execução de cosigo assembler*/

    /**Contrutor da classe
     Este metodo inicializa o objeto banco pedindo uma instacia a classe deste
     objeto. O objeto layout tambem e inicializado por este metodo pedindo uma
     instancia para sua classe.

     /nao possui argumentos
     /nao possui retorno
     */
    public Execucao(){
        banco = BancoMemoria.getInstanciaBanco();
        layout = Interface.getInstanciaInterface();
    }

    @Override
    /** O metodo que comeca a execucao da classe chamando o primeiro metodo
     que deve ser executado

     /nao possui argumentos
     /nao possui retorno
     */
    public void run(){
        try {
            fimexecucao = Executa1();
            layout.setImagemUm();
        } catch (InterruptedException ex) {
            
        }

    }

    /** Retorna o valor da booleano da variavel fimexecucao

     /nao possui argumentos
     /retorna o valor booleano da variavel fimexecucao
     */
    public boolean getFimExecucao(){
        return(fimexecucao);
    }

    /** Modifica o valor da variavel fimexecucao

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setFimExecucao(boolean x){
        fimexecucao = x;
    }

    /**Faz o primeiro passo da execução das instruções assembler, o passo de
     busca da instrução.
     * Este metodo faz a busca da instrução na memoria e incrementa o valor de
     * PC

     /nao recebe argumento
     /retorna um valor booleano
     */
    public boolean Executa1() throws InterruptedException {
        int x,i,j;/*!<*/
        String b;
        String [] instrucao = layout.getAuxString().split("\n");
        for(x=0;x<layout.getContInstrucoes();x++){
            banco.setRegMem(instrucao[x]);
            banco.setPC(banco.getPC() + 4);
            b = Integer.toString(banco.getPC());
            layout.setRegistradorPC(b);
            layout.setRegistradorInstrucao(banco.getRegMem());
            layout.setImagemDois();
            Thread.sleep(layout.getTempo()*1000);
            Executa2();
            layout.setRegistradorULA("0");
            layout.setRegistradorA("0");
            layout.setRegistradorB("0");
            layout.setRegistradorDadosMemoria("0");
            layout.setRegistradorPC("0");
            layout.setRegistradorInstrucao("0");
        }
        JOptionPane.showMessageDialog(null,"Código Executado Com Sucesso!","Fim",JOptionPane.INFORMATION_MESSAGE);
        layout.setPlay(false);
        layout.setNext(false);
        layout.setCarregar(false);
        layout.setAcao(false);
        layout.setLoad(false);
        layout.setPausar(false);
        layout.setProximo(false);
        return(true);
    }

    /** Metodo que executa o segundo passo da execucao da instrução
     * Este metodo faz a decodificação da instrução definindo qual o proximo
     * passo a ser executado e quais sinais de controle serao utilizado

     /nao recebe argumentos
     /nao possui retorno
     */
    public void Executa2() throws InterruptedException{
        int temp1, temp2, temp3;
        String b;
        String [] instrucao = banco.getRegMem().split(" ");
        layout.setOpCode(instrucao[0]);
        layout.setDestino(instrucao[1]);
        temp3 = Integer.parseInt(layout.getDestino().substring(1, layout.getDestino().length()));
        layout.setImagemTres();
        if (layout.getOpCode().equalsIgnoreCase("ADD") || layout.getOpCode().equalsIgnoreCase("SUB") || layout.getOpCode().equalsIgnoreCase("XOR") || layout.getOpCode().equalsIgnoreCase("OR") || layout.getOpCode().equalsIgnoreCase("AND")){
            layout.setOp1(instrucao[2].substring(1, instrucao[2].length()));
            layout.setOp2(instrucao[3].substring(1, instrucao[2].length()));
            temp1 = Integer.parseInt(layout.getOp1());
            temp2 = Integer.parseInt(layout.getOp2());
            banco.setRegA(banco.getBanco(temp1));
            banco.setRegB(banco.getBanco(temp2));
            b = Integer.toString(banco.getRegA());
            layout.setRegistradorA(b);
            b = Integer.toString(banco.getRegB());
            layout.setRegistradorB(b);
            layout.setImagemTres();
            Thread.sleep(layout.getTempo()*1000);
            if(layout.getOpCode().equalsIgnoreCase("ADD")){
                ADD(temp1, temp2, temp3);
                return;
            }
            else{
                 if(layout.getOpCode().equalsIgnoreCase("SUB")){
                        SUB(temp1, temp2, temp3);
                        return;
                     }
                     else{
                         if(layout.getOpCode().equalsIgnoreCase("XOR")){
                                XOR(temp1, temp2, temp3);
                                return;
                             }
                             else{
                                 if(layout.getOpCode().equalsIgnoreCase("OR")){
                                        OR(temp1, temp2, temp3);
                                        return;
                                     }
                                     else{
                                          if(layout.getOpCode().equalsIgnoreCase("AND")){
                                                AND(temp1,temp2,temp3);
                                                return;
                                          }
                                    }
                            }
                    }
           }
        }
        else{
            if(layout.getOpCode().equalsIgnoreCase("ADDI") || layout.getOpCode().equalsIgnoreCase("SUBI")){
                layout.setOp1(instrucao[2].substring(1, instrucao[2].length()));
                temp1 = Integer.parseInt(layout.getOp1());
                layout.setOp2(instrucao[3]);
                temp2 = Integer.parseInt(layout.getOp2());
                banco.setRegA(banco.getBanco(temp1));
                b = Integer.toString(banco.getRegA());
                layout.setRegistradorA(b);
                Thread.sleep(layout.getTempo()*1000);
                if(layout.getOpCode().equalsIgnoreCase("ADDI")){
                    ADDI(temp1, temp2, temp3);
                    return;
                }
                else{
                    if(layout.getOpCode().equalsIgnoreCase("SUBI")){
                        SUBI(temp1, temp2, temp3);
                        return;
                    }
                }
            }
            else{
                if(layout.getOpCode().equalsIgnoreCase("LW") || layout.getOpCode().equalsIgnoreCase("SW")){
                            layout.setOp1(instrucao[4]);
                            layout.setOp2(instrucao[2]);
                            temp1 = Integer.parseInt(layout.getOp1().substring(1,layout.getOp1().length()));
                            temp2 = Integer.parseInt(layout.getOp2());
                            if(layout.getOpCode().equalsIgnoreCase("LW")){
                                banco.setRegB(banco.getBanco(temp3));
                                b = Integer.toString(banco.getRegB());
                                layout.setRegistradorB(b);
                                Thread.sleep(layout.getTempo()*1000);
                                LW(temp1, temp2, temp3);
                                return;
                            }
                            else{
                                if(layout.getOpCode().equalsIgnoreCase("SW")){
                                    Thread.sleep(layout.getTempo()*1000);
                                    SW(temp1, temp2, temp3);
                                    return;
                                }
                            }
                    }
            }
        }
    }
    /** Metodo que executa a instrucao sw
     * Este metodo realiza a execucao da instrucao sw, lendo o valor presente
     * no banco de registradores na posicao referida na instrucao e salvado na
     * posicao da memoria tambem referida na instrucao

     /recebe tres inteiros contendo a posicao de dois registradores a serem
     * lidos e um inteiro a ser utilizado para calcular o endereco alvo
     /nao possui retorno
     */
    public void SW(int temp1, int temp2, int temp3) throws InterruptedException{
        String b;
        banco.setRegULA(banco.getBanco(temp1) + temp2);
        b = Integer.toString(banco.getRegULA());
        layout.setRegistradorULA(b);
        layout.setImagemQuatro();
        banco.setRegB(banco.getBanco(temp3));
        Thread.sleep(layout.getTempo()*1000);
        banco.setMemoria2(banco.getRegULA(), banco.getRegB());
        layout.setMemoria();
        layout.setImagemSete();
        Thread.sleep(layout.getTempo()*1000);
    }
    /** Metodo que executa a instrucao lw
     * Este metodo realiza a execucao da instrucao lw, lendo o valor presente
     * na memoria na posicao referida na instrucao e salvado na posicao do banco
     * de registradores tambem referida na instrucao

     /recebe tres inteiros contendo a posicao de dois registradores a serem
     * lidos e um inteiro a ser utilizado para calcular o endereco alvo
     /nao possui retorno
     */
    public void LW(int temp1, int temp2, int temp3) throws InterruptedException{
        String b;
        banco.setRegULA(banco.getBanco(temp1) + temp2);
        b = Integer.toString(banco.getRegULA());
        layout.setRegistradorULA(b);
        layout.setImagemQuatro();
        Thread.sleep(layout.getTempo()*1000);
        banco.setRegDado(banco.getMemoria2(banco.getRegULA() / 4));
        b = Integer.toString(banco.getRegDado());
        layout.RegistradorMemoria(b);
        layout.setImagemSeis();
        Thread.sleep(layout.getTempo()*1000);
        banco.setBanco(temp3, banco.getRegDado());
        layout.setBancoLayout();
        layout.setImagemSete();
        Thread.sleep(layout.getTempo()*1000);
    }

    /** Metodo que executa a instrucao addi
     * Este metodo realiza a execucao da instrucao addi, lendo o valor presente
     * posicao referida e realizando o calculo com o imediato e salvando na
     * posicao descrita por um de seus argumetos tambem referida na instrucao

     /recebe tres inteiros contendo a posicao de dois registradores a serem
     * lidos e um inteiro a ser utilizado como imediato para os calculos
     /nao possui retorno
     */
    void ADDI(int temp1, int temp2, int temp3) throws InterruptedException{
        String b;
        banco.setRegULA(banco.getBanco(temp1) + temp2);
        b = Integer.toString(banco.getRegULA());
        layout.setRegistradorULA(b);
        layout.setImagemCincoAddi();
        Thread.sleep(layout.getTempo()*1000);
        banco.setBanco(temp3,banco.getRegULA());
        layout.setBancoLayout();
        layout.setImagemOito();
        Thread.sleep(layout.getTempo()*1000);
    }

    /** Metodo que executa a instrucao add
     * Este metodo realiza a execucao da instrucao add, lendo o valor presente
     * posicao referida na instrucao e salvado na posicao tambem referida na
     * instrucao

     /recebe tres inteiros contendo a posicao de dois registradores a serem
     * lidos e um inteiro a ser utilizado para calcular o endereco alvo
     /nao possui retorno
     */
    void ADD(int temp1, int temp2, int temp3) throws InterruptedException{
        String b;
        banco.setRegULA(banco.getBanco(temp1) + banco.getBanco(temp2));
        b = Integer.toString(banco.getRegULA());
        layout.setRegistradorULA(b);
        layout.setImagemCinco();
        Thread.sleep(layout.getTempo()*1000);
        banco.setBanco(temp3,banco.getRegULA());
        layout.setBancoLayout();
        layout.setImagemOito();
        Thread.sleep(layout.getTempo()*1000);
    }

    /** Metodo que executa a instrucao subi
     * Este metodo realiza a execucao da instrucao subi, lendo o valor presente
     * posicao do banco de registradores referida e realizando o calculo com o
     * imediato e salvando na posicao do banco de registradores descrita por um
     * de seus argumetos tambem referida na instrucao

     /recebe tres inteiros contendo a posicao de dois registradores a serem
     * lidos e um inteiro a ser utilizado como imediato para os calculos
     /nao possui retorno
     */
    void SUBI(int temp1, int temp2, int temp3) throws InterruptedException{
        String b;
        banco.setRegULA(banco.getBanco(temp1) - temp2);
        b = Integer.toString(banco.getRegULA());
        layout.setRegistradorULA(b);
        layout.setImagemCincoSubi();
        Thread.sleep(layout.getTempo()*1000);
        banco.setBanco(temp3,banco.getRegULA());
        layout.setBancoLayout();
        layout.setImagemOito();
        Thread.sleep(layout.getTempo()*1000);
    }
    /** Metodo que executa a instrucao and
     * Este metodo realiza a execucao da instrucao and, lendo o valor presente
     * posicao do banco de registrador referida na instrucao e salvado na
     * posicao do banco de registradores tambem referida na instrucao

     /recebe tres inteiros contendo a posicao do banco de registradores serem
     * lidos e a posicao do banco de registradores onde será gravado o valor
     * calculado
     /nao possui retorno
     */
    void AND(int temp1, int temp2, int temp3) throws InterruptedException{
        String b;
        banco.setRegULA(banco.getBanco(temp1) & banco.getBanco(temp2));
        b = Integer.toString(banco.getRegULA());
        layout.setRegistradorULA(b);
        layout.setImagemCincoAND();
        Thread.sleep(layout.getTempo()*1000);
        banco.setBanco(temp3,banco.getRegULA());
        layout.setBancoLayout();
        layout.setImagemOito();
        Thread.sleep(layout.getTempo()*1000);
    }

    /** Metodo que executa a instrucao or
     * Este metodo realiza a execucao da instrucao or, lendo o valor presente
     * posicao do banco de registrador referida na instrucao e salvado na
     * posicao do banco de registradores tambem referida na instrucao

     /recebe tres inteiros contendo a posicao do banco de registradores serem
     * lidos e a posicao do banco de registradores onde será gravado o valor
     * calculado
     /nao possui retorno
     */
    void OR(int temp1, int temp2, int temp3) throws InterruptedException{
        String b;
        banco.setRegULA(banco.getBanco(temp1) | banco.getBanco(temp2));
        b = Integer.toString(banco.getRegULA());
        layout.setRegistradorULA(b);
        layout.setImagemCincoAND();
        Thread.sleep(layout.getTempo()*1000);
        banco.setBanco(temp3,banco.getRegULA());
        layout.setBancoLayout();
        layout.setImagemOito();
        Thread.sleep(layout.getTempo()*1000);
    }

    /** Metodo que executa a instrucao xor
     * Este metodo realiza a execucao da instrucao xor, lendo o valor presente
     * posicao do banco de registrador referida na instrucao e salvado na
     * posicao do banco de registradores tambem referida na instrucao

     /recebe tres inteiros contendo a posicao do banco de registradores serem
     * lidos e a posicao do banco de registradores onde será gravado o valor
     * calculado
     /nao possui retorno
     */
    void XOR(int temp1, int temp2, int temp3) throws InterruptedException{
        String b;
        banco.setRegULA(banco.getBanco(temp1) ^ banco.getBanco(temp2));
        b = Integer.toString(banco.getRegULA());
        layout.setRegistradorULA(b);
        layout.setImagemCincoAND();
        Thread.sleep(layout.getTempo()*1000);
        banco.setBanco(temp3,banco.getRegULA());
        layout.setBancoLayout();
        layout.setImagemOito();
        Thread.sleep(layout.getTempo()*1000);
    }
    /** Metodo que executa a instrucao sub
     * Este metodo realiza a execucao da instrucao sub, lendo o valor presente
     * nas posicoes dos registradores referidas na instrucao e salvado na
     * posicao do registrador tambem referida na instrucao

     /recebe tres inteiros contendo a posicao de dois registradores a serem
     * lidos e de um registrador onde será salvo o valor o calculo
     /nao possui retorno
     */
    void SUB(int temp1, int temp2, int temp3) throws InterruptedException{
        String b;
        banco.setRegULA(banco.getBanco(temp1) - banco.getBanco(temp2));
        b = Integer.toString(banco.getRegULA());
        layout.setRegistradorULA(b);
        layout.setImagemCincoSub();
        Thread.sleep(layout.getTempo()*1000);
        banco.setBanco(temp3,banco.getRegULA());
        layout.setBancoLayout();
        layout.setImagemOito();
        Thread.sleep(layout.getTempo()*1000);
    }
}
