import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class ExampleServer extends UnicastRemoteObject implements Example {
  private String stringState;
  private ArrayList<Moeda> moedasRegistradas = new ArrayList<Moeda>();

  public ExampleServer() throws RemoteException{};

  public void setString(String s) throws RemoteException {
    this.stringState = s;
    System.out.println("Setando a variavel do objeto para:" + s);
  }

  public String getString() throws RemoteException {
    return "getstring: " + this.stringState;
  }

  public ArrayList<Moeda> getMoedas() throws RemoteException {
    return moedasRegistradas;
  }

  public void initMoedas() throws RemoteException {
    Moeda real = new Moeda("real", 2.01);
    Moeda dolar = new Moeda("dolar", 3.99);

    moedasRegistradas.add(real);
    moedasRegistradas.add(dolar);
  }
}
