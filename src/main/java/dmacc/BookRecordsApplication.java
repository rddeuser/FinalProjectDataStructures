package dmacc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dmacc.beans.BooksToReadList;
import dmacc.beans.HaveReadList;
import dmacc.repository.HaveReadRepository;
import dmacc.repository.ToReadRepository;

@SpringBootApplication
public class BookRecordsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookRecordsApplication.class, args);
	}
	
}
