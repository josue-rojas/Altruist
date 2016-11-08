package comjosuerojasrojas.httpsgithub.altruist;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

public class NewPost extends AppCompatActivity {
    EditText Description;
    EditText Name;
    EditText Needs;

    Bitmap imageBitmap;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    String mCurrentPhotoPath;

    static String desc,name,needs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        Description = (EditText)findViewById(R.id.description);
        Name = (EditText)findViewById(R.id.name);
        Needs = (EditText)findViewById(R.id.needs);
        ((ImageView)findViewById(R.id.profilePicture)).setEnabled(false);
        ((Button)findViewById(R.id.photo)).setEnabled(false);


    }

    public void Submit(View view){

        DataHandler.profileSubmit = imageBitmap;

        desc = Description.getText().toString();
        name = Name.getText().toString();
        needs = Needs.getText().toString();



        Intent intent = new Intent(this, PostPreview.class);
        startActivity(intent);


        //save it


    }

    public void cancel(View v){
        finish();
    }


    public void takePhoto(View v){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            ((ImageView)findViewById(R.id.profilePicture)).setImageBitmap(imageBitmap);
        }
    }



}
