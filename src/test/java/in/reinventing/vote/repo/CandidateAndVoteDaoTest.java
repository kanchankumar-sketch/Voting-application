package in.reinventing.vote.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.reinventing.vote.dao.CandidateAndVoteDao;

@SpringBootTest
class CandidateAndVoteDaoTest {

	@Autowired
	private CandidateAndVoteDao candidateAndVoteDao;

	@Test
	@DisplayName("Enterning Candidate Test.")
	void enteringCandidate() {
		String name = "kanchan";
		assertTrue(this.candidateAndVoteDao.enterCondidate(name));
	}

	@Test
	@DisplayName("Testing entered candidate peresent or not.")
	void isCandidatePresent() {
		String name = "kanchan12";
		this.candidateAndVoteDao.enterCondidate(name);
		assertTrue(this.candidateAndVoteDao.isCondidatePresent(name));
	}

	@Test
	@DisplayName("Voting test.")
	void voteCandidate() {
		String name = "kanchan13";
		this.candidateAndVoteDao.enterCondidate(name);
		assertTrue(this.candidateAndVoteDao.voteCandidate(name));
	}

	@Test
	@DisplayName("voting count test.")
	void countVote() {
		String name = "kanchan11";
		this.candidateAndVoteDao.enterCondidate(name);
		this.candidateAndVoteDao.voteCandidate(name);
		assertEquals(1, this.candidateAndVoteDao.countVote(name));
	}

}
