package in.reinventing.vote.dao;

import java.util.Map;

public interface VoteDao {

	public boolean voteCandidate(String name);
	
	public Map<String,Integer> getVoteList();
	
	public Integer countVote(String name);
}
