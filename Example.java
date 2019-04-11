import java.rmi.*;
import java.util.*;

public interface Example extends Remote {
  public void setString (String s) throws RemoteException;
  public String getString () throws RemoteException;
  public void initMoedas() throws RemoteException;
  public ArrayList<Moeda> getMoedas() throws RemoteException;
  public void adicionaMoeda (String nome, double cotacao) throws RemoteException;
}
