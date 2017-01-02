package com.example.melificent.demoforkunming.Activity;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.example.melificent.demoforkunming.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/2 0002.
 */

public class GasActivity extends AppCompatActivity {
    TextView title, toatal, ch4, sh2, o2;
    PieChart pieChart;
    LineChart lineChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gas_activity);
        title = (TextView) findViewById(R.id.gas_title);
        toatal = (TextView) findViewById(R.id.gas_total);
        ch4 = (TextView) findViewById(R.id.gas_ch4);
        o2 = (TextView) findViewById(R.id.gas_02);
        sh2= (TextView) findViewById(R.id.gas_sh2);
        pieChart = (PieChart) findViewById(R.id.pichart);
        lineChart = (LineChart) findViewById(R.id.linechart);
        title.setText("欢迎查看气体详情");
        toatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //生成饼状图，查看气体总览
                getPieChart();
                title.setText("气体总览");

            }
        });
        ch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLineChart();
                title.setText("甲烷");
            }
        });

    }

    private void getLineChart() {

    }

    private void getPieChart() {
        PieData piedata  = getPieData(4,100);
        showChart(pieChart,piedata);
    }
    private PieData getPieData(int count,float range){
        ArrayList<String> values = new ArrayList<>();
        values.add("甲烷");
        values.add("氧气");
        values.add("硫化氢");
        values.add("其它");
        ArrayList<Entry> yvalues = new ArrayList<>();
        float ch4 = 14;
        float o2 = 38;
        float sh2 = 38;
        float others = 14;
        yvalues.add(new Entry(ch4,0));
        yvalues.add(new Entry(o2,0));
        yvalues.add(new Entry(sh2,2));
        yvalues.add(new Entry(others,3));
        PieDataSet pieDataset= new PieDataSet(yvalues,"");
        pieDataset.setSliceSpace(0);
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.rgb(205,205,205));
        colors.add(Color.rgb(114,188,223));
        colors.add(Color.rgb(255,123,124));
        colors.add(Color.rgb(57,135,200));
        pieDataset.setColors(colors);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5*(metrics.densityDpi /160);
        pieDataset.setSelectionShift(px);
        PieData piedata = new PieData(values,pieDataset);

        return piedata;
    }
    private  void  showChart(PieChart piechart,PieData piedata){
        piechart.setHoleColorTransparent(true);
        piechart.setTransparentCircleRadius(64f);
        piechart.setDescription("");
        piechart.setDrawCenterText(true);
        piechart.setDrawHoleEnabled(true);
        piechart.setUsePercentValues(true);
        piechart.setCenterText("气体分布总览");
        piechart.setData(piedata);
        Legend legend = piechart.getLegend();
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_RIGHT);
        legend.setXEntrySpace(7f);
        legend.setYEntrySpace(5f);
       piechart.animateXY(1000,2000);
    }

}
