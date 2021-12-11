package dmacc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import dmacc.beans.BookNew;
import dmacc.beans.HaveReadList;

class haveReadTests {

	@Test
	void testAddHaveRead() {
		//declare necessary objects
		HaveReadList hr = new HaveReadList();
		LinkedList<BookNew> listToCompare = new LinkedList<BookNew>();
		BookNew book = new BookNew("The Selection", "Kiera Cass", 5);
				
		//add book to lists
		listToCompare.add(book);
		hr.addHaveRead(book);
				
		//assert
		assertEquals(hr.getHaveRead(), listToCompare);
	}//end testAddHaveRead

	@Test
	void testRemoveBook() {
		//declare necessary objects
		HaveReadList hr = new HaveReadList();
		LinkedList<BookNew> listToCompare = new LinkedList<BookNew>();
		BookNew book = new BookNew("The Selection", "Kiera Cass", 5);
		BookNew book2 = new BookNew("Divergent", "Veronica Roth", 6);
				
		//add book to lists
		listToCompare.add(book2);
				
		hr.addHaveRead(book);
		hr.addHaveRead(book2);
				
		hr.removeBook(book);
						
		//assert
		assertEquals(hr.getHaveRead(), listToCompare);
	}//end testRemoveBook

	@Test
	void testFindBook() {
		//declare necessary objects
		HaveReadList hr = new HaveReadList();
		BookNew book = new BookNew("The Selection", "Kiera Cass", 5);
		BookNew book2 = new BookNew("Divergent", "Veronica Roth", 6);
		BookNew book3 = new BookNew("Princess Diaries", "Meg Cabot", 1);
				
		//add books to list				
		hr.addHaveRead(book);
		hr.addHaveRead(book2);
		hr.addHaveRead(book3);
						
		//assert
		assertEquals(hr.findBook("Divergent"), book2);
	}//end testFindBook

}//end haveReadTests
