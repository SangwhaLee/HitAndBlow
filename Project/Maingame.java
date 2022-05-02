package Project;

public interface Maingame {
	int[] answer = new int[4];
	boolean overlap = false;
	
	public void MakeAnswer();
	
	public boolean Confirm(Play p1 ,int[] input);
	
	public void Chooseover(boolean overlap);
	
	public int[] getAnswer(Play p1);
}
