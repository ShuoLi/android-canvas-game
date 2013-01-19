package com.tarena;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circle {
	int radius;
	float x;
	float y;
	Paint paint;
	int alpha;
	List<Circle> parent;
	
	public Circle(int radius, float f, float g,List<Circle> parent) {
		super();
		this.radius = radius;
		this.x = f;
		this.y = g;
		this.parent=parent;
		alpha=0;
		paint=new Paint();
		paint.setColor(Color.rgb(
				//
				(int) (100+Math.random()*155), 
				//
				(int) (100+Math.random()*155), 
				//
				(int) (100+Math.random()*155)));
	}

	public void draw(Canvas canvas){
		if(alpha>255){
			return;
		}
		paint.setAlpha(255-alpha);
		canvas.drawCircle(x, y, radius, paint);
	}
	
	public void step(){
		alpha+=10;
		radius+=10;
		
	}
}
