import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class TicTacToeGame {
	private static char[][] board=new char[3][3];
	private static int step=0;
	private static char currentPlayer='X';
	public static void resetGame() {
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				board[i][j]=' ';
		step=0;
		currentPlayer = 'X'; 
		    
		JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);  
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        
		JButton button1 = new JButton(" ");
        button1.setFont(new Font("Arial", Font.PLAIN, 60));
        button1.setBackground(Color.CYAN);
        panel.add(button1);
        button1.addActionListener(e -> clicked(button1, 0, 0));
        
        JButton button2 = new JButton(" ");
        button2.setFont(new Font("Arial", Font.PLAIN, 60));
        button2.setBackground(Color.CYAN);
        panel.add(button2);
        button2.addActionListener(e -> clicked(button2, 0, 1));

        JButton button3 = new JButton(" ");
        button3.setFont(new Font("Arial", Font.PLAIN, 60));
        button3.setBackground(Color.CYAN);
        panel.add(button3);
        button3.addActionListener(e -> clicked(button3, 0, 2));

        JButton button4 = new JButton(" ");
        button4.setFont(new Font("Arial", Font.PLAIN, 60));
        button4.setBackground(Color.CYAN);
        panel.add(button4);
        button4.addActionListener(e -> clicked(button4, 1, 0));

        JButton button5 = new JButton(" ");
        button5.setFont(new Font("Arial", Font.PLAIN, 60));
        button5.setBackground(Color.CYAN);
        panel.add(button5);
        button5.addActionListener(e -> clicked(button5, 1, 1));

        JButton button6 = new JButton(" ");
        button6.setFont(new Font("Arial", Font.PLAIN, 60));
        button6.setBackground(Color.CYAN);
        panel.add(button6);
        button6.addActionListener(e -> clicked(button6, 1, 2));

        JButton button7 = new JButton(" ");
        button7.setFont(new Font("Arial", Font.PLAIN, 60));
        button7.setBackground(Color.CYAN);
        panel.add(button7);
        button7.addActionListener(e -> clicked(button7, 2, 0));

        JButton button8 = new JButton(" ");
        button8.setFont(new Font("Arial", Font.PLAIN, 60));
        button8.setBackground(Color.CYAN);
        panel.add(button8);
        button8.addActionListener(e -> clicked(button8, 2, 1));

        JButton button9 = new JButton(" ");
        button9.setFont(new Font("Arial", Font.PLAIN, 60));
        button9.setBackground(Color.CYAN);
        panel.add(button9);
        button9.addActionListener(e -> clicked(button9, 2, 2));
        
	    frame.add(panel);
        frame.setVisible(true);
	}
	public static boolean checkWinner() {
		for(int i=0;i<3;i++)
		{
				if (board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]) {
	                return true;
	            }
	            if (board[0][i]!=' ' && board[0][i]==board[1][i] && board[1][i]==board[2][i]) {
	                return true;
	            }
		}
		if (board[0][0] != ' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0]) {
            return true;
        }
        return false;
	}
	public static void clicked(JButton button, int row, int column) {
		if(board[row][column]!=' ') 
			return;
		step++;
		board[row][column]=currentPlayer;
		button.setText(String.valueOf(currentPlayer));
		if(step>4) {
			if(checkWinner()) {
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
            	//System.exit(0); 
				resetGame();
			}
			else if(step==9) {
				JOptionPane.showMessageDialog(null, "No one won :(");
            	//System.exit(0);
				resetGame();
			}
		}
		if(step!=0)
			currentPlayer = (currentPlayer=='X') ? 'O': 'X';
		
		
	}
	public static void main(String[] args) {
		resetGame();
	}

}