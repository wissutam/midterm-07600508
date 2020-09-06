package th.ac.su.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clearButton = findViewById(R.id.button_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Distance = findViewById(R.id.text_distance);
                EditText Time = findViewById(R.id.text_time);
                TextView Ans = findViewById(R.id.text_ans);

                Distance.setText("");
                Time.setText("");
                Ans.setText("");
            }
        });

        Button calButton = findViewById(R.id.button_cal);
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText Distance = findViewById(R.id.text_distance);
                EditText Time = findViewById(R.id.text_time);

                String Distance2 = Distance.getText().toString();
                String Time2 = Time.getText().toString();

                TextView Ans = findViewById(R.id.text_ans);

                if(Distance2.length()==0 || Time2.length()==0){
                    Toast t = Toast.makeText(MainActivity.this, R.string.Distanceandtime,Toast.LENGTH_LONG);
                    t.show();
                }
                if(Distance2.length()>0 && Time2.length()>0){

                    if(Time2.equals("0")){
                        Toast t = Toast.makeText(MainActivity.this, R.string.TimeZero,Toast.LENGTH_LONG);
                        t.show();
                    }
                    else {
                        double Distance3 = Double.parseDouble(Distance2);
                        double Time3 = Double.parseDouble(Time2);
                        double Answer = (Distance3/1000)/(Time3/3600);
                        Ans.setText(String.format("%.2f",Answer));
                        if(Answer>80){
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("SPEED CALCULATOR");
                            dialog.setMessage(R.string.Speed);
                            dialog.setPositiveButton("OK", null);
                            dialog.show();
                        }

                    }
                }
            }
        });


    }
}