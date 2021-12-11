package dmacc.beans;
import java.util.Stack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HaveReadList {
	//declare attributes
	@Id
	@GeneratedValue
	private long id;
	private Stack<BookNew> haveRead;

	public HaveReadList() {
		haveRead = new Stack<BookNew>();
	}//end default constructor

	public Stack<BookNew> getHaveRead() {
		return haveRead;
	}//end getHaveRead

	public void setHaveRead(Stack<BookNew> haveRead) {
		this.haveRead = haveRead;
	}//end setHaveRead

	public void addHaveRead(BookNew toAdd) {
		haveRead.add(toAdd);
	}//end addHaveRead
	
	public void removeBook(BookNew toDelete) {
		haveRead.remove(toDelete);
	}//end removeBook
	
	public BookNew findBook(String title) {
		//declare new book
		BookNew toCheck = null;
		
		//find book
		for (int i = 0; i < haveRead.size(); i++) {
			toCheck = haveRead.get(i);
			if (toCheck.getTitle().equals(title)) {
				break;
			}//end if
		}//end for
		
		//return book
		return toCheck;
	}//end findBook
	
	@Override
	public String toString() {
		return "HaveReadList [haveRead=" + haveRead + "]";
	}//end toString
	
}//end HaveReadList
