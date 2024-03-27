package com.example.viikko11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddGroceryActivity extends AppCompatActivity {

    private EditText editName, editNote;
    private Button buttonAddGroceryTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_grocery);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            editName = findViewById(R.id.editGroceryName);
            editNote = findViewById(R.id.editGroceryNote);
            buttonAddGroceryTo = findViewById(R.id.buttonAddGrocery);

            buttonAddGroceryTo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ListGrocery.getInstance().addGrocery(new Grocery(editName.getText().toString(), editNote.getText().toString()));
                    Intent intent = new Intent(AddGroceryActivity.this, MainActivity.class);
                    startActivity(intent);

                }
            });



            return insets;
        });
    }
}