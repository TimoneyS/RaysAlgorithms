package object;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;

import global.Conf;
/**
 * 
 * @author Ray
 *	主要用于 Tank Bullet 的方法规定
 */
public abstract class CollideItem extends Item {
	
	protected Color  color;						//用来区分坦克所属的阵营
	protected double direction;					//方向
	
	public CollideItem(double x, double y, double direction, Color color) {
		this.x 			= x;
		this.y 			= y;
		this.direction 	= direction;
		this.color 		= color;	
	}
	
	public boolean collide(CollideItem target) {
		boolean rs = false;
		
		if(collideCheck(target)) {
			onCollide(target);
			rs = true;
		}
		
		if(outOfBoundCheck()) {
			onOutOfBound();
			rs = true;
		}
		
		return rs;
	}
	
	// 冲撞集合
	public boolean collide(List<? extends CollideItem> list) {
		boolean result = false;
		Iterator<? extends CollideItem> i = list.iterator();
		while(i.hasNext()) {
			if(( result = collide(i.next()) ) ) break;
		}
		return result;
	}
	
	public boolean collideCheck(CollideItem target) {
		boolean result = false;
		if(target.hashCode() == hashCode()) {				// 目标是当前对象自身
			result = false;													
		} else {
			double dx = Math.abs(getX() - target.getX());	// 坐标差用于和距离比较								
			double dy = Math.abs(getY() - target.getY());
			// 距离减去缓冲
			double d = target.getRadius() + getRadius() - Conf.CrashOverlap;
			if( dx <= d && dy <= d ) result = true;
		}
		return result;
	}
	
	public abstract void onCollide(CollideItem target);
	
	public boolean outOfBoundCheck() {
		return (Math.abs(x-Conf.D_WIDTH/2) >= (Conf.D_WIDTH/2-getRadius()) ||
				Math.abs(y-Conf.D_HEIGTH/2) >= (Conf.D_HEIGTH/2-getRadius())) ;
	}
	
	// 越界的处理
	public abstract void onOutOfBound();
	
	public Color getColor() { return color; }
	
	public abstract double getRadius();
}