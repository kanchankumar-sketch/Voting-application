package in.reinventing.vote.dao;

public interface CanditateDao {

	public boolean isCondidatePresent(String name);
	public boolean enterCondidate(String name);
	
}
