package com.zfuller.task71_zacharyfuller;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zfuller.task71_zacharyfuller.data.DatabaseHelper;
import com.zfuller.task71_zacharyfuller.model.Item;

public class NewAdvertActivity extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newadvert);

        EditText editTextName = (findViewById(R.id.editTextName));
        EditText editTextPhone = (findViewById(R.id.editTextPhone));
        EditText editTextDesc = (findViewById(R.id.editTextDesc));
        EditText editTextDate = (findViewById(R.id.editTextDate));
        EditText editTextLocation = (findViewById(R.id.editTextLocation));
        Button btnSave = (findViewById(R.id.btnSave));
        RadioGroup radioGroup = (findViewById(R.id.radioGroup));

        db = new DatabaseHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton radioSelected;
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioSelected = findViewById(radioId);
                String type = radioSelected.getText().toString();
                String name = editTextName.getText().toString();
                String phone = editTextPhone.getText().toString();
                String desc = editTextDesc.getText().toString();
                String date = editTextDate.getText().toString();
                String location = editTextLocation.getText().toString();

                if (!name.isEmpty() && !phone.isEmpty() && !desc.isEmpty() && !date.isEmpty() && !location.isEmpty()) {
                    long check = db.insertItem(new Item(type, name, phone, desc, date, location));
                    Log.d("abc", String.valueOf(check));
                    if (check > 0) {
                        Toast.makeText(NewAdvertActivity.this, "Item submitted successfully!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(NewAdvertActivity.this, "Submission error...", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(NewAdvertActivity.this, "Please fill in all entries before saving", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    public void checkForEmpty() {
//        if (!name.isEmpty() && !phone.isEmpty() && !desc.isEmpty() && !date.isEmpty() && !location.isEmpty()) {
//            check = true;
//        } else {
//            Toast.makeText(NewAdvertActivity.this, "Please fill in all entries before saving", Toast.LENGTH_SHORT).show();
//            check = false;
//        }
//    }

//    public void checkRadioBtn() {
//        if (rdoLost.isChecked()) {
//            typeStatus = "lost";
//
//        } else if (rdoFound.isChecked()) {
//            typeStatus = "found";
//        }
//    }
}
