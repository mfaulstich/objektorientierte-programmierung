package de.fhswf.inf.oop.aufgabe1.uebung2;


public class ElectricSlide {

    // PIO Pinbelegung
    public static final byte OUTPUT_MOTOR_RIGHT = 1;
    public static final byte OUTPUT_MOTOR_LEFT = 2;
    public static final byte OUTPUT_BREAK = 4;
    public static final byte INPUT_LIMIT_RIGHT = 16;
    public static final byte INPUT_LIMIT_LEFT = 32;

    // Grenzwerte
    private static final int LIMIT_SWITCH_POSITON_AMOUNT_ABSOLUTE = 10;
    private static final int OVERFLOW_AMOUNT_ABSOLUTE = 12;

	private static String toBinaryString(byte value) {
		String result = Integer.toBinaryString(Integer.valueOf(value));
		while (result.length() < 8) {
			result = "0" + result;
		}
		return result;
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

    byte pioState;

    public byte nextCycle(byte pioState) {

        // Ausmaskieren der Read-Only-Pins
        byte newPioState = (byte) (this.pioState & 0xF0);
        newPioState = (byte) (pioState & 0x0F);

        overflow_left = position < -OVERFLOW_AMOUNT_ABSOLUTE;
        wand_rechts_overflow = position > OVERFLOW_AMOUNT_ABSOLUTE;
        limit_links = position <= -LIMIT_SWITCH_POSITON_AMOUNT_ABSOLUTE;
        limit_rechts = position >= LIMIT_SWITCH_POSITON_AMOUNT_ABSOLUTE;
        motor_left = (newPioState & OUTPUT_MOTOR_LEFT) != 0;
        motor_right = (newPioState & OUTPUT_MOTOR_RIGHT) != 0;
        motorBreak = (newPioState & OUTPUT_BREAK) != 0;

        rotating_left = rotating_left && !motorBreak;
        rotating_right = rotating_right && !motorBreak;

        if (overflow_left) {
            throw new IllegalStateException("electricSlide ist vor die linke Wand gefahren");
        }
        if (wand_rechts_overflow) {
            throw new IllegalStateException("electricSlide ist vor die rechte Wand gefahren");
        }
        if (limit_links) {
            newPioState |= INPUT_LIMIT_LEFT;
        } else {
            newPioState &= ~INPUT_LIMIT_LEFT;
        }
        if (limit_rechts) {
            newPioState |= INPUT_LIMIT_RIGHT;
        } else {
            newPioState &= ~INPUT_LIMIT_RIGHT;
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
        this.pioState = newPioState;
        System.out.println(this);
        return this.pioState;
    }

    public String toString() {
        return String.format("Position: %4d, pioState: %s, Motor: %-6s, Dreht: %-6s, Bremse: %-4s, Limit %-6s",
                position, toBinaryString(pioState),
                motor_left ? "links" : motor_right ? "rechts" : "aus",
                rotating_left ? "links" : rotating_right ? "rechts" : "aus", motorBreak ? "an" : "aus",
                limit_links ? "links" : limit_rechts ? "rechts" : "keines");
    }
}
