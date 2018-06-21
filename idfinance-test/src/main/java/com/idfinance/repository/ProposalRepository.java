package com.idfinance.repository;

import com.idfinance.entity.Proposal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProposalRepository extends CrudRepository<Proposal, Integer> {

  //@Query("SELECT COUNT(p) FROM proposal p WHERE p.state='waiting'")
  long countByStateEquals(String state);
}
