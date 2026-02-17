/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package alende.psp.chatrmi;

import alende.psp.chatrmi.interfaz.Chat;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author frana
 */
public class PspChatRMI  implements Chat{
private Map<String,Chat> user= new HashMap<>();
    public static void main(String[] args) {
        
        
        try {
            PspChatRMI obj = new PspChatRMI();
            Chat stub=(Chat) UnicastRemoteObject.exportObject(obj, 0);
            

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(1010);
            registry.rebind("Chat", stub);
            

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    
    }

    @Override
    public void receiveMessage(String from, String message) throws RemoteException {

    }

    @Override
    public void sendMessage(String from, String to, String message) throws RemoteException {
        Chat receptor=user.get(to);
        if (receptor==null) {
            System.out.println("Usuario no existente");
            return;
        }
        receptor.receiveMessage(from, message);
    }

    @Override
    public void Register(String name, Chat chat) throws RemoteException {
            user.put(name, chat);
            System.out.println(name);
    }

    @Override
    public List<String> usuarios() throws RemoteException {
       List<String> users= new ArrayList<>();
        for (String string : user.keySet()) {
            users.add(string);
        }
        return users;
       
    }

    @Override
    public void Unregister(String name) throws RemoteException {
            user.remove(name);
        }
}
