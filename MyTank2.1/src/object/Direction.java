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
	
	public void plus(Direction tar){
		x = (x + tar.getX() == 0) ? 0 : x | tar.getX();
		y = (y + tar.getY() == 0) ? 0 : y | tar.getY();
		
		degrees = ( Math.toDegrees(Math.atan2(x, y)) + 360 ) % 360;
		radians = Math.toRadians(toDegrees());
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
		System.out.printf("( %2d, %2s) -> ½Ç¶È : %3s, »¡¶È : %3s \n", x, y, toDegrees(), toRadians());
	}
	
	public boolean isZero() {
		return x==0 && y == 0;
		
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	
//	public static void main(String[] args) {
//		Direction w = new Direction(0, 1);
//		Direction s = new Direction(0, -1);
//		Direction a = new Direction(-1, 0);
//		Direction d = new Direction(1, 0);
//		
//		Direction[] input = new Direction[]{ s };
//		
//		
//		Direction z = new Direction(0, 0);
//		for(Direction dir : input)
//			z.plus(dir);
//		z.inspect_print();
//	}

}

