package principal;
import entidades.*;

/**
 * @author 20161014040004
 */
public class Main {
    
    public static void main(String[] args){
        
        BTS bts = new BTS();
        bts.inserir(6);
        bts.inserir(9);
        bts.inserir(8);
        bts.inserir(2);
        bts.inserir(4);
        bts.inserir(3);
        bts.inserir(5);
        bts.inserir(1);
        bts.remover(2);
        System.out.println(bts.buscar(3));
        System.out.println(bts.buscar(4));
        bts.Imprimir();
    }
}
