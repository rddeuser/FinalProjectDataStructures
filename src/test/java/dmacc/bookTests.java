package dmacc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dmacc.beans.BookNew;

class bookTests {

	@Test
	void testCompareTitle() {
		//declare objects and variables
		BookNew book1 = new BookNew("Divergent");
		BookNew book2 = new BookNew("Insurgent");
		int differenceInLetters = -5;
		
		//assert 
		assertEquals(book1.compareTitle(book2), differenceInLetters);
	}//end testCompareTitle

	@Test
	void testCompareAuthor() {
		//declare objects and variables
		BookNew book1 = new BookNew("Only the Good Spy Young", "Ally Carter");
		BookNew book2 = new BookNew("Princess Diaries", "Meg Cabot");
		int differenceInLetters = -12;
		
		//assert 
		assertEquals(book1.compareAuthor(book2), differenceInLetters);
	}//end testCompareAuthor

	@Test
	void testCompareRating() {
		//declare objects and variables
		BookNew book1 = new BookNew("Only the Good Spy Young", "Ally Carter", 9);
		BookNew book2 = new BookNew("Princess Diaries", "Meg Cabot", 5);
		int difference = 4;
		
		//assert 
		assertEquals(book1.compareRating(book2), difference);
	}//end testCompareRating

}//end bookTests
