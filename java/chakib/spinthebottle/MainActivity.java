package chakib.spinthebottle;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView mBottle ,gomordiMenu,waterMenu,sodaMenu,beerMenu,alcoholMenu,mImActver;
    ImageView water1,water2,water3,water4,water5;
    ImageView soda1,soda2,soda3;
    ImageView beer1,beer2,beer3,beer4,beer5,beer6,beer7,beer8,beer9;
    ImageView alcohol1,alcohol2,alcohol3,alcohol4,alcohol5,alcohol6,alcohol7,alcohol8,alcohol9;
    ScrollView mainMenu ,Menuwater,Menusoda,Menubeer,Menualcohol ;
    RelativeLayout flBottle;
    LinearLayout  mbubble , mActVertite ,mquestActVer;
    CheckBox mCbAction , mCbVerite;
    TextView mTextActVer;
    //Button mButton;

    Random random;
    int angle;
    boolean restart = false;
    ActionBar actionBar;
    Menu menu;

    ArrayList<String> actionArray;
    ArrayList<String> veriteArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = this.getSupportActionBar();

        if(actionBar != null)
        {
            actionBar.setBackgroundDrawable(new
                ColorDrawable(Color.parseColor("#ffe7a6")));
        }
        flBottle = (RelativeLayout) findViewById(R.id.fl_bottle);
        mbubble = (LinearLayout) findViewById(R.id.iv_bubble);
        mActVertite = (LinearLayout) findViewById(R.id.iv_act_verite);
        mquestActVer = (LinearLayout) findViewById(R.id.tv_act_verite);
        mBottle = (ImageView) findViewById(R.id.iv_bottle);
        mainMenu = (ScrollView) findViewById(R.id.sv_main_menu);
        gomordiMenu=(ImageView) findViewById(R.id.iv_gomordi_menu);
        waterMenu=(ImageView) findViewById(R.id.iv_water_menu);
        sodaMenu=(ImageView) findViewById(R.id.iv_soda_menu);
        beerMenu=(ImageView) findViewById(R.id.iv_beer_menu);
        alcoholMenu=(ImageView) findViewById(R.id.iv_liqueur_menu);
        Menuwater = (ScrollView) findViewById(R.id.sv_water_menu);
        Menusoda = (ScrollView) findViewById(R.id.sv_soda_menu);
        Menubeer = (ScrollView) findViewById(R.id.sv_beer_menu);
        Menualcohol = (ScrollView) findViewById(R.id.sv_alcohol_menu);
        water1=(ImageView) findViewById(R.id.im_water1);
        water2=(ImageView) findViewById(R.id.im_water2);
        water3=(ImageView) findViewById(R.id.im_water3);
        water4=(ImageView) findViewById(R.id.im_water4);
        water5=(ImageView) findViewById(R.id.im_water5);
        soda1=(ImageView) findViewById(R.id.im_soda1);
        soda2=(ImageView) findViewById(R.id.im_soda2);
        soda3=(ImageView) findViewById(R.id.im_soda3);
        beer1=(ImageView) findViewById(R.id.im_beer1);
        beer2=(ImageView) findViewById(R.id.im_beer2);
        beer3=(ImageView) findViewById(R.id.im_beer3);
        beer4=(ImageView) findViewById(R.id.im_beer4);
        beer5=(ImageView) findViewById(R.id.im_beer5);
        beer6=(ImageView) findViewById(R.id.im_beer6);
        beer7=(ImageView) findViewById(R.id.im_beer7);
        beer8=(ImageView) findViewById(R.id.im_beer8);
        beer9=(ImageView) findViewById(R.id.im_beer9);
        alcohol1=(ImageView) findViewById(R.id.im_alcohol1);
        alcohol2=(ImageView) findViewById(R.id.im_alcohol2);
        alcohol3=(ImageView) findViewById(R.id.im_alcohol3);
        alcohol4=(ImageView) findViewById(R.id.im_alcohol4);
        alcohol5=(ImageView) findViewById(R.id.im_alcohol5);
        alcohol6=(ImageView) findViewById(R.id.im_alcohol6);
        alcohol7=(ImageView) findViewById(R.id.im_alcohol7);
        alcohol8=(ImageView) findViewById(R.id.im_alcohol8);
        alcohol9=(ImageView) findViewById(R.id.im_alcohol9);
        mCbAction = (CheckBox) findViewById(R.id.cb_action);
        mCbVerite = (CheckBox) findViewById(R.id.cb_verite);
        mImActver=(ImageView) findViewById(R.id.imv_act_verite);
        mTextActVer = (TextView) findViewById(R.id.tv_text_act_verite);

        //initialisations arrays

        actionArray = new ArrayList<>();
            actionArray.add(getString(R.string.action1));
            actionArray.add(getString(R.string.action2));
            actionArray.add(getString(R.string.action3));
            actionArray.add(getString(R.string.action4));
            actionArray.add(getString(R.string.action5));
            actionArray.add(getString(R.string.action6));
            actionArray.add(getString(R.string.action7));
            actionArray.add(getString(R.string.action8));
            actionArray.add(getString(R.string.action9));
            actionArray.add(getString(R.string.action10));
            actionArray.add(getString(R.string.action11));
            actionArray.add(getString(R.string.action12));
            actionArray.add(getString(R.string.action13));
            actionArray.add(getString(R.string.action14));
            actionArray.add(getString(R.string.action15));
            actionArray.add(getString(R.string.action16));
            actionArray.add(getString(R.string.action17));
            actionArray.add(getString(R.string.action18));
            actionArray.add(getString(R.string.action19));
            actionArray.add(getString(R.string.action20));

        veriteArray = new ArrayList<>();
            veriteArray.add(getString(R.string.verite1));
            veriteArray.add(getString(R.string.verite2));
            veriteArray.add(getString(R.string.verite3));
            veriteArray.add(getString(R.string.verite4));
            veriteArray.add(getString(R.string.verite5));
            veriteArray.add(getString(R.string.verite6));
            veriteArray.add(getString(R.string.verite7));
            veriteArray.add(getString(R.string.verite8));
            veriteArray.add(getString(R.string.verite9));
            veriteArray.add(getString(R.string.verite10));
            veriteArray.add(getString(R.string.verite11));
            veriteArray.add(getString(R.string.verite12));
            veriteArray.add(getString(R.string.verite13));
            veriteArray.add(getString(R.string.verite14));
            veriteArray.add(getString(R.string.verite15));
            veriteArray.add(getString(R.string.verite16));
            veriteArray.add(getString(R.string.verite17));
            veriteArray.add(getString(R.string.verite18));
            veriteArray.add(getString(R.string.verite19));
            veriteArray.add(getString(R.string.verite20));


        //mButton = (Button) findViewById(R.id.button_go);

        mBottle.setBackgroundResource(R.drawable.alcohol1);
        random = new Random();


        /*mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(restart)
                {   angle = angle % 360;
                    RotateAnimation rotate = new RotateAnimation(angle , 360 , Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(1000);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    mBottle.startAnimation(rotate);

                    mButton.setText("GO");
                    restart = false;

                }
                else {
                    angle = random.nextInt(7200) + 360;
                    RotateAnimation rotate = new RotateAnimation(0, angle , Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(1000);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    mBottle.startAnimation(rotate);


                    restart = true;
                    mButton.setText("RESET");
                }
            }
        });*/

        //recuperation de barre d'acion

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
        this.menu.setGroupVisible(0,false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItemThatWasSelected = item.getItemId();
        if(menuItemThatWasSelected == android.R.id.home)
        {
            if(   flBottle.getVisibility() == View.VISIBLE)
            {
                mbubble.setVisibility(View.INVISIBLE);
                mActVertite.setVisibility(View.INVISIBLE);
                mquestActVer.setVisibility(View.INVISIBLE);
                angle = angle % 360;
                RotateAnimation rotate = new RotateAnimation(angle, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setFillAfter(true);
                rotate.setDuration(1);
                rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                mBottle.startAnimation(rotate);

                //mButton.setText("GO");
                restart = false;
                }
            flBottle.setVisibility(View.INVISIBLE);
            Menuwater.setVisibility(View.INVISIBLE);
            Menusoda.setVisibility(View.INVISIBLE);
            Menubeer.setVisibility(View.INVISIBLE);
            Menualcohol.setVisibility(View.INVISIBLE);
            mainMenu.setVisibility(View.VISIBLE);
            if(actionBar != null)
            {
                actionBar.setDisplayHomeAsUpEnabled(false);
            }
            this.menu.setGroupVisible(0,false);
        }
        if (menuItemThatWasSelected == R.id.action_changer_flacon) {

            if(   flBottle.getVisibility() == View.VISIBLE)
            {
                mbubble.setVisibility(View.INVISIBLE);
                mActVertite.setVisibility(View.INVISIBLE);
                mquestActVer.setVisibility(View.INVISIBLE);
                angle = angle % 360;
                RotateAnimation rotate = new RotateAnimation(angle, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setFillAfter(true);
                rotate.setDuration(1);
                rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                mBottle.startAnimation(rotate);

                //mButton.setText("GO");
                restart = false;

                flBottle.setVisibility(View.INVISIBLE);
                Menuwater.setVisibility(View.INVISIBLE);
                Menusoda.setVisibility(View.INVISIBLE);
                Menubeer.setVisibility(View.INVISIBLE);
                Menualcohol.setVisibility(View.INVISIBLE);
                mainMenu.setVisibility(View.VISIBLE);
                if (actionBar != null) {
                    actionBar.setDisplayHomeAsUpEnabled(false);
                }
                this.menu.setGroupVisible(0,false);
            }
        }

        return super.onOptionsItemSelected(item);
    }
    public void StartnReset(View view) throws InterruptedException {
        if(restart)
        {
            mbubble.setVisibility(View.INVISIBLE);
            mActVertite.setVisibility(View.INVISIBLE);
            mquestActVer.setVisibility(View.INVISIBLE);
            angle = angle % 360;
            RotateAnimation rotate = new RotateAnimation(angle , 360 , Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotate.setFillAfter(true);
            rotate.setDuration(1000);
            rotate.setInterpolator(new AccelerateDecelerateInterpolator());

            mBottle.startAnimation(rotate);
            //mButton.setText("GO");
            restart = false;

        }
        else {
            angle = random.nextInt(7200) + 360;
            RotateAnimation rotate = new RotateAnimation(0, angle , Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotate.setFillAfter(true);
            rotate.setDuration(1000);
            rotate.setInterpolator(new AccelerateDecelerateInterpolator());

            mBottle.startAnimation(rotate);
            mBottle.getAnimation().setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mbubble.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });


            restart = true;
            //mButton.setText("RESET");
        }
        /*
        if(isNetworkAvailable(MainActivity.this))
            Toast.makeText(MainActivity.this,"you're connected", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this,"you're not connected", Toast.LENGTH_LONG).show();
        */
    }
    public void actVerite(View view)
    { if (mCbAction.isChecked())
            {
                mImActver.setBackgroundResource(R.drawable.texteaction);
                mTextActVer.setText(actionArray.get(randomArray(0,20)));

            }
      if (mCbVerite.isChecked())
            {
                mImActver.setBackgroundResource(R.drawable.texteverite);
                mTextActVer.setText(veriteArray.get(randomArray(0,20)));
            }
        mbubble.setVisibility(View.INVISIBLE);
        mActVertite.setVisibility(View.VISIBLE);
        mquestActVer.setVisibility(View.VISIBLE);
    }

    public void setFlacon(View view)
    {if(view.equals(gomordiMenu))
        {
            mBottle.setBackgroundResource(R.drawable.gomordi);
            mainMenu.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(water1))
        {
            mBottle.setBackgroundResource(R.drawable.water1);
            Menuwater.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }

        if(view.equals(water2))
        {
            mBottle.setBackgroundResource(R.drawable.water2);
            Menuwater.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }

        if(view.equals(water3))
        {
            mBottle.setBackgroundResource(R.drawable.water3);
            Menuwater.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }

        if(view.equals(water4))
        {
            mBottle.setBackgroundResource(R.drawable.water4);
            Menuwater.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }

        if(view.equals(water5))
        {
            mBottle.setBackgroundResource(R.drawable.water5);
            Menuwater.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }

        if(view.equals(soda1))
        {
            mBottle.setBackgroundResource(R.drawable.soda1);
            Menusoda.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(soda2))
        {
            mBottle.setBackgroundResource(R.drawable.soda2);
            Menusoda.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(soda3))
        {
            mBottle.setBackgroundResource(R.drawable.soda3);
            Menusoda.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }

        if(view.equals(beer1))
        {
            mBottle.setBackgroundResource(R.drawable.beer1);
            Menubeer.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(beer2))
        {
            mBottle.setBackgroundResource(R.drawable.beer2);
            Menubeer.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(beer3))
        {
            mBottle.setBackgroundResource(R.drawable.beer3);
            Menubeer.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(beer4))
        {
            mBottle.setBackgroundResource(R.drawable.beer4);
            Menubeer.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(beer5))
        {
            mBottle.setBackgroundResource(R.drawable.beer5);
            Menubeer.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(beer6))
        {
            mBottle.setBackgroundResource(R.drawable.beer6);
            Menubeer.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(beer7))
        {
            mBottle.setBackgroundResource(R.drawable.beer7);
            Menubeer.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(beer8))
        {
            mBottle.setBackgroundResource(R.drawable.beer8);
            Menubeer.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(beer9))
        {
            mBottle.setBackgroundResource(R.drawable.beer9);
            Menubeer.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }

        if(view.equals(alcohol1))
        {
            mBottle.setBackgroundResource(R.drawable.alcohol1);
            Menualcohol.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(alcohol2))
        {
            mBottle.setBackgroundResource(R.drawable.alcohol2);
            Menualcohol.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(alcohol3))
        {
            mBottle.setBackgroundResource(R.drawable.alcohol3);
            Menualcohol.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(alcohol4))
        {
            mBottle.setBackgroundResource(R.drawable.alcohol4);
            Menualcohol.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(alcohol5))
        {
            mBottle.setBackgroundResource(R.drawable.alcohol5);
            Menualcohol.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(alcohol6))
        {
            mBottle.setBackgroundResource(R.drawable.alcohol6);
            Menualcohol.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(alcohol7))
        {
            mBottle.setBackgroundResource(R.drawable.alcohol7);
            Menualcohol.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(alcohol8))
        {
            mBottle.setBackgroundResource(R.drawable.alcohol8);
            Menualcohol.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }
        if(view.equals(alcohol9))
        {
            mBottle.setBackgroundResource(R.drawable.alcohol9);
            Menualcohol.setVisibility(View.INVISIBLE);
            flBottle.setVisibility(View.VISIBLE);

        }

        this.menu.setGroupVisible(0,true);


    }

    public void selectMenu(View view)

    {   if(view.equals(waterMenu))
        {
            mainMenu.setVisibility(View.INVISIBLE);
            Menuwater.setVisibility(View.VISIBLE);

        }
        if(view.equals(sodaMenu))
        {
            mainMenu.setVisibility(View.INVISIBLE);
            Menusoda.setVisibility(View.VISIBLE);

        }
        if(view.equals(beerMenu))
        {
            mainMenu.setVisibility(View.INVISIBLE);
            Menubeer.setVisibility(View.VISIBLE);

        }
        if(view.equals(alcoholMenu))
        {
            mainMenu.setVisibility(View.INVISIBLE);
            Menualcohol.setVisibility(View.VISIBLE);

        }
        if(actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.cb_action:
                if (!mCbAction.isChecked()) mCbAction.setChecked(true);
                if (mCbVerite.isChecked()) mCbVerite.setChecked(false);
                break;
            case R.id.cb_verite:
                if (mCbAction.isChecked()) mCbAction.setChecked(false);
                if (!mCbVerite.isChecked()) mCbVerite.setChecked(true);
                break;

        }
    }

    public int randomArray(int lowerBound , int upperBound)
    {
        Random random = new Random();
        int randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound;
        return randomNumber;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
