/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hanif salafi
 */
public class User {
    private String username;
    private String password;
    private String name;
    private String pertanyaanKeamanan;
    private String jawaban;

    public User(String username, String name, String password, String pertanyaanKeamanan, String jawaban) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.pertanyaanKeamanan = pertanyaanKeamanan;
        this.jawaban = jawaban;
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPertanyaanKeamanan() {
        return pertanyaanKeamanan;
    }

    public void setPertanyaanKeamanan(String pertanyaanKeamanan) {
        this.pertanyaanKeamanan = pertanyaanKeamanan;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
}
