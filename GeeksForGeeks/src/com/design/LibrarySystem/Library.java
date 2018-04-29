package com.design.LibrarySystem;

import java.util.LinkedList;

public class Library {
	LinkedList<Book> holdings = new LinkedList<Book>();

	// constructor
	Library() {
	}

	// add a new book to the library
	Library addBook(Book newBook) {
		holdings.add(newBook);
		return this;
	}

	// find a book by its title
	// assumes the title is in the library
	// (unrealistic, but what we know how to do so far)
	Book findByTitle(String atitle) {
		for (Book item : holdings) {
			if (item.title.equals(atitle)) {
				return item;
			}
		}
		// the compiler needs to return something if the book
		// isn't found. We can use null for this (we really
		// should handle the error explicitly, but we haven't
		// covered how to do that yet).
		return null;
	}
}
