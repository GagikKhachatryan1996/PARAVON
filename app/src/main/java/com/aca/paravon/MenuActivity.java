package com.aca.paravon;

import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MenuActivity extends AppCompatActivity {


    TabLayout tabLayout;
    private Button btn_kanchel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btn_kanchel = findViewById(R.id.btn_kanchel);

        btn_kanchel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog aboutDialog = new AlertDialog.Builder(MenuActivity.this)
                        .setMessage("Ցանկանու՞մ եք կանչել մատուցողին")
                        .setPositiveButton("Այո", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {




                                showNotification(MenuActivity.this,"Հաղորդագրություն","Մատուցողը 5 րոպեյվա ընթացքում կմոտենա");

                            }
                        }).setNegativeButton("Ոչ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).create();

                aboutDialog.show();


            }
        });


        tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("Ուտելիքներ"));
        tabLayout.addTab(tabLayout.newTab().setText("Խմիչքներ"));
        tabLayout.addTab(tabLayout.newTab().setText("Ծխախոտներ"));

        tabLayout.setTabTextColors(ColorStateList.valueOf(Color.WHITE));


        final ViewPager viewPager = findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    public void showNotification(Context context, String title, String body) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId = 1;
        String channelId = "channel-01";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(body);
/*
          TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
          stackBuilder.addNextIntent(intent);
          PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                0,
               PendingIntent.FLAG_UPDATE_CURRENT
           );
          mBuilder.setContentIntent(resultPendingIntent);
*/
        notificationManager.notify(notificationId, mBuilder.build());
    }



}
