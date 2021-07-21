package com.techdot.graphapp.mathFunction;

import android.graphics.Color;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;

import java.util.ArrayList;

public class Function {

    public static ScatterData getSineData() {

        ArrayList<Entry> entries = new ArrayList<>();

        for (int i = 0; i < (6*360); i++) {
            float radians = (float) Math.toRadians(i);
            float value = (float) Math.sin(radians);
            entries.add(new Entry(i, value));
        }

        ScatterDataSet set = new ScatterDataSet(entries, "Sine function");
        set.setColor(Color.BLACK);

        ScatterData data = new ScatterData(set);

        return data;
    }

    public static ScatterData getCosineData() {

        ArrayList<Entry> entries = new ArrayList<>();

        for (int i = 0; i < (6*360); i++) {
            float radians = (float) Math.toRadians(i);
            float value = (float) Math.cos(radians);
            entries.add(new Entry(i, value));
        }

        ScatterDataSet set = new ScatterDataSet(entries, "Cosine function");
        set.setColor(Color.BLACK);

        ScatterData data = new ScatterData(set);

        return data;
    }

    public static ScatterData getTanData() {

        ArrayList<Entry> entries = new ArrayList<>();

        for (int i = 0; i < (6*360); i++) {
            float radians = (float) Math.toRadians(i);
            float value = (float) Math.tan(radians);
            entries.add(new Entry(i, value));
        }

        ScatterDataSet set = new ScatterDataSet(entries, "Tangent function");
        set.setColor(Color.BLACK);

        ScatterData data = new ScatterData(set);

        return data;
    }

    public static ScatterData getTData() {
        ArrayList<Entry> entries = new ArrayList<>();

        for (int i = 0; i < (500); i++) {
            entries.add(new Entry(i, i));
        }

        ScatterDataSet set = new ScatterDataSet(entries, "T function");
        set.setColor(Color.BLACK);

        ScatterData data = new ScatterData(set);

        return data;
    }
}
