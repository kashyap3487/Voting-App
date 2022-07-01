package com.example.as_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.as_4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMainBinding.inflate(LayoutInflater.from(this));
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());



        Intent intent=getIntent();

        int icnt1=intent.getIntExtra("icnt1",0);
        int icnt2=intent.getIntExtra("icnt2",0);
        int icnt3=intent.getIntExtra("icnt3",0);

        binding.c1Votes.setText(Integer.toString(icnt1));
        binding.c2Votes.setText(Integer.toString(icnt2));
        binding.c3Votes.setText(Integer.toString(icnt3));

        binding.gotoVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent vote=new Intent(MainActivity.this,Voting.class);
                    startActivity(vote);
            }
        });

    }
}