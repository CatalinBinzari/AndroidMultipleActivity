package com.example.tut11;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    @SuppressLint("StaticFieldLeak")
    private static ListView list_view;
    private static String[] NAMES= new String[] {"Cat","bin","cez","aliona","irina"};

    private static SeekBar seek_bar;
    private static TextView text_View;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listView();
        seekbar();
    }
    public void listView(){
        list_view = (ListView) findViewById(R.id.listWiew);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.name_list, NAMES);//returneaza ptr fiecare item din NAMES, o colectie de obiecte de tip list_name in adapter
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String value = (String) list_view.getItemAtPosition(position);
                        Toast.makeText(Main3Activity.this, "Position: "+position+", value: "+value,
                        Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void seekbar(){
        seek_bar = (SeekBar) findViewById(R.id.seekBar);
        text_View = (TextView) findViewById(R.id.textView2);
        text_View.setText("Covered: "+ seek_bar.getProgress() + " / "+ seek_bar.getMax());
        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress_value ;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value=progress;
                text_View.setText("Covered: "+ progress_value + " / "+ seek_bar.getMax());
                Toast.makeText(Main3Activity.this, "in progress... ",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Main3Activity.this, "Start progress... ",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                text_View.setText("Covered: "+ progress_value + " / "+ seek_bar.getMax());
                Toast.makeText(Main3Activity.this, "Stop progress... ",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
