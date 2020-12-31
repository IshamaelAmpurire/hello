package com.example.morganhello;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class patientsdata extends AppCompatActivity {

    EditText patientdata, name,gender, age;
    Button insert, update, delete, view, send;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientsdata);


        name = findViewById(R.id.name);
        gender = findViewById(R.id.gender);
        age = findViewById(R.id.age);

        final patientjava DB;
        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        view = findViewById(R.id.view);

        DB = new patientjava(this);

        insert.setOnClickListener(new View.OnClickListener (){

            public void onClick(View view){
                String nameTXT = name.getText().toString();
                String genderTXT = gender.getText().toString();
                String ageTXT = age.getText().toString();


                Boolean checkinsertdata = DB.insertuserdata(nameTXT, genderTXT, ageTXT);
                if (checkinsertdata==true)
                    Toast.makeText(patientsdata.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(patientsdata.this, "Entry Failed", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener (){

            public void onClick(View view){
                String nameTXT = name.getText().toString();
                String genderTXT = gender.getText().toString();
                String ageTXT = age.getText().toString();
                Boolean checkupdatedata = DB.updateuserdata(nameTXT, genderTXT, ageTXT);
                if (checkupdatedata==true)
                    Toast.makeText(patientsdata.this, " Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(patientsdata.this, "Update Failed", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener (){

            public void onClick(View view){
                String nameTXT = name.getText().toString();
                String genderTXT = gender.getText().toString();
                String ageTXT = age.getText().toString();

                Boolean checkdeletedata = DB.updateuserdata(nameTXT, genderTXT, ageTXT);
                if (checkdeletedata==true)
                    Toast.makeText(patientsdata.this, " Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(patientsdata.this, "Delete Failed", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount()==0){
                    Toast.makeText(patientsdata.this,"No Entry At the Moment", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Project Name:"+res.getString(0)+"\n");
                    buffer.append("Project Manager:"+res.getString(1)+"\n\n");
                    buffer.append("Project Location:"+res.getString(2)+"\n\n\n");
                    buffer.append("Project Budget:"+res.getString(3)+"\n\n\n\n");
                    buffer.append("Project Teams:"+res.getString(4)+"\n\n\n\n\n\n");
                    buffer.append("Project Start:"+res.getString(5)+"\n\n\n\n\n\n\n\n");
                    buffer.append("Project End:"+res.getString(6)+"\n\n\n\n\n\n\n\n\\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(patientsdata.this);
                builder.setCancelable(true);
                builder.setTitle("project Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });



    }
}
