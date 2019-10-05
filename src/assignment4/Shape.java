package assignment4;

import java.math.RoundingMode;
import java.text.DecimalFormat;

class Shape{
		String name;
		float perimeter;
		float area;
		
		Shape(){
			
		}
		
		void draw() {
			System.out.println("Drawing " + this.getClass().getSimpleName());
		}
		
		void getArea() {
		}
		
		void getPerimeter() {
		}				
	
	static class Circle extends Shape{
		private float radius;
		
		Circle(float radius) {
			this.radius = radius;
		}
		private float getRadius() {
			return this.radius;
		}
		
		void getArea() {
			float radius = getRadius();
			super.area = (float) (radius * radius * Math.PI);
			DecimalFormat df = new DecimalFormat("0.00");
			df.setRoundingMode(RoundingMode.DOWN);
			System.out.println(df.format(area));
		}
		
		void getPeimeter() {
			float radius = getRadius();
			super.perimeter = (float) ( 2 * radius * Math.PI);
			DecimalFormat df = new DecimalFormat("0.00");
			df.setRoundingMode(RoundingMode.DOWN);
			System.out.println(df.format(perimeter));
		}
	}
	
	static class Rectangle extends Shape{
		private float width;
		private float height;
		
		Rectangle(float width, float height){
			this.width = width;
			this.height = height;
		}
		
		private float getWidth() {
			return this.width;
		}
		
		private float getHeight() {
			return this.height;
		}
		
		void getArea() {
			float width = getWidth();
			float height = getHeight();
			super.area = width * height;
			System.out.println(area);
		}
		
		void getPerimeter() {
			float width = getWidth();
			float height = getHeight();
			super.perimeter = ( width + height ) * 2f;
			System.out.println(perimeter);
		}
	}
	
	static class Square extends Shape{
		private float side;
		
		private float getSide() {
			return this.side;
		}
		
		Square(float side){
			this.side = side;
		}
		void getArea() {
			float side = getSide();
			super.area = side * side;
			System.out.println(area);
		}
		void getPerimeter() {
			float side = getSide();
			super.perimeter = side * 4f;
			System.out.println(perimeter);
		}
	}
	
	public static void main(String[] args) {
		Shape s = new Shape();
		Rectangle r= new Rectangle(2.0f, 3.0f);
		Circle c = new Circle(4.0f);
		Square sq = new Square(4.0f);
		
		r.getArea();
		r.getPerimeter();
		c.getArea();
		c.getPeimeter();
		sq.getArea();
		sq.getPerimeter();
		r.draw();
		c.draw();
		s.draw();
		sq.draw();
	}
}






