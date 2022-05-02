package Project;
import java.awt.*;
import javax.swing.*;

public class MainPageText extends JComponent {
	public static final int MESSAGE_X=110;
	public static final int MESSAGE_Y=100;
	private static final int DEFAULT_WIDTH=300;
	private static final int DEFAULT_HEIGHT=200;
	private JPanel buttonPanel;
	private JPanel RacePanel;
	private JPanel BattlePanel;
	private JButton race = new JButton("Race");
	private JButton battle = new JButton("Battle");
	private JLabel label = new JLabel("Hit & Blow");

	public MainPageText() {
		setLayout(new BorderLayout());
		label.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,30));
		add(label, BorderLayout.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		buttonPanel = new JPanel();
		buttonPanel.add(race);
		buttonPanel.add(battle);
		add(buttonPanel, BorderLayout.SOUTH);
		
		race.addActionListener(new RaceAction());
		battle.addActionListener(new BattleAction());
		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
	
}