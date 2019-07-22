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
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Interface.java
 *
 * Created on 08/06/2010, 01:40:17
 */

package mips_pms;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Warley
 */
public class Interface extends javax.swing.JFrame{

    /** Creates new form Interface */
    public static Sobre about;/*!< variavel da classe Sobre utilizada para fazer
     a chama a janela about*/
    public String opCode;/*!< variavel utilizada para salvar o valor do opcode
     da instrucao*/
    private String destino;/*!< variavel utilizada para salvar o valor da
     operacao realizada*/
    private String op1;/*!< variavel utilizada para guardar o numero do
     registrador onde esta o primeiro operando*/
    private String op2;/*!< variavel utilizada para guardar o numero do
     registrador onde esta o segundo operando*/
    private boolean acao;/*!< variavel utilizada para verificar se o simulador
     ja esta sendo executado*/
    private boolean load;/*!< variavel utilizada para verificar se ja foi
     verificado a sintatica do condigo assembler*/
    public boolean pausar;/*!< variavel utilizada para verificar se a execucao
     esta pausada*/
    public static String aux;/*!< variavel utilizada como auxiliar*/
    public int cont;/*!< variavel utilizada para contar a quantidade de
     instrucoes lidas*/
    private String instrucoes;/*!< variavel utilizada para salvar as instrucoes
     para realizar a analise sintatica*/
    BancoMemoria banco; /*!< variavel que contem os registradores do banco
     de registradores*/
    private boolean proximo; /*!< variavel para verificar se o botao next foi
     pressionado*/
    public static Interface instancia;/*!< instancia da classe interface*/
    Execucao execucao; /*!< instancia da classe execucao*/
    private int tempo; /*!< variavel utilizada para salvar o valor do tempo
     de clico de clock*/
    private boolean stop;/*!< variavel utilizado para verificar se a execucao
     da simulacao parou*/
    private Interface() {
        initComponents();
        acao = false;
        about = new Sobre();
        about.setVisible(false);
        load = false;
        Play.setEnabled(false);
        Stop.setEnabled(false);
        //Next.setEnabled(false);
        proximo = false;
        pausar = false;
        jSpinner1.setValue(1);
    }
    public static Interface getInstanciaInterface(){
        if(instancia == null){
            instancia = new Interface();
        }
        return(instancia);
    }

    /** Retorna o valor da variavel tempo

     /nao possui argumento
     /retorna o valor inteiro da variavel inteira tempo
     */
    public int getTempo(){
        return(tempo);
    }

    /** Retorna o valor da variavel stop

     /nao possui argumento
     /retorna o valor booleano da variavel stop
     */
    public boolean getStop(){
        return(stop);
    }

    /** Modifica o valor da variavel stop pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setStop(boolean x){
        stop = x;
    }

    /** Modifica o valor da variavel Carregar pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setCarregar(boolean x){
        Carregar.setEnabled(x);
    }

    /** Modifica o valor da variavel Play pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setPlay(boolean x){
        Play.setEnabled(x);
    }

    /** Modifica o valor da variavel Next pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setNext(boolean x){
        //Next.setEnabled(x);
    }

    /** Retorna o valor da variavel aux

     /nao possui argumento
     /retorna o valor da variavel do tipo String aux
     */
    public String getAuxString(){
        return(aux);
    }

    /** Retorna o valor da variavel cont

     /nao possui argumento
     /retorna o valor inteiro da variavel inteira cont
     */
    public int getContInstrucoes(){
        return(cont);
    }

    /** Modifica o valor da variavel acao pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setAcao(boolean x){
        acao = x;
    }

    /** Modifica o valor da variavel load pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setLoad(boolean x){
        load = x;
    }

    /** Modifica o valor da variavel pausar pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setPausar(boolean x){
        pausar = x;
    }

    /** Modifica o valor da variavel proximo pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setProximo(boolean x){
        proximo = x;
    }

    /** Modifica o valor da RegistradorMemoria pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void RegistradorMemoria(String x){
        RegistradorMemoria.setText(x);
    }

    /** Retorna o valor da variavel pausar

     /nao possui argumento
     /retorna o valor boolenao inteiro da variavel pausar
     */
    public boolean getPausar(){
        return(pausar);
    }

    /** Modifica o valor da variavel opcode pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setOpCode(String x){
        opCode = x;
    }

    /** Retorna o valor da variavel opCode

     /nao possui argumento
     /retorna o valor da variavel do tipo String opCode
     */
    public String getOpCode(){
        return(opCode);
    }

    /** Modifica o valor da variavel op1 pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setOp1(String x){
        op1 = x;
    }

    /** Retorna o valor da variavel op1

     /nao possui argumento
     /retorna o valor da variavel do tipo String op1
     */
    public String getOp1(){
        return(op1);
    }

    /** Modifica o valor da variavel op2 pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setOp2(String x){
        op2 = x;
    }

    /** Retorna o valor da variavel op2

     /nao possui argumento
     /retorna o valor da variavel do tipo String op2
     */
    public String getOp2(){
        return(op2);
    }

    /** Modifica o valor da variavel destino pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setDestino(String x){
        destino = x;
    }

    /** Retorna o valor da variavel destino

     /nao possui argumento
     /retorna o valor variavel do tipo String destino
     */
    public String getDestino(){
        return(destino);
    }

    /** Retorna o valor da variavel proximo

     /nao possui argumento
     /retorna o valor booleano da variavel proximo
     */
    public boolean getProximo(){
        return(proximo);
    }

    /** Modifica o valor da variavel RegistradorULA pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setRegistradorULA(String Reg){
        RegistradorULA.setText(Reg);
    }

    /** Modifica o valor da variavel RegistradorPC pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setRegistradorPC(String Reg){
        RegistradorPC.setText(Reg);
    }

    /** Modifica o valor da variavel RegistradorInstrucao pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setRegistradorInstrucao(String Reg){
        RegistradorInstrucao.setText(Reg);
    }

    /** Modifica o valor da variavel RegistradorA pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setRegistradorA(String x){
        RegistradorA.setText(x);
    }

    /** Modifica o valor da variavel RegistradorB pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setRegistradorB(String x){
        RegistradorB.setText(x);
    }

    /** Modifica o valor da variavel RegistradorMemoria pelo valor recebido

     /recebe um valor booleano
     /nao possui retorno
     */
    public void setRegistradorDadosMemoria(String x){
        RegistradorMemoria.setText(x);
    }

    /** Retorna o valor da variavel acao

     /nao possui argumento
     /retorna o valor booleano da variavel acao
     */
    public boolean getAcao(){
        return(acao);
    }
    /** Atualiza o layout

     /nao recebe argumentos
     /nao possui retorno
     */
    public void setImagemLayout(){
        //jPanel3.getParent().update(jPanel3.getParent().getGraphics());
        jPanel3.update(jPanel3.getGraphics());
        //jPanel1.update(jPanel1.getGraphics());
        //jPanel2.update(jPanel2.getGraphics());
        //jPanel4.update(jPanel4.getGraphics());
    }

    /** Modifica a imagem da variavel Imagem pela imagem 1

     /nao recebe argumento
     /nao possui retorno
     */
    public void setImagemUm(){
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1.jpg")));
        setImagemLayout();
    }

    /** Modifica a imagem da variavel Imagem pela imagem 2

     /nao recebe argumento
     /nao possui retorno
     */
    public void setImagemDois(){
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/2.jpg")));
        setImagemLayout();
    }

    /** Modifica a imagem da variavel Imagem pela imagem 3

     /nao recebe argumento
     /nao possui retorno
     */
    public void setImagemTres(){
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/3.jpg")));
        setImagemLayout();
    }

    /** Modifica a imagem da variavel Imagem pela imagem 4

     /nao recebe argumento
     /nao possui retorno
     */
    public void setImagemQuatro(){
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/4.jpg")));
        setImagemLayout();
    }

    /** Modifica a imagem da variavel Imagem pela imagem 5

     /nao recebe argumento
     /nao possui retorno
     */
    public void setImagemCinco(){
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/5.jpg")));
        setImagemLayout();
    }

    /** Modifica a imagem da variavel Imagem pela imagem 5(AND)2

     /nao recebe argumento
     /nao possui retorno
     */
    public void setImagemCincoAND2(){
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/5(AND)2.jpg")));
        setImagemLayout();
    }

    /** Modifica a imagem da variavel Imagem pela imagem 5(AND)

     /nao recebe argumento
     /nao possui retorno
     */
    public void setImagemCincoAND(){
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/5(AND).jpg")));
        setImagemLayout();
    }

    /** Modifica a imagem da variavel Imagem pela imagem 5(Sub)

     /nao recebe argumento
     /nao possui retorno
     */
    public void setImagemCincoSub(){
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/5(Sub).jpg")));
        setImagemLayout();
    }

    /** Modifica a imagem da variavel Imagem pela imagem 5(Subi)

     /nao recebe argumento
     /nao possui retorno
     */
    public void setImagemCincoSubi(){
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/5(Subi).jpg")));
        setImagemLayout();
    }

    /** Modifica a imagem da variavel Imagem pela imagem 5(addi)

     /nao recebe argumento
     /nao possui retorno
     */
    public void setImagemCincoAddi(){
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/5(addi).jpg")));
        setImagemLayout();
    }

    /** Modifica a imagem da variavel Imagem pela imagem 6

     /nao recebe argumento
     /nao possui retorno
     */
    public void setImagemSeis(){
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/6.jpg")));
        setImagemLayout();
    }

