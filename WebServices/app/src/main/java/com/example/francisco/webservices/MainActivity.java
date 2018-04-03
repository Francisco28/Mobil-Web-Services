package com.example.francisco.webservices;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button click;
    public static TextView data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.getBtn);
        data = (TextView) findViewById(R.id.showData);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetJson process = new GetJson();
                process.execute();
            }
        });
    }

    public class GetJson extends AsyncTask<Void,Void,Void> {
        String data ="";
        String fecha ="";
        String temp ="";
        String entry = "";
        String dataParsed = "";
        String singleParsed ="";
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL("https://api.thingspeak.com/channels/463886/fields/1.json");
                HttpURLConnection httpURLConnection = (HttpURLConnection)
                        url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new
                        InputStreamReader(inputStream));

                StringBuffer buffer = new StringBuffer();

                String line = "";
                while(line != null){
                    line = bufferedReader.readLine();
                    data = data + line;
                }


               
                JSONObject parentObject = new JSONObject(data);
                JSONArray parentArray = parentObject.getJSONArray("feeds");

                for(int i=0; i<parentArray.length(); i++){

                    JSONObject finalObject = parentArray.getJSONObject(i);
                    fecha = finalObject.getString("created_at");
                    temp = finalObject.getString("field1");
                    entry = finalObject.getString("entry_id");

                    dataParsed = dataParsed + "Entrada:"+ entry +"   -   Fecha y Hora:" +fecha + "   -   Temperatura(C°): "+ temp + "\n\n"   ;



                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            MainActivity.data.setText(this.dataParsed);
        }
    }

}
