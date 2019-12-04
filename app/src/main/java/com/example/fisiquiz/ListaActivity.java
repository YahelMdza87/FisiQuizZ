package com.example.fisiquiz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    ArrayList<String> myArrayList =new ArrayList<>();
    ListView listView;
    DatabaseReference myFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        final ArrayAdapter<String> myArrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myArrayList);
        listView=(ListView)findViewById(R.id.listview);
        listView.setAdapter(myArrayAdapter);
        myFirebase=FirebaseDatabase.getInstance().getReference();

        myFirebase.child("Quiz").addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull final DataSnapshot dataSnapshot, @Nullable String s) {
                final String pregunta=dataSnapshot.child("pregunta").getValue().toString();
                myArrayList.add(pregunta);
                myArrayAdapter.notifyDataSetChanged();

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String respuesta=dataSnapshot.child("resouesta").getValue().toString();
                        Intent hacerquiz = new Intent(view.getContext(), QuizActivity.class);
                        hacerquiz.putExtra("pregunta", pregunta);
                        hacerquiz.putExtra("respuesta", respuesta);

                        startActivity(hacerquiz);
                    }
                });
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
