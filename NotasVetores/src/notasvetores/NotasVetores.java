package notasvetores;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class NotasVetores {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        //Criacao de variaveis
        int    qtdAlunos = 0;
        double contNotas = 0;
        
        //Entrada de dados qtd alunos
        System.out.println("Informe a quantidade de alunos: ");
        qtdAlunos = sc.nextInt();
        
        //Criacao dos arrays com a qtd de alunos informados
        String[]   arrayAluno    = new String [qtdAlunos];
        double[][] arrayNotas    = new double [qtdAlunos][4];
        double[]   arrayMedias   = new double [qtdAlunos];
        String[]   arraySituacao = new String [qtdAlunos];
        
        //laco de repeticao para pedir o nome dos alunos
        for (int Alunos = 0; Alunos < qtdAlunos; Alunos++) {
            System.out.println("Informe o nome do aluno " + (Alunos + 1) + ": ");
            arrayAluno[Alunos] = sc.next();
            
            //Zerando o contador das notas
            contNotas = 0;
            
            //Laco de repeticao para coletar as notas de cada aluno
            for (int nota = 0; nota < 4; nota++) {
                System.out.println("Informe a nota " + (nota + 1 ) + " de " + arrayAluno[Alunos] + ": ");
                arrayNotas[Alunos][nota] = sc.nextDouble();
                
                //Contador das notas de cada aluno
                contNotas = contNotas + arrayNotas[Alunos][nota];
            }
            
            //fazendo a media de cada aluno
            arrayMedias[Alunos] = contNotas/4;
            
            //Comando condicional para verificar a situacao do aluno
            if (arrayMedias[Alunos] < 5.5) {
                 arraySituacao[Alunos] = ("Reprovado");
            } 
                else if(arrayMedias[Alunos] >= 5.5 && arrayMedias[Alunos] < 7.49){
                        arraySituacao[Alunos] = ("Em PPE");
                }
                    else{
                        arraySituacao[Alunos] = ("Aprovado!!");
                    }
        }
        
        //Limpando a entrada dos dados para apenas mostrar a saida
        limparSaida();
        
        //Laco de repeticao para mostrar a saida dos dados
        for (int i = 0; i < qtdAlunos; i++) {
            System.out.println("Aluno: " + arrayAluno[i]);
            for (int j = 0; j < 4; j++) {
            System.out.println("Notas: " + arrayNotas[i][j] );
            }
            System.out.println("\nMedia: " + arrayMedias[i]);
            System.out.println("Situacao: " + arraySituacao[i]);
            System.out.println("__________________________\n");
        }
    }
    
            /*
            Função que limpa o Output do Netbeans
            */
            public final static void limparSaida() {
                try {
                    Robot robot = new Robot();
                    robot.setAutoDelay(10);
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_L);
                    robot.keyRelease(KeyEvent.VK_CONTROL);
                    robot.keyRelease(KeyEvent.VK_L);
                } catch (AWTException ex) {
                }
            }
}