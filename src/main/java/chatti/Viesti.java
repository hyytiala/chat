/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatti;

/**
 *
 * @author hyytiala
 */
public class Viesti {

    private int id;
    private String sisalto;
    private String kayttaja;

    
    public Viesti(int id, String sisalto, String kayt) {
        this.id = id;
        this.sisalto = sisalto;
        this.kayttaja=kayt;
    }

    public int getId() {
        return id;
    }

    public String getSisalto() {
        return sisalto;
    }
    
    public String getKayttaja() {
        return kayttaja;
    }
}
