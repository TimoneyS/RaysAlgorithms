package global;

public class Conf {
	public static double size = 5;											// �ߴ�
	
	public static boolean 			PLA_DIE = false;						// ���̹�˿�������
	public static java.awt.Color 	PLA_COLOR = java.awt.Color.pink;		// ���̹����ɫ
	public static boolean 			PLA_CHEAT = false;						// ����
	public static double 			PLA_ROTATE_SPEED = Math.toRadians(4);	// ת���ٶ�
	
	public static double 			BULLET_SPEED = 20;						// �����ӵ��ٶ�
	public static double 			TANK_MOVE_SPEED = 20;					// �ƶ��ٶ�
	
	public static boolean AI_DIE = true;									// �����Ƿ������
	public static boolean AI_FIRE = true;									// ���Է���
	public static boolean AI_MOVE = true;									// �����ƶ�
	public static int AI_SHOOT_RATE = 100;									// ���伸�ʣ�����ԽСԽ��
	
	public static int MaxExplodRadius = 30;									// ��ը���ߴ�
	public static int EXPLODE_SPEED = 3;									// ��ը�ĸ����ٶȣ�����Խ��Խ��
	
	public static double crashOverlap = 3;									// ��ײ����ӻ��ĳ߶�
	
	public static int D_HEIGTH = 600;
	public static int D_WIDTH = 800;
	public static int REFRESH_TIME = 30;									// ˢ�µļ������λ����
}
