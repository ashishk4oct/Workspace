package com.design.LibrarySystem;

public class Book {
	String title;
	String callNum;
	int timesOut = 0;
	boolean isAvailable = true;

	// constructor
	Book(String title, String callNum) {
		this.title = title;
		this.callNum = callNum;
	}

	// mark a book as checked out of the library
	public Book checkOut() {
		this.isAvailable = false;
		this.timesOut = this.timesOut + 1;
		return this;
	}

	// mark a book as checked in at the library
	public Book checkIn() {
		this.isAvailable = true;
		return this;
	}
}