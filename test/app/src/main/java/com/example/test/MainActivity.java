package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.provider.ContactsContract;

import com.squareup.picasso.Picasso;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {


    private static final String KEY_OPTIONS = "key_options";
    ConstraintLayout mainConstraint;

    private static final int REQUEST_CODE_READ_CONTACTS = 1;
    private static boolean READ_CONTACTS_GRANTED = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ConstraintLayout mainConstraint = new ConstraintLayout(this);
//        ConstraintLayout.LayoutParams mainConstraintParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        ConstraintLayout constraintLayout = new ConstraintLayout(this);
//        constraintLayout.setId(View.generateViewId());
//        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        TextView textView = new TextView(this);
//        textView.setId(View.generateViewId());
//        textView.setText("CLICK");
//        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
//        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
//        constraintLayout.addView(textView);
//
//        ConstraintLayout constraintLayout1 = new ConstraintLayout(this);
//        ConstraintLayout.LayoutParams layoutParams1 = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        TextView textView1 = new TextView(this);
//        textView1.setText("DEFAULT");
//        layoutParams1.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
//        constraintLayout1.addView(textView1);
//
//        mainConstraint.addView(constraintLayout, layoutParams);
//        mainConstraint.addView(constraintLayout1, layoutParams1);
//
//
//        final int[] index = {0};
//        constraintLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                if (index[0] % 2 == 0) {
//
//                    textView1.setText("CLICK");
//                }
//                else
//                    textView1.setText("UNCLICK");
//                index[0]++;
//            }
//        });
//
//
//        setContentView(mainConstraint);


//       MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.music);
//       Play(mediaPlayer);


//        ConstraintLayout mainConstraint = new ConstraintLayout(this);
//
//        EditText editText = new EditText(this);
//        editText.setId(View.generateViewId());
//        ConstraintLayout.LayoutParams editTextParams =
//                new ConstraintLayout.LayoutParams(400,
//                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
//        editTextParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
//        editTextParams.topToTop   = ConstraintLayout.LayoutParams.PARENT_ID;
//        mainConstraint.addView(editText, editTextParams);
//
//        Button sendButton = new Button(this);
//        sendButton.setText("SEND");
//        sendButton.setId(View.generateViewId());
//        ConstraintLayout.LayoutParams sendButtonParams =
//                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
//        sendButtonParams.topToBottom = editText.getId();
//        sendButtonParams.leftToLeft  = ConstraintLayout.LayoutParams.PARENT_ID;
//        mainConstraint.addView(sendButton, sendButtonParams);
//
//        TextView textData = new TextView(this);
//        textData.setId(View.generateViewId());
//        textData.setText("DEFAULT");
//        textData.setTextSize(25);
//        ConstraintLayout.LayoutParams textDataParams =
//                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
//        textDataParams.topToBottom = sendButton.getId();
//        textDataParams.leftToLeft  = ConstraintLayout.LayoutParams.PARENT_ID;
//        mainConstraint.addView(textData, textDataParams);
//
//        Button getButton = new Button(this);
//        getButton.setText("GET");
//        ConstraintLayout.LayoutParams getButtonParams =
//                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
//        getButtonParams.topToBottom = textData.getId();
//        getButtonParams.leftToLeft  = ConstraintLayout.LayoutParams.PARENT_ID;
//        mainConstraint.addView(getButton, getButtonParams);
//
//        SharedPreferences settings = getSharedPreferences(KEY_OPTIONS, MODE_PRIVATE);
//
//        sendButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                SharedPreferences.Editor settingsEditor = settings.edit();
//                settingsEditor.putString(KEY_OPTIONS, editText.getText().toString());
//                settingsEditor.apply();
//            }
//        });
//
//
//        getButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                textData.setText(settings.getString(KEY_OPTIONS, "NOT DEFINE"));
//            }
//        });
//
//        setContentView(mainConstraint);


        //startActivity(new Intent(this, SettingsActivity.class));

//        String FILE_NAME = "file.txt";
//        ConstraintLayout mainConstraint = new ConstraintLayout(this);
//
//        EditText editText = new EditText(this);
//        editText.setId(View.generateViewId());
//        ConstraintLayout.LayoutParams editTextParams =
//                new ConstraintLayout.LayoutParams(400,
//                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
//        editTextParams.topToTop   = ConstraintLayout.LayoutParams.PARENT_ID;
//        editTextParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
//        mainConstraint.addView(editText, editTextParams);
//
//        Button sendButton = new Button(this);
//        sendButton.setText("SEND");
//        sendButton.setId(View.generateViewId());
//        ConstraintLayout.LayoutParams sendButtonParams =
//                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
//        sendButtonParams.leftToRight = editText.getId();
//        sendButtonParams.topToTop    = ConstraintLayout.LayoutParams.PARENT_ID;
//        mainConstraint.addView(sendButton, sendButtonParams);
//
//        TextView textView = new TextView(this);
//        textView.setTextSize(30);
//        ConstraintLayout.LayoutParams textViewParams =
//                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
//        textViewParams.topToBottom = editText.getId();
//        textViewParams.leftToLeft  = ConstraintLayout.LayoutParams.PARENT_ID;
//        mainConstraint.addView(textView, textViewParams);
//
//        sendButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                FileOutputStream fos = null;
//                try {
//
//                    fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
//                    fos.write(editText.getText().toString().getBytes());
//                } catch (Exception exception) {
//
//                }
//
//                FileInputStream fin = null;
//                try {
//
//                    fin = openFileInput(FILE_NAME);
//                    byte[] bytes = new byte[fin.available()];
//                    fin.read(bytes);
//                    String string = new String(bytes);
//                    textView.setText(string);
//                } catch (Exception exception) {
//
//
//                }
//            }
//        });

        //setContentView(mainConstraint);


//        String[] files = fileList();
//            Toast.makeText(this, files[0], Toast.LENGTH_LONG).show();


//        SQLiteDatabase database = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
//        database.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, age INTEGER)");
//        Cursor query = database.rawQuery("SELECT * FROM users;", null);
//        if(query.moveToFirst()) {
//
//            String name = query.getString(0);
//            int age = query.getInt(1);
//        }


//        ConstraintLayout mainConstraint = new ConstraintLayout(this);
//
//        Button getButton = new Button(this);
//        getButton.setId(View.generateViewId());
//        getButton.setText("GET");
//        ConstraintLayout.LayoutParams getButtonParams =
//                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                        ViewGroup.LayoutParams.WRAP_CONTENT);
//        getButtonParams.topToTop    = ConstraintLayout.LayoutParams.PARENT_ID;
//        getButtonParams.leftToLeft  = ConstraintLayout.LayoutParams.PARENT_ID;
//        mainConstraint.addView(getButton, getButtonParams);
//
//        TextView dataBaseText = new TextView(this);
//        dataBaseText.setTextSize(15);
//        dataBaseText.setText("DEFAULT");
//        dataBaseText.setId(View.generateViewId());
//        ConstraintLayout.LayoutParams dataBaseTextLayout =
//                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
//        dataBaseTextLayout.leftToLeft  = ConstraintLayout.LayoutParams.PARENT_ID;
//        dataBaseTextLayout.topToBottom = getButton.getId();
//        mainConstraint.addView(dataBaseText, dataBaseTextLayout);
//
//        SQLiteDatabase database = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
//        database.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, age INTEGER, UNIQUE(name))");
//        database.execSQL("INSERT OR IGNORE INTO users VALUES ('Semen Semenov', 19), ('Alexandr Zaytsev', 20)");
//        Cursor query = database.rawQuery("SELECT * FROM users;", null);
//
//        final boolean[] flag = {false};
//
//        getButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                while(query.moveToNext()) {
//
//                    if(flag[0] == false) {
//
//                        dataBaseText.setText("");
//                        flag[0] = true;
//                    }
//                    dataBaseText.append("Name: " + query.getString(0) + ", " + "Age: " + query.getInt(1) + " ;\n");
//                }
//
//                query.close();
//                database.close();
//            }
//        });
//
//        setContentView(mainConstraint);


//        String[] strings = new String[]{"New Balance 228", "New Balance 812", "Adidas", "Nike", "VERSACE"};
//
//        ConstraintLayout mainConstraint = new ConstraintLayout(this);
//
//        EditText editText = new EditText(this);
//        editText.setId(View.generateViewId());
//        ConstraintLayout.LayoutParams editTextParams = new ConstraintLayout.LayoutParams(400, ViewGroup.LayoutParams.WRAP_CONTENT);
//        editTextParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
//        editTextParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
//        mainConstraint.addView(editText, editTextParams);
//
//        TextView textView = new TextView(this);
//
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//                textView.setText("");
//                for(int i = 0; i < strings.length; i++) {
//
//                    if(editText.getText().toString().regionMatches(true, 0, strings[i], 0, editText.getText().length()) == true) {
//                        textView.append(strings[i] + "\n");
//                    }
//                }
//            }
//        });
//        ConstraintLayout.LayoutParams textViewParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        textViewParams.topToBottom = editText.getId();
//        textViewParams.leftToLeft  = ConstraintLayout.LayoutParams.PARENT_ID;
//        mainConstraint.addView(textView, textViewParams);
//
//
//
//        setContentView(mainConstraint);


//        setContentView(R.layout.activity_main);
//        ViewPager2 pager = findViewById(R.id.pager);
//        FragmentStateAdapter pageAdapter = new MyAdapter(this);
//        pager.setAdapter(pageAdapter);


//    mainConstraint = new ConstraintLayout(this);
//
//    EditText editText = new EditText(this);
//    editText.setId(View.generateViewId());
//    ConstraintLayout.LayoutParams editTextParams = new ConstraintLayout.LayoutParams(400, ViewGroup.LayoutParams.WRAP_CONTENT);
//    editTextParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
//    editTextParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
//    mainConstraint.addView(editText, editTextParams);
//
//    Button sendButton = new Button(this);
//    ConstraintLayout.LayoutParams sendButtonParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//    sendButtonParams.leftToRight = editText.getId();
//    sendButtonParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
//    mainConstraint.addView(sendButton, sendButtonParams);
//
//
//    sendButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//
//            Bundle bundle = new Bundle();
//            bundle.putString("keyname", editText.getText().toString());
//            bundle.putLong("keycode", 228);
//
//            MyDialog dialog = new MyDialog();
//            dialog.setArguments(bundle);
//            dialog.show(getSupportFragmentManager(), "custom");
//        }
//    });
//
//    setContentView(mainConstraint);


//        ImageView imageView = new ImageView(this);
//        imageView.setImageResource(R.drawable.yt);
//
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_test);
//        imageView.startAnimation(animation);
//        setContentView(imageView);


