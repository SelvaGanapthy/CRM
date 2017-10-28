package com.example.admin.crm;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Admin on 10/28/2017.
 */

public class NewLead extends AppCompatActivity implements View.OnClickListener {
    private Calendar cal;
    private int day, month, year, backpress = 0;
    static final int DATE_PICKER_ID = 1111;
    Thread updateSeekbar;
    SeekBar seekBar;
    RelativeLayout include1, include2, include3, include4, voice_found;
    TextView tv_no_voice_found;
    EditText new_lead_Name, new_lead_phoneno, new_lead_Email, new_lead_Projects, date;
    String phoneValid = "[987]";
    Pattern pattern_Email = Pattern.compile("^.+@.+\\..+$");
    ImageView newLead_feedbackReg_buttonNxt, newLead_conversDetail_bNxt, emoji_happy, emoji_very_happy, emoji_sad;
    static MediaPlayer mp;
    static String adpath;
    static boolean volume = true;
    ImageButton playnpause_bt, volumeonnoff_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlead);
        initialize();
        Intent intent = getIntent();
        adpath = intent.getStringExtra("audiopath");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mp.seekTo(seekBar.getProgress());
            }
        });

        updateSeekbar = new Thread() {
            @Override
            public void run() {
                int totalduration = mp.getDuration(), currentduration = 0;
                while (currentduration < totalduration) {
                    try {
                        sleep(500);
                        currentduration = mp.getCurrentPosition();
                        seekBar.setProgress(currentduration);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }


}
