package comjosuerojasrojas.httpsgithub.altruist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PostPreview extends AppCompatActivity {
    String name;
    String needs;
    String description;
    Intent previous;
    static String newData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_preview);

        //((Button)findViewById(R.id.help)).setActivated(false);

        TextView userStory = (TextView) findViewById(R.id.description);
        userStory.setText(NewPost.desc);

        TextView userName = (TextView) findViewById(R.id.profileName);
        userName.setText("Thank You! from " + NewPost.name);

        ((Button)findViewById(R.id.help)).setEnabled(false);

        //get the image if there is and make it to null for later use
        if(DataHandler.profileSubmit != null)
            ((ImageView)findViewById(R.id.profilePicture)).setImageBitmap(DataHandler.profileSubmit);
        DataHandler.profileSubmit = null;


        // String newData = (TextUtils.join("/p",(needs.split(","))) + ";" + name + "/n
        // ");



    }

    public void Submit(View v){




        String Data = (MainActivity.dataView.getText().toString() + TextUtils.join("/p",(NewPost.needs.split(","))) + ";" + NewPost.desc + ";" + NewPost.name + "/n");
        Log.d("newData",Data);
        DataHandler.postPerson(newData);
        Intent intent = new Intent(this, MainActivity.class);
        newData = Data;

       // MainActivity.dataView.setText(newData);
        //MainActivity.finish();
        startActivity(intent);



    }
}
