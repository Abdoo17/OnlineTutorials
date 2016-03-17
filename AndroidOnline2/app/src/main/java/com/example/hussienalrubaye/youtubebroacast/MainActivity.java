package com.example.hussienalrubaye.youtubebroacast;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView txtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtv=(TextView) findViewById(R.id.txtv);
        Button bulcik= (Button) findViewById(R.id.buClick);
        bulcik.setText("Change button text");
        bulcik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    //define variable to hold all messages data
                    String sms = "";
                    //set inbox direct to read message from
                    Uri uriSMSURI = Uri.parse("content://sms/inbox");
                    //get all messages and load it in Cursor
                    Cursor cur = getContentResolver().query(uriSMSURI, null, null, null, null);
                    //move Cursor to first message
                    cur.moveToPosition(0);
                    //read all messages one by one
                    while (cur.moveToNext()) {
                        //load sender and the message content
                        sms += "From :" + cur.getString(cur.getColumnIndex("address")) + " : " + cur.getString(cur.getColumnIndex("body"))+"\n";
                    }
                    //display message in Textbox
                    txtv.setText(sms);
                }   catch(Exception ex){

                }


            }
        });
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();
    }

    protected void  onStart(){
        super.onStart();
        Toast.makeText(this,"Onstart",Toast.LENGTH_LONG).show();
    }


    protected void onResume(){
        super.onResume();
        Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show();
    }

    protected void onPause(){
        super.onPause();
        Toast.makeText(this,"onPause",Toast.LENGTH_LONG).show();
    }


    protected void  onStop(){
        super.onStop();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.mainmen,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.goback) {

            Toast.makeText(this,"go back",Toast.LENGTH_LONG).show();


        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.gobackforod) {

            Toast.makeText(this,"go gobackforod",Toast.LENGTH_LONG).show();


        }
    return true;
    }

}