    /** Modifica a imagem da variavel Imagem pela imagem 7

     /nao recebe argumento
     /nao possui retorno
     */
    public void setImagemSete(){
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/7.jpg")));
        setImagemLayout();
    }

    /** Modifica a imagem da variavel Imagem pela imagem 8

     /nao recebe argumento
     /nao possui retorno
     */
    public void setImagemOito(){
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/8.jpg")));
        setImagemLayout();
    }

    /** Modifica a imagem da variavel Imagem pela imagem 9

     /nao recebe argumento
     /nao possui retorno
     */
    public void setImagemNove(){
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/9.jpg")));
        setImagemLayout();
    }

    /** Zera valores
     * Este metodo zera os valos do banco de registradores, da memoria, tanto de
     * dados quanto de instrucao, e os registradores temporarios.

     /nao possui argumento
     /nao possui retorn
     */
    void ZeraBancoMemoriaRegistradoresTemporario(){
        int x;
        String b;
        for(x=0;x<32;x++){
            banco.setBanco(x,0);
        }
        for(x=0;x<50;x++){
            banco.setMemoria1(x, "0");
        }
        for(x=50;x<100;x++){
            banco.setMemoria2(x*4, 0);
        }
        setMemoria();
        setBancoLayout();
        banco.setPC(0);
        b = Integer.toString(banco.getPC());
        RegistradorPC.setText(b);
        banco.setRegA(0);
        b = Integer.toString(banco.getRegA());
        RegistradorA.setText(b);
        banco.setRegB(0);
        b = Integer.toString(banco.getRegB());
        RegistradorB.setText(b);
        banco.setRegULA(0);
        b = Integer.toString(banco.getRegULA());
        RegistradorULA.setText(b);
        banco.setRegDado(0);
        b = Integer.toString(banco.getRegDado());
        RegistradorMemoria.setText(b);
        banco.setRegMem("0");
        RegistradorInstrucao.setText(banco.getRegMem());
    }

    /** Atualiza Banco de Registradores
     * Este merodo atualiza os valores da painel que contem os valores do banco
     * de registradores, este painel fica presente no layout do sistema

     /nao possui argumento
     /nao possui retorno
     */
    public void setBancoLayout(){
       String a;
       a = Integer.toString(banco.getBanco(0));
       Reg0.setText(a);
       a = Integer.toString(banco.getBanco(1));
       Reg1.setText(a);
       a = Integer.toString(banco.getBanco(2));
       Reg2.setText(a);
       a = Integer.toString(banco.getBanco(3));
       Reg3.setText(a);
       a = Integer.toString(banco.getBanco(4));
       Reg4.setText(a);
       a = Integer.toString(banco.getBanco(5));
       Reg5.setText(a);
       a = Integer.toString(banco.getBanco(6));
       Reg6.setText(a);
       a = Integer.toString(banco.getBanco(7));
       Reg7.setText(a);
       a = Integer.toString(banco.getBanco(8));
       Reg8.setText(a);
       a = Integer.toString(banco.getBanco(9));
       Reg9.setText(a);
       a = Integer.toString(banco.getBanco(10));
       Reg10.setText(a);
       a = Integer.toString(banco.getBanco(11));
       Reg11.setText(a);
       a = Integer.toString(banco.getBanco(12));
       Reg12.setText(a);
       a = Integer.toString(banco.getBanco(13));
       Reg13.setText(a);
       a = Integer.toString(banco.getBanco(14));
       Reg14.setText(a);
       a = Integer.toString(banco.getBanco(15));
       Reg15.setText(a);
       a = Integer.toString(banco.getBanco(16));
       Reg16.setText(a);
       a = Integer.toString(banco.getBanco(17));
       Reg17.setText(a);
       a = Integer.toString(banco.getBanco(18));
       Reg18.setText(a);
       a = Integer.toString(banco.getBanco(19));
       Reg19.setText(a);
       a = Integer.toString(banco.getBanco(20));
       Reg20.setText(a);
       a = Integer.toString(banco.getBanco(21));
       Reg21.setText(a);
       a = Integer.toString(banco.getBanco(22));
       Reg22.setText(a);
       a = Integer.toString(banco.getBanco(23));
       Reg23.setText(a);
       a = Integer.toString(banco.getBanco(24));
       Reg24.setText(a);
       a = Integer.toString(banco.getBanco(25));
       Reg25.setText(a);
       a = Integer.toString(banco.getBanco(26));
       Reg26.setText(a);
       a = Integer.toString(banco.getBanco(27));
       Reg27.setText(a);
       a = Integer.toString(banco.getBanco(28));
       Reg28.setText(a);
       a = Integer.toString(banco.getBanco(29));
       Reg29.setText(a);
       a = Integer.toString(banco.getBanco(30));
       Reg30.setText(a);
       a = Integer.toString(banco.getBanco(31));
       Reg31.setText(a);
    }

    /** preenche a memoria de instrucao
     * Este metodo preenche a memoria de instrucao com as instrucoes lidas
     * do campo texto presente no layout

     /recebe um variavel do tipo inteiro
     /nao possui retorno
     */
    void inicializa(int q){
        int x;
        String [] instrucao = aux.split("\n");
        for(x=0;x<q;x++){
            banco.setMemoria1(x,instrucao[x]);
        }
    }

