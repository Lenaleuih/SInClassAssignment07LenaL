package com.example.android.sinclassassignment07_lenal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Animal List");
    }

    public void addAnimal(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivityForResult(intent, Keys.REQUEST_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        displayView = (TextView) findViewById(R.id.animalView);
        String currentDisplay = displayView.getText().toString();

        if (requestCode == 112 && resultCode == RESULT_OK) {
            Animal a = (Animal) data.getSerializableExtra(Keys.ANIMAL);

            if (currentDisplay.equals("")) {
                displayView.setText(a.toString());
            } else {
                displayView.setText(currentDisplay + "\n\n\n" + a.toString());
            }
        }
    }


}
