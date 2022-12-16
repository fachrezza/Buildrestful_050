/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author A S U S
 */
//membuat class product
public class Product {
    private String id; //mendeklarasikan variabel id dengan tipe data string
    private String nama; //mendeklarasikan variabel nama dengan tipe data string
    private int Price;
    private int disc;
    private int total;


    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getDisc() {
        return disc;
    }

    public void setDisc(int disc) {
        this.disc = disc;
    }

    public int getTotal() {
        return getPrice() - ((getDisc() * getPrice())/100);
    }
    
    public int getPrice() {
        return Price;
    }

    //membuat fungsi untuk memanggil id
    public String getId() {
        return id;
    }
    
    //membuat fungsi untuk menginput id
    public void setId(String id) {
        this.id = id;
    }

    //membuat fungsi untuk memanggil nama
    public String getNama() {
        return nama;
    }

    //membuat fungsi untuk menginput menginput
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setDisc(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

   
}
