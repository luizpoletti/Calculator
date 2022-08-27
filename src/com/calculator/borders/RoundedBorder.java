package com.calculator.borders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class RoundedBorder implements Border {

	private Color color;
	private int radius;

	public RoundedBorder(Color color, int radius) {
		this.color = color;
		this.radius = radius;
	}

	@Override
	public Insets getBorderInsets(Component component) {
		return new Insets(radius + 1, radius + 1, radius + 2, radius);
	}

	@Override
	public boolean isBorderOpaque() {
		return false;
	}

	@Override
	public void paintBorder(Component component, Graphics graphics, int x, int y, int width, int height) {
		graphics.setColor(color);
		graphics.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
	}

}
