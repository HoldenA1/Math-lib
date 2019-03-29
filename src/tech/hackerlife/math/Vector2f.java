package tech.hackerlife.math;

import java.awt.*;

public class Vector2f {
	// Down is positive!!
	float x, y;
	final float VECTOR_ARROW_SIZE = 10;
	
	public static final Vector2f ZERO = new Vector2f(0, 0);
	
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
		float x = this.x + vec.X();
		float y = this.y + vec.Y();
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
	public Vector2f divideVec(Vector2f vec) {
		float x = this.x / vec.X();
		float y = this.y / vec.Y();
		return new Vector2f(x, y);
	}
	
	public Vector2f divideScalar(float scalar) {
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
			return this.divideScalar(magnitude);
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
		return x == vec.X() && y == vec.Y();
	}
	
	/**
	 * @param scale Put 1 for normal use
	 */
	public void drawVector(Graphics g, Vector2f pos, float scale, Color vectorColor) {
		g.setColor(vectorColor);
		
		Vector2f scaledInitial = pos.mult(scale);
		Vector2f scaledFinal = this.mult(scale);
		scaledFinal = scaledFinal.add(scaledInitial);
	    int dx = (int) (scaledFinal.X() - scaledInitial.X());
	    int dy = (int) (scaledFinal.Y() - scaledInitial.Y());
	    double D = Math.sqrt(dx*dx + dy*dy);
	    double xm = D - VECTOR_ARROW_SIZE, xn = xm, ym = VECTOR_ARROW_SIZE, yn = -VECTOR_ARROW_SIZE, x;
	    double sin = dy / D, cos = dx / D;

	    x = xm*cos - ym*sin + scaledInitial.X();
	    ym = xm*sin + ym*cos + scaledInitial.Y();
	    xm = x;

	    x = xn*cos - yn*sin + scaledInitial.X();
	    yn = xn*sin + yn*cos + scaledInitial.Y();
	    xn = x;

	    int[] xpoints = {(int) scaledFinal.X(), (int) xm, (int) xn};
	    int[] ypoints = {(int) scaledFinal.Y(), (int) ym, (int) yn};

	    g.drawLine((int) scaledInitial.X(), (int) scaledInitial.Y(), (int) scaledFinal.X(), (int) scaledFinal.Y());
	    g.fillPolygon(xpoints, ypoints, 3);
	}
	
	public float X() {
		return x;
	}
	
	public float Y() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}