package object;

public class Direction {
	
	public static final Direction UP = new Direction(0, 1);
	public static final Direction DOWN = new Direction(0, -1);
	public static final Direction LEFT = new Direction(-1, 0);
	public static final Direction RIGHT = new Direction(1, 0);
	
	private int x;
	private int y;
	private Double degrees = null;
	private Double radians = null;
	
	public Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Direction plus(Direction tar){
		int i = (x + tar.getX() == 0) ? 0 : x | tar.getX();
		int j = (y + tar.getY() == 0) ? 0 : y | tar.getY();
		return new Direction(i, j);
	}
	
	public double toDegrees(){
		if(degrees == null) degrees = ( Math.toDegrees(Math.atan2(x, y)) + 360 ) % 360;
		return degrees;
	}
	
	public double toRadians(){
		if(radians == null) radians = Math.toRadians(toDegrees());
		return radians;
	}
	
	public void inspect_print() {
		System.out.printf("( %2d, %2s) -> Deg : %3s, Rad : %3s \n", x, y, toDegrees(), toRadians());
	}
	
	public boolean isZero() {
		return x==0 && y == 0;
		
	}
	
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }

	public static void main(String[] args) {
		Direction w = new Direction(0, 1);
		Direction s = new Direction(0, -1);
		Direction a = new Direction(-1, 0);
		Direction d = new Direction(1, 0);
		
		Direction[] input = new Direction[]{ s, a, d, w};
		
		
		Direction z = new Direction(0, 0);
		for(Direction dir : input)
			z = z.plus(dir);
		z.inspect_print();
	}
	

}

