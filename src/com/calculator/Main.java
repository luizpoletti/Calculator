package com.calculator;

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.calculator.borders.RoundedBorder;
import com.calculator.operation.Operation;
import com.calculator.operation.operations.Division;
import com.calculator.operation.operations.Multiply;
import com.calculator.operation.operations.Subtract;
import com.calculator.operation.operations.Sum;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private List<Operation> operations;
	private Operation currentOperation;

	private JButton[] operation;
	private JButton[] number;

	private JButton point;
	private JButton result;
	private JButton clear;
	private JButton exit;

	private JTextField screen;

	public Main() {
		operations = Arrays.asList(new Sum(), new Subtract(), new Multiply(), new Division());

		operation = new JButton[4];
		number = new JButton[10];

		run();
		registerListeners();
	}

	public static void main(String[] args) {
		new Main();
	}

	public void run() {
		setTitle("Calculadora");
		setSize(300, 335);
		setLocation(600, 200);
		setIconImage(new ImageIcon("images/calculator.png").getImage());
		getContentPane().setBackground(Color.BLACK);

		loadNumbers();
		loadOperations();
		loadButtons();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void registerListeners() {
		for (int index = 0; index < 10; index++) {
			final int x = index;
			number[index].addActionListener((action) -> {
				screen.setText(screen.getText() + x);
				screen.setHorizontalAlignment(JTextField.RIGHT);
			});
		}
		for (int index = 0; index < 4; index++) {
			final int x = index;
			operation[index].addActionListener((action) -> {
				Operation operation = operations.get(x);

				screen.setText(screen.getText() + operation.getIcon());
				setCurrentOperation(operation);
			});
		}
		point.addActionListener((action) -> {
			screen.setText(screen.getText().isEmpty() ? "" : screen.getText() + ".");
			screen.setHorizontalAlignment(JTextField.RIGHT);
		});
		result.addActionListener((action) -> screen.setText(currentOperation == null ? "" : currentOperation.display(screen.getText())));
		clear.addActionListener((action) -> screen.setText(""));
		exit.addActionListener((action) -> System.exit(0));
	}

	public void loadNumbers() {
		number[0] = new JButton("0");
		number[0].setBounds(100, 225, 45, 25);
		number[0].setFont(new Font("Tahoma", Font.BOLD, 12));
		number[0].setBackground(Color.BLACK);
		number[0].setForeground(Color.WHITE);
		number[0].setBorder(new RoundedBorder(new Color(64, 64, 64), 10));
		add(number[0]);

		int x = 50;
		int y = 150;
		for (int index = 1; index < 10; index++) {
			number[index] = new JButton("" + index);
			number[index].setBounds(x, y, 45, 25);
			number[index].setFont(new Font("Tahoma", Font.BOLD, 12));
			number[index].setBackground(Color.BLACK);
			number[index].setForeground(Color.WHITE);
			number[index].setBorder(new RoundedBorder(new Color(64, 64, 64), 10));
			add(number[index]);

			if (index % 3 == 0) {
				x = 50;
				y += 25;

			} else
				x += 50;
		}

	}

	public void loadOperations() {
		operation[0] = new JButton("+");
		operation[1] = new JButton("-");
		operation[2] = new JButton("×");
		operation[3] = new JButton("÷");

		for (int index = 0; index < 4; index++) {
			operation[index].setBounds(200, 150 + 25 * index, 45, 25);
			operation[index].setFont(new Font("Tahoma", Font.BOLD, 12));
			operation[index].setBackground(Color.BLACK);
			operation[index].setForeground(new Color(255, 111, 0));
			operation[index].setBorder(new RoundedBorder(new Color(64, 64, 64), 10));
			add(operation[index]);
		}

	}

	public void loadButtons() {
		screen = new JTextField();
		screen.setEditable(false);
		screen.setFont(new Font("Tahoma", Font.BOLD, 11));

		point = new JButton(".");
		result = new JButton("=");
		clear = new JButton("C");
		exit = new JButton("Fechar");

		screen.setBounds(50, 50, 200, 30);
		point.setBounds(50, 225, 45, 25);
		result.setBounds(150, 225, 45, 25);
		clear.setBounds(50, 110, 100, 25);
		exit.setBounds(150, 110, 100, 25);

		point.setFont(new Font("Tahoma", Font.BOLD, 12));
		result.setFont(new Font("Tahoma", Font.BOLD, 12));
		clear.setFont(new Font("Tahoma", Font.BOLD, 12));
		exit.setFont(new Font("Tahoma", Font.BOLD, 12));

		screen.setForeground(Color.WHITE);
		point.setForeground(new Color(255, 111, 0));
		result.setForeground(Color.WHITE);
		clear.setForeground(new Color(255, 111, 0));
		exit.setForeground(new Color(255, 111, 0));

		screen.setBackground(Color.BLACK);
		point.setBackground(Color.BLACK);
		result.setBackground(new Color(219, 85, 7));
		clear.setBackground(Color.BLACK);
		exit.setBackground(Color.BLACK);

		screen.setBorder(BorderFactory.createLineBorder(new Color(32, 32, 32), 2));
		point.setBorder(new RoundedBorder(new Color(64, 64, 64), 10));
		result.setBorder(new RoundedBorder(new Color(219, 85, 7), 10));
		clear.setBorder(new RoundedBorder(new Color(64, 64, 64), 10));
		exit.setBorder(new RoundedBorder(new Color(64, 64, 64), 10));

		add(screen);
		add(point);
		add(result);
		add(clear);
		add(exit);

		setLayout(null);
	}

	public void setCurrentOperation(Operation operation) {
		currentOperation = operation;
	}

}
