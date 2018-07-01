package com.java.designpattern.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {

	public double data ;
	public Singleton pointer ;
	
	private Singleton(double data, Singleton pointer) {
		this.data = data;
		this.pointer = pointer;
		System.out.println(this.toString());
	}
	
	public static Singleton getInstance() {
		return SingletonHelper.INSTANCE ;
	}
	
	private static class SingletonHelper{
		private static Singleton INSTANCE = new Singleton(Math.random(), new Singleton(Math.random(), null));
	}

	@Override
	public String toString() {
		return super.toString() +" Singleton [data=" + data + "]";
	}
	
	// with this method it gives same object on Serialization and Deserialization.
	protected Object readResolve() {
	    return getInstance(); 
	}	
	// important :
	/* readResolver is used to enforce singletons, when an object is read, replace it with the object received from getInstance() method.
	 * 
	 * This ensures that nobody can create another instance by serializing and deserializing the singleton.
	*/
}
