package com.example.gamesinfo;


import static com.example.gamesinfo.GameData.data;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import java.util.Objects;

public class InfoData extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_data);
        findViewById(R.id.back).setOnClickListener(v -> finish());
        int pos = Objects.requireNonNull(getIntent().getExtras()).getInt("POS", 0);
        TextView bar = findViewById(R.id.name);
        TextView infoText = findViewById(R.id.info_text);
        ImageView imgInfo = findViewById(R.id.ifo_img);
        bar.setText(data.get(pos).name);
        infoText.setText(data.get(pos).info);
        Glide.with(this)
                .load(data.get(pos).img)
                .into(imgInfo);
    }
}
