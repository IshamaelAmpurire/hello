package com.example.morganhello;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.infor);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,patientsdata.class));
            }


});
    }
    public void sendMsg (View view){

        EditText msg = findViewById(R.id.invisible);
        Intent intent = new Intent(this,msgdisplay.class);
        intent.putExtra ("MESSAGE", msg.getText().toString());
        startActivity(intent);
        msg.setText("");





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.calldial,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.call2:
                Toast.makeText(this,"call 1 dailing",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.call3:
                Toast.makeText(this,"call 2 dailing",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.airtel:
                Toast.makeText(this,"call airtel dailing",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.mtn:
                Toast.makeText(this,"call mtn dailing",Toast.LENGTH_SHORT).show();
                return true;

           default:
               return super.onOptionsItemSelected(item);
        }

    }
}
