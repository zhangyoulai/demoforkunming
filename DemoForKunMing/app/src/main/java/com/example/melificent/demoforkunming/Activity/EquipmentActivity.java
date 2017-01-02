package com.example.melificent.demoforkunming.Activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.melificent.demoforkunming.R;

/**
 * Created by Administrator on 2017/1/2 0002.
 */

public class EquipmentActivity extends AppCompatActivity {
    Button button;
    EditText CONTENT;
    LinearLayout ll_details,ll_equipment_descrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipment_activity);
        button = (Button) findViewById(R.id.equipment_search_button);
        ll_details = (LinearLayout) findViewById(R.id.ll_image_details);
        ll_equipment_descrip = (LinearLayout) findViewById(R.id.equipment_text_details);
        CONTENT = (EditText) findViewById(R.id.equipment_search_content);
        CONTENT.setText("风机");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_equipment_descrip.setVisibility(View.VISIBLE);
                ll_details.setVisibility(View.VISIBLE);
            }
        });

    }
}
