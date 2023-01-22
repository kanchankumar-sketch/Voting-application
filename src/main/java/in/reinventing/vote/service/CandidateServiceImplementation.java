package in.reinventing.vote.service;
import static in.reinventing.vote.dao.CandidateAndVoteDao.INITIAL_VOTE_COUNT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.reinventing.vote.dao.CandidateAndVoteDao;
import in.reinventing.vote.model.CandidateModel;
import in.reinventing.vote.model.ExceptionResponseModel;

@Service
public class CandidateServiceImplementation implements CandidateService {
	
	@Autowired
	private CandidateAndVoteDao  candidateAndVoteDao;

	@Override
	public Object enterCandidate(String name) {
		if(!this.candidateAndVoteDao.enterCondidate(name)) {
			return new ExceptionResponseModel(false,"Candidate already registered with name ="+name);
		}
		return new CandidateModel(name,INITIAL_VOTE_COUNT);
	}

}
