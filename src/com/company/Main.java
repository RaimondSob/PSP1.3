package com.company;

import Entity.User;
import Repositories.UserRepository;
import Services.UserService;
import validation.PasswordPolicy;
import validation.Validation;

public class Main {

    public static void main(String[] args) {
/*        var val = new Validation();
        var pol = new PasswordPolicy();
        pol.setSpecialSymbols("#");
        pol.requireUppercase(false);
        pol.setMinLength(3);
        pol.requireSpecialSymbols(false);
        int[] al = val.checkPassword("gjfdljgldj",pol);
        int[] al1 = val.checkPassword("adssAd#",pol);

        System.out.println(al.length);
        System.out.println(al1.length);*/
        var test = new UserService();
        var test2 = new UserRepository();
        //test2.ReadFromFile();
        var testusr = new User();
        testusr.setPassword("asd");
        testusr.setAddress("asd");
        testusr.setNumber("865555555");
        testusr.setEmail("asd@asd.com");
        testusr.setName("asd");
        testusr.setSurname("asd");
        testusr.setId(1);
        test2.Add(testusr);
        //var usr = test.CreateUser(testusr);

        test2.CloseAndSave();
        System.out.println(testusr);
    }
}
