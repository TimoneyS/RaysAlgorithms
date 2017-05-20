package global;

import java.awt.Color;

public class Conf {
//	static {
//	    try {
//	    	String path = System.getProperty("user.dir")+ "\\src\\jdbc.properties";
//	    	//2.得到文件写入流
//	    	FileInputStream is = new FileInputStream(path);
//	    	//3.实例化文件属性配置文件类
//	    	Properties props = new Properties();
//	
//			props.load(is);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//    //4.从写入流中加载属性配置文件
	
	public static double 			SIZE 				= 5;						// 尺寸
	
	public static boolean 			PLA_DIE				= false;					// 玩家坦克可以死亡
	public static Color 			PLA_COLOR 			= new Color(255, 175, 175);	// 玩家坦克颜色
	public static boolean 			PLA_CHEAT 			= false;					// 作弊
	public static double 			PLA_ROTATE_SPEED 	= Math.toRadians(4);		// 转向速度
	
	public static double 			BULLET_SPEED 		= 20;						// 发射子弹速度
	public static double 			TANK_MOVE_SPEED 	= 10;						// 移动速度
	
	public static boolean 			AI_DIE 				= true;						// 电脑是否会死亡
	public static boolean 			AI_FIRE 			= true;						// 电脑发射
	public static boolean 			AI_MOVE 			= true;						// 电脑移动
	public static int 				AI_SHOOT_RATE 		= 100;						// 发射几率，数字越小越快
	
	public static int 				MaxExplodRadius 	= 30;						// 爆炸最大尺寸
	public static int 				EXPLODE_SPEED	 	= 3;						// 爆炸的更新速度，数字越大越快
	
	public static double 			CrashOverlap 		= 3;						// 碰撞检测忽略的尺度
	
	public static int 				D_HEIGTH 	   		= 600;
	public static int 				D_WIDTH  	   		= 800;
	public static int 				REFRESH_TIME 		= 30;						// 刷新的间隔，单位毫秒
}
