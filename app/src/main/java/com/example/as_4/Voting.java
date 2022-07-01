package com.example.as_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.as_4.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class Voting extends AppCompatActivity {

    private String[] candidate={"choose candidate","candidate 1","candidate 2","candidate 3"};
    private int cnt1=0,cnt2=0,cnt3=0;
    private TextView name1,id1;
    private Spinner spinner1;
    private Button btn;
    private ToggleButton toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);
        name1=findViewById(R.id.nameText);
        id1=findViewById(R.id.id);
        spinner1=findViewById(R.id.spinner1);
        toggle=findViewById(R.id.toggle);
        btn=findViewById(R.id.vote);
        ArrayList<String> name_array=new ArrayList<>();
        ArrayList<String> id_array=new ArrayList<>();

        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_spinner_item,candidate);
        spinner1.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=name1.getText().toString().trim();
                String id=id1.getText().toString().trim();
                if(name.isEmpty()  && id.isEmpty()){

                    Toast.makeText(Voting.this, "Please Provide Name and Id", Toast.LENGTH_SHORT).show();
                }
                else if(name.isEmpty()){
                    Toast.makeText(Voting.this, "Please provide name", Toast.LENGTH_SHORT).show();
                }
                else if(id.isEmpty()){
                    Toast.makeText(Voting.this, "Please provide ID", Toast.LENGTH_SHORT).show();
                }
                else{
                    String candidate=spinner1.getSelectedItem().toString();
                    if (candidate.equals("choose candidate")){
                        Toast.makeText(Voting.this, "Please select Candidate", Toast.LENGTH_SHORT).show();
                    }
                    else if(toggle.isChecked()){
//                        Toast.makeText(Voting.this, candidate+" ", Toast.LENGTH_SHORT).show();
                        if(id_array.contains(id)){
                            Toast.makeText(Voting.this, "User Already Voted", Toast.LENGTH_SHORT).show();
                        }
                        else{

                            name_array.add(name);
                            id_array.add(id);
                            if(candidate.equals("candidate 1")){
                                cnt1+=1;
                            }
                            else if(candidate.equals("candidate 2")){
                                cnt2+=1;
                            }
                            else if(candidate.equals("candidate 3")){
                                cnt3+=1;
                            }
                            Toast.makeText(Voting.this, "Vote Successfully casted", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Voting.this, "Please Accept the terms", Toast.LENGTH_SHORT).show();

                    }
                    }
                }

        });


    }

    @Override
    public void onBackPressed() {
        Intent send=new Intent(Voting.this,MainActivity.class);
        send.putExtra("icnt1",cnt1);
        send.putExtra("icnt2",cnt2);
        send.putExtra("icnt3",cnt3);


        startActivity(send);
    }
}