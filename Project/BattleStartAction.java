package Project;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BattleStartAction extends JFrame {
	private JPanel pin = new JPanel();
	private JPanel display = new JPanel();
	private JPanel hitblow = new JPanel();
	private JPanel last = new JPanel();
	private JButton[] color = new JButton[6];
	private JButton[] ds = new JButton[4];
	private JLabel[] check = new JLabel[30];
	private JButton confirm = new JButton("Confirm");
	private Pin pincolor[] = Pin.values();
	private int[] answer1 = new int[4];
	private int[] answer2 = new int[4];
	private Play p1 = new Play();
	private Play p2 = new Play();
	private int dsindex=0;
	private int current=10;
	Battle battle = new Battle();
	boolean ok = true;
	boolean win = false;
	boolean overlap=false;
	int phase=0;
	
	public BattleStartAction() {
		setLayout(new BorderLayout());
		setTitle("Blow & Hit:Battle");
		setSize(900,500);
		setLocation(0,0);
		setVisible(true);
		
		for(int i=0;i<4;i++) {
			answer1[i] = 10;
			answer2[i] = 10;
		}
		
		for(int i=0;i<6;i++) {
			pin.add(color[i] = new JButton(""+pincolor[i]));
		}
		add(pin,BorderLayout.SOUTH);
		
		display.setLayout(new GridLayout(1,4));
		for(int i=0;i<4;i++) {
			display.add(ds[i]= new JButton());
		}
		add(display, BorderLayout.CENTER);
		
		last.add(confirm);
		add(last,BorderLayout.EAST);
		
		hitblow.setLayout(new GridLayout(3,11));
		hitblow.add(new JLabel("", SwingConstants.CENTER));
		for(int i=0;i<10;i++) {
			if(i%2==0)
				hitblow.add(check[i] = new JLabel("p1,"+(i/2+1)+"회차"));
			else
				hitblow.add(check[i] = new JLabel("p2,"+((i-1)/2+1)+"회차"));
		}
		hitblow.add(new JLabel("HIT:",SwingConstants.CENTER));
		for(int i=10;i<20;i++)
			hitblow.add(check[i]= new JLabel(""));
		hitblow.add(new JLabel("BLOW:",SwingConstants.CENTER));
		for(int i=20;i<30;i++)
			hitblow.add(check[i] = new JLabel(""));
		
		add(hitblow,BorderLayout.NORTH);
		
		int ans = JOptionPane.showConfirmDialog(this,"중복을 혀용하시겠습니까?","중복확인",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
		
		if(ans==0)
			overlap=true;
		else
			overlap=false;
		
		JOptionPane.showMessageDialog(this, "먼저 각자의 답을 입력해주십시오", "정보", JOptionPane.INFORMATION_MESSAGE);
		 
		battle.Chooseover(overlap);
		
		
		color[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(current!=10) {
					ds[current].setBackground(Color.blue);
					if(phase%2==0) {
						answer1[current] = 0;
						if(phase==0)
							p1.input_true(current, 0);
						else
							p1.input_answer(current, 0);
					}
					else {
						answer2[current] = 0;
						if(phase==1)
							p2.input_true(current, 0);
						else
							p2.input_answer(current, 0);
					}
					current=10;
				}
				else if(dsindex>3) {}
				else {
				ds[dsindex].setBackground(Color.blue);
				if(phase%2==0) {
					answer1[dsindex] = 0;
					if(phase==0)
						p1.input_true(dsindex, 0);
					else
						p1.input_answer(dsindex, 0);
				}
				else {
					answer2[dsindex] = 0;
					if(phase==1)
						p2.input_true(dsindex, 0);
					else
						p2.input_answer(dsindex, 0);
				}
				dsindex++;
				}
			}
		});
		
		color[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(current!=10) {
					ds[current].setBackground(Color.red);
					if(phase%2==0) {
						answer1[current] = 1;
						if(phase==0)
							p1.input_true(current, 1);
						else
							p1.input_answer(current, 1);
					}
					else {
						answer2[current] = 1;
						if(phase==1)
							p2.input_true(current, 1);
						else
							p2.input_answer(current, 1);
					}
					current=10;
				}
				else if(dsindex>3) {}
				else {
				ds[dsindex].setBackground(Color.red);
				if(phase%2==0) {
					answer1[dsindex] = 1;
					if(phase==0)
						p1.input_true(dsindex, 1);
					else
						p1.input_answer(dsindex, 1);
				}
				else {
					answer2[dsindex] = 1;
					if(phase==1)
						p2.input_true(dsindex, 1);
					else
						p2.input_answer(dsindex, 1);
				}
				dsindex++;
				}
			}
		});
		
		color[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(current!=10) {
					ds[current].setBackground(Color.green);
					if(phase%2==0) {
						answer1[current] = 2;
						if(phase==0)
							p1.input_true(current, 2);
						else
							p1.input_answer(current, 2);
					}
					else {
						answer2[current] = 2;
						if(phase==1)
							p2.input_true(current, 2);
						else
							p2.input_answer(current, 2);
					}
					current=10;
				}
				else if(dsindex>3) {}
				else {
				ds[dsindex].setBackground(Color.green);
				if(phase%2==0) {
					answer1[dsindex] = 2;
					if(phase==0)
						p1.input_true(dsindex, 2);
					else
						p1.input_answer(dsindex, 2);
				}
				else {
					answer2[dsindex] = 2;
					if(phase==1)
						p2.input_true(dsindex, 2);
					else
						p2.input_answer(dsindex, 2);
				}
				dsindex++;
				}
			}	
		});
		
		color[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(current!=10) {
					ds[current].setBackground(Color.yellow);
					if(phase%2==0) {
						answer1[current] = 3;
						if(phase==0)
							p1.input_true(current, 3);
						else
							p1.input_answer(current, 3);
					}
					else {
						answer2[current] = 3;
						if(phase==1)
							p2.input_true(current, 3);
						else
							p2.input_answer(current, 3);
					}
					current=10;
				}
				else if(dsindex>3) {}
				else {
				ds[dsindex].setBackground(Color.yellow);
				if(phase%2==0) {
					answer1[dsindex] = 3;
					if(phase==0)
						p1.input_true(dsindex, 3);
					else
						p1.input_answer(dsindex, 3);
				}
				else {
					answer2[dsindex] = 3;
					if(phase==1)
						p2.input_true(dsindex, 3);
					else
						p2.input_answer(dsindex, 3);
				}
				dsindex++;
				}
			}
		});
		
		color[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(current!=10) {
					ds[current].setBackground(Color.pink);
					if(phase%2==0) {
						answer1[current] = 4;
						if(phase==0)
							p1.input_true(current, 4);
						else
							p1.input_answer(current, 4);
					}
					else {
						answer2[current] = 4;
						if(phase==1)
							p2.input_true(current, 4);
						else
							p2.input_answer(current, 4);
					}
					current=10;
				}
				else if(dsindex>3) {}
				else {
				ds[dsindex].setBackground(Color.pink);
				if(phase%2==0) {
					answer1[dsindex] = 4;
					if(phase==0)
						p1.input_true(dsindex, 4);
					else
						p1.input_answer(dsindex, 4);
				}
				else {
					answer2[dsindex] = 4;
					if(phase==1)
						p2.input_true(dsindex, 4);
					else
						p2.input_answer(dsindex, 4);
				}
				dsindex++;
				}
			}
		});
		
		color[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(current!=10) {
					ds[current].setBackground(Color.white);
					if(phase%2==0) {
						answer1[current] = 5;
						if(phase==0)
							p1.input_true(current, 5);
						else
							p1.input_answer(current, 5);
					}
					else {
						answer2[current] = 5;
						if(phase==1)
							p2.input_true(current, 5);
						else
							p2.input_answer(current, 5);
					}
					current=10;
				}
				else if(dsindex>3) {}
				else {
				ds[dsindex].setBackground(Color.white);
				if(phase%2==0) {
					answer1[dsindex] = 5;
					if(phase==0)
						p1.input_true(dsindex, 5);
					else
						p1.input_answer(dsindex, 5);
				}
				else {
					answer2[dsindex] = 5;
					if(phase==1)
						p2.input_true(dsindex, 5);
					else
						p2.input_answer(dsindex, 5);
				}
				dsindex++;
				}
			}
		});
		
		ds[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				current = 0;
			}
		});
		
		ds[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				current = 1;
			}
		});
		
		ds[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				current = 2;
			}
		});
		
		ds[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				current = 3;
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ok=true;
				if(phase%2==0) {
				for(int i=0;i<4;i++) {
					if(answer1[i]==10) {
						JOptionPane.showMessageDialog(display, "모든 공간에 색을 채워주십시오", "입력불가", JOptionPane.ERROR_MESSAGE);
						ok = false;
						break;
					}
				}
				}
				else {
					for(int i=0;i<4;i++) {
						if(answer2[i]==10) {
							JOptionPane.showMessageDialog(display, "모든 공간에 색을 채워주십시오", "입력불가", JOptionPane.ERROR_MESSAGE);
							ok = false;
							break;
						}
					}
				}
				if(overlap==false && phase==0) {
					for(int i=0;i<4;i++) {
						for(int j=0;j<4;j++) {
							if(answer1[i]==answer1[j] && i!=j) {
								JOptionPane.showMessageDialog(display, "중복값을 입력해서는 안됩니다. 다시 입력해주십시오", "중복불가", JOptionPane.ERROR_MESSAGE);
								ok=false;
								dsindex=0;
								break;
							}
						}
						if(ok==false)
							break;
					}
				}
				else if(overlap==false && phase==1) {
					for(int i=0;i<4;i++) {
						for(int j=0;j<4;j++) {
							if(answer2[i]==answer2[j] && i!=j) {
								JOptionPane.showMessageDialog(display, "중복값을 입력해서는 안됩니다. 다시 입력해주십시오", "중복불가", JOptionPane.ERROR_MESSAGE);
								ok=false;
								dsindex=0;
								break;
							}
						}
						if(ok==false)
							break;
					}
				}
				if(ok ==true) {
					if(phase<=1) {
						battle.EachAnswer(p1, p2);
						phase++;
					}
					else if(phase>1 && phase%2==0) {
						win = battle.Confirm(p1, answer1);
						check[phase+8].setText(battle.getHit()+"");
						check[phase+18].setText(battle.getBlow()+"");
						phase++;
						if(win) {
							JOptionPane.showMessageDialog(display, "Player1,축하드립니다.승리했습니다.", "승리!!", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
					}
					else if(phase>1 && phase%2!=0) {
						win = battle.Confirm(p2, answer2);
						check[phase+8].setText(battle.getHit()+"");
						check[phase+18].setText(battle.getBlow()+"");
						phase++;
						if(win) {
							JOptionPane.showMessageDialog(display, "Player2,축하드립니다.승리했습니다.", "승리!!", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
					}
					if(phase==12) {
						JOptionPane.showMessageDialog(display, "무승부입니다.승자는 없습니다.", "무승부", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					dsindex=0;
				}
				
			}
		});
		
	}
}
