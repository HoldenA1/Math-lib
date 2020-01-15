package tech.hackerlife.math;

import java.awt.*;

public class Vector2f {
	public float x, y;
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @param angle in radians measured from the x-axis
	 * @param mag is magnitude of vector
	 */
	public Vector2f(double theta, float mag) {
		this.x = (float) (mag * Math.cos(theta));
		this.y = (float) (mag * Math.sin(theta));
	}
	
	/**
	 * @return the resultant vector
	 */
	public Vector2f add(Vector2f vec) {
		float x = this.x + vec.x;
		float y = this.y + vec.y;
		return new Vector2f(x, y);
	}
	
	/**
	 * @return the resultant vector
	 */
	public Vector2f add(float scalar) {
		float x = this.x + scalar;
		float y = this.y + scalar;
		return new Vector2f(x, y);
	}
	
	/**
	 * @return the resultant vector
	 */
	public Vector2f div(Vector2f vec) {
		float x = this.x / vec.x;
		float y = this.y / vec.y;
		return new Vector2f(x, y);
	}
	
	public Vector2f div(float scalar) {
		float x = this.x / scalar;
		float y = this.y / scalar;
		return new Vector2f(x, y);
	}
	
	/**
	 * @return the resultant vector
	 */
	public Vector2f mult(float scalar) {
		float x = this.x * scalar;
		float y = this.y * scalar;
		return new Vector2f(x, y);
	}
	
	public float mag() {
		return (float) Math.sqrt(x*x + y*y);
	}
	
	/**
	 * @return the resultant vector
	 */
	public Vector2f normalize() {
		float magnitude = this.mag();
		if (magnitude > 0) {
			return this.div(magnitude);
		}
		return this;
	}
	
	/**
	 * @return angle in radians
	 */
	public double dir() {
		return Math.atan2(this.y, this.x);
	}
	
	public boolean equals(Vector2f vec) {
		return x == vec.x && y == vec.y;
	}
	
	public Point scale(float scale) {
		Vector2f temp = this.mult(scale);
		return new Point((int)temp.x, (int)temp.y);
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public static Vector2f zero() {
		return new Vector2f(0, 0);
	}

}