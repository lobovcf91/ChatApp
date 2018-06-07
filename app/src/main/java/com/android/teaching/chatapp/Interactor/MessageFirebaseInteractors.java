package com.android.teaching.chatapp.Interactor;

import android.provider.ContactsContract;
import android.util.Log;

import com.android.teaching.chatapp.model.MessageModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class MessageFirebaseInteractors {
    private ArrayList<MessageModel> messages = new ArrayList<>();

public void getMessages (final MessageInteractorCallback callback){

    //1-llamar a firebasa
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference myReference = firebaseDatabase.getReference("messages");
    myReference.addListenerForSingleValueEvent(new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot){
            for (DataSnapshot nodojuego: dataSnapshot.getChildren()) {
                MessageModel model = nodojuego.getValue(MessageModel.class);
                Log.d("Firebase Interactor", "Message: "+ model.getText());
                messages.add(model);
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });

}

}