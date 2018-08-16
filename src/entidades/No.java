/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author felipe
 */
public class No {
    private int elemento;
    No pai, fiDireito, fiEsquerdo;
    
    public No (int s){
        elemento = s;
        fiDireito = null;
        fiEsquerdo = null;
    }
    public No (int s, No pai){
        this.pai = pai;
        elemento = s;
        fiDireito = null;
        fiEsquerdo = null;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getFiDireito() {
        return fiDireito;
    }

    public void setFiDireito(No fiDireito) {
        this.fiDireito = fiDireito;
    }

    public No getFiEsquerdo() {
        return fiEsquerdo;
    }

    public void setFiEsquerdo(No fiEsquerdo) {
        this.fiEsquerdo = fiEsquerdo;
    }
    
    
}
