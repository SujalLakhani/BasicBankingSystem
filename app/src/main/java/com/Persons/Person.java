package com.Persons;

public class Person {
    String name,email;
    int id, amount;

    public Person(int id, String name, int amount,String email) {
        this.name = name;
        this.id = id;
        this.amount = amount;
        this.email = email;
    }

    public Person(String name, int amount,String email) {
        this.name = name;
        this.amount = amount;
        this.email = email;
    }

    public Person() {
    }

    public void setName(String name){
        this.name=name;
    }
    public void setAmount(int amount){
        this.amount=amount;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getName(){
        return name;
    }
    public int getAmount(){
        return amount;
    }
    public int getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }

}
