/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.beans;

/**
 *
 * @author kcuadror
 */
public class CustomerTO {
    private int idCustomer;
    private String surnames;
    private String names;
    private String email;
    private String telephone;
    private double totalPurchases;

    public CustomerTO() {
    }

    public CustomerTO(int idCustomer, String surnames, String names, String email, String telephone, double totalPurchases) {
        this.idCustomer = idCustomer;
        this.surnames = surnames;
        this.names = names;
        this.email = email;
        this.telephone = telephone;
        this.totalPurchases = totalPurchases;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalPurchases() {
        return totalPurchases;
    }

    public void setTotalPurchases(double totalPurchases) {
        this.totalPurchases = totalPurchases;
    }

    @Override
    public String toString() {
        return "CustomerTO{" + "idCustomer=" + idCustomer + ", surnames=" + surnames + ", names=" + names + ", email=" + email + ", telephone=" + telephone + ", totalCompras=" + totalPurchases + '}';
    }
}
