package in.reinventing.vote.repo.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.reinventing.vote.model.CandidateModel;
import in.reinventing.vote.service.CandidateServiceImplementation;
import in.reinventing.vote.service.VotingServiceImplementation;

@SpringBootTest
public class VotingServiceTest {
	
	@Autowired
	private VotingServiceImplementation serviceImplementation;
	
	@Autowired
	private CandidateServiceImplementation candidateServiceImplementation;
	
	
	@Test
	@DisplayName("Casting Vote.")
	void castVote() {
		String name="kanchan1";
		this.candidateServiceImplementation.enterCandidate(name);
		assertTrue(this.serviceImplementation.castVote(name) instanceof CandidateModel);
	}
	
	@Test
	@DisplayName("Count Vote Test")
	void countVote() {
		String name="kanchan2";
		this.candidateServiceImplementation.enterCandidate(name);
		this.serviceImplementation.castVote(name);
		assertTrue(this.serviceImplementation.countVote(name) instanceof CandidateModel);
	}
	
	@Test
	void getAllList() {
		System.out.println(this.serviceImplementation.listVote());
	}
	
	@Test
	@DisplayName("GetWinner 2time kanchan3,1 time kanchan4 winner should be kanchan3")
	void getWinner() {
		String name1="kanchan3";
		String name2="kanchan4";
		this.candidateServiceImplementation.enterCandidate(name1);
		this.candidateServiceImplementation.enterCandidate(name2);
		this.serviceImplementation.castVote(name1);
		this.serviceImplementation.castVote(name2);
		this.serviceImplementation.castVote(name1);
		CandidateModel c=(CandidateModel) this.serviceImplementation.getWinner();
		assertTrue(c.getName().equals(name1));
	}

}
