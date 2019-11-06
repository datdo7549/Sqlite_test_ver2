package com.example.sqlite_test_ver2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.sqlite_test_ver2.adapter.Custom_Adapter;
import com.example.sqlite_test_ver2.data.Database_Manager;
import com.example.sqlite_test_ver2.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText address;
    private EditText phone;
    private Button btt;
    private Database_Manager database_manager;
    private ListView listView;
    private Custom_Adapter custom_adapter;
    private ArrayList<Student> studentArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database_manager=new Database_Manager(this);
        name=findViewById(R.id.name1);
        email=findViewById(R.id.email1);
        address=findViewById(R.id.adress1);
        phone=findViewById(R.id.number_phone);
        btt=findViewById(R.id.btt);
        listView=findViewById(R.id.listview);
        studentArrayList=database_manager.readAllStudent();
        setAdapter();
        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student=CreateStudent();
                database_manager.addStudent(student);
                studentArrayList.clear();
                studentArrayList.addAll(database_manager.readAllStudent());
                setAdapter();
            }
        });
    }

    private Student CreateStudent() {
        String ten=name.getText().toString();
        String imai=email.getText().toString();
        String diachi=address.getText().toString();
        String dt=phone.getText().toString();
        return new Student(ten,imai,diachi,dt);
    }
    public void setAdapter()
    {
        if(custom_adapter==null)
        {
            custom_adapter=new Custom_Adapter(this,R.layout.custom_item,studentArrayList);
            listView.setAdapter(custom_adapter);
        }
        else
        {
            custom_adapter.notifyDataSetChanged();
        }
    }
}
