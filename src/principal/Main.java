package principal;
import entidades.*;

/**
 * @author 20161014040004
 */
public class Main {
    
    public static void main(String[] args){
        
        BTS bts = new BTS();
        bts.inserir(1);
        bts.inserir(2);
        System.out.println(bts.buscar(3));
    }
}
