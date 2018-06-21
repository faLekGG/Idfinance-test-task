package com.idfinance.client;

import com.idfinance.entity.Proposal;
import com.idfinance.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

  @Autowired
  private ProposalService proposalService;

  @RequestMapping("/proposal/{id}")
  public String getStateOfProposal(@PathVariable Integer id) {
    return proposalService.getStateOfProposal(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/proposals")
  public void addProposal(@RequestBody Proposal topic) {
    proposalService.addProposal(topic);
  }
}
