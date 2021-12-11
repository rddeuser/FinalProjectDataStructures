package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.HaveReadList;

@Repository
public interface HaveReadRepository extends JpaRepository<HaveReadList, Long> {
	//repository interface for the have read list
}//end HaveReadRepository
