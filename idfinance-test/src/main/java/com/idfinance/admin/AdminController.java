package com.idfinance.admin;

import com.idfinance.entity.Proposal;
import com.idfinance.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

  @Autowired
  private ProposalService proposalService;

  @RequestMapping("/proposals")
  public List<Proposal> getAllProposals(Model model) {
    return proposalService.getAllProposals();
  }

  /*@RequestMapping(method = RequestMethod.PUT, value = "/proposals/{id}")
  public void updateProposal(@RequestBody Proposal proposal, @PathVariable Integer id) {
    proposalService.updateProposal(proposal);
  }*/

  @RequestMapping(method = RequestMethod.PUT, value = "/proposals/accepted/{id}/{state}")
  public void setStateProposal(@PathVariable Integer id, @PathVariable Boolean state) {
    proposalService.setStateProposal(id, state);
  }

  @RequestMapping("/proposals/accepted")
  public Long getAcceptedProposals() {
    return proposalService.getAcceptedProposals();
  }

  @RequestMapping("/proposals/refused")
  public Long getRefusedProposals() {
    return proposalService.getRefusedProposals();
  }
}
