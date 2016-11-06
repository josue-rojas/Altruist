package comjosuerojasrojas.httpsgithub.altruist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Post extends AppCompatActivity {

    int numID = -1;
    String name;
    String need;
    String descrition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        numID = MainActivity.buttonNum;

        if(numID < 5) {
            String imageFile = "photo" + (numID - 1) + "";
            Log.d("image", imageFile);
            Resources res = getResources();
            int imageID = res.getIdentifier(imageFile, "drawable", getPackageName());

            // int imageID = getResources().getIdentifier(imageFile, "drawable", this.getPackageName());

            ImageView profile = (ImageView) findViewById(R.id.profilePicture);
            //Drawable drawable = res.getDrawable(imageID );
            profile.setImageResource(imageID);

        }




        //add needs

        TextView userStory = (TextView) findViewById(R.id.description);
        userStory.setText(DataHandler.getPerson(numID-1)[1]);

        TextView userName = (TextView) findViewById(R.id.Name);
        userName.setText("Thank You from " + DataHandler.getPerson(numID-1)[2]);

        Button helpButton = (Button)findViewById(R.id.help);
        helpButton.setEnabled(false);
        /*

        helpButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "Thank you", Toast.LENGTH_LONG).show();
            }
        });
        */
    }


    public void setName(String name){
        this.name = name;
    }

    public void setNeed(String need){
        this.need = need;
    }

    public void setDescrition(String descrition){
        this.descrition = descrition;
    }
}
