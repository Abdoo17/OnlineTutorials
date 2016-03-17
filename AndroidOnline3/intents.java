

/**
 * Created by hussienalrubaye on 3/17/16.
 */
public class intentds {
    
    //1- open new activity
    Intent intent=Intent(this,NewActivity.class);
    startActivity(intent);
    // 2- share data
    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
    sharingIntent.setType("text/plain");
    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
    startActivity(Intent.createChooser(sharingIntent, "Share using"));
    
    // 3- start new app and pass data
    Intent intent= getPackageManager().getLaunchIntentForPackage(“reciver packge name“);
    intent.putExtra("Comment",etComment.getText().toString());
    start another app
    startActivity(intent);
    
    //send sms
    Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
    smsIntent.setType("vnd.android-dir/mms-sms");
    smsIntent.putExtra("address","your desired phoneNumber");
    smsIntent.putExtra("sms_body","your desired message");
    startActivity(smsIntent);
 }