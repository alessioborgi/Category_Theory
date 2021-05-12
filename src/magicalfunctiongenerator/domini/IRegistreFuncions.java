package magicalfunctiongenerator.domini;

import java.util.*;

public interface IRegistreFuncions extends IDibuixable
{
    ListIterator getFuncions();
    Funcio get(String nom);
    void add(Funcio f) throws Exception;
    void remove(String funcio) throws Exception;
    boolean comprovarRepetida(Funcio f);
    boolean existeix(Funcio f);
    boolean existeix(String s);
    int size();
    boolean equals(Object o);
    Funcio get(int index);
    int getIndex(String funcio);
}
