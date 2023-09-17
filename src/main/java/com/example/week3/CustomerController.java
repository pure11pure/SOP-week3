package com.example.week3;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class CustomerController {

    public CustomerController() {
        customers = new ArrayList<>();
        customers.add(new Customer("1010", "John", true, 25));
        customers.add(new Customer("1018", "Peter", true, 24));
        customers.add(new Customer("1019", "Sara", false, 23));
        customers.add(new Customer("1110", "Rose", false, 23));
        customers.add(new Customer("1001", "Emma", false, 30));
    }

    //attribute
    private List<Customer> customers;

    //method
    @RequestMapping(value = "/customers")
    public List<Customer> getCustomers(){
        return this.customers;
    }

    @RequestMapping(value = "/customerbyid/{id}")
    public Customer getCustomerByID(@PathVariable("id") String id){
        //'.size()' เป็นเมธอดที่ใช้ในการหาขนาดของคอลเล็กชัน
        for(int i = 0; i < this.customers.size(); i++){
            if(this.customers.get(i).getID().equals(id)){
                return this.customers.get(i);
                //.get(i) -> เข้าถึงข้อมูลในลิสต์ที่ตำแหน่ง i
                //.getID() -> การเรียก method
            }
        }
        return null;
    }

    @RequestMapping(value = "/customerbyname/{n}")
    public Customer getCustomerByName(@PathVariable("n") String name){
        //'.size()' เป็นเมธอดที่ใช้ในการหาขนาดของคอลเล็กชัน
        for(int i = 0; i < this.customers.size(); i++){
            if(this.customers.get(i).getName().equals(name)){
                return this.customers.get(i);
                //.get(i) -> เข้าถึงข้อมูลในลิสต์ที่ตำแหน่ง i
                //.getID() -> การเรียก method
            }
        }
        return null;
    }
//    public boolean getCustomerByID(){
//
//    }
//    public boolean getCustomerByName(){
//
//    }


    @RequestMapping(value = "/customerDelByID/{id}", method = RequestMethod.DELETE)
    public boolean delCustomerByID(@PathVariable("id") String id){
        //'.size()' เป็นเมธอดที่ใช้ในการหาขนาดของคอลเล็กชัน
        for(int i = 0; i < this.customers.size(); i++){
            if(this.customers.get(i).getID().equals(id)){
                this.customers.remove(i);
                return true;
                //.get(i) -> เข้าถึงข้อมูลในลิสต์ที่ตำแหน่ง i
                //.getID() -> การเรียก method
            }
        }
        return false;
    }

    @RequestMapping(value = "/customerDelByname/{n}", method = RequestMethod.DELETE)
    public boolean delCustomerByName(@PathVariable("n") String name){
        //'.size()' เป็นเมธอดที่ใช้ในการหาขนาดของคอลเล็กชัน
        for(int i = 0; i < this.customers.size(); i++){
            if(this.customers.get(i).getName().equals(name)){
                this.customers.remove(i);
                return true;
                //.get(i) -> เข้าถึงข้อมูลในลิสต์ที่ตำแหน่ง i
                //.getID() -> การเรียก method
            }
        }
        return false;
    }


    @RequestMapping(value = "/addCustomer" , method = RequestMethod.GET)
    public boolean addCustomer(@RequestParam("id") String ID,@RequestParam("n") String n,@RequestParam("s") String s,@RequestParam("a") int a){
        int beforeNum = this.customers.size();
        this.customers.add(new Customer(ID, n, s.toLowerCase().equals("male"), a));
        if(this.customers.size() == beforeNum){
            return false;
        }
        return true;
        }

    @RequestMapping(value = "/addCustomer2" , method = RequestMethod.POST)
    public boolean addCustomer2(@RequestParam("id") String ID,@RequestParam("n") String n,@RequestParam("s") String s,@RequestParam("a") int a){
        int beforeNum = this.customers.size();
        this.customers.add(new Customer(ID, n, s.toLowerCase().equals("male"), a));
        if(this.customers.size() == beforeNum){
            return false;
        }
        return true;
    }

}
