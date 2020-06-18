package com.example.intentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile extends AppCompatActivity {
    Button mail,call,map,shop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
       mail =findViewById(R.id.mail);
       call=findViewById(R.id.call);
       map=findViewById(R.id.map);
       shop=findViewById(R.id.shop);
       mail.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(Intent.ACTION_SEND);
               i.setData(Uri.parse("email"));
               String[] s={"abc@gmail.com","yahoo@gmail.com"};
               i.putExtra(Intent.EXTRA_EMAIL,s);
               i.putExtra(Intent.EXTRA_SUBJECT,"This is a Subject");
               i.putExtra(Intent.EXTRA_TEXT,"Hii This is the Email Body");
               i.setType("message/rfc822"); //setting MIME Email Multipurpose Internet Mail Extensions
               Intent chooser = Intent.createChooser(i,"Launch Email");
               startActivity(chooser);

           }
       });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:12.934451,77.606016"));
                Intent chooser = Intent.createChooser(i,"Launch Maps");
                startActivity(chooser);

            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+909090909));//
                Intent chooser = Intent.createChooser(i,"Launch calls");
                startActivity(chooser);
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = getString(R.string.website);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });

    }
}