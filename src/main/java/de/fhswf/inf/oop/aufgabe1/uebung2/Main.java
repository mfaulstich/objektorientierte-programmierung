package de.fhswf.inf.oop.aufgabe1.uebung2;

import java.util.function.Function;

public class Main {

	private static class ElectricSledge {
		private static Function<String, String> fill = s -> {
			while (s.length() < 8) {
				s = "0" + s;
			}
			return s;
		};
		private int position;
		private boolean overflow_left;
		private boolean wand_rechts_overflow;
		private boolean limit_links;
		private boolean limit_rechts;
		private boolean motor_left;
		private boolean motor_right;
		private boolean rotating_left;
		private boolean rotating_right;
		private boolean motorBreak;

		byte pinCode;

		public byte nextCycle(byte status) {

			// Ausmaskieren der Read-Only-Pins
			byte newState = (byte) (this.pinCode & 0xF0);
			newState = (byte) (status & 0x0F);

			overflow_left = position < -OVERFLOW_AMOUNT_ABSOLUTE;
			wand_rechts_overflow = position > OVERFLOW_AMOUNT_ABSOLUTE;
			limit_links = position <= -LIMIT_SWITCH_POSITON_AMOUNT_ABSOLUTE;
			limit_rechts = position >= LIMIT_SWITCH_POSITON_AMOUNT_ABSOLUTE;
			motor_left = (newState & OUTPUT_MOTOR_LEFT) != 0;
			motor_right = (newState & OUTPUT_MOTOR_RIGHT) != 0;
			motorBreak = (newState & OUTPUT_BREAK_ON) != 0;

			rotating_left = rotating_left && !motorBreak;
			rotating_right = rotating_right && !motorBreak;

			if (overflow_left) {
				throw new IllegalStateException("Schlitten ist vor die linke Wand gefahren");
			}
			if (wand_rechts_overflow) {
				throw new IllegalStateException("Schlitten ist vor die rechte Wand gefahren");
			}
			if (limit_links) {
				newState |= LIMIT_LEFT;
			} else {
				newState &= ~LIMIT_LEFT;
			}
			if (limit_rechts) {
				newState |= LIMIT_RIGHT;
			} else {
				newState &= ~LIMIT_RIGHT;
			}
			if (motor_left && motor_right) {
				throw new IllegalStateException(
						"Massiver Kurzschluss in der Motorsteuerung!\nMotor wird rechts und links gleichzeitig angesteuert!");
			}
			if (motor_left) {
				if (motorBreak) {
					throw new IllegalStateException("Motor-Achsbruch bei Motor links und Bremse an.");
				}
				rotating_left = true;
			}
			if (motor_right) {
				if (motorBreak) {
					throw new IllegalStateException("Motor-Achsbruch bei Motor rechts und Bremse an.");
				}
				rotating_right = true;
			}
			if (rotating_left) {
				position--;
			}
			if (rotating_right) {
				position++;
			}
			this.pinCode = newState;
			System.out.println(this);
			return this.pinCode;
		}

		public String toString() {
			return String.format("Position: %3d, Status: %s, Motor: %-6s, Dreht: %-6s, Bremse: %-4s, Limit %-6s",
					position, toBinaryString(pinCode),
					motor_left ? "links" : motor_right ? "rechts" : "aus",
					rotating_left ? "links" : rotating_right ? "rechts" : "aus", motorBreak ? "an" : "aus",
					limit_links ? "links" : limit_rechts ? "rechts" : "keines");
		}

	}

	private static final byte OUTPUT_MOTOR_RIGHT = 1;
	private static final byte OUTPUT_MOTOR_LEFT = 2;
	private static final byte OUTPUT_BREAK_ON = 4;
	private static final byte LIMIT_RIGHT = 16;
	private static final byte LIMIT_LEFT = 32;

	private static final int LIMIT_SWITCH_POSITON_AMOUNT_ABSOLUTE = 4;
	private static final int OVERFLOW_AMOUNT_ABSOLUTE = 6;

	public static void main(String[] args) {
		ElectricSledge schlitten = new ElectricSledge();
		byte status = 0;
		status = schlitten.nextCycle(status);
		status = OUTPUT_MOTOR_LEFT;
		status = schlitten.nextCycle(status);
		while ((status & LIMIT_LEFT) == 0) {
			status = schlitten.nextCycle(status);
		}
		status &= ~OUTPUT_MOTOR_LEFT;
		status = schlitten.nextCycle(status);
		status |= OUTPUT_BREAK_ON;
		status = schlitten.nextCycle(status);
		status &= ~OUTPUT_BREAK_ON;
		status = schlitten.nextCycle(status);
		status |= OUTPUT_MOTOR_RIGHT;
		status = schlitten.nextCycle(status);
		while ((status & LIMIT_RIGHT) == 0) {
			status = schlitten.nextCycle(status);
		}
		status &= ~OUTPUT_MOTOR_RIGHT;
		status = schlitten.nextCycle(status);
		status |= OUTPUT_BREAK_ON;
		status = schlitten.nextCycle(status);
		status &= ~OUTPUT_BREAK_ON;
		status = schlitten.nextCycle(status);

	}

	private static String toBinaryString(byte value) {
		String result = Integer.toBinaryString(Integer.valueOf(value));
		while (result.length() < 8) {
			result = "0" + result;
		}
		return result;
	};

}
