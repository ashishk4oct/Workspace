package com.java.basics.singleton;


/*
 * Notice the private inner static class that contains the instance of the singleton class. 
 * When the singleton class is loaded, SingletonHelper class is not loaded into memory and
 * only when someone calls the getInstance method, this class gets loaded and creates the Singleton class instance.
 * 
 * 
 * This is the most widely used approach for Singleton class as it doesn’t require synchronization.
*/
public class MySingletonNew {

	private static class SingletonHelper{
		private static final MySingletonNew INSTANCE = new MySingletonNew();
	}
	
	public static MySingletonNew getInstance() {
		return SingletonHelper.INSTANCE;
	}
}


