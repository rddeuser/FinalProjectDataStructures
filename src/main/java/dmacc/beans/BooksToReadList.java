package dmacc.beans;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author Becca Deuser
 *
 */

@Entity
public class BooksToReadList {
	//declare attributes
	@Id
	@GeneratedValue
	private long id;
	private LinkedList<BookNew> booksToRead;

	public BooksToReadList() {
		booksToRead = new LinkedList<BookNew>();
	}//end BooksToReadList

	public LinkedList<BookNew> getBooksToRead() {
		return booksToRead;
	}//end getBooksToRead

	public void setBooksToRead(LinkedList<BookNew> booksToRead) {
		this.booksToRead = booksToRead;
	}//end setBooksToRead

	public void addBooksToRead(BookNew toAdd) {
		booksToRead.add(toAdd);
	}//end addBooksToRead
	
	public void sortByTitle() {
		//use insertion sort to sort by title
		for (int j = 1; j < booksToRead.size(); j++) {
	        BookNew current = booksToRead.get(j);
	        int i = j-1;
	        while ((i > -1) && ((booksToRead.get(i).compareTitle(current)) > 0)) {
	        	booksToRead.set(i+1, booksToRead.get(i));
	            i--;
	        }//end while
	        
	        booksToRead.set(i+1, current);
	    }//end for
	}//end sortByTitle
	
	public void sortByAuthor() {
		//use insertion sort to sort by author
		for (int j = 1; j < booksToRead.size(); j++) {
	        BookNew current = booksToRead.get(j);
	        int i = j-1;
	        while ((i > -1) && ((booksToRead.get(i).compareAuthor(current)) > 0)) {
	        	booksToRead.set(i+1, booksToRead.get(i));
	            i--;
	        }//end while
	        
	        booksToRead.set(i+1, current);
	    }//end for
	}//end sortByAuthor
	
	public void sortByRating() {
		//use insertion sort to sort by rating
		for (int j = 1; j < booksToRead.size(); j++) {
	        BookNew current = booksToRead.get(j);
	        int i = j-1;
	        while ((i > -1) && ((booksToRead.get(i).compareRating(current)) > 0)) {
	        	booksToRead.set(i+1, booksToRead.get(i));
	            i--;
	        }//end while
	        
	        booksToRead.set(i+1, current);
	    }//end for
	}//end sortByRating
	
	public void removeBook(BookNew toDelete) {
		booksToRead.remove(toDelete);
	}//end removeBook
	
	public BookNew findBook(String title) {
		//declare new book
		BookNew toCheck = null;
		
		//find book
		for (int i = 0; i < booksToRead.size(); i++) {
			toCheck = booksToRead.get(i);
			if (toCheck.getTitle().equals(title)) {
				break;
			}//end if
		}//end for
		
		//return book
		return toCheck;
	}//end findBook
	
	@Override
	public String toString() {
		return "BooksToReadList [booksToRead=" + booksToRead + "]";
	}//end toString
	
}//end BooksToReadList
