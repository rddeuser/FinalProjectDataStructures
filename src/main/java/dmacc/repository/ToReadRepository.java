package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.BooksToReadList;

@Repository
public interface ToReadRepository extends JpaRepository<BooksToReadList, Long> {
	//repository interface for the have read list
}//end ToReadRepository
