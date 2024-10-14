package cursoemvideo.aula02;

public class Aula02 {
  public static void main(String[] args) {
      Caneta c1 = new Caneta();
      c1.modelo = "Bic";
      c1.cor = "Azul";
      c1.ponta = 0.5f;
      c1.destampar();
      c1.status();
      c1.rabiscar();

      Caneta c2 = new Caneta();
      c2.modelo = "Arco-Iris";
      c2.cor = "Vermelho";
      c2.ponta = 2.0f;
      c2.tampar();
      c2.status();
      c2.rabiscar();

  }
}
