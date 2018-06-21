package com.idfinance.service;

import com.idfinance.entity.Proposal;
import com.idfinance.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProposalService {

  @Autowired
  private ProposalRepository proposalRepository;

  public void addProposal(Proposal proposal) {
    proposalRepository.save(proposal);
  }

  public String getStateOfProposal(Integer id) {
    Proposal proposal = proposalRepository.findById(id).get();
    return proposal.getState();
  }

  public List<Proposal> getAllProposals() {
    List<Proposal> proposals = new ArrayList<>();
    proposalRepository.findAll().forEach(proposals::add);
    return proposals;
  }

  public void setStateProposal(Integer id, Boolean state) {
    Proposal proposal = proposalRepository.findById(id).get();

    if(state) {
      proposal.setState("accepted");
    } else {
      proposal.setState("refused");
    }

    proposalRepository.save(proposal);
  }

  public void updateProposal(Proposal proposal) {
    proposalRepository.save(proposal);
  }

  public Long getAcceptedProposals() {
    return proposalRepository.countByStateEquals("accepted");
  }

  public Long getRefusedProposals() {
    return proposalRepository.countByStateEquals("refused");
  }
}
