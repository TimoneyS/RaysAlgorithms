package global;

import java.awt.Color;

public class Conf {
//	static {
//	    try {
//	    	String path = System.getProperty("user.dir")+ "\\src\\jdbc.properties";
//	    	//2.�õ��ļ�д����
//	    	FileInputStream is = new FileInputStream(path);
//	    	//3.ʵ�����ļ����������ļ���
//	    	Properties props = new Properties();
//	
//			props.load(is);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//    //4.��д�����м������������ļ�
	
	public static double 			SIZE 				= 5;						// �ߴ�
	
	public static boolean 			PLA_DIE				= false;					// ���̹�˿�������
	public static Color 			PLA_COLOR 			= new Color(255, 175, 175);	// ���̹����ɫ
	public static boolean 			PLA_CHEAT 			= false;					// ����
	public static double 			PLA_ROTATE_SPEED 	= Math.toRadians(4);		// ת���ٶ�
	
	public static double 			BULLET_SPEED 		= 20;						// �����ӵ��ٶ�
	public static double 			TANK_MOVE_SPEED 	= 10;						// �ƶ��ٶ�
	
	public static boolean 			AI_DIE 				= true;						// �����Ƿ������
	public static boolean 			AI_FIRE 			= true;						// ���Է���
	public static boolean 			AI_MOVE 			= true;						// �����ƶ�
	public static int 				AI_SHOOT_RATE 		= 100;						// ���伸�ʣ�����ԽСԽ��
	
	public static int 				MaxExplodRadius 	= 30;						// ��ը���ߴ�
	public static int 				EXPLODE_SPEED	 	= 3;						// ��ը�ĸ����ٶȣ�����Խ��Խ��
	
	public static double 			CrashOverlap 		= 3;						// ��ײ�����Եĳ߶�
	
	public static int 				D_HEIGTH 	   		= 600;
	public static int 				D_WIDTH  	   		= 800;
	public static int 				REFRESH_TIME 		= 30;						// ˢ�µļ������λ����
}
