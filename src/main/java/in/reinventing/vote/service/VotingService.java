package in.reinventing.vote.service;

import java.util.List;

public interface VotingService {
	
	Object castVote(String candidateName);
	
	Object countVote(String candidateName);
	
	List<Object> listVote();
	
	Object getWinner();

}
