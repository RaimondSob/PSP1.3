package Entity;


import java.io.Serializable;

public class User implements Serializable {
    public Integer Id;
    public String Name;
    public String Surname;
    public String Number;
    public String Email;
    public String Address;
    public String Password;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer newId) {
        this.Id = newId;
    }
    public String getName() {
        return Name;
    }

    public void setName(String newName) {
        this.Name = newName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String newSurname) {
        this.Surname = newSurname;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String newNumber) {
        this.Number = newNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String newEmail) {
        this.Email = newEmail;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String newAddress) {
        this.Address = newAddress;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String newPassword) {
        this.Password = newPassword;
    }
}
