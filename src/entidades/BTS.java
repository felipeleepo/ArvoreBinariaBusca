/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;
/**
 *
 * @author 20161014040004
 */
public class BTS {
    ArvoreBinaria a;
    public BTS(){ a = new ArvoreBinaria(); }

    public void inserir(int e){
        a.Insert(e, a.root());
    }
    
    public String buscar(int e){
        int result = a.Search(e, a.root());
        if(result == -1)
            return "Valor não Encontrado";
        else
            return "Valor contém na Árvore: " + result;
    }
    
    public void remover(int e){
        System.out.println((a.remove(e, a.root())).getElemento());
    }
    
    public void ImprimirEmOrdem() {
        a.printInOrder(a.root());
    }
    
    public void Imprimir(){
        a.printTree(a.root(), false, "");
    }
}
