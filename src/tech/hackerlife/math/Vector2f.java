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
	public Vector2f divideVec(Vector2f vec) {
		float x = this.x / vec.x;
		float y = this.y / vec.y;
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
		return x == vec.x && y == vec.y;
	}
	
	public Point scale(float scale) {
		Vector2f temp = this.mult(scale);
		return new Point((int)temp.x, (int)temp.y);
	}
	
	/**
	 * @param scale Put 1 for normal use
	 */
	public void drawVector(Graphics g, Vector2f pos, float scale, Color vectorColor) {
		g.setColor(vectorColor);
		
		Point scaledInitial = pos.scale(scale);
		Point scaledFinal = this.scale(scale);
	    int dx = scaledFinal.x;
	    int dy = scaledFinal.y;
	    double D = Math.sqrt(dx*dx + dy*dy);
	    double xm = D - VECTOR_ARROW_SIZE, xn = xm, ym = VECTOR_ARROW_SIZE, yn = -VECTOR_ARROW_SIZE, x;
	    double sin = dy / D, cos = dx / D;

	    x = xm*cos - ym*sin + scaledInitial.x;
	    ym = xm*sin + ym*cos + scaledInitial.y;
	    xm = x;

	    x = xn*cos - yn*sin + scaledInitial.x;
	    yn = xn*sin + yn*cos + scaledInitial.y;
	    xn = x;

	    int[] xpoints = {scaledFinal.x, (int) xm, (int) xn};
	    int[] ypoints = {scaledFinal.y, (int) ym, (int) yn};

	    g.drawLine(scaledInitial.x, scaledInitial.y, scaledFinal.x, scaledFinal.y);
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