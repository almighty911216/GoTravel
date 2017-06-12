package com.example.almig.android;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.androidbootstrap.BootstrapButton;
import com.example.fabanimation.FloatingActionButton;
import com.example.materialtextfield.MaterialTextField;
import com.example.materialtimepicker.date.DatePickerDialog;
import com.example.materialtimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class WriteFootprintTextActivity extends AppCompatActivity {
    private MaterialTextField mTfTitle;
    private EditText mEtTitle;
    private BootstrapButton mBtnTime;
    private BootstrapButton mBtnDate;
    private ImageView mIvPicture;
    private FloatingActionButton mFabCam;
    private FloatingActionButton mFabAlbum;

    private void initBinding() {
        mTfTitle = (MaterialTextField) findViewById(R.id.mtf_write_footprint_title);
        mEtTitle = (EditText) findViewById(R.id.et_write_footprint_title);
        mBtnTime = (BootstrapButton) findViewById(R.id.btn_footprint_write_time);
        mBtnDate = (BootstrapButton) findViewById(R.id.btn_footprint_write_date);
        mIvPicture = (ImageView) findViewById(R.id.iv_footprint_write_picture);
        mFabCam = (FloatingActionButton) findViewById(R.id.fam_footprint_camera);
        mFabCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mFabAlbum = (FloatingActionButton) findViewById(R.id.fam_footprint_album);
        mFabAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void initTitle() {
    }

    private void initTimePicker() {
        mBtnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog tpd = TimePickerDialog.newInstance(new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
                        String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
                        String minuteString = minute < 10 ? "0" + minute : "" + minute;
                        String time = hourString + "시 " + minuteString + "분";
                        mBtnTime.setText(time);
                    }
                }, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false);

                tpd.setThemeDark(true);

                tpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        Log.d("TimePicker", "Dialog was cancelled");
                    }
                });
                Log.d("asd", getFragmentManager().toString());
                tpd.show(getFragmentManager(), "TimepickerDiaglog");
            }
        });

        mBtnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                                String date = dayOfMonth + "/" + (++monthOfYear) + "/" + year;
                                mBtnDate.setText(date);
                            }
                        },
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setThemeDark(true);
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_footprint_text);

        initBinding();
        initTimePicker();
    }
}