package comjosuerojasrojas.httpsgithub.altruist;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    static int buttonNum = -1;
    private static Context context;
    static TextView dataView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("refreshtest","refresh");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataView = (TextView)findViewById(R.id.data);
        if(PostPreview.newData != null)
         dataView.setText(PostPreview.newData);
        Log.d("dataview",dataView.getText().toString());
        DataHandler data = new DataHandler(dataView.getText().toString());
        createButtons();
        DataHandler.getNeeds(1);
        this.context = getApplicationContext();

    }

    public void updateData(String newData){
       // String newData = (TextUtils.join("/p",(NewPost.needs.split(","))) + ";" + NewPost.desc + ";" + NewPost.name + "/n");
        Log.d("newData",newData);
        dataView.setText(newData);
    }


    /**submit new post method
     * moves to new post activity
     * @param view
     */
    public void newPost(View view) {
       Intent intent = new Intent(this, NewPost.class);
        startActivity(intent);
    }

    public void createButtons(){
        Log.d("insideCreate","");
        int numPost = DataHandler.paragraph.length-1;
        Log.d("insideCreate",numPost+"");
        //first post
        Button myButton = new Button(this);
        Log.d("insideCreate","afterMybutton");
        myButton.setText("Post");
        RelativeLayout ll = (RelativeLayout) findViewById(R.id.mainLayout);
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        p.addRule(RelativeLayout.BELOW, R.id.newpost);
        p.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        p.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        for(int i = 0; i < numPost; i++){
            RelativeLayout.LayoutParams para = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
            if(i == 0) para.addRule(RelativeLayout.BELOW,R.id.newpost);
            else para.addRule(RelativeLayout.BELOW,i);

            para.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            para.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            Button posts = new Button(this);

            posts.setText(DataHandler.getName(i));
            posts.setId(i+1);
            posts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonNum = v.getId();
                    Intent intent = new Intent(context, Post.class);
                    startActivity(intent);
                }
            });
            ll.addView(posts,para);
        }
       // ll.addView(myButton);


    }
}
