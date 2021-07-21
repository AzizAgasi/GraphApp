package com.techdot.graphapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowInsetsAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.LineData;
import com.techdot.graphapp.mathFunction.Function;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ScatterChart chart;
    private EditText input;
    private Button enter;
    private Button play;
    private Button pause;

    private Runnable background;
    String userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chart = findViewById(R.id.graphView);
        input = findViewById(R.id.userInput);
        enter = findViewById(R.id.enterData);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.getText().toString().equals("")) {
                    userInput = input.getText().toString();
                    getData();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a function", Toast.LENGTH_SHORT).show();
                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.run();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void getData() {
        initializeChart();
        if (userInput.contains("sin") || userInput.contains("sine")) {
            background = new Runnable() {
                @Override
                public void run() {
                    chart.setData(Function.getSineData());
                }
            };
            background.run();
        } else if (userInput.contains("cos") || userInput.contains("cosine")) {
            background = new Runnable() {
                @Override
                public void run() {
                    chart.setData(Function.getCosineData());
                }
            };
            background.run();
        } else if (userInput.contains("tan") || userInput.contains("tangent")) {
            background = new Runnable() {
                @Override
                public void run() {
                    chart.setData(Function.getTanData());
                }
            };
            background.run();
        } else if (userInput.contentEquals("(t)") || userInput.contentEquals("t")) {
            background = new Runnable() {
                @Override
                public void run() {
                    chart.setData(Function.getTData());
                }
            };
            background.run();
        }
    }

    private void initializeChart() {
        chart.setDrawGridBackground(false);
        chart.getDescription().setEnabled(false);
        chart.setDrawGridBackground(false);
        chart.animateX(5000);
    }
}