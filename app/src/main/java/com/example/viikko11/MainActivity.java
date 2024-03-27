package com.example.viikko11;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Context context;

    private Button addGrocery;

    private RecyclerView rvGroceries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            addGrocery = findViewById(R.id.buttonAddNewGrocery);
            rvGroceries = findViewById(R.id.rvGroceries);
            rvGroceries.setLayoutManager(new LinearLayoutManager(this));
            ArrayList<Grocery> groceries = new ArrayList<>();
            groceries = ListGrocery.getInstance().getGroceries();
            rvGroceries.setAdapter(new GroceryListAdapter(getApplicationContext(), groceries));

            addGrocery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AddGroceryActivity.class);
                    startActivity(intent);
                }
            });
            return insets;
        });


    }



}