package com.example.android.sinclassassignment07_lenal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddActivity extends AppCompatActivity {

    private EditText animalName;
    private EditText numberOfLegs;
    private CheckBox hasFur;
    private EditText otherInformation;

    private Button submitButton;
    private String animalClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setTitle("Animal List");

        animalName = (EditText) findViewById(R.id.animalName);
        numberOfLegs = (EditText) findViewById(R.id.numberOfLegs);
        hasFur = (CheckBox) findViewById(R.id.hasFur);
        otherInformation = (EditText) findViewById(R.id.moreInformation);
        submitButton = (Button) findViewById(R.id.submitButton);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.type1:
                if (checked)
                    animalClass = "mammal";
                break;
            case R.id.type2:
                if (checked)
                    animalClass = "bird";
                break;
            case R.id.type3:
                if (checked)
                    animalClass = "fish";
                break;
            case R.id.type4:
                if (checked)
                    animalClass = "reptile";
                break;
            case R.id.otherType:
                if (checked)
                    animalClass = "other classes";
                break;
        }

    }

    public void submit(View view) {
        String n = animalName.getText().toString();
        int l = Integer.parseInt(numberOfLegs.getText().toString());
        Boolean f = hasFur.isChecked();
        String oi = otherInformation.getText().toString();
        Animal a = new Animal(n, l, f, animalClass, oi);

        Intent data = new Intent();
        data.putExtra(Keys.ANIMAL, a);
        setResult(RESULT_OK, data);
        finish();

    }
}
