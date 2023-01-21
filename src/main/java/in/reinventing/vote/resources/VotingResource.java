package in.reinventing.vote.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.reinventing.vote.model.CandidateModel;
import in.reinventing.vote.service.CandidateService;
import in.reinventing.vote.service.VotingService;

@RestController
public class VotingResource {

	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private VotingService votingService;

	@GetMapping("/entercandidate")
	public ResponseEntity<?> enterCandidate(@RequestParam(value = "name", required = false) String name) {
		if (name != null && !name.trim().equalsIgnoreCase("")) {
			Object response = candidateService.enterCandidate(name);
			return new ResponseEntity<Object>(response,
					response instanceof CandidateModel ? HttpStatus.ACCEPTED : HttpStatus.ALREADY_REPORTED);
		}
		return new ResponseEntity<Object>("Please make sure candidate name parameter is not empty.",
				HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping("/castvote")
	public ResponseEntity<?> getCastVote(@RequestParam(value = "name", required = false) String name){
		if (name != null && !name.trim().equalsIgnoreCase("")) {
			Object response = votingService.castVote(name);
			return new ResponseEntity<Object>(response,
					response instanceof CandidateModel ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>("Please make sure candidate name parameter is not empty.",
				HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/countvote")
	public ResponseEntity<?> getCountVote(@RequestParam(value = "name", required = false) String name){
		if (name != null && !name.trim().equalsIgnoreCase("")) {
			Object response = votingService.countVote(name);
			return new ResponseEntity<Object>(response,
					response instanceof CandidateModel ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>("Please make sure candidate name parameter is not empty.",
				HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/listvote")
	public ResponseEntity<?> getlistVote(){
		return new ResponseEntity<Object>(votingService.listVote(),HttpStatus.OK);
	}
	
	@GetMapping("/getwinner")
	public ResponseEntity<?> getWinner(){
		return new ResponseEntity<Object>(votingService.getWinner(),HttpStatus.OK);
	}

}
