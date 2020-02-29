package com.example.realtimedatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name,accountNumber,accountType,expiryDate;
    private Button chooseImageButton,saveBtn;
    private ImageView imageView;
    private ProgressBar progressBar;
    private Uri imageUri;
    private StorageTask uploadTask;

    DatabaseReference databaseReference;
    StorageReference storageReference;

    private static final int IMAGE_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference=FirebaseDatabase.getInstance().getReference("Upload");
        storageReference= FirebaseStorage.getInstance().getReference("Upload");

        name=(EditText)findViewById(R.id.nameEditTextId);
        accountNumber=(EditText)findViewById(R.id.accountNumberEditTextId);
        accountType=(EditText)findViewById(R.id.accountTypeEditTextId);
        expiryDate=(EditText)findViewById(R.id.expiryDateEditTextId);
        chooseImageButton=(Button)findViewById(R.id.chooseBtnId);
        saveBtn=(Button)findViewById(R.id.saveBtnId);
        imageView=(ImageView)findViewById(R.id.imageViewId);
        progressBar=(ProgressBar)findViewById(R.id.progressBarId);


        chooseImageButton.setOnClickListener(this);
        saveBtn.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){


            case R.id.chooseBtnId:

                openFileChooser();

                break;

            case R.id.saveBtnId:
                if (uploadTask!=null && uploadTask.isInProgress()){

                    Toast.makeText(getApplicationContext(),"Uploading is progress",Toast.LENGTH_LONG).show();


                }
                else {
                    saveData();

                }

                break;
        }

    }

    public String getFileExtension(Uri imageUri)
    {
        ContentResolver contentResolver=getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();

        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageUri));

    }

    private void saveData() {

      final   String t1=name.getText().toString().trim();
       final String t2=accountNumber.getText().toString().trim();
       final String t3=accountType.getText().toString().trim();
        final String t4=expiryDate.getText().toString().trim();
        StorageReference ref=storageReference.child(System.currentTimeMillis()+"."+getFileExtension(imageUri));

        ref.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content

                        Toast.makeText(getApplicationContext(),"Image Is Stored Successfully",Toast.LENGTH_LONG).show();

                        Upload upload=new Upload(t1,t2,t3,t4,taskSnapshot.getStorage().getDownloadUrl().toString());

                        String uploadId=databaseReference.push().getKey();
                        databaseReference.child(uploadId).setValue(upload);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                        Toast.makeText(getApplicationContext(),"Image Is Not Stored Successfully",Toast.LENGTH_LONG).show();

                    }
                });






    }

    private void openFileChooser() {

        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData()!=null){

            imageUri=data.getData();
            Picasso.with(this).load(imageUri).into(imageView);
        }
    }
}
