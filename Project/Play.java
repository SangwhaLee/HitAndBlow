package Project;

public class Play {
	private int[] myanswer = new int[4];
	private int[] trueanswer = new int[4];
	
	public void input_answer(int index, int input) {
		myanswer[index]= input;
	}
	
	public void input_true(int index, int input) {
		trueanswer[index]= input;
	}
	
	public int[] getMyAnswer() {
		return myanswer;
	}
	
	public int[] getTrueAnswer() {
		return trueanswer;
	}
	
}
