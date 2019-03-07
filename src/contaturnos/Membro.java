/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaturnos;

/**
 *
 * @author jpgiandoso
 */
public class Membro implements Comparable<Membro> {

    String nome;
    int iniciativa;
    int CA;
    int hp;
    String efeitos;

    public Membro(){
        
    }

    public int getCA() {
        return CA;
    }

    public void setCA(int CA) {
        this.CA = CA;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getEfeitos() {
        return efeitos;
    }

    public void setEfeitos(String efeitos) {
        this.efeitos = efeitos;
    }

    public Membro(String nome, int iniciativa) {
        this.iniciativa = iniciativa;
        this.nome = nome;
    }
    
    public Membro(String nome, int iniciativa, int CA, int vida) {
        this.iniciativa = iniciativa;
        this.nome = nome;
        this.CA = CA;
        this.hp = vida;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }

    @Override
    public int compareTo(Membro o) {
        if (this.iniciativa > o.getIniciativa()) {
            return -1;
        }
        if (this.iniciativa < o.getIniciativa()) {
            return 1;
        }
        return 0;
    }

}