//    @Override
//    public void CreateCard(String name, long numberPhone) {
//
//        ConstraintLayout cardConstraint = new ConstraintLayout(this);
//        ConstraintLayout.LayoutParams cardConstraintParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        cardConstraintParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
//        cardConstraintParams.topToTop     = ConstraintLayout.LayoutParams.PARENT_ID;
//
//        cardConstraint.setId(View.generateViewId());
//
//        TextView nameView = new TextView(this);
//        nameView.setId(View.generateViewId());
//        nameView.setText(name);
//
//        ConstraintLayout.LayoutParams nameViewParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        nameViewParams.topToTop   = cardConstraint.getId();
//        nameViewParams.leftToLeft = cardConstraint.getId();
//        cardConstraint.addView(nameView, nameViewParams);
//
//        TextView cardView = new TextView(this);
//        cardView.setText(numberPhone + "");
//        ConstraintLayout.LayoutParams cardViewParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        cardViewParams.topToBottom = nameView.getId();
//        cardViewParams.leftToLeft  = cardConstraint.getId();
//        cardConstraint.addView(cardView, cardViewParams);
//
//        mainConstraint.addView(cardConstraint, cardConstraintParams);
//    }


//
//        XmlPullParser xpp = getResources().getXml(R.xml.users);
//        UserResourceParser parser = new UserResourceParser();
//        TextView textView = new TextView(this);
//
//        if (parser.parse(xpp)) {
//            for (User prod : parser.getUsers()) {
//                Log.d("XML", prod.toString());
//            }
//
//            setContentView(R.layout.activity_main);
//        }


