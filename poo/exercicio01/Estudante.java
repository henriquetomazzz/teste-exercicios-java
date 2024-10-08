/*Crie uma classe Estudante com atributos para nome, matrícula e três notas. Implemente métodos para calcular a média
das notas e determinar se o aluno foi aprovado ou reprovado, considerando que a média para ser aprovado é 70. Crie objetos
 studante e imprima informações dos objetos.

A classe Estudante deve possuir o construtor Estudante(String nome, int matricula, double n1, double n2, double n3)
A classe Estudante deve possuir o método double getMedia() que retorna o cálculo da média das notas do estudante
A classe Estudante deve possuir um método void setNotas(double n1, double n2, double n3) para definir as três notas de uma
vez
A classe Estudante deve possuir métodos double getNota1(), double getNota2() e double getNota3()
Crie uma exceção NotaInvalidaException, que deve ser lançada quando uma nota negativa é passada para os métodos que recebem
nota
Crie um caso de teste para testar o método double getMedia()
Crie um caso de teste para testar os métodos void setNotas(double n1, double n2, double n3), double getNota1(), double
getNota2() e double getNota3()*/
package exercicio01;
class NotaInvalidaException extends Exception {
    public NotaInvalidaException(String message) {
        super(message);
    }
}

class Estudante {
    private String nome;
    private int matricula;
    private double nota1;
    private double nota2;
    private double nota3;

    public Estudante(String nome, int matricula, double n1, double n2, double n3) throws NotaInvalidaException {
        this.nome = nome;
        this.matricula = matricula;
        setNotas(n1, n2, n3);
    }

    public void setNotas(double n1, double n2, double n3) throws NotaInvalidaException {
        if (n1 < 0 || n2 < 0 || n3 < 0) {
            throw new NotaInvalidaException("Nota não pode ser negativa.");
        }
        this.nota1 = n1;
        this.nota2 = n2;
        this.nota3 = n3;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public double getMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }

    public boolean isAprovado() {
        return getMedia() >= 70;
    }

    public void imprimirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Nota 3: " + nota3);
        System.out.println("Média: " + getMedia());
        System.out.println(isAprovado() ? "Status: Aprovado" : "Status: Reprovado");
    }
}

public class TesteEstudante {
    public static void main(String[] args) {
        try {
            Estudante est1 = new Estudante("João", 12345, 85, 75, 90);
            est1.imprimirInfo();

            System.out.println("\nTeste de média:");
            System.out.println("Média esperada: " + est1.getMedia());

            System.out.println("\nTeste de notas:");
            System.out.println("Nota 1: " + est1.getNota1());
            System.out.println("Nota 2: " + est1.getNota2());
            System.out.println("Nota 3: " + est1.getNota3());

            // Teste de alteração de notas válidas
            System.out.println("\nAlterando notas...");
            est1.setNotas(65, 70, 80);
            est1.imprimirInfo();

            System.out.println("\nTentativa de atribuir nota negativa:");
            est1.setNotas(50, -10, 70);

        } catch (NotaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
