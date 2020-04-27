package com.aca.paravon;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class CxaxotneriFragment extends Fragment {

    private TextView tvyal_cxaxotneri;



    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("cxaxotneri");





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String x=dataSnapshot.child("0").getValue(String.class);
                String x1=dataSnapshot.child("1").getValue(String.class);
                String x2=dataSnapshot.child("2").getValue(String.class);
                String x3=dataSnapshot.child("3").getValue(String.class);
                String x4=dataSnapshot.child("4").getValue(String.class);


                tvyal_cxaxotneri.setText(x+"\n"+x1+"\n"+x2+"\n"+x3+"\n"+x4);

                Toast.makeText(getContext(), "Succes", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();


            }
        });






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.cxaxotneri, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvyal_cxaxotneri=view.findViewById(R.id.tvyal_cxaxotneri);


    }
}