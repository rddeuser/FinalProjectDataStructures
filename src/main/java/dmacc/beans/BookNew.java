package dmacc.beans;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author Becca Deuser
 *
 */

@Embeddable
public class BookNew implements Serializable {
	private static final long serialVersionUID = -4239031207819579080L;
	
	//declare attributes
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String author;
	private int excitementRating;

	public BookNew() {
		
	}//end default constructor

	public BookNew(String title, String author, int excitmentRating) {
		this.title = title;
		this.author = author;
		this.excitementRating = excitmentRating;
	}//end non-default constructor
	
	public BookNew(String title, String author) {
		this.title = title;
		this.author = author;
	}//end non-default constructor
	
	public BookNew(String title) {
		this.title = title;
	}//end non-default constructor

	public BookNew(long id, String title, String author, int excitementRating) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.excitementRating = excitementRating;
	}//end all arg constructor

	public String getTitle() {
		return title;
	}//end getTitle

	public void setTitle(String title) {
		this.title = title;
	}//end setTitle

	public String getAuthor() {
		return author;
	}//end getAuthor

	public void setAuthor(String author) {
		this.author = author;
	}//end setAuthor

	public int getExcitementRating() {
		return excitementRating;
	}//end getExcitmentRating

	public long getId() {
		return id;
	}//end getId

	public void setId(long id) {
		this.id = id;
	}//end setId

	public void setExcitementRating(int excitmentRating) {
		this.excitementRating = excitmentRating;
	}//end setExcitmentRating

	public int compareTitle(BookNew toCompare) {
		return title.compareTo(toCompare.getTitle());
	}//end compareTitle
	
	public int compareAuthor(BookNew toCompare) {
		return author.compareTo(toCompare.getAuthor());
	}//end compareAuthor
	
	public int compareRating(BookNew toCompare) {
		return excitementRating - toCompare.getExcitementRating();
	}//end compareRating
	
	@Override
	public String toString() {
		return this.title + ", " + this.author + ", " + this.excitementRating + "," + this.id;
	}//end toString
	
}//end BookNew

