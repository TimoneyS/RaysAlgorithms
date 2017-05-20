package global;

public class Conf {
	public static double size = 5;											// 尺寸
	
	public static boolean 			PLA_DIE = false;						// 玩家坦克可以死亡
	public static java.awt.Color 	PLA_COLOR = java.awt.Color.pink;		// 玩家坦克颜色
	public static boolean 			PLA_CHEAT = false;						// 作弊
	public static double 			PLA_ROTATE_SPEED = Math.toRadians(4);	// 转向速度
	
	public static double 			BULLET_SPEED = 20;						// 发射子弹速度
	public static double 			TANK_MOVE_SPEED = 20;					// 移动速度
	
	public static boolean AI_DIE = true;									// 电脑是否会死亡
	public static boolean AI_FIRE = true;									// 电脑发射
	public static boolean AI_MOVE = true;									// 电脑移动
	public static int AI_SHOOT_RATE = 100;									// 发射几率，数字越小越快
	
	public static int MaxExplodRadius = 30;									// 爆炸最大尺寸
	public static int EXPLODE_SPEED = 3;									// 爆炸的更新速度，数字越大越快
	
	public static double crashOverlap = 3;									// 碰撞检测延缓的尺度
	
	public static int D_HEIGTH = 600;
	public static int D_WIDTH = 800;
	public static int REFRESH_TIME = 30;									// 刷新的间隔，单位毫秒
}
