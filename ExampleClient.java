import java.net.MalformedURLException;
import java.rmi.*;

public class ExampleClient {
  public static void main(String[] args) {
    try {
      Example example = (Example) Naming.lookup("rmi://localhost/Example");
      example.setString("sucesso");
      System.out.println(example.getString());
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (NotBoundException e) {
      e.printStackTrace();
    }
  }
}
