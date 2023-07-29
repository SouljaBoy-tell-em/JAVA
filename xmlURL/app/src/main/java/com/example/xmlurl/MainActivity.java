package com.example.xmlurl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView usersList = findViewById(R.id.usersList);
        TextView contentView = findViewById(R.id.contentView);

        contentView.setText("Загрузка...");
        new Thread(new Runnable() {
            public void run() {
                try{
                    String content = download("https://firebasestorage.googleapis.com/v0/b/shop-c93db.appspot.com/o/users.xml?alt=media&token=37aad1a5-d118-485c-b210-adf9e96f3242  try");
                    usersList.post(new Runnable() {
                        public void run() {
                            UserXmlParser parser = new UserXmlParser();
                            if(parser.parse(content))
                            {
                                ArrayAdapter<User> adapter = new ArrayAdapter(getBaseContext(),
                                        android.R.layout.simple_list_item_1, parser.getUsers());
                                usersList.setAdapter(adapter);
                                contentView.setText("Загруженно объектов: " + adapter.getCount());
                            }
                        }
                    });
                }
                catch (IOException ex){
                    contentView.post(new Runnable() {
                        public void run() {
                            contentView.setText("Ошибка: " + ex.getMessage());
                        }
                    });
                }
            }
        }).start();
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
