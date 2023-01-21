package in.reinventing.vote.model;

public class CandidateModel{
	
	private String name;
	private Integer count;
	
	public CandidateModel(String name, Integer count) {
		super();
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CandidateModel [name=" + name + ", count=" + count + "]";
	}
	
	
}
