/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hanif salafi
 */
public class Admin extends User{
    private List<Member> listMember = new ArrayList<>();
    private String idAdmin;

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Admin(String name, String idAdmin) {
        super(name);
        this.idAdmin = idAdmin;
    }
    
    @Override
    public void setName(String name){
        super.setName(name);
    }
    
    public void addMember (Member member){
        listMember.add(member);
    }
    
    public Member getMember(int x) {
        return listMember.get(x);
    }
}
