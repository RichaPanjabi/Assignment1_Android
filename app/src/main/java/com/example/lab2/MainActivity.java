package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnDisp;
    ListView listView;
    ArrayList<String> selectedStudents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDisp=findViewById(R.id.dispButton);

          listView=findViewById(R.id.studentList);

        selectedStudents=new ArrayList<>();

        btnDisp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayList();
            }
        }

            );

    }//end of onCreate

    public void displayList()
    {
        final ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("John Doe");
        arrayList.add("Jane Smith");
        arrayList.add("Peter Pan");
        arrayList.add("Super Man");
        arrayList.add("Tony Stark");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"clicked item: " +position+ " "+ arrayList.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
