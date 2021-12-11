package dmacc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import dmacc.beans.BooksToReadList;
import dmacc.beans.BookNew;

class booksToReadTests {

	@Test
	void testAddBooksToRead() {
		//declare necessary objects
		BooksToReadList btr = new BooksToReadList();
		LinkedList<BookNew> listToCompare = new LinkedList<BookNew>();
		BookNew book = new BookNew("The Selection", "Kiera Cass", 5);
		
		//add book to lists
		listToCompare.add(book);
		btr.addBooksToRead(book);
		
		//assert
		assertEquals(btr.getBooksToRead(), listToCompare);
	}//end testAddBooksToRead

	@Test
	void testSortByTitle() {
		//declare necessary objects
		BooksToReadList btr = new BooksToReadList();
		LinkedList<BookNew> listToCompare = new LinkedList<BookNew>();
		BookNew book = new BookNew("The Selection", "Kiera Cass", 5);
		BookNew book2 = new BookNew("Divergent", "Veronica Roth", 6);
		BookNew book3 = new BookNew("Princess Diaries", "Meg Cabot", 1);
		
		//add books to lists
		listToCompare.add(book2);
		listToCompare.add(book3);
		listToCompare.add(book);
		
		btr.addBooksToRead(book);
		btr.addBooksToRead(book2);
		btr.addBooksToRead(book3);
		
		btr.sortByTitle();
		
		//assert
		assertEquals(btr.getBooksToRead(), listToCompare);
	}//end testSoryByTitle

	@Test
	void testSortByAuthor() {
		//declare necessary objects
		BooksToReadList btr = new BooksToReadList();
		LinkedList<BookNew> listToCompare = new LinkedList<BookNew>();
		BookNew book = new BookNew("The Selection", "Kiera Cass", 5);
		BookNew book2 = new BookNew("Divergent", "Veronica Roth", 6);
		BookNew book3 = new BookNew("Princess Diaries", "Meg Cabot", 1);
				
		//add books to lists
		listToCompare.add(book);
		listToCompare.add(book3);
		listToCompare.add(book2);
				
		btr.addBooksToRead(book);
		btr.addBooksToRead(book2);
		btr.addBooksToRead(book3);
				
		btr.sortByAuthor();
		
		//assert
		assertEquals(btr.getBooksToRead(), listToCompare);
	}//end testSortByAuthor

	@Test
	void testSortByRating() {
		//declare necessary objects
		BooksToReadList btr = new BooksToReadList();
		LinkedList<BookNew> listToCompare = new LinkedList<BookNew>();
		BookNew book = new BookNew("The Selection", "Kiera Cass", 5);
		BookNew book2 = new BookNew("Divergent", "Veronica Roth", 6);
		BookNew book3 = new BookNew("Princess Diaries", "Meg Cabot", 1);
				
		//add books to lists
		listToCompare.add(book3);
		listToCompare.add(book);
		listToCompare.add(book2);
				
		btr.addBooksToRead(book);
		btr.addBooksToRead(book2);
		btr.addBooksToRead(book3);
				
		btr.sortByRating();
		
		//assert
		assertEquals(btr.getBooksToRead(), listToCompare);
	}//end sortByRating

	@Test
	void testRemoveBook() {
		//declare necessary objects
		BooksToReadList btr = new BooksToReadList();
		LinkedList<BookNew> listToCompare = new LinkedList<BookNew>();
		BookNew book = new BookNew("The Selection", "Kiera Cass", 5);
		BookNew book2 = new BookNew("Divergent", "Veronica Roth", 6);
		
		//add book to lists
		listToCompare.add(book2);
		
		btr.addBooksToRead(book);
		btr.addBooksToRead(book2);
		
		btr.removeBook(book);
				
		//assert
		assertEquals(btr.getBooksToRead(), listToCompare);
	}//end testRemoveBook

	@Test
	void testFindBook() {
		//declare necessary objects
		BooksToReadList btr = new BooksToReadList();
		BookNew book = new BookNew("The Selection", "Kiera Cass", 5);
		BookNew book2 = new BookNew("Divergent", "Veronica Roth", 6);
		BookNew book3 = new BookNew("Princess Diaries", "Meg Cabot", 1);
		
		//add books to list				
		btr.addBooksToRead(book);
		btr.addBooksToRead(book2);
		btr.addBooksToRead(book3);
				
		//assert
		assertEquals(btr.findBook("Divergent"), book2);
	}//end testFindBook

}//end booksToReadTests
