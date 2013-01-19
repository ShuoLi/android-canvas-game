package com.tarena;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View {

	List<Circle> circles = Collections
			.synchronizedList(new ArrayList<Circle>());

	public CanvasView(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {

		for (int i = 0; i < circles.size(); i++) {
			Circle circle = circles.get(i);
			circle.draw(canvas);
			circle.step();
			if (circle.alpha >= 255) {
				circles.remove(circle);
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		circles.add(new Circle(10, event.getX(), event.getY(), circles));
		postInvalidate();
		return true;
	}

	public void step() {
		postInvalidate();
	}

}
