/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.No;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public interface IArvoreBinariaBusca {
    int size();
    int height(No n);
    boolean isEmpty();
    ArrayList<Object> elements(No n);
    ArrayList<No> nos(No n);
    
    No root();
    No parent(No n);
    ArrayList<No> children(No n);
    
    boolean isInternal(No n);
    boolean isExternal(No n);
    boolean isRoot(No n);
    int depth(No n);
    
    Object replace(No n, Object o);
    
    No leftChild(No n);
    No rightChild(No n);
    boolean hasLeft(No n);
    boolean hasRight(No n);
    
    
}
