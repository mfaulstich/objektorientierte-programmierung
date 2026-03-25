package de.fhswf.inf.oop.aufgabe1.uebung2;

public class Main {

	private static final byte OUTPUT_MOTOR_RIGHT = ElectricSlide.OUTPUT_MOTOR_RIGHT;
	private static final byte OUTPUT_MOTOR_LEFT = ElectricSlide.OUTPUT_MOTOR_LEFT;
	private static final byte OUTPUT_BREAK = ElectricSlide.OUTPUT_BREAK;
	private static final byte INPUT_LIMIT_RIGHT = ElectricSlide.INPUT_LIMIT_RIGHT;
	private static final byte INPUT_LIMIT_LEFT = ElectricSlide.INPUT_LIMIT_LEFT;


	public static void main(String[] args) {
		ElectricSlide electricSlide = new ElectricSlide();
		byte pioState = 0;
		pioState = electricSlide.nextCycle(pioState);
		pioState = OUTPUT_MOTOR_LEFT;
		pioState = electricSlide.nextCycle(pioState);
		while ((pioState & INPUT_LIMIT_LEFT) == 0) {
			pioState = electricSlide.nextCycle(pioState);
		}
		pioState &= ~OUTPUT_MOTOR_LEFT;
		pioState = electricSlide.nextCycle(pioState);
		pioState |= OUTPUT_BREAK;
		pioState = electricSlide.nextCycle(pioState);
		pioState &= ~OUTPUT_BREAK;
		pioState = electricSlide.nextCycle(pioState);
		pioState |= OUTPUT_MOTOR_RIGHT;
		pioState = electricSlide.nextCycle(pioState);
		while ((pioState & INPUT_LIMIT_RIGHT) == 0) {
			pioState = electricSlide.nextCycle(pioState);
		}
		pioState &= ~OUTPUT_MOTOR_RIGHT;
		pioState = electricSlide.nextCycle(pioState);
		pioState |= OUTPUT_BREAK;
		pioState = electricSlide.nextCycle(pioState);
		pioState &= ~OUTPUT_BREAK;
		pioState = electricSlide.nextCycle(pioState);

	}

}
