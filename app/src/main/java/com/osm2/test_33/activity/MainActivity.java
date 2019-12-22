package com.osm2.test_33.activity;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;


import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.VideoView;


import com.chenantao.fabMenu.FabMenu;
import com.chenantao.fabMenu.anim.ZhihuAnim;
import com.github.adriangar.fabmenu.FabMenuButton;
import com.github.adriangar.fabmenu.FabMenuLayout;


import com.osm2.test_33.Complaint_all.CommunicationsActivity;
import com.osm2.test_33.MtrActivity;
import com.osm2.test_33.R;
import com.osm2.test_33.TestActivity;
import com.osm2.test_33.library_CircleMenu.OnMenuSelectedListener;
import com.osm2.test_33.library_CircleMenu.OnMenuStatusChangeListener;
import com.osm2.test_33.library_CircleMenu.CircleMenu;
import com.osm2.test_33.listProduct.ProductListAdressActivity;
import com.osm2.test_33.oils.OilsListAdressActivity;


import java.util.ArrayList;
import java.util.List;


import com.osm2.test_33.Design_Menu.ResideMenu;
import com.osm2.test_33.Design_Menu.ResideMenuItem;
import yalantis.com.sidemenu.model.SlideMenuItem;
import yalantis.com.sidemenu.util.ViewAnimator;

public class MainActivity extends AppCompatActivity {


    // Create a VideoView variable, a MediaPlayer variable, and an int to hold the current
    // video position.
    private VideoView videoBG;
    MediaPlayer mMediaPlayer;
    int mCurrentVideoPosition;
    public ImageView img1, img2, gawda, img4, hints, img5, img_close,imageView;
    //

    // ViewPager viewPager;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private List<SlideMenuItem> list = new ArrayList<>();
    private ViewAnimator viewAnimator;
    private int res = R.drawable.ic_menu_camera;
    private LinearLayout linearLayout;
    public Button btn3,rights,lefts; //btnr,btng,
   public Animation animation;
   boolean isbtn=false;
    Animation animFadein, animFadeout;
    boolean flag=false;
    private CircleMenu circleMenu;



