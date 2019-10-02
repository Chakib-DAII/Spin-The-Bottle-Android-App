package chakib.spinthebottle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    //Duration of wait
    private final int SPLASH_DISPLAY_LENGTH = 4000;


    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
            createShortcut();
        //img = (ImageView)findViewById(R.id.imageView);
       // img.setImageResource(R.drawable.alcohol1);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
    public void createShortcut(){
        SharedPreferences appPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean isAppInstalled = appPreferences.getBoolean("isAppInstalled", false);

        String currentLanguage = Locale.getDefault().getDisplayLanguage();
        String previousSetLanguage = appPreferences.getString("phoneLanguage", Locale.getDefault().getDisplayLanguage());
        Boolean shortcutReinstall = false;
        if (!previousSetLanguage.equals(currentLanguage)) {
            shortcutReinstall = true;
        }
        if(!isAppInstalled || shortcutReinstall){

            Intent HomeScreenShortCut= new Intent(getApplicationContext(),
                    SplashActivity.class);

            HomeScreenShortCut.setAction(Intent.ACTION_MAIN);
            HomeScreenShortCut.putExtra("duplicate", false);

            if(shortcutReinstall) {
                Intent removeIntent = new Intent();
                removeIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, HomeScreenShortCut);
                String prevAppName = appPreferences.getString("appName", getString(R.string.app_name));
                removeIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, prevAppName);
                removeIntent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
                getApplicationContext().sendBroadcast(removeIntent);
            }

            Intent addIntent = new Intent();
            addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, HomeScreenShortCut);
            addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.app_name));
            addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                    Intent.ShortcutIconResource.fromContext(getApplicationContext(),
                            R.drawable.logoactionverite));
            addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
            getApplicationContext().sendBroadcast(addIntent);


            //Make preference true
            SharedPreferences.Editor editor = appPreferences.edit();
            editor.putBoolean("isAppInstalled", true);
            editor.putString("phoneLanguage", currentLanguage);
            editor.putString("appName", getString(R.string.app_name));
            editor.commit();
        }
    }

}
