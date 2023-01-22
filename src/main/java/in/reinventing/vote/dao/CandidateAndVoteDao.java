package in.reinventing.vote.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

@Repository
public class CandidateAndVoteDao implements CanditateDao, VoteDao {

	private static final ConcurrentHashMap<String, Integer> candidateVoting = new ConcurrentHashMap<>();
	public static final Integer INITIAL_VOTE_COUNT = 0;

	@Override
	public boolean isCondidatePresent(String name) {
		return candidateVoting.get(name) != null;
	}

	@Override
	public boolean voteCandidate(String name) {
		if (isCondidatePresent(name)) {
			candidateVoting.put(name, countVote(name) + 1);
			return true;
		}
		return false;
	}

	@Override
	public Map<String, Integer> getVoteList() {
		return candidateVoting;
	}

	@Override
	public Integer countVote(String name) {
		if (isCondidatePresent(name)) {
			return candidateVoting.get(name);
		}
		return -1;
	}

	@Override
	public boolean enterCondidate(String name) {
		if (isCondidatePresent(name)) {
			return false;
		}
		candidateVoting.put(name, INITIAL_VOTE_COUNT);
		return true;
	}

}
