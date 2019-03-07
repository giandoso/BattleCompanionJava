/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaturnos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jpgiandoso
 */
public class DAO_Contador {

    public List<Membro> getList() {
        Collections.sort(Dados.l);
        return Dados.l;
    }

    public boolean salvar(Membro m) {
        int index = 0;
        for (Membro i : Dados.l) {
            if (i.getNome().equals(m.getNome())) {
                Dados.l.remove(i);
                Dados.l.add(m);
                break;
            }
            index++;
        }
        if (index == Dados.l.size()) {
            Dados.l.add(m);
        }
        return true;
    }
    
    public void setName(int index, String name){
        int i = 0;
        for (Membro m : Dados.l) {
            if(index == i){
                m.setNome(name);
            }else{
                i++;
            }       
        }
    }
    
    public void remover(int index){
        Dados.l.remove(index);
        System.out.println("Removido index :" + index);
    }

    public void dumpIn(String fileName) throws FileNotFoundException, IOException {
        FileReader scanner = new FileReader(fileName);
        BufferedReader file = new BufferedReader(scanner);
        int qtdMembros = Integer.parseInt(file.readLine());
        for (int i = 0; i < Dados.l.size(); i++) {
            Dados.l.remove(i);
        }
        for (int i = 0; i < qtdMembros; i++) {
            Membro m = new Membro();
            m.setNome(file.readLine());
            m.setIniciativa(Integer.parseInt(file.readLine()));
            m.setCA(Integer.parseInt(file.readLine()));
            m.setHp(Integer.parseInt(file.readLine()));
            Dados.l.add(m);
        }
        file.close();
    }

    public void dumpOut(String fileName) throws IOException {
        FileWriter file;
        file = new FileWriter(new File(fileName));
//        file.write(Dados.l.size() + "\r\n");
        file.write(Dados.l.size() + "\n");
        for (Membro i : Dados.l) {
//            file.write(i.nome + "\r\n");
            file.write(i.nome + "\n");
            file.flush();
//            file.write(String.valueOf(i.iniciativa) + "\r\n");
            file.write(String.valueOf(i.iniciativa) + "\n");
            file.flush();
//            file.write(String.valueOf(i.CA) + "\r\n");
            file.write(String.valueOf(i.CA) + "\n");
            file.flush();
//            file.write(String.valueOf(i.CA) + "\r\n");
            file.write(String.valueOf(i.hp) + "\n");
            file.flush();
            // como identificar campo efeitos?
        }
        file.close();
    }

}
