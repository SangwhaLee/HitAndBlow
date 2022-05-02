package Project;

public class Race implements Maingame {
	private int[] answer = new int[4];
	private boolean[] which = new boolean[6];
	private boolean overlap = false;
	private int blow=0;
	private int hit=0;
	
	@Override
	public void MakeAnswer() {
		// TODO Auto-generated method stub
		answer[0]=(int)(Math.random()*6);
		for(int i=1;i<4;i++) {
			answer[i]=(int)(Math.random()*5);
			if(overlap==false) {
				for(int j=0;j<i;j++) {
					if(answer[i]==answer[j])
						i--;
				}
			}
		}
	}

	@Override
	public boolean Confirm(Play p1, int[] input) {
		// TODO Auto-generated method stub
		hit=0;
		blow=0;
		for(int i=0;i<6;i++) {
			which[i]=false;
		}
		for(int i=0;i<4;i++) {
			if(p1.getMyAnswer()[i]==answer[i]) {
				hit++;
				which[answer[i]]=true;
			}
		}
		for(int i=0;i<4;i++) {
			if(which[input[i]]==false) {
				for(int j=0;j<4;j++) {
					if(input[i]==answer[j]) {
						blow++;
						which[answer[i]]=true;
						break;
					}
				}
			}
		}
		if(hit==4)
			return true;
		else
			return false;
	}

	@Override
	public void Chooseover(boolean overlap) {
		// TODO Auto-generated method stub
		this.overlap=overlap;
	}
	
	public int getHit() {
		return hit;
	}
	
	public int getBlow() {
		return blow;
	}
	
	@Override
	public int[] getAnswer(Play p1) {
		return answer;
	}

}
