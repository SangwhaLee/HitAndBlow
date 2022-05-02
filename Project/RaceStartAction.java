package Project;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RaceStartAction extends JFrame {
	private JPanel pin = new JPanel();
	private JPanel display = new JPanel();
	private JPanel hitblow = new JPanel();
	private JPanel last = new JPanel();
	private JButton[] color = new JButton[6];
	private JButton[] ds = new JButton[4];
	private JLabel[] check = new JLabel[27];
	private JButton confirm = new JButton("Confirm");
	private Pin pincolor[] = Pin.values();
	private int[] answer = new int[4];
	private Play p1 = new Play();
	private int dsindex=0;
	private int current=10;
	Race race = new Race();
	boolean ok = true;
	int phase=0;
	
	public RaceStartAction() {
		setLayout(new BorderLayout());
		setTitle("Blow & Hit:Race");
		setSize(900,500);
		setLocation(0,0);
		setVisible(true);
		
		for(int i=0;i<4;i++) {
			answer[i] = 10;
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
		
		hitblow.setLayout(new GridLayout(3,9));
		hitblow.add(new JLabel("", SwingConstants.CENTER));
		for(int i=0;i<8;i++) {
			if(i%2==0)
				hitblow.add(check[i] = new JLabel("p1,"+(i/2+1)+"회차"));
			else
				hitblow.add(check[i] = new JLabel("p2,"+((i-1)/2+1)+"회차"));
		}
		hitblow.add(new JLabel("HIT:",SwingConstants.CENTER));
		for(int i=8;i<16;i++)
			hitblow.add(check[i]= new JLabel(""));
		hitblow.add(new JLabel("BLow:",SwingConstants.CENTER));
		for(int i=16;i<24;i++)
			hitblow.add(check[i] = new JLabel(""));
		
		add(hitblow,BorderLayout.NORTH);
		
		int ans = JOptionPane.showConfirmDialog(this,"중복을 혀용하시겠습니까?","중복확인",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
		boolean overlap=false;
		if(ans==0)
			overlap=true;
		else
			overlap=false;
		race.Chooseover(overlap);
		race.MakeAnswer();
		
		
		color[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(current!=10) {
					ds[current].setBackground(Color.blue);
					answer[current] = 0;
					p1.input_answer(current, 0);
					current=10;
				}
				else if(dsindex>3) {}
				else {
				ds[dsindex].setBackground(Color.blue);
				answer[dsindex] = 0;
				p1.input_answer(dsindex, 0);
				dsindex++;
				}
			}
		});
		
		color[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(current!=10) {
					ds[current].setBackground(Color.red);
					answer[current] = 1;
					p1.input_answer(current, 1);
					current=10;
				}
				else if(dsindex>3) {}
				else {
				ds[dsindex].setBackground(Color.red);
				answer[dsindex] = 1;
				p1.input_answer(dsindex, 1);
				dsindex++;
				}
			}
		});
		
		color[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(current!=10) {
					ds[current].setBackground(Color.green);
					answer[current] = 2;
					p1.input_answer(current, 2);
					current=10;
				}
				else if(dsindex>3) {}
				else {
				ds[dsindex].setBackground(Color.green);
				answer[dsindex] = 2;
				p1.input_answer(dsindex, 2);
				dsindex++;
				}
			}	
		});
		
		color[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(current!=10) {
					ds[current].setBackground(Color.yellow);
					answer[current] = 3;
					p1.input_answer(current, 3);
					current=10;
				}
				else if(dsindex>3) {}
				else {
				ds[dsindex].setBackground(Color.yellow);
				answer[dsindex] = 3;
				p1.input_answer(dsindex, 3);
				dsindex++;
				}
			}
		});
		
		color[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(current!=10) {
					ds[current].setBackground(Color.pink);
					answer[current] = 4;
					p1.input_answer(current, 4);
					current=10;
				}
				else if(dsindex>3) {}
				else {
				ds[dsindex].setBackground(Color.pink);
				answer[dsindex] = 4;
				p1.input_answer(dsindex, 4);
				dsindex++;
				}
			}
		});
		
		color[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(current!=10) {
					ds[current].setBackground(Color.white);
					answer[current] = 5;
					p1.input_answer(current, 5);
					current=10;
				}
				else if(dsindex>3) {}
				else {
				ds[dsindex].setBackground(Color.white);
				answer[dsindex] = 5;
				p1.input_answer(dsindex, 5);
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
				for(int i=0;i<4;i++) {
					if(answer[i]==10) {
						JOptionPane.showMessageDialog(display, "모든 공간에 색을 채워주십시오", "입력불가", JOptionPane.ERROR_MESSAGE);
						ok = false;
						break;
					}
				}
				if(ok ==true) {
					race.Confirm(p1, answer);
					check[phase+8].setText(race.getHit()+"");
					check[phase+16].setText(race.getBlow()+"");
					phase++;
					for(int i=0;i<4;i++)
						System.out.print(race.getAnswer(p1)[i]);
					if(race.getHit()==4) {
						if(phase%2==0)
							JOptionPane.showMessageDialog(display, "Player1,축하드립니다.승리했습니다.", "승리!!", JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(display, "Player2,축하드립니다.승리했습니다.", "승리!!", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					if(phase==8) {
						JOptionPane.showMessageDialog(display, "무승부입니다.승자는 없습니다.", "무승부", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					dsindex=0;
				}
				
			}
		});
		
	}
}
