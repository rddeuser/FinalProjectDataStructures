package dmacc.controller;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.BookNew;
import dmacc.beans.BooksToReadList;
import dmacc.beans.HaveReadList;
import dmacc.repository.HaveReadRepository;
import dmacc.repository.ToReadRepository;

@Controller
public class WebController {
	//declare repos
	@Autowired
	ToReadRepository trRepo;
	@Autowired
	HaveReadRepository hrRepo;
	
	//view all books to read
	@GetMapping("/viewbtr")
	
	public String viewAllBooksToRead(Model model) {
		if (trRepo.findAll().isEmpty()) {
			BooksToReadList btr = new BooksToReadList();
			trRepo.save(btr);
		}//end if
		
		model.addAttribute("books", trRepo.findAll().get(0).getBooksToRead());
		return "viewBooksToRead";
	}//end viewAllBooksToRead

	//add a new book to read
	@GetMapping("/inputToRead")
	
	public String addNewBookToRead(Model model) {
		BookNew book = new BookNew();
		model.addAttribute("newBook", book);
		return "newBtr";
	}//end addNewBookToRead

	@PostMapping("/inputToRead")

	public String addNewBookToRead(@ModelAttribute BookNew book, Model model) {
		//create list
		BooksToReadList btr;
		
		//check if repo is empty
		if (trRepo.count() > 0) {
			btr = trRepo.findAll().get(0);
		}//end if
		else {
			btr = new BooksToReadList();
		}//end else

		//add book to list
		btr.addBooksToRead(book);
		trRepo.save(btr);
		return viewAllBooksToRead(model);
	}//end addNewBookToRead
	
	//view all books in have read
	@GetMapping("/viewhr")
	
	public String viewAllHaveRead(Model model) {
		if (hrRepo.findAll().isEmpty()) {
			HaveReadList hr = new HaveReadList();
			hrRepo.save(hr);
		}//end if
		
		model.addAttribute("books", hrRepo.findAll().get(0).getHaveRead());
		return "viewHaveRead";
	}//end viewAllHaveRead
	
	//add new book to have read
	@GetMapping("/inputHaveRead")
	
	public String addNewBookHaveRead(Model model) {
		BookNew book = new BookNew();
		model.addAttribute("newBook", book);
		return "newHr";
	}//end addNewBookHaveRead

	@PostMapping("/inputHaveRead")

	public String addNewBookHaveRead(@ModelAttribute BookNew book, Model model) {
		//create list
		HaveReadList hr;
		
		//check if repo is empty
		if (hrRepo.count() > 0) {
			hr = hrRepo.findAll().get(0);
		}//end if
		else {
			hr = new HaveReadList();
		}//end else
		
		//add book to list
		hr.addHaveRead(book);
		hrRepo.save(hr);
		return viewAllHaveRead(model);
	}//end addNewBookHaveRead
	
	//get suggestion to read
	@GetMapping("/getTopbtr")
	
	public String viewTopBook(Model model) {
		//get books from LinkedList in repo
		LinkedList<BookNew> booksToRead = trRepo.findAll().get(0).getBooksToRead();
		
		//check if list is empty
		if (booksToRead.isEmpty()) {
			return addNewBookToRead(model);
		}//end if
		
		//get top book
		BookNew b = booksToRead.pop();
		model.addAttribute("book", b);
		return "whatToRead";
	}//end viewTopBook
	
	//delete book to read
	@GetMapping("/deletebtr/{id}")
		
	public String deleteBookToRead(@PathVariable("id") String title, Model model) {
		BooksToReadList btr = trRepo.findAll().get(0);
		BookNew toDelete = btr.findBook(title);
		btr.removeBook(toDelete);
		trRepo.save(btr);
		return viewAllBooksToRead(model);
	}//end deleteBook
	
	//delete have read book
	@GetMapping("/deletehr/{id}")
			
	public String deleteHaveRead(@PathVariable("id") String title, Model model) {
		HaveReadList hr = hrRepo.findAll().get(0);
		BookNew toDelete = hr.findBook(title);
		hr.removeBook(toDelete);
		hrRepo.save(hr);
		return viewAllHaveRead(model);
	}//end deleteHaveRead
	
	//move book
	@GetMapping("/move/{id}")
			
	public String moveBook(@PathVariable("id") String title, Model model) {
		BooksToReadList btr = trRepo.findAll().get(0);
		BookNew toDelete = btr.findBook(title);
		System.out.print(btr.toString());
		btr.removeBook(toDelete);
		trRepo.save(btr);
		return addNewBookHaveRead(toDelete, model);
		}//end moveBook
	
	//sort books to read by author
	@GetMapping("/sortByAuthor")
	
	public String sortBooksByAuthor(Model model) {
		BooksToReadList btr = trRepo.findAll().get(0);
		btr.sortByAuthor();
		trRepo.save(btr);
		return viewAllBooksToRead(model);
	}//end sortBooksByAuthor
	
	//sort books to read by rating
	@GetMapping("/sortByRating")
	
	public String sortBooksByRating(Model model) {
		BooksToReadList btr = trRepo.findAll().get(0);
		btr.sortByRating();
		trRepo.save(btr);
		return viewAllBooksToRead(model);
	}//end sortBooksByRating
	
	//sort books to read by title
	@GetMapping("/sortByTitle")
	
	public String sortBooksByTitle(Model model) {
		BooksToReadList btr = trRepo.findAll().get(0);
		btr.sortByTitle();
		trRepo.save(btr);
		return viewAllBooksToRead(model);
	}//end sortBooksByTitle
}//end WebController
