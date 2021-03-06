/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import interfaces.IArvoreBinariaBusca;
import static java.lang.Integer.max;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class ArvoreBinaria implements IArvoreBinariaBusca{
    private No raiz;
    private int tamanho;

    public No Insert(int o, No n){
        
        if(isEmpty()){
            raiz = new No(o);
            tamanho++;
            System.out.println("Valor inserido na Raíz " + raiz.getElemento());
            return raiz;
        }
        
        if(n == null){
            n = new No(o);
            tamanho++;
            System.out.println("Valor inserido " + n.getElemento());
        }else if(o < n.getElemento())
            n.fiEsquerdo = Insert(o, n.getFiEsquerdo()); 
        else
            n.fiDireito = Insert(o, n.getFiDireito());
        return n;
    }
    
    public int Search(int o, No n){
        if(isEmpty())
            return -99999;// Exceção
        if(n == null)
            return -1;
        if (o == n.getElemento())
            return n.getElemento();
        else if(o < n.getElemento()){System.out.println("esq");
            return Search(o, n.getFiEsquerdo());}
        else{System.out.println("dir");
            return Search(o, n.getFiDireito());}
    }
    
    public No remove(int o, No n){
        
        if(isEmpty()){
            System.out.println("Arvore Vazia");
            return null;
        }
        
        if(n.getElemento() == o){
            if(n.fiDireito == n.fiEsquerdo)
                return null;
            else if(n.fiEsquerdo == null)
                return n.fiDireito;
            else if(n.fiDireito == null)
                return n.fiEsquerdo;
            else{
                No d, e, aux = null;
                d = n.fiDireito;
                e = n.fiDireito;
                while(e.fiEsquerdo != null){
                    aux = e;
                    e = e.fiEsquerdo;
                }
                n.setElemento(e.getElemento());
                e = null;
                aux.fiEsquerdo = null;
                return n;
            }            
        }else if(n.getElemento() > o){System.out.println("esq"); 
            n.fiEsquerdo = remove(o, n.fiEsquerdo);}
        else{System.out.println("dir");
            n.fiDireito = remove(o, n.fiDireito);}
        return n;
    }
    
    public void printInOrder(No n) {
        if(n != null) {
            printInOrder(n.fiEsquerdo);   
            System.out.println(n.getElemento());
            printInOrder(n.fiDireito);  
        }
    }
    
    private void printNodeValue(No n){
        
        if (n == null) {
            System.out.print("<null>");
        } else {
            System.out.print(n.getElemento());
        }
        System.out.print('\n');
    }
    
    public void printTree(No n, boolean isRight, String indent){
        if (n.fiDireito != null) {
            printTree(n.fiDireito, true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("----- ");
        printNodeValue(n);
        if (n.fiEsquerdo != null) {
            printTree(n.fiEsquerdo, false, indent + (isRight ? " |      " : "        "));
        }
    }
    
    public ArvoreBinaria() {
        raiz = null;
        this.tamanho = 0;
        System.out.println("Árvore Criada");
    }
    
    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public int height(No n) {
        if(isExternal(n))
            return 0;
        else{
            int h = 0;
            for(No x : children(n)){
                h = max(h, height(x));
            }
            return ++h;
        }
    }

    @Override
    public boolean isEmpty() {
        return (tamanho == 0);
    }

    @Override
    public ArrayList<Object> elements(No n) {
        ArrayList<Object> a = new ArrayList();
        if(isInternal(n))
            nos(leftChild(n));
        a.add(n.getElemento());
        if(isInternal(n))
            nos(rightChild(n));
        return a;
    }

    @Override
    public ArrayList<No> nos(No n) {
        ArrayList<No> a = new ArrayList();
        if(isInternal(n))
            nos(leftChild(n));
        a.add(n);
        if(isInternal(n))
            nos(rightChild(n));
        return a;
             
    }

    @Override
    public No root() {
        return raiz;
    }

    @Override
    public No parent(No n) {
        return n.getPai();
    }

    @Override
    public ArrayList< No> children(No n) {
        ArrayList<No> a = new ArrayList();
        a.add(n.getFiEsquerdo());
        a.add(n.getFiDireito());
        return a;
    }

    @Override
    public boolean isInternal(No n) {
        return(hasLeft(n) || hasRight(n));
    }

    @Override
    public boolean isExternal(No n) {
//        return n.getFiDireito() == null && n.getFiEsquerdo() == null;
        return !(hasLeft(n) || hasRight(n));
    }

    @Override
    public boolean isRoot(No n) {
        return (n.getPai() == null);
    }

    @Override
    public int depth(No n) {
        if(isRoot(n))
            return 0;
        return 1 + depth(parent(n));
    }

    @Override
    public Object replace(No n, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public No leftChild(No n) {
        return n.getFiEsquerdo();
    }

    @Override
    public No rightChild(No n) {
        return n.getFiDireito();
    }

    @Override
    public boolean hasLeft(No n) {
        return (leftChild(n) != null);
    }

    @Override
    public boolean hasRight(No n) {
        return (rightChild(n) != null);
    }
    
}
