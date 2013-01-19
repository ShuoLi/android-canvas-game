package com.tarena;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity {
	
	CanvasView view;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view=new CanvasView(MainActivity.this);
        setContentView(view);
        AlphaThead alphaThead=new AlphaThead();
        alphaThead.start();
        Log.i("event","create view");
    }
    
    public class AlphaThead extends Thread{
    	public AlphaThead() {
			// TODO Auto-generated constructor stub
		}
    	@Override
    	public void run() {
    		while(true){
	    		if(!isInterrupted()){
		    		try {
						sleep(100);
						view.step();
					} catch (InterruptedException e) {
						interrupt();
					} catch	(Exception e){
						
					}
	    		}
    		}
    	}
    }
    
    
}