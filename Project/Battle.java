package Project;

public class Battle implements Maingame {
	private int[] answer1 = new int[4];
	private int[] answer2 = new int[4];
	private  boolean overlap = false;
	private boolean[] which = new boolean[6];
	private int hit=0;
	private int blow=0;

	@Override
	public void MakeAnswer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Confirm(Play p1,int[] input) {
		// TODO Auto-generated method stub
		hit=0;
		blow=0;
		boolean player1=true;
		for(int i=0;i<6;i++) {
			which[i]=false;
		}
		for(int i=0;i<4;i++) {
			if(p1.getTrueAnswer()[i]!=answer1[i]) player1=false;
		}
		
		if(player1==true) {
			for(int i=0;i<4;i++) {
				if(p1.getMyAnswer()[i]==answer2[i]) {
					hit++;
					which[answer2[i]]=true;
				}
			}
			for(int i=0;i<4;i++) {
				if(which[input[i]]==false) {
					for(int j=0;j<4;j++) {
						if(input[i]==answer2[j]) {
							blow++;
							which[answer2[i]]=true;
							break;
						}
					}
				}
			}
			if(hit==4) return true;
			else return false;
		}
		else {
			for(int i=0;i<4;i++) {
				if(p1.getMyAnswer()[i]==answer1[i]) {
					hit++;
					which[answer1[i]]=true;
				}
			}
			for(int i=0;i<4;i++) {
				if(which[input[i]]==false) {
					for(int j=0;j<4;j++) {
						if(input[i]==answer1[j]) {
							blow++;
							which[answer1[i]]=true;
							break;
						}
					}
				}
			}
			if(hit==4) return true;
			else return false;
		}
	}

	@Override
	public void Chooseover(boolean overlap) {
		// TODO Auto-generated method stub
		this.overlap=overlap;
	}
	
	public void EachAnswer(Play p1, Play p2) {
		for(int i=0;i<4;i++) {
			answer1[i]=p1.getTrueAnswer()[i];
			answer2[i]=p2.getTrueAnswer()[i];
		}
	}
	
	public int getHit() {
		return hit;
	}
	
	public int getBlow() {
		return blow;
	}

	@Override
	public int[] getAnswer(Play p1) {
		// TODO Auto-generated method stub
		for(int i=0;i<4;i++) {
			if(p1.getMyAnswer()[i]!=answer1[i])
				return answer2;
		}
		return answer1;
	}

}
