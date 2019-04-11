import java.net.MalformedURLException;
import java.rmi.*;
import java.util.*;

public class ExampleClient {
  public static void main(String[] args) {
    try {
      Example example = (Example) Naming.lookup("rmi://localhost/Example");
      example.setString("sucesso");
      System.out.println(example.getString());

      example.initMoedas();
      ArrayList<Moeda> moedasRegistradas = example.getMoedas();

      for(int i=0; i< moedasRegistradas.size(); i++) {
        System.out.println("moeda: " + moedasRegistradas.get(i).getNome() + "cotacao: " + moedasRegistradas.get(i).getCotacao());
      }

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (NotBoundException e) {
      e.printStackTrace();
    }
  }
}
