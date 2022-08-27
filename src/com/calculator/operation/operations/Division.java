package com.calculator.operation.operations;

import com.calculator.operation.Operation;

public class Division implements Operation {

	private float value1;
	private float value2;

	public Division() {
		value1 = 0;
		value2 = 0;
	}

	@Override
	public String display(String screen) {
		value1 = Float.parseFloat(screen.split("÷")[0] == null ? "0" : screen.split("÷")[0]);
		value2 = Float.parseFloat(screen.split("÷")[1] == null ? "0" : screen.split("÷")[1]);

		return String.valueOf(value1 / value2);
	}

	@Override
	public String getIcon() {
		return "÷";
	}

}
