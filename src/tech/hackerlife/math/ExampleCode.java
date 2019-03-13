package tech.hackerlife.math;

public class ExampleCode {

	public static void main(String[] args) {
		Vector2f v1 = new Vector2f(2, 5);
		Vector2f v2 = new Vector2f(-10, 7);

		Vector2f v3 = v1.add(v2);
		
		System.out.println(v3.toString());
	}

}