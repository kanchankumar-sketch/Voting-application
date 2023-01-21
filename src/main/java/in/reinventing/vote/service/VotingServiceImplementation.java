package in.reinventing.vote.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.reinventing.vote.dao.CandidateAndVoteDao;
import in.reinventing.vote.model.CandidateModel;
import in.reinventing.vote.model.ExceptionResponseModel;


@Service
public class VotingServiceImplementation implements VotingService {
	
	@Autowired
	private CandidateAndVoteDao candidateAndVoteDao;
	
	@Override
	public Object castVote(String candidateName) {
		if(!candidateAndVoteDao.isCondidatePresent(candidateName)) {
			return new ExceptionResponseModel(false,"Candidate with name ="+candidateName+" does not exists.");
		}
		Integer currentVoteCount=candidateAndVoteDao.countVote(candidateName);
		candidateAndVoteDao.voteCandidate(candidateName);
		return new CandidateModel(candidateName,currentVoteCount+1);
	}

	@Override
	public Object countVote(String candidateName) {
		if(!candidateAndVoteDao.isCondidatePresent(candidateName)) {
			return new ExceptionResponseModel(false,"Candidate with name ="+candidateName+" does not exists.");
		}
		return new CandidateModel(candidateName,candidateAndVoteDao.countVote(candidateName));
	}

	@Override
	public List<Object> listVote() {
		List<Object> listOfCandidate=new ArrayList<>();
		for (Map.Entry<String, Integer> entry : candidateAndVoteDao.getVoteList().entrySet()) {
			listOfCandidate.add(new CandidateModel(entry.getKey(), entry.getValue()));
		}
		return listOfCandidate;
	}

	@Override
	public Object getWinner() {
		Integer max=-1;
		String winnerName="No registered candidate found";
		for (Map.Entry<String, Integer> entry : candidateAndVoteDao.getVoteList().entrySet()) {
			String name=entry.getKey(); 
			Integer voteCount=entry.getValue();
			if(max<voteCount) {
				max=voteCount;
				winnerName=name;
			}
		}
		return new CandidateModel(winnerName, max);
	}

}