//        TextView textView = new TextView(this);
//        textView.setText("download...");
//
//        ListView usersList = findViewById(R.id.usersList);
//        TextView contentView = findViewById(R.id.contentView);
//
//        contentView.setText("Загрузка...");
//        new Thread(new Runnable() {
//            public void run() {
//                try{
//                    String content = download("https://github.com/hellprogmaker/JAVA/blob/main/android/parser/fileparser/users.xml");
//                    usersList.post(new Runnable() {
//                        public void run() {
//
//                            UserXmlParser parser = new UserXmlParser();
//                            if(parser.parse(content))
//                            {
//                                ArrayAdapter<User> adapter = new ArrayAdapter(getBaseContext(),
//                                        android.R.layout.simple_list_item_1, parser.getUsers());
//                                usersList.setAdapter(adapter);
//                                contentView.setText("Загруженно объектов: " + adapter.getCount());
//                            }
//                        }
//                    });
//                }
//                catch (IOException ex){
//                    contentView.post(new Runnable() {
//                        public void run() {
//                            contentView.setText("Ошибка: " + ex.getMessage());
//                        }
//                    });
//                }
//            }
//        }).start();


//        setContentView(textView);




//        try {
//            String fileName = "f1ea8ae2e3a05e675f937fc177626474.jpeg";
//            String website = "https://w.forfun.com/fetch/f1/" + fileName;
//
//            System.out.println("Downloading File From: " + website);
//
//            URL url = new URL(website);
//            InputStream inputStream = url.openStream();
//            OutputStream outputStream = new FileOutputStream("res/drawable/" + fileName);
//            byte[] buffer = new byte[10000];
//
//            int length = 0;
//
//            while ((length = inputStream.read(buffer)) != -1) {
//                System.out.println("Buffer Read of length: " + length);
//                outputStream.write(buffer, 0, length);
//            }
//
//            inputStream.close();
//            outputStream.close();
//        } catch (Exception e) {
//            System.out.println("Exception: " + e.getMessage());
//        }

        ImageView imageView = new ImageView(this);
        Picasso.get().load("https://i.ebayimg.com/images/g/Z50AAOSwxQxh3Rrs/s-l500.jpg").into(imageView);
        setContentView(imageView);
}

    private String download(String urlPath) throws IOException{
        StringBuilder xmlResult = new StringBuilder();
        BufferedReader reader = null;
        InputStream stream = null;
        HttpsURLConnection connection = null;
        try {
            URL url = new URL(urlPath);
            connection = (HttpsURLConnection) url.openConnection();
            stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line=reader.readLine()) != null) {
                xmlResult.append(line);
            }
            return xmlResult.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (stream != null) {
                stream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}





//    private void Play(MediaPlayer mediaPlayer) {
//
//        if(mediaPlayer.isPlaying()) {
//
//            mediaPlayer.pause();
//            mediaPlayer.seekTo(0); // позволяет перейти к определенной миллисекунде;
//            mediaPlayer.setLooping(false);
//        }
//
//        mediaPlayer.start();
//        mediaPlayer.setLooping(true);
//    }
//}