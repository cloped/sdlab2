import java.rmi.*;
import java.rmi.server.*;

public class ExampleServer extends UnicastRemoteObject implements Example {
  private String stringState;

  public ExampleServer() throws RemoteException{};

  public void setString(String s) throws RemoteException {
    this.stringState = s;
    System.out.println("Setando a variavel do objeto para:" + s);
  }

  public String getString() throws RemoteException {
    return "getstring: " + this.stringState;
  }
}