    /** Cria arquivo temporario
     * Este metodo cria um arquivo temporario com as instrucoes presete no
     * campo texto presente no layout

     /nao possui argumento
     /nao possui retorno
     */
    private void createArqTemp(){
        instrucoes = this.cxFonte.getText();
         PrintWriter print;
        try{
          print = new PrintWriter(new FileWriter("temp.asm"));
          print.println(instrucoes);
          print.close();
        }
        catch(Exception e){
          JOptionPane.showMessageDialog(null,"Erro ao Criar Arquivo Temporário","Arquivo",JOptionPane.ERROR_MESSAGE);
        }
   }
    /** Analise o codigo
     * Este metodo analisa cada parte da instrucao para verificar se sua
     * sintatica esta correta

     /nao possui argumento
     /nao possui retorno
     */
    public boolean Analisa(){
        int x, temp1, temp2, temp3;
        String [] instrucao = aux.split("\n");
        for(x=0;x<cont;x++){
            String [] assembly = instrucao[x].split(" ");
            opCode = assembly[0];
            if (opCode.equalsIgnoreCase("ADD") || opCode.equalsIgnoreCase("SUB") || opCode.equalsIgnoreCase("XOR") || opCode.equalsIgnoreCase("OR") || opCode.equalsIgnoreCase("AND")){
                destino = assembly[1];
                op1 = assembly[2];
                op2 = assembly[3];
                if(destino.length()>1 && op1.length()>1 && op2.length()>1 && destino.length()<4 && op1.length()<4 && op2.length()<4 && op2.substring(0,1).equalsIgnoreCase("$") && op1.substring(0,1).equalsIgnoreCase("$") && destino.substring(0,1).equalsIgnoreCase("$")){
                    destino = assembly[1].substring(1,assembly[1].length());
                    temp3 = Integer.parseInt(destino);
                    op1 = assembly[2].substring(1,assembly[2].length());
                    temp1 = Integer.parseInt(op1);
                    op2 = assembly[3].substring(1,assembly[3].length());
                    temp2 = Integer.parseInt(op2);
                    if(temp1 < 0 || temp1 >31 || temp2 < 0 || temp2 >31 || temp3 <= 0 || temp3 >31){
                        return(false);
                    }
                }
                else{
                    return(false);
                }
            }
            else{
                if(opCode.equalsIgnoreCase("ADDI") || opCode.equalsIgnoreCase("SUBI")){
                    destino = assembly[1];
                    op1 = assembly[2];
                    op2 = assembly[3];
                    if(destino.length()>1 && op1.length()>1 && destino.length()<4 && op1.length()<4 && op2.length()>=1 && op1.substring(0,1).equalsIgnoreCase("$") && destino.substring(0,1).equalsIgnoreCase("$")){
                        if(op2.substring(0,1).equalsIgnoreCase("0") || op2.substring(0,1).equalsIgnoreCase("1") || op2.substring(0,1).equalsIgnoreCase("2") || op2.substring(0,1).equalsIgnoreCase("3") || op2.substring(0,1).equalsIgnoreCase("4") || op2.substring(0,1).equalsIgnoreCase("5") || op2.substring(0,1).equalsIgnoreCase("6") || op2.substring(0,1).equalsIgnoreCase("7") || op2.substring(0,1).equalsIgnoreCase("8") || op2.substring(0,1).equalsIgnoreCase("9")){
                            destino = assembly[1].substring(1,assembly[1].length());
                            temp3 = Integer.parseInt(destino);
                            op1 = assembly[2].substring(1,assembly[2].length());
                            temp1 = Integer.parseInt(op1);
                            temp2 = Integer.parseInt(op2);
                            if(temp1 < 0 || temp1 >31 || temp3 <= 0 || temp3 >31){
                                return(false);
                            }
                        }
                        else{
                            return(false);
                        }
                    }
                    else{
                        return(false);
                    }
                }
                else{
                    if(opCode.equalsIgnoreCase("LW") || opCode.equalsIgnoreCase("SW")){
                        destino = assembly[1];
                        op2 = assembly[2];
                        op1 = assembly[4];
                        temp1 = Integer.parseInt(op2);
                        if(destino.length()>1 && op1.length()>1 && op2.length()>=1 && destino.length()<4 && op1.length()<4 && op1.substring(0,1).equalsIgnoreCase("$") && destino.substring(0,1).equalsIgnoreCase("$")){
                            temp2 = Integer.parseInt(op1.substring(1,op1.length()));
                            destino = assembly[1].substring(1,assembly[1].length());
                            temp3 = Integer.parseInt(destino);
                            //colocar validação da posição de memoria;
                            if(temp2 <0 || temp2 >31 || temp3 <0 || temp3 >31){
                                return(false);
                            }
                            if(!assembly[3].equals("(") || !assembly[5].equals(")")){
                                return(false);
                            }
                            if(opCode.equalsIgnoreCase("LW")){
                                if(temp3 == 0){
                                    return(false);
                                }
                            }
                            if(((temp1+banco.getBanco(temp2)) / 4) < 50 || ((temp1+banco.getBanco(temp2)) / 4) > 99){
                                return(false);
                            }
                        }
                        else{
                            return(false);
                        }
                    }
                    else{
                        return(false);
                    }
                }
            }
        }
        return(true);
    }
    /** Le do arquivo temporario e chama a funcao de analisar o codigo
     * Este metodo le as instrucoes presentes no arquivo temporario e coloca em
     * uma variavel temporaria, logo apos esse metodo chama o metodo Analisa que
     * verifica parte por parte da instrucao para verificar a sitatica

     /nao possui argumento
     /retorna o valor do tipo booleano
     */
   public boolean AnaliseSintatica(){
       /*instrucoes = this.cxFonte.getText();
       int x;
       for(x=0;x<instrucoes.){
       }
       String [] temp = instrucoes.split("\n");
       return(true);
        */
        String a;
        try{
        File file = new File("temp.asm");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        cont = 0;
        a = br.readLine();
        if(a.length() == 0){
            JOptionPane.showMessageDialog(null,"Por Favor Entre Com o Código Assembler","Informação",JOptionPane.INFORMATION_MESSAGE);
            return(false);
        }
        aux = "";
        while(a != null){
                if(a.length() == 0){
                    break;
                }
                cont++;
                aux += a;
                aux += "\n";
                a = br.readLine();
        }
        file.deleteOnExit();
        return(true);
        } catch(IOException e){
            return(false);
        }
    }
   /** Atualiza a memoria
    * Este metodo atualiza todos os valores, tanto da memoria de instrucao
    * quanto da memoria de dados, presentes no painel localizado no layout do
    * sistema

     /nao possui argumento
     /nao possui retorno
     */
   public void setMemoria(){
       String a;
       Mem0.setText(banco.getMemoria1(0));
       Mem1.setText(banco.getMemoria1(1));
       Mem2.setText(banco.getMemoria1(2));
       Mem3.setText(banco.getMemoria1(3));
       Mem4.setText(banco.getMemoria1(4));
       Mem5.setText(banco.getMemoria1(5));
       Mem6.setText(banco.getMemoria1(6));
       Mem7.setText(banco.getMemoria1(7));
       Mem8.setText(banco.getMemoria1(8));
       Mem9.setText(banco.getMemoria1(9));
       Mem10.setText(banco.getMemoria1(10));
       Mem11.setText(banco.getMemoria1(11));
       Mem12.setText(banco.getMemoria1(12));
       Mem13.setText(banco.getMemoria1(13));
       Mem14.setText(banco.getMemoria1(14));
       Mem15.setText(banco.getMemoria1(15));
       Mem16.setText(banco.getMemoria1(16));
       Mem17.setText(banco.getMemoria1(17));
       Mem18.setText(banco.getMemoria1(18));
       Mem19.setText(banco.getMemoria1(19));
       Mem20.setText(banco.getMemoria1(20));
       Mem21.setText(banco.getMemoria1(21));
       Mem22.setText(banco.getMemoria1(22));
       Mem23.setText(banco.getMemoria1(23));
       Mem24.setText(banco.getMemoria1(24));
       Mem25.setText(banco.getMemoria1(25));
       Mem26.setText(banco.getMemoria1(26));
       Mem27.setText(banco.getMemoria1(27));
       Mem28.setText(banco.getMemoria1(28));
       Mem29.setText(banco.getMemoria1(29));
       Mem30.setText(banco.getMemoria1(30));
       Mem31.setText(banco.getMemoria1(31));
       Mem32.setText(banco.getMemoria1(32));
       Mem33.setText(banco.getMemoria1(33));
       Mem34.setText(banco.getMemoria1(34));
       Mem35.setText(banco.getMemoria1(35));
       Mem36.setText(banco.getMemoria1(36));
       Mem37.setText(banco.getMemoria1(37));
       Mem38.setText(banco.getMemoria1(38));
       Mem39.setText(banco.getMemoria1(39));
       Mem40.setText(banco.getMemoria1(40));
       Mem41.setText(banco.getMemoria1(41));
       Mem42.setText(banco.getMemoria1(42));
       Mem43.setText(banco.getMemoria1(43));
       Mem44.setText(banco.getMemoria1(44));
       Mem45.setText(banco.getMemoria1(45));
       Mem46.setText(banco.getMemoria1(46));
       Mem47.setText(banco.getMemoria1(47));
       Mem48.setText(banco.getMemoria1(48));
       Mem49.setText(banco.getMemoria1(49));
       a = Integer.toString(banco.getMemoria2(50));
       Mem50.setText(a);
       a = Integer.toString(banco.getMemoria2(51));
       Mem51.setText(a);
       a = Integer.toString(banco.getMemoria2(52));
       Mem52.setText(a);
       a = Integer.toString(banco.getMemoria2(53));
       Mem53.setText(a);
       a = Integer.toString(banco.getMemoria2(54));
       Mem54.setText(a);
       a = Integer.toString(banco.getMemoria2(55));
       Mem55.setText(a);
       a = Integer.toString(banco.getMemoria2(56));
       Mem56.setText(a);
       a = Integer.toString(banco.getMemoria2(57));
       Mem57.setText(a);
       a = Integer.toString(banco.getMemoria2(58));
       Mem58.setText(a);
       a = Integer.toString(banco.getMemoria2(59));
       Mem59.setText(a);
       a = Integer.toString(banco.getMemoria2(60));
       Mem60.setText(a);
       a = Integer.toString(banco.getMemoria2(61));
       Mem61.setText(a);
       a = Integer.toString(banco.getMemoria2(62));
       Mem62.setText(a);
       a = Integer.toString(banco.getMemoria2(63));
       Mem63.setText(a);
       a = Integer.toString(banco.getMemoria2(64));
       Mem64.setText(a);
       a = Integer.toString(banco.getMemoria2(65));
       Mem65.setText(a);
       a = Integer.toString(banco.getMemoria2(66));
       Mem66.setText(a);
       a = Integer.toString(banco.getMemoria2(67));
       Mem67.setText(a);
       a = Integer.toString(banco.getMemoria2(68));
       Mem68.setText(a);
       a = Integer.toString(banco.getMemoria2(69));
       Mem69.setText(a);
       a = Integer.toString(banco.getMemoria2(70));
       Mem70.setText(a);
       a = Integer.toString(banco.getMemoria2(71));
       Mem71.setText(a);
       a = Integer.toString(banco.getMemoria2(72));
       Mem72.setText(a);
       a = Integer.toString(banco.getMemoria2(73));
       Mem73.setText(a);
       a = Integer.toString(banco.getMemoria2(74));
       Mem74.setText(a);
       a = Integer.toString(banco.getMemoria2(75));
       Mem75.setText(a);
       a = Integer.toString(banco.getMemoria2(76));
       Mem76.setText(a);
       a = Integer.toString(banco.getMemoria2(77));
       Mem77.setText(a);
       a = Integer.toString(banco.getMemoria2(78));
       Mem78.setText(a);
       a = Integer.toString(banco.getMemoria2(79));
       Mem79.setText(a);
       a = Integer.toString(banco.getMemoria2(80));
       Mem80.setText(a);
       a = Integer.toString(banco.getMemoria2(81));
       Mem81.setText(a);
       a = Integer.toString(banco.getMemoria2(82));
       Mem82.setText(a);
       a = Integer.toString(banco.getMemoria2(83));
       Mem83.setText(a);
       a = Integer.toString(banco.getMemoria2(84));
       Mem84.setText(a);
       a = Integer.toString(banco.getMemoria2(85));
       Mem85.setText(a);
       a = Integer.toString(banco.getMemoria2(86));
       Mem86.setText(a);
       a = Integer.toString(banco.getMemoria2(87));
       Mem87.setText(a);
       a = Integer.toString(banco.getMemoria2(88));
       Mem88.setText(a);
       a = Integer.toString(banco.getMemoria2(89));
       Mem89.setText(a);
       a = Integer.toString(banco.getMemoria2(90));
       Mem90.setText(a);
       a = Integer.toString(banco.getMemoria2(91));
       Mem91.setText(a);
       a = Integer.toString(banco.getMemoria2(92));
       Mem92.setText(a);
       a = Integer.toString(banco.getMemoria2(93));
       Mem93.setText(a);
       a = Integer.toString(banco.getMemoria2(94));
       Mem94.setText(a);
       a = Integer.toString(banco.getMemoria2(95));
       Mem95.setText(a);
       a = Integer.toString(banco.getMemoria2(96));
       Mem96.setText(a);
       a = Integer.toString(banco.getMemoria2(97));
       Mem97.setText(a);
       a = Integer.toString(banco.getMemoria2(98));
       Mem98.setText(a);
       a = Integer.toString(banco.getMemoria2(99));
       Mem99.setText(a);

   }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        cxFonte = new javax.swing.JTextPane();
        Carregar = new javax.swing.JButton();
        Stop = new javax.swing.JButton();
        Play = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Reg0 = new javax.swing.JTextField();
        Reg1 = new javax.swing.JTextField();
        Reg2 = new javax.swing.JTextField();
        Reg3 = new javax.swing.JTextField();
        Reg4 = new javax.swing.JTextField();
        Reg5 = new javax.swing.JTextField();
        Reg7 = new javax.swing.JTextField();
        Reg6 = new javax.swing.JTextField();
        Reg9 = new javax.swing.JTextField();
        Reg8 = new javax.swing.JTextField();
        Reg10 = new javax.swing.JTextField();
        Reg11 = new javax.swing.JTextField();
        Reg12 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Reg13 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Reg14 = new javax.swing.JTextField();
        Reg15 = new javax.swing.JTextField();
        Reg16 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        Reg23 = new javax.swing.JTextField();
        Reg22 = new javax.swing.JTextField();
        Reg20 = new javax.swing.JTextField();
        Reg18 = new javax.swing.JTextField();
        Reg21 = new javax.swing.JTextField();
        Reg17 = new javax.swing.JTextField();
        Reg19 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Reg27 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        Reg31 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        Reg24 = new javax.swing.JTextField();
        Reg28 = new javax.swing.JTextField();
        Reg26 = new javax.swing.JTextField();
        Reg29 = new javax.swing.JTextField();
        Reg25 = new javax.swing.JTextField();
        Reg30 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        RegistradorPC = new javax.swing.JTextField();
        RegistradorInstrucao = new javax.swing.JTextField();
        RegistradorMemoria = new javax.swing.JTextField();
        RegistradorA = new javax.swing.JTextField();
        RegistradorB = new javax.swing.JTextField();
        RegistradorULA = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Imagem = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        Mem11 = new javax.swing.JTextField();
        Mem12 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        Mem13 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        Mem31 = new javax.swing.JTextField();
        Mem28 = new javax.swing.JTextField();
        Mem24 = new javax.swing.JTextField();
        Mem0 = new javax.swing.JTextField();
        Mem1 = new javax.swing.JTextField();
        Mem2 = new javax.swing.JTextField();
        Mem3 = new javax.swing.JTextField();
        Mem4 = new javax.swing.JTextField();
        Mem5 = new javax.swing.JTextField();
        Mem6 = new javax.swing.JTextField();
        Mem7 = new javax.swing.JTextField();
        Mem8 = new javax.swing.JTextField();
        Mem9 = new javax.swing.JTextField();
        Mem10 = new javax.swing.JTextField();
        Mem26 = new javax.swing.JTextField();
        Mem29 = new javax.swing.JTextField();
        Mem25 = new javax.swing.JTextField();
        Mem30 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        Mem19 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        Mem27 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        Mem23 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        Mem15 = new javax.swing.JTextField();
        Mem14 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        Mem16 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        Mem20 = new javax.swing.JTextField();
        Mem18 = new javax.swing.JTextField();
        Mem21 = new javax.swing.JTextField();
        Mem17 = new javax.swing.JTextField();
        Mem22 = new javax.swing.JTextField();
        Mem43 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        Mem45 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        Mem35 = new javax.swing.JTextField();
        Mem37 = new javax.swing.JTextField();
        Mem36 = new javax.swing.JTextField();
        Mem39 = new javax.swing.JTextField();
        Mem32 = new javax.swing.JTextField();
        Mem33 = new javax.swing.JTextField();
        Mem34 = new javax.swing.JTextField();
        Mem40 = new javax.swing.JTextField();
        Mem48 = new javax.swing.JTextField();
        Mem47 = new javax.swing.JTextField();
        Mem46 = new javax.swing.JTextField();
        Mem50 = new javax.swing.JTextField();
        Mem44 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        Mem42 = new javax.swing.JTextField();
        Mem41 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        Mem38 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        Mem49 = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        Mem65 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        Mem68 = new javax.swing.JTextField();
        Mem67 = new javax.swing.JTextField();
        Mem66 = new javax.swing.JTextField();
        Mem64 = new javax.swing.JTextField();
        Mem62 = new javax.swing.JTextField();
        Mem61 = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        Mem63 = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        Mem55 = new javax.swing.JTextField();
        Mem57 = new javax.swing.JTextField();
        Mem56 = new javax.swing.JTextField();
        Mem59 = new javax.swing.JTextField();
        Mem51 = new javax.swing.JTextField();
        Mem52 = new javax.swing.JTextField();
        Mem53 = new javax.swing.JTextField();
        Mem54 = new javax.swing.JTextField();
        Mem60 = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        Mem58 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        Mem73 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        Mem77 = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        Mem71 = new javax.swing.JTextField();
        Mem72 = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        Mem70 = new javax.swing.JTextField();
        Mem86 = new javax.swing.JTextField();
        Mem87 = new javax.swing.JTextField();
        Mem85 = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        Mem82 = new javax.swing.JTextField();
        Mem83 = new javax.swing.JTextField();
        Mem84 = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        Mem81 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        Mem88 = new javax.swing.JTextField();
        Mem78 = new javax.swing.JTextField();
        Mem74 = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        Mem80 = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        Mem79 = new javax.swing.JTextField();
        Mem75 = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        Mem76 = new javax.swing.JTextField();
        Mem69 = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        Mem99 = new javax.swing.JTextField();
        Mem93 = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        Mem95 = new javax.swing.JTextField();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        Mem96 = new javax.swing.JTextField();
        Mem94 = new javax.swing.JTextField();
        Mem89 = new javax.swing.JTextField();
        Mem90 = new javax.swing.JTextField();
        Mem98 = new javax.swing.JTextField();
        Mem97 = new javax.swing.JTextField();
        Mem91 = new javax.swing.JTextField();
        Mem92 = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuClose5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);

        jScrollPane1.setViewportView(cxFonte);

        Carregar.setText("Carregar");
        Carregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarregarMouseClicked(evt);
            }
        });
        Carregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Carregar(evt);
            }
        });

        Stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Stop.jpg"))); // NOI18N
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Stop(evt);
            }
        });

        Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Play.jpg"))); // NOI18N
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Play(evt);
            }
        });

        jLabel1.setText("$0");

        jLabel2.setText("$1");

        jLabel3.setText("$2");

        jLabel4.setText("$5");

        jLabel5.setText("$3");

        jLabel6.setText("$4");

        jLabel7.setText("$6");

        jLabel8.setText("$7");

        jLabel9.setText("$8");

        jLabel10.setText("$9");

        jLabel11.setText("$10");

        jLabel12.setText("$11");

        Reg0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg0.setText("0000");
        Reg0.setEnabled(false);
        Reg0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reg0ActionPerformed(evt);
            }
        });

        Reg1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg1.setText("0000");
        Reg1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg1.setEnabled(false);

        Reg2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg2.setText("0000");
        Reg2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg2.setEnabled(false);

        Reg3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg3.setText("0000");
        Reg3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg3.setEnabled(false);

        Reg4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg4.setText("0000");
        Reg4.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg4.setEnabled(false);

        Reg5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg5.setText("0000");
        Reg5.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg5.setEnabled(false);

        Reg7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg7.setText("0000");
        Reg7.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg7.setEnabled(false);

        Reg6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg6.setText("0000");
        Reg6.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg6.setEnabled(false);

        Reg9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg9.setText("0000");
        Reg9.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg9.setEnabled(false);

        Reg8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg8.setText("0000");
        Reg8.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg8.setEnabled(false);

        Reg10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg10.setText("0000");
        Reg10.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg10.setEnabled(false);

        Reg11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg11.setText("0000");
        Reg11.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg11.setEnabled(false);

        Reg12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg12.setText("0000");
        Reg12.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg12.setEnabled(false);

        jLabel13.setText("$21");

        jLabel14.setText("$12");

        jLabel15.setText("$22");

        jLabel16.setText("$13");

        jLabel17.setText("$19");

        jLabel18.setText("$14");

        Reg13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg13.setText("0000");
        Reg13.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg13.setEnabled(false);
        Reg13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reg13ActionPerformed(evt);
            }
        });

        jLabel19.setText("$20");

        jLabel20.setText("$17");

        Reg14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg14.setText("0000");
        Reg14.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg14.setEnabled(false);

        Reg15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg15.setText("0000");
        Reg15.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg15.setEnabled(false);

        Reg16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg16.setText("0000");
        Reg16.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg16.setEnabled(false);

        jLabel21.setText("$23");

        jLabel22.setText("$15");

        Reg23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg23.setText("0000");
        Reg23.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg23.setEnabled(false);

        Reg22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg22.setText("0000");
        Reg22.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg22.setEnabled(false);

        Reg20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg20.setText("0000");
        Reg20.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg20.setEnabled(false);

        Reg18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg18.setText("0000");
        Reg18.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg18.setEnabled(false);

        Reg21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg21.setText("0000");
        Reg21.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg21.setEnabled(false);

        Reg17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg17.setText("0000");
        Reg17.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg17.setEnabled(false);

        Reg19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg19.setText("0000");
        Reg19.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg19.setEnabled(false);

        jLabel23.setText("$18");

        jLabel24.setText("$16");

        jLabel25.setText("$24");

        jLabel26.setText("$26");

        Reg27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg27.setText("0000");
        Reg27.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg27.setEnabled(false);

        jLabel27.setText("$29");

        jLabel28.setText("$27");

        jLabel29.setText("$30");

        jLabel30.setText("$25");

        jLabel31.setText("$28");

        Reg31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg31.setText("0000");
        Reg31.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg31.setEnabled(false);

        jLabel32.setText("$31");

        Reg24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg24.setText("0000");
        Reg24.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg24.setEnabled(false);

        Reg28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg28.setText("0000");
        Reg28.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg28.setEnabled(false);

        Reg26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg26.setText("0000");
        Reg26.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg26.setEnabled(false);

        Reg29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg29.setText("0000");
        Reg29.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg29.setEnabled(false);

        Reg25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg25.setText("0000");
        Reg25.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg25.setEnabled(false);

        Reg30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Reg30.setText("0000");
        Reg30.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Reg30.setEnabled(false);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Banco de Registradores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Reg0, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reg1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reg2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reg3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Reg4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Reg5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Reg6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Reg7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Reg8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Reg10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Reg9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Reg11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel15)
                                                .addComponent(jLabel19)
                                                .addComponent(jLabel17)
                                                .addComponent(jLabel23)
                                                .addComponent(jLabel20)
                                                .addComponent(jLabel24)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Reg16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Reg17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Reg18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Reg19, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Reg20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Reg22, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Reg21, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Reg23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel32)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel27)
                                                .addComponent(jLabel29)
                                                .addComponent(jLabel31)
                                                .addComponent(jLabel28)
                                                .addComponent(jLabel26)
                                                .addComponent(jLabel30)
                                                .addComponent(jLabel25)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Reg24, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Reg25, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Reg26, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Reg27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Reg28, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Reg30, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Reg29, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Reg31, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel22)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Reg12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reg13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reg14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reg15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Reg0, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Reg1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Reg2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Reg3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(Reg4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Reg5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Reg6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Reg7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(Reg16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(Reg17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(Reg18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(Reg19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(Reg20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(Reg21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(Reg22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(Reg23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Reg8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Reg9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(Reg10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(Reg11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(Reg12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(Reg13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(Reg14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(Reg15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(Reg24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(Reg25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(Reg26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(Reg27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(Reg28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(Reg29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(Reg30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(Reg31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel1);

        jLabel33.setText("PC");

        jLabel34.setText("Registrador de Instrução");

        jLabel35.setText("Registrador de Dados da Memória");

        jLabel36.setText("Registrador A");

        jLabel37.setText("Registrador B");

        jLabel38.setText("ULA Saída");

        RegistradorPC.setEditable(false);
        RegistradorPC.setForeground(new java.awt.Color(102, 102, 102));
        RegistradorPC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RegistradorPC.setText("0000");
        RegistradorPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistradorPCActionPerformed(evt);
            }
        });

        RegistradorInstrucao.setEditable(false);
        RegistradorInstrucao.setForeground(new java.awt.Color(102, 102, 102));
        RegistradorInstrucao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RegistradorInstrucao.setText("0000");
        RegistradorInstrucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistradorInstrucaoActionPerformed(evt);
            }
        });

        RegistradorMemoria.setEditable(false);
        RegistradorMemoria.setForeground(new java.awt.Color(102, 102, 102));
        RegistradorMemoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RegistradorMemoria.setText("0000");
        RegistradorMemoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistradorMemoriaActionPerformed(evt);
            }
        });

        RegistradorA.setEditable(false);
        RegistradorA.setForeground(new java.awt.Color(102, 102, 102));
        RegistradorA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RegistradorA.setText("0000");
        RegistradorA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistradorAActionPerformed(evt);
            }
        });

        RegistradorB.setEditable(false);
        RegistradorB.setForeground(new java.awt.Color(102, 102, 102));
        RegistradorB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RegistradorB.setText("0000");
        RegistradorB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistradorBActionPerformed(evt);
            }
        });

        RegistradorULA.setEditable(false);
        RegistradorULA.setForeground(new java.awt.Color(102, 102, 102));
        RegistradorULA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RegistradorULA.setText("0000");
        RegistradorULA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistradorULAActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Registradores Temporários");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37)
                            .addComponent(jLabel36)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RegistradorPC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegistradorMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegistradorA, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegistradorB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegistradorULA, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegistradorInstrucao, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(RegistradorPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(RegistradorInstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegistradorMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(RegistradorA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(RegistradorB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(RegistradorULA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Imagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(Imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 784, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Imagem, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
        );

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Mémoria");
        jLabel41.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel41.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel43.setText("21");

        jLabel44.setText("12");

        Mem11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem11.setText("0000");
        Mem11.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem11.setEnabled(false);

        Mem12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem12.setText("0000");
        Mem12.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem12.setEnabled(false);
        Mem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mem12ActionPerformed(evt);
            }
        });

        jLabel45.setText("19");

        jLabel46.setText("22");

        jLabel47.setText("13");

        jLabel48.setText("17");

        jLabel49.setText("20");

        Mem13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem13.setText("0000");
        Mem13.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem13.setEnabled(false);
        Mem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mem13ActionPerformed(evt);
            }
        });

        jLabel50.setText("14");

        jLabel51.setText("31");

        Mem31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem31.setText("0000");
        Mem31.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem31.setEnabled(false);
        Mem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mem31ActionPerformed(evt);
            }
        });

        Mem28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem28.setText("0000");
        Mem28.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem28.setEnabled(false);

        Mem24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem24.setText("0000");
        Mem24.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem24.setEnabled(false);

        Mem0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem0.setText("0000");
        Mem0.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem0.setEnabled(false);

        Mem1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem1.setText("0000");
        Mem1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem1.setEnabled(false);

        Mem2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem2.setText("0000");
        Mem2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem2.setEnabled(false);

        Mem3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem3.setText("0000");
        Mem3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem3.setEnabled(false);

        Mem4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem4.setText("0000");
        Mem4.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem4.setEnabled(false);

        Mem5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem5.setText("0000");
        Mem5.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem5.setEnabled(false);

        Mem6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem6.setText("0000");
        Mem6.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem6.setEnabled(false);

        Mem7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem7.setText("0000");
        Mem7.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem7.setEnabled(false);

        Mem8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem8.setText("0000");
        Mem8.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem8.setEnabled(false);

        Mem9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem9.setText("0000");
        Mem9.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem9.setEnabled(false);

        Mem10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem10.setText("0000");
        Mem10.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem10.setEnabled(false);

        Mem26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem26.setText("0000");
        Mem26.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem26.setEnabled(false);

        Mem29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem29.setText("0000");
        Mem29.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem29.setEnabled(false);

        Mem25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem25.setText("0000");
        Mem25.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem25.setEnabled(false);

        Mem30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem30.setText("0000");
        Mem30.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem30.setEnabled(false);

        jLabel52.setText("26");

        jLabel53.setText("24");

        jLabel54.setText("16");

        jLabel55.setText("18");

        jLabel56.setText("9");

        Mem19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem19.setText("0000");
        Mem19.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem19.setEnabled(false);

        jLabel57.setText("7");

        jLabel58.setText("8");

        jLabel59.setText("4");

        jLabel60.setText("6");

        jLabel61.setText("5");

        jLabel62.setText("3");

        jLabel63.setText("1");

        jLabel64.setText("2");

        jLabel65.setText("11");

        jLabel66.setText("10");

        jLabel67.setText("25");

        jLabel68.setText("28");

        jLabel69.setText("27");

        jLabel70.setText("30");

        Mem27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem27.setText("0000");
        Mem27.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem27.setEnabled(false);

        jLabel71.setText("29");

        Mem23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem23.setText("0000");
        Mem23.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem23.setEnabled(false);

        jLabel72.setText("15");

        Mem15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem15.setText("0000");
        Mem15.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem15.setEnabled(false);

        Mem14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem14.setText("0000");
        Mem14.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem14.setEnabled(false);

        jLabel73.setText("23");

        Mem16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem16.setText("0000");
        Mem16.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem16.setEnabled(false);

        jLabel74.setText("0");

        Mem20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem20.setText("0000");
        Mem20.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem20.setEnabled(false);

        Mem18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem18.setText("0000");
        Mem18.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem18.setEnabled(false);

        Mem21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem21.setText("0000");
        Mem21.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem21.setEnabled(false);

        Mem17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem17.setText("0000");
        Mem17.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem17.setEnabled(false);

        Mem22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem22.setText("0000");
        Mem22.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem22.setEnabled(false);

        Mem43.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem43.setText("0000");
        Mem43.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem43.setEnabled(false);
        Mem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mem43ActionPerformed(evt);
            }
        });

        jLabel75.setText("44");

        jLabel76.setText("47");

        jLabel77.setText("50");

        jLabel78.setText("43");

        Mem45.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem45.setText("0000");
        Mem45.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem45.setEnabled(false);

        jLabel79.setText("45");

        jLabel80.setText("40");

        Mem35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem35.setText("0000");
        Mem35.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem35.setEnabled(false);

        Mem37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem37.setText("0000");
        Mem37.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem37.setEnabled(false);

        Mem36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem36.setText("0000");
        Mem36.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem36.setEnabled(false);

        Mem39.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem39.setText("0000");
        Mem39.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem39.setEnabled(false);

        Mem32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem32.setText("0000");
        Mem32.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem32.setEnabled(false);

        Mem33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem33.setText("0000");
        Mem33.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem33.setEnabled(false);

        Mem34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem34.setText("0000");
        Mem34.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem34.setEnabled(false);

        Mem40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem40.setText("0000");
        Mem40.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem40.setEnabled(false);

        Mem48.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem48.setText("0000");
        Mem48.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem48.setEnabled(false);

        Mem47.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem47.setText("0000");
        Mem47.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem47.setEnabled(false);

        Mem46.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem46.setText("0000");
        Mem46.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem46.setEnabled(false);

        Mem50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem50.setText("0000");
        Mem50.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem50.setEnabled(false);

        Mem44.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem44.setText("0000");
        Mem44.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem44.setEnabled(false);

        jLabel81.setText("48");

        jLabel82.setText("39");

        jLabel83.setText("46");

        jLabel84.setText("49");

        Mem42.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem42.setText("0000");
        Mem42.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem42.setEnabled(false);

        Mem41.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem41.setText("0000");
        Mem41.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem41.setEnabled(false);

        jLabel85.setText("42");

        Mem38.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem38.setText("0000");
        Mem38.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem38.setEnabled(false);

        jLabel86.setText("34");

        jLabel87.setText("36");

        jLabel88.setText("35");

        jLabel89.setText("33");

        jLabel90.setText("32");

        jLabel91.setText("41");

        Mem49.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem49.setText("0000");
        Mem49.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem49.setEnabled(false);

        jLabel92.setText("38");

        jLabel93.setText("37");

        Mem65.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem65.setText("0000");
        Mem65.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem65.setEnabled(false);

        jLabel94.setText("65");

        jLabel95.setText("60");

        Mem68.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem68.setText("0000");
        Mem68.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem68.setEnabled(false);

        Mem67.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem67.setText("0000");
        Mem67.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem67.setEnabled(false);

        Mem66.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem66.setText("0000");
        Mem66.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem66.setEnabled(false);

        Mem64.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem64.setText("0000");
        Mem64.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem64.setEnabled(false);

        Mem62.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem62.setText("0000");
        Mem62.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem62.setEnabled(false);

        Mem61.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem61.setText("0000");
        Mem61.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem61.setEnabled(false);

        jLabel96.setText("62");

        Mem63.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem63.setText("0000");
        Mem63.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem63.setEnabled(false);
        Mem63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mem63ActionPerformed(evt);
            }
        });

        jLabel97.setText("64");

        jLabel98.setText("67");

        jLabel99.setText("63");

        Mem55.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem55.setText("0000");
        Mem55.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem55.setEnabled(false);

        Mem57.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem57.setText("0000");
        Mem57.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem57.setEnabled(false);

        Mem56.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem56.setText("0000");
        Mem56.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem56.setEnabled(false);

        Mem59.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem59.setText("0000");
        Mem59.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem59.setEnabled(false);

        Mem51.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem51.setText("0000");
        Mem51.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem51.setEnabled(false);

        Mem52.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem52.setText("0000");
        Mem52.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem52.setEnabled(false);

        Mem53.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem53.setText("0000");
        Mem53.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem53.setEnabled(false);

        Mem54.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem54.setText("0000");
        Mem54.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem54.setEnabled(false);

        Mem60.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem60.setText("0000");
        Mem60.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem60.setEnabled(false);

        jLabel100.setText("68");

        jLabel101.setText("59");

        jLabel102.setText("66");

        Mem58.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem58.setText("0000");
        Mem58.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem58.setEnabled(false);

        jLabel103.setText("54");

        jLabel104.setText("56");

        jLabel105.setText("55");

        jLabel106.setText("53");

        jLabel107.setText("51");

        jLabel108.setText("52");

        jLabel109.setText("61");

        jLabel110.setText("58");

        jLabel111.setText("57");

        Mem73.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem73.setText("0000");
        Mem73.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem73.setEnabled(false);

        jLabel112.setText("79");

        Mem77.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem77.setText("0000");
        Mem77.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem77.setEnabled(false);

        jLabel113.setText("80");

        jLabel114.setText("78");

        jLabel115.setText("77");

        jLabel116.setText("75");

        jLabel117.setText("82");

        jLabel118.setText("88");

        jLabel119.setText("85");

        jLabel120.setText("83");

        jLabel121.setText("87");

        Mem71.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem71.setText("0000");
        Mem71.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem71.setEnabled(false);

        Mem72.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem72.setText("0000");
        Mem72.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem72.setEnabled(false);

        jLabel122.setText("73");

        Mem70.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem70.setText("0000");
        Mem70.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem70.setEnabled(false);

        Mem86.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem86.setText("0000");
        Mem86.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem86.setEnabled(false);

        Mem87.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem87.setText("0000");
        Mem87.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem87.setEnabled(false);

        Mem85.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem85.setText("0000");
        Mem85.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem85.setEnabled(false);

        jLabel123.setText("69");

        jLabel124.setText("71");

        Mem82.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem82.setText("0000");
        Mem82.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem82.setEnabled(false);

        Mem83.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem83.setText("0000");
        Mem83.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem83.setEnabled(false);

        Mem84.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem84.setText("0000");
        Mem84.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem84.setEnabled(false);

        jLabel125.setText("81");

        Mem81.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem81.setText("0000");
        Mem81.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem81.setEnabled(false);

        jLabel126.setText("70");

        jLabel127.setText("72");

        Mem88.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem88.setText("0000");
        Mem88.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem88.setEnabled(false);

        Mem78.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem78.setText("0000");
        Mem78.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem78.setEnabled(false);

        Mem74.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem74.setText("0000");
        Mem74.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem74.setEnabled(false);

        jLabel128.setText("84");

        jLabel129.setText("86");

        Mem80.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem80.setText("0000");
        Mem80.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem80.setEnabled(false);

        jLabel130.setText("76");

        Mem79.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem79.setText("0000");
        Mem79.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem79.setEnabled(false);

        Mem75.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem75.setText("0000");
        Mem75.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem75.setEnabled(false);

        jLabel131.setText("74");

        Mem76.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem76.setText("0000");
        Mem76.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem76.setEnabled(false);

        Mem69.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem69.setText("0000");
        Mem69.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem69.setEnabled(false);

        jLabel132.setText("91");

        Mem99.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem99.setText("0000");
        Mem99.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem99.setEnabled(false);

        Mem93.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem93.setText("0000");
        Mem93.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem93.setEnabled(false);
        Mem93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mem93ActionPerformed(evt);
            }
        });

        jLabel133.setText("90");

        jLabel134.setText("94");

        jLabel135.setText("97");

        Mem95.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem95.setText("0000");
        Mem95.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem95.setEnabled(false);

        jLabel136.setText("95");

        jLabel137.setText("93");

        Mem96.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem96.setText("0000");
        Mem96.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem96.setEnabled(false);

        Mem94.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem94.setText("0000");
        Mem94.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem94.setEnabled(false);

        Mem89.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem89.setText("0000");
        Mem89.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem89.setEnabled(false);

        Mem90.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem90.setText("0000");
        Mem90.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem90.setEnabled(false);

        Mem98.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem98.setText("0000");
        Mem98.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem98.setEnabled(false);

        Mem97.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem97.setText("0000");
        Mem97.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem97.setEnabled(false);

        Mem91.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem91.setText("0000");
        Mem91.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem91.setEnabled(false);

        Mem92.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mem92.setText("0000");
        Mem92.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mem92.setEnabled(false);

        jLabel138.setText("92");

        jLabel139.setText("89");

        jLabel140.setText("98");

        jLabel141.setText("99");

        jLabel142.setText("96");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel90)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel91)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel82)
                                    .addComponent(jLabel80)
                                    .addComponent(jLabel92)
                                    .addComponent(jLabel93)
                                    .addComponent(jLabel87)
                                    .addComponent(jLabel88)
                                    .addComponent(jLabel86)
                                    .addComponent(jLabel89))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Mem41, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem40, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem39, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem38, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem37, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem36, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem35, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem34, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem33, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem32, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel75)
                            .addComponent(jLabel79)
                            .addComponent(jLabel78)
                            .addComponent(jLabel85))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Mem45, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem44, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem43, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem42, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel84)
                            .addComponent(jLabel81)
                            .addComponent(jLabel76)
                            .addComponent(jLabel83))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Mem47, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem46, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem48, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem49, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel73)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel43)
                                .addComponent(jLabel46)
                                .addComponent(jLabel49)
                                .addComponent(jLabel45)
                                .addComponent(jLabel55)
                                .addComponent(jLabel48)
                                .addComponent(jLabel54)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Mem16, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem17, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem18, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem19, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem20, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem21, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem22, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem23, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel71)
                                .addComponent(jLabel70)
                                .addComponent(jLabel68)
                                .addComponent(jLabel69)
                                .addComponent(jLabel52)
                                .addComponent(jLabel67)
                                .addComponent(jLabel53)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Mem24, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem25, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem26, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem27, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem28, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem31, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem30, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem29, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel72)
                            .addComponent(jLabel47)
                            .addComponent(jLabel44))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Mem12, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem13, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem14, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem15, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel64)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel65)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel66)
                                    .addComponent(jLabel58)
                                    .addComponent(jLabel57)
                                    .addComponent(jLabel60)
                                    .addComponent(jLabel61)
                                    .addComponent(jLabel59)
                                    .addComponent(jLabel62)
                                    .addComponent(jLabel63)
                                    .addComponent(jLabel74))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Mem1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem3, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem4, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem5, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem6, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem7, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem8, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem9, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem10, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(Mem11, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Mem50, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel108)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel109)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel101)
                                        .addComponent(jLabel95)
                                        .addComponent(jLabel110)
                                        .addComponent(jLabel111)
                                        .addComponent(jLabel104)
                                        .addComponent(jLabel105)
                                        .addComponent(jLabel103)
                                        .addComponent(jLabel106)
                                        .addComponent(jLabel107))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Mem51, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem52, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem53, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem54, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem55, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem56, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem57, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem58, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem60, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem59, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem61, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel97)
                                .addComponent(jLabel94)
                                .addComponent(jLabel99)
                                .addComponent(jLabel96))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Mem62, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem63, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem64, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem65, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel100)
                                .addComponent(jLabel98)
                                .addComponent(jLabel102))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Mem66, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem67, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem68, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel122)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel124)
                                    .addComponent(jLabel127)
                                    .addComponent(jLabel126)
                                    .addComponent(jLabel123)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Mem69, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem70, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem72, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem71, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem73, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel125)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel112)
                                    .addComponent(jLabel113)
                                    .addComponent(jLabel114)
                                    .addComponent(jLabel115)
                                    .addComponent(jLabel130)
                                    .addComponent(jLabel116)
                                    .addComponent(jLabel131)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Mem74, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem75, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem76, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem77, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem78, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem80, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem79, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem81, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel117)
                                .addComponent(jLabel118)
                                .addComponent(jLabel121)
                                .addComponent(jLabel129)
                                .addComponent(jLabel119)
                                .addComponent(jLabel128)
                                .addComponent(jLabel120))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Mem82, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem83, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem84, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem85, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem86, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem87, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem88, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel132)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel139)
                                    .addComponent(jLabel133)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Mem90, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem89, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem91, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel134)
                                .addComponent(jLabel136)
                                .addComponent(jLabel137)
                                .addComponent(jLabel138))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Mem92, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem93, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem94, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem95, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel141)
                                .addComponent(jLabel140)
                                .addComponent(jLabel135)
                                .addComponent(jLabel142))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Mem96, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem97, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem98, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mem99, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(Mem0, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77)
                    .addComponent(Mem50, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63)
                            .addComponent(Mem1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(Mem2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62)
                            .addComponent(Mem3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(Mem4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(Mem5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(Mem6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(Mem7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(Mem8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(Mem9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(Mem10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(Mem11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(Mem12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(Mem13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(Mem14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72)
                            .addComponent(Mem15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(Mem16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(Mem17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(Mem18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(Mem19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(Mem20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(Mem21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(Mem22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(Mem23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(Mem24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel67)
                            .addComponent(Mem25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(Mem26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel69)
                            .addComponent(Mem27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68)
                            .addComponent(Mem28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71)
                            .addComponent(Mem29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(Mem30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(Mem31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel90)
                            .addComponent(Mem32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel89)
                            .addComponent(Mem33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel86)
                            .addComponent(Mem34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel88)
                            .addComponent(Mem35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel87)
                            .addComponent(Mem36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel93)
                            .addComponent(Mem37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel92)
                            .addComponent(Mem38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel82)
                            .addComponent(Mem39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel80)
                            .addComponent(Mem40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel91)
                            .addComponent(Mem41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel85)
                            .addComponent(Mem42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel78)
                            .addComponent(Mem43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(Mem44, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel79)
                            .addComponent(Mem45, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83)
                            .addComponent(Mem46, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76)
                            .addComponent(Mem47, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81)
                            .addComponent(Mem48, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel84)
                            .addComponent(Mem49, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel107)
                            .addComponent(Mem51, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel108)
                            .addComponent(Mem52, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel106)
                            .addComponent(Mem53, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel103)
                            .addComponent(Mem54, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel105)
                            .addComponent(Mem55, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel104)
                            .addComponent(Mem56, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel111)
                            .addComponent(Mem57, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel110)
                            .addComponent(Mem58, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel101)
                            .addComponent(Mem59, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel95)
                            .addComponent(Mem60, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel109)
                            .addComponent(Mem61, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel96)
                            .addComponent(Mem62, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel99)
                            .addComponent(Mem63, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel97)
                            .addComponent(Mem64, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel94)
                            .addComponent(Mem65, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel102)
                            .addComponent(Mem66, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel98)
                            .addComponent(Mem67, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel100)
                            .addComponent(Mem68, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel123)
                            .addComponent(Mem69, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel126)
                            .addComponent(Mem70, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel124)
                            .addComponent(Mem71, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel127)
                            .addComponent(Mem72, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel122)
                            .addComponent(Mem73, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel131)
                            .addComponent(Mem74, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel116)
                            .addComponent(Mem75, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel130)
                            .addComponent(Mem76, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel115)
                            .addComponent(Mem77, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel114)
                            .addComponent(Mem78, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel112)
                            .addComponent(Mem79, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel113)
                            .addComponent(Mem80, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel125)
                            .addComponent(Mem81, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel117)
                            .addComponent(Mem82, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel120)
                            .addComponent(Mem83, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel128)
                            .addComponent(Mem84, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel119)
                            .addComponent(Mem85, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel129)
                            .addComponent(Mem86, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel121)
                            .addComponent(Mem87, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel118)
                            .addComponent(Mem88, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel139)
                            .addComponent(Mem89, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel133)
                            .addComponent(Mem90, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel132)
                            .addComponent(Mem91, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel138)
                            .addComponent(Mem92, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel137)
                            .addComponent(Mem93, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel134)
                            .addComponent(Mem94, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel136)
                            .addComponent(Mem95, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel142)
                            .addComponent(Mem96, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel135)
                            .addComponent(Mem97, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel140)
                            .addComponent(Mem98, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel141)
                            .addComponent(Mem99, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel4);

        jLabel42.setText("Tempo do Ciclo de Clock");

        jLabel143.setText("Segundo(s)");

        jSpinner1.setInputVerifier(jSpinner1.getInputVerifier());

        jMenu1.setText("Arquivo");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Abrir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Salvar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        menuClose5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        menuClose5.setText("Sair");
        menuClose5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                menuClose5menuClose1StateChanged(evt);
            }
        });
        menuClose5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClose5menuClose1ActionPerformed(evt);
            }
        });
        jMenu1.add(menuClose5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");

        jMenuItem1.setText("MIPS-PMS");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Carregar, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel143)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel42))
                        .addGap(38, 38, 38)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, 0, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Carregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel143)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1016)/2, (screenSize.height-685)/2, 1016, 685);
    }// </editor-fold>//GEN-END:initComponents

    private void menuClose5menuClose1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_menuClose5menuClose1StateChanged

        //camandos para fechar a janela
    }//GEN-LAST:event_menuClose5menuClose1StateChanged

    private void menuClose5menuClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClose5menuClose1ActionPerformed
        this.dispose();
}//GEN-LAST:event_menuClose5menuClose1ActionPerformed
/** Carrega o codigo assembler
 * Este metodo carrega o codigo assembler para o arquivo temporario e chama a
 * analise sintatica

     /possui uma variavel de evento
     /nao possui retorno
     */
    private void CarregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarregarMouseClicked
        banco = BancoMemoria.getInstanciaBanco();
        setBancoLayout();
        createArqTemp();
        if(AnaliseSintatica()){
            if(Analisa()){
                inicializa(cont);
                setMemoria();
                cxFonte.setEditable(false);
                Play.setEnabled(true);
                Stop.setEnabled(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Erro na Sintática","Análise Sitática",JOptionPane.ERROR_MESSAGE);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_CarregarMouseClicked

    /** Chama a janela about

     /possui uma variavel de evento
     /ao possui retorno
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
                about.setVisible(true);
                // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /** Abri um arquivo

     /possui uma variavel de evento
     /ao possui retorno
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        javax.swing.JFileChooser caminho = new javax.swing.JFileChooser();
       int returnVal = caminho.showOpenDialog(null);
       try{
       if( returnVal  == javax.swing.JFileChooser.APPROVE_OPTION )
       {
           File arq = caminho.getSelectedFile();
           BufferedReader buffer = new BufferedReader( new FileReader(arq) );
           String linha = buffer.readLine();

           if(linha != null)
              this.cxFonte.setText( linha );

           linha = buffer.readLine();

           while(linha != null)
           {
            this.cxFonte.setText( this.cxFonte.getText() + "\n" + linha );
            linha = buffer.readLine();
           }
           buffer.close();
        }
       }
       catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao Abrir o Arquivo","Arquivo",JOptionPane.ERROR_MESSAGE);
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /** Salva o codigo do campo texto em um arquivo

     /possui uma variavel de evento
     /ao possui retorno
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        javax.swing.filechooser.FileNameExtensionFilter filter = new javax.swing.filechooser.FileNameExtensionFilter("MIPS_PMS (*.asm)", "asm");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(null);
        if(returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
           File record = new File(chooser.getSelectedFile() + ".asm");
           try
           {
             PrintWriter pWriter = new PrintWriter(new FileWriter(record));
             pWriter.print(this.cxFonte.getText());
             pWriter.close();
           }
           catch(Exception e){
              JOptionPane.showMessageDialog(null,"Erro ao Salvar o Arquivo","Arquivo",JOptionPane.ERROR_MESSAGE);
           }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /** inicializa a execucao da simulacao

     /possui uma variavel de evento
     /ao possui retorno
     */
    private void Play(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Play
        tempo = (Integer) jSpinner1.getValue();
        if(tempo > 0){
            if( load ){
                if( !acao ){
                    //Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pause.jpg")));
                    Play.update(Play.getGraphics());
                    acao = true;
                    //tempo = (Integer) jSpinner1.getValue();
                    //tempo = Integer.parseInt(jSpinner1.getToolTipText());
                    //jSpinner1.getToolTipText();
                    stop = false;
                    jSpinner1.setEnabled(false);
                    execucao = new Execucao();
                    execucao.start();
                    pausar = false;
                }
                /*else{
                    if(pausar == false){
                        Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Play.jpg")));
                        Play.update(Play.getGraphics());
                        pausar = true;
                        //Next.setEnabled(true);
                    }
                    else{
                        Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pause.jpg")));
                        Play.update(Play.getGraphics());
                        //execucao.notifyAll();
                        //Next.setEnabled(false);
                        pausar = false;
                    }
                }*/
            }
            else{
                JOptionPane.showMessageDialog(null,"Código Assembley Não Carregado","Iniciar",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Valor do campo tempo do ciclo de clock inválido","Iniciar",JOptionPane.INFORMATION_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Play

    private void Carregar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Carregar
        load = true;
        // TODO add your handling code here:
    }//GEN-LAST:event_Carregar

    /** Para a execucao de uma simulacao

     /possui uma variavel de evento
     /ao possui retorno
     */
    private void Stop(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Stop
        setStop(true);
        execucao.stop();
        setImagemUm();
        ZeraBancoMemoriaRegistradoresTemporario();
        //cxFonte.setText("");
        load = false;
        cxFonte.setEditable(true);
        Play.setEnabled(false);
        Stop.setEnabled(false);
        //Next.setEnabled(false);
        acao = false;
        load = false;
        pausar = false;
        proximo = false;
        Carregar.setEnabled(true);
        //Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Play.jpg")));
        //Play.update(Play.getGraphics());
        //Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1.jpg")));;;
        //setImagemLayout();
        jSpinner1.setEnabled(true);
        //setImagemUm();
        // TODO add your handling code here:
    }//GEN-LAST:event_Stop

    private void Reg13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reg13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Reg13ActionPerformed

    private void RegistradorPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistradorPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistradorPCActionPerformed

    private void RegistradorInstrucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistradorInstrucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistradorInstrucaoActionPerformed

    private void RegistradorMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistradorMemoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistradorMemoriaActionPerformed

    private void RegistradorAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistradorAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistradorAActionPerformed

    private void RegistradorBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistradorBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistradorBActionPerformed

    private void RegistradorULAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistradorULAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistradorULAActionPerformed

    private void Mem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mem13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Mem13ActionPerformed

    private void Mem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mem43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Mem43ActionPerformed

    private void Mem63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mem63ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Mem63ActionPerformed

    private void Mem93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mem93ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Mem93ActionPerformed

    private void Mem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mem12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Mem12ActionPerformed

    private void Mem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mem31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Mem31ActionPerformed

    private void Reg0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reg0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Reg0ActionPerformed

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Carregar;
    private javax.swing.JLabel Imagem;
    private javax.swing.JTextField Mem0;
    private javax.swing.JTextField Mem1;
    private javax.swing.JTextField Mem10;
    private javax.swing.JTextField Mem11;
    private javax.swing.JTextField Mem12;
    private javax.swing.JTextField Mem13;
    private javax.swing.JTextField Mem14;
    private javax.swing.JTextField Mem15;
    private javax.swing.JTextField Mem16;
    private javax.swing.JTextField Mem17;
    private javax.swing.JTextField Mem18;
    private javax.swing.JTextField Mem19;
    private javax.swing.JTextField Mem2;
    private javax.swing.JTextField Mem20;
    private javax.swing.JTextField Mem21;
    private javax.swing.JTextField Mem22;
    private javax.swing.JTextField Mem23;
    private javax.swing.JTextField Mem24;
    private javax.swing.JTextField Mem25;
    private javax.swing.JTextField Mem26;
    private javax.swing.JTextField Mem27;
    private javax.swing.JTextField Mem28;
    private javax.swing.JTextField Mem29;
    private javax.swing.JTextField Mem3;
    private javax.swing.JTextField Mem30;
    private javax.swing.JTextField Mem31;
    private javax.swing.JTextField Mem32;
    private javax.swing.JTextField Mem33;
    private javax.swing.JTextField Mem34;
    private javax.swing.JTextField Mem35;
    private javax.swing.JTextField Mem36;
    private javax.swing.JTextField Mem37;
    private javax.swing.JTextField Mem38;
    private javax.swing.JTextField Mem39;
    private javax.swing.JTextField Mem4;
    private javax.swing.JTextField Mem40;
    private javax.swing.JTextField Mem41;
    private javax.swing.JTextField Mem42;
    private javax.swing.JTextField Mem43;
    private javax.swing.JTextField Mem44;
    private javax.swing.JTextField Mem45;
    private javax.swing.JTextField Mem46;
    private javax.swing.JTextField Mem47;
    private javax.swing.JTextField Mem48;
    private javax.swing.JTextField Mem49;
    private javax.swing.JTextField Mem5;
    private javax.swing.JTextField Mem50;
    private javax.swing.JTextField Mem51;
    private javax.swing.JTextField Mem52;
    private javax.swing.JTextField Mem53;
    private javax.swing.JTextField Mem54;
    private javax.swing.JTextField Mem55;
    private javax.swing.JTextField Mem56;
    private javax.swing.JTextField Mem57;
    private javax.swing.JTextField Mem58;
    private javax.swing.JTextField Mem59;
    private javax.swing.JTextField Mem6;
    private javax.swing.JTextField Mem60;
    private javax.swing.JTextField Mem61;
    private javax.swing.JTextField Mem62;
    private javax.swing.JTextField Mem63;
    private javax.swing.JTextField Mem64;
    private javax.swing.JTextField Mem65;
    private javax.swing.JTextField Mem66;
    private javax.swing.JTextField Mem67;
    private javax.swing.JTextField Mem68;
    private javax.swing.JTextField Mem69;
    private javax.swing.JTextField Mem7;
    private javax.swing.JTextField Mem70;
    private javax.swing.JTextField Mem71;
    private javax.swing.JTextField Mem72;
    private javax.swing.JTextField Mem73;
    private javax.swing.JTextField Mem74;
    private javax.swing.JTextField Mem75;
    private javax.swing.JTextField Mem76;
    private javax.swing.JTextField Mem77;
    private javax.swing.JTextField Mem78;
    private javax.swing.JTextField Mem79;
    private javax.swing.JTextField Mem8;
    private javax.swing.JTextField Mem80;
    private javax.swing.JTextField Mem81;
    private javax.swing.JTextField Mem82;
    private javax.swing.JTextField Mem83;
    private javax.swing.JTextField Mem84;
    private javax.swing.JTextField Mem85;
    private javax.swing.JTextField Mem86;
    private javax.swing.JTextField Mem87;
    private javax.swing.JTextField Mem88;
    private javax.swing.JTextField Mem89;
    private javax.swing.JTextField Mem9;
    private javax.swing.JTextField Mem90;
    private javax.swing.JTextField Mem91;
    private javax.swing.JTextField Mem92;
    private javax.swing.JTextField Mem93;
    private javax.swing.JTextField Mem94;
    private javax.swing.JTextField Mem95;
    private javax.swing.JTextField Mem96;
    private javax.swing.JTextField Mem97;
    private javax.swing.JTextField Mem98;
    private javax.swing.JTextField Mem99;
    private javax.swing.JButton Play;
    private javax.swing.JTextField Reg0;
    private javax.swing.JTextField Reg1;
    private javax.swing.JTextField Reg10;
    private javax.swing.JTextField Reg11;
    private javax.swing.JTextField Reg12;
    private javax.swing.JTextField Reg13;
    private javax.swing.JTextField Reg14;
    private javax.swing.JTextField Reg15;
    private javax.swing.JTextField Reg16;
    private javax.swing.JTextField Reg17;
    private javax.swing.JTextField Reg18;
    private javax.swing.JTextField Reg19;
    private javax.swing.JTextField Reg2;
    private javax.swing.JTextField Reg20;
    private javax.swing.JTextField Reg21;
    private javax.swing.JTextField Reg22;
    private javax.swing.JTextField Reg23;
    private javax.swing.JTextField Reg24;
    private javax.swing.JTextField Reg25;
    private javax.swing.JTextField Reg26;
    private javax.swing.JTextField Reg27;
    private javax.swing.JTextField Reg28;
    private javax.swing.JTextField Reg29;
    private javax.swing.JTextField Reg3;
    private javax.swing.JTextField Reg30;
    private javax.swing.JTextField Reg31;
    private javax.swing.JTextField Reg4;
    private javax.swing.JTextField Reg5;
    private javax.swing.JTextField Reg6;
    private javax.swing.JTextField Reg7;
    private javax.swing.JTextField Reg8;
    private javax.swing.JTextField Reg9;
    private javax.swing.JTextField RegistradorA;
    private javax.swing.JTextField RegistradorB;
    private javax.swing.JTextField RegistradorInstrucao;
    private javax.swing.JTextField RegistradorMemoria;
    private javax.swing.JTextField RegistradorPC;
    private javax.swing.JTextField RegistradorULA;
    private javax.swing.JButton Stop;
    private javax.swing.JTextPane cxFonte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JMenuItem menuClose5;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Interface Interface = null;
                Interface = Interface.getInstanciaInterface();
                Interface.setVisible(true);
            }
        });
    }
}
