package com.java.concepts;

public interface InterfaceTest {

}

interface Subject{
    void registerObject();
    void deRegisterObject();


}

interface Observer<E extends Object>{
    void update(E e);
}
