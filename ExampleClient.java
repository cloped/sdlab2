import java.net.MalformedURLException;
import java.rmi.*;
import java.util.*;

public class ExampleClient {
  public static void main(String[] args) {
    try {
      Example example = (Example) Naming.lookup("rmi://localhost/Example");
      ArrayList<Moeda> moedasRegistradas = example.getMoedas();
      
      // Iniciaolizando se precisar
      if(moedasRegistradas.size() == 0) {
        example.initMoedas();
      }
      moedasRegistradas = example.getMoedas();

      // Adicionando uma moeda aqui 
      example.adicionaMoeda("Amauri", 99999.001);
      moedasRegistradas = example.getMoedas(); // tem que fazer isso pq ele não dá o get do atualizado


      // Mostrando as moedas
      for(int i=0; i< moedasRegistradas.size(); i++) {
        System.out.println("moeda: " + moedasRegistradas.get(i).getNome() + " cotacao: " + moedasRegistradas.get(i).getCotacao());
      }
      System.out.println("----------------------------------");


      // Editando a cotacao do dola aqui
      example.mudaCotacao("dolar", 123.1);
      moedasRegistradas = example.getMoedas(); // tem que fazer isso pq ele não dá o get do atualizado

      // removendoo real daqui
      example.removeMoeda("real");
      moedasRegistradas = example.getMoedas(); // tem que fazer isso pq ele não dá o get do atualizado

      // Mostrando as moedas
      for(int i=0; i< moedasRegistradas.size(); i++) {
        System.out.println("moeda: " + moedasRegistradas.get(i).getNome() + " cotacao: " + moedasRegistradas.get(i).getCotacao());
      }
      System.out.println("----------------------------------");

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (NotBoundException e) {
      e.printStackTrace();
    }
  }
}
