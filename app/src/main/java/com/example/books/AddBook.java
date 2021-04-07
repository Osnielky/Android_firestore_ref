package com.example.books;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddBook extends AppCompatActivity {

    EditText title, startDate, endDate;
    RatingBar rt;
    ImageButton save;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        db = FirebaseFirestore.getInstance();

        title = findViewById(R.id.idTitletext);
        startDate = findViewById(R.id.idStartDate);
        endDate = findViewById(R.id.idEndDate);
        rt = findViewById(R.id.ratingBar);
        save = findViewById(R.id.imageButton2);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titleToSave = title.getText().toString();
                String startDateToSave = startDate.getText().toString();
                String endDateToSave = endDate.getText().toString();
                int rating = rt.getNumStars();


                if (validation()) {

                    CollectionReference dbBooks = db.collection("book");

                    Books book = new Books(titleToSave, startDateToSave, endDateToSave, rating);

                    dbBooks.add(book).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {


                            Toast.makeText(AddBook.this, "Book added", Toast.LENGTH_SHORT).show();
                            cleanHouse();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AddBook.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
                } else {

                }


            }
        });


    }

    public boolean validation() {

        if (title.getText().equals("")) {

            title.setHint("Title is needed");
            title.setHintTextColor(Color.red(5));
            return false;
        }

return true;
    }


    public void cleanHouse() {
        title.setText("");
        startDate.setText("");
        endDate.setText("");
        rt.setNumStars(0);


    }


}