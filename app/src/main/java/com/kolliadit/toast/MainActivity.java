package com.kolliadit.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref ; // 0 - for private mode
    SharedPreferences.Editor editor;
    Button B1;
    Button B2;
    Button B3;
    Button B4;
    Integer[] scores = new Integer[4];
    SeekBar seek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        B1 = findViewById(R.id.Button1);
//        B2 = findViewById(R.id.Button2);
//        B3 = findViewById(R.id.Button3);
//        B4 = findViewById(R.id.Button4);
        pref= getApplicationContext().getSharedPreferences("MyPref", 0);
        seek = (SeekBar) findViewById(R.id.SeekBar);
        editor = pref.edit();
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //grab data from sp
for(int num=0;num<4;num++)
        scores[num]=pref.getInt(""+num,0);



    }
    public void onC (View view){
        String num = view.getResources().getResourceName(view.getId()).trim();
        num = num.charAt(num.length() - 1) + "";
        scores[Integer.parseInt(num) - 1]++;
        //Log.i("scores", "" + scores[Integer.parseInt(qa.get(num))-1]);
        editor.putInt(num, scores[Integer.parseInt((num)) - 1]);
        editor.commit();
        Context context = getApplicationContext();
        CharSequence text = num + ": " + scores[Integer.parseInt((num)) - 1];
        int duration = Toast.LENGTH_SHORT;
        System.out.println(duration);
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

}