    private String[] mItemTexts = new String[] { "安全中心 ", "特色服务", "投资理财",
            "转账汇款", "我的账户", "信用卡" };
    private int[] mItemImgs = new int[] { R.drawable.ic_gawda,
            R.drawable.ic_gawda, R.drawable.ic_gawda,
            R.drawable.ic_gawda, R.drawable.ic_gawda,
            R.drawable.ic_gawda };
    private ResideMenu resideMenu;
    private MainActivity mContext;
    private ResideMenuItem itemHome;
    private ResideMenuItem itemProfile;
    private ResideMenuItem itemCalendar;
    private ResideMenuItem itemSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_main);
        mContext = this;


      //  rights=(Button)findViewById(R.id.btn_right);
        //FabSpeedDial fabSpeedDial = (FabSpeedDial) findViewById(R.id.fab_speed_dial);
       // mFabMenu = (FabMenu) findViewById(R.id.fabMenu);
       // mFabMenu.setMenuItemAnim(new ZhihuAnim());

                                 // You don't need to override all methods. Just the ones you want.


                                 //  mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
                                 //   mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
                                 //  mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener()
                                 // {
                                 //    @Override
                                 //   public void itemClick(View view, int pos)
                                 //  {
                                 //     Toast.makeText(MainActivity.this, mItemTexts[pos],
                                 //            Toast.LENGTH_SHORT).show();

                                 //  }
                                 //  @Override
                                 //  public void itemCenterClick(View view)
                                 //  {
                                 //     Toast.makeText(MainActivity.this,
                                 //            "you can do something just like ccb  ",
                                 //            Toast.LENGTH_SHORT).show();
                                 //  }
                                 //    });


        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.ic_menu, R.drawable.ic_close_white)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.ic_gawda)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.ic_tires)
                .addSubMenu(Color.parseColor("#8A39FF"), R.drawable.ic_vehicles)
                .addSubMenu(Color.parseColor("#FF6A00"), R.drawable.ic_elec)
                .addSubMenu(Color.parseColor("#FF6A00"), R.drawable.ic_elec)
                .addSubMenu(Color.parseColor("#FF6A00"), R.drawable.ic_elec)

                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

                    @Override
                    public void onMenuSelected(int index) {

                        Intent intent=new Intent();
                        switch (index){
                            case 0:
                                intent =  new Intent(MainActivity.this, ProductListAdressActivity.class);
                                startActivity(intent);
                                break;
                            case 1:
                                intent =  new Intent(MainActivity.this, OilsListAdressActivity.class);
                                startActivity(intent);
                                break;
                            case 2:
                                intent =  new Intent(MainActivity.this, TestActivity.class);
                                startActivity(intent);
                                break;
                            case 3:
                                intent =  new Intent(MainActivity.this, TestActivity.class);
                                startActivity(intent);
                                break;
                            case 4:
                                intent =  new Intent(MainActivity.this, TestActivity.class);
                                startActivity(intent);
                                break;
                            case 5:
                                intent =  new Intent(MainActivity.this, TestActivity.class);
                                startActivity(intent);
                                break;
                            default:
                                break;
                        }

                        startActivity(intent);
                    }

                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {}

            @Override
            public void onMenuClosed() {}

        });

         animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        animFadeout = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_out);

        Typeface mytypeface=Typeface.createFromAsset(getAssets(),"fonts/flat.ttf");
        TextView txtzz=(TextView) findViewById(R.id.txtysmo) ;
        TextView txtxx=(TextView) findViewById(R.id.textView2) ;
        txtzz.setTypeface(mytypeface);
        txtxx.setTypeface(mytypeface);

       Button btn=(Button) findViewById(R.id.btn_com) ;
       btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

            Intent intents =  new Intent(MainActivity.this, CommunicationsActivity.class);
             startActivity(intents);
         }
         });

        imageView=(ImageView) findViewById(R.id.imageView_oilss);



        //Hook up the VideoView to our UI.
        videoBG = (VideoView) findViewById(R.id.videoView);

        //   Build your video Uri
        Uri uri = Uri.parse("android.resource://" // First start with this,
                + getPackageName() // then retrieve your package name,
                + "/" // add a slash,
                + R.raw.intro_movie); // and then finally add your video resource. Make sure it is stored
        // in the raw folder.

        // Set the new Uri to our VideoView
        videoBG.setVideoURI(uri);
        //Start the VideoView
        videoBG.start();

        // Set an OnPreparedListener for our VideoView. For more information about VideoViews,
        // check out the Android Docs: https://developer.android.com/reference/android/widget/VideoView.html
        videoBG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mMediaPlayer = mediaPlayer;
                // We want our video to play over and over so we set looping to true.
                mMediaPlayer.setLooping(true);
                // We then seek to the current posistion if it has been set and play the video.
                if (mCurrentVideoPosition != 0) {
                    mMediaPlayer.seekTo(mCurrentVideoPosition);
                    mMediaPlayer.start();
                }
            }
        });


    }

    public interface FabMenuAnim {

        Animator provideOpenAnimator(ViewGroup menuItem, View icon, View title, int index);

        Animator provideCloseAnimator(final ViewGroup menuItem, View icon, View title,int index);

        /**
         * 避免 item 跟 menu 的动画看起来不协调，提供一个方法为 menu 设置动画时间
         * @return
         */
        long provideAnimDuration();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //  // Capture the current video position and pause the video.
       mCurrentVideoPosition = mMediaPlayer.getCurrentPosition();
        videoBG.pause();
        mMediaPlayer.pause();

    }
    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Restart the video when resuming the Activity
        videoBG.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // When the Activity is destroyed, release our MediaPlayer and set it to null.
        mMediaPlayer.release();
        mMediaPlayer = null;
    }




    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_menu:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
    }


}