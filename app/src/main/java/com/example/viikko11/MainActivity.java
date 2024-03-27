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
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private Context context;

    private Button addGrocery;
    private ImageButton imageTime, imageAlphabet;

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
            imageTime = findViewById(R.id.imageTime);
            imageAlphabet = findViewById(R.id.imageAlphabet);
            rvGroceries.setLayoutManager(new LinearLayoutManager(this));
            ArrayList<Grocery> groceries = new ArrayList<>();
            groceries = ListGrocery.getInstance().getGroceries();
            ArrayList<Grocery> finalGroceries = groceries;
            imageAlphabet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Collections.sort(finalGroceries,
                            new Comparator<Grocery>() {
                                @Override
                                public int compare(Grocery o1, Grocery o2) {
                                    return o1.getName().compareToIgnoreCase(o2.getName());
                                }
                            });
                    rvGroceries.setAdapter(new GroceryListAdapter(getApplicationContext(), finalGroceries));

                }

            });

            imageTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Collections.sort(finalGroceries, new Comparator<Grocery>() {
                        @Override
                        public int compare(Grocery o1, Grocery o2) {
                            long one = o1.getTimeStamp().getTime();
                            long two = o2.getTimeStamp().getTime();
                            if(one > two){
                                return 1;
                            } else if (one < two){
                                return -1;

                            } else{
                            return 0;
                            }

                        }
                    });
                    rvGroceries.setAdapter(new GroceryListAdapter(getApplicationContext(), finalGroceries));

                }
            });

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