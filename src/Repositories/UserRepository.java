package Repositories;

import Entity.User;

import java.io.*;
import java.util.*;

public class UserRepository {

    ArrayList<User> _users = new ArrayList<User>();
    public void ReadFromFile()
    {
        try
        {
            FileInputStream fis = new FileInputStream("users.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            _users = (ArrayList<User>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }

    public User GetById(Integer id)
    {
        for(User user : _users) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    public boolean DeleteById(Integer id)
    {
        for(User user : _users) {
            if(user.getId().equals(id)) {
                _users.remove(user.getId());
                return true;
            }
        }
        return false;
    }
    public boolean UpdateById(Integer id,User updatedUser)
    {
        for(User user : _users) {
            if(user.getId().equals(id)) {
                _users.remove(user.getId());
                _users.add(updatedUser);
                return true;
            }
        }
        return false;
    }

    public void Add (User user)
    {
        _users.add(user);
    }
    public void CloseAndSave()
    {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            fout = new FileOutputStream("users.txt");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(_users);
            fout.close();
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public int GenerateId()
    {
        if(_users.isEmpty())
        {
            return 0;
        }
        var user = _users.get(_users.size() -1);
        var newId = user.Id + 1;
        return newId;
    }
}
