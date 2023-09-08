package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        String myurl = "https://api.chucknorris.io/jokes/random";

        HttpURLConnection connection = null;
        int responseCode = 0;

        URL url = null;

        try {
            url = new URL(myurl);
            System.out.println("URL object made");
        } catch (MalformedURLException e) {
            System.out.println("Something is wrong with the URL");
        }

        //Connection :

        try {
            connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();
            System.out.println("Connection opened");
        }
        catch (IOException e) {
            System.out.println("Could not open connection");
        }

        if(responseCode == 200){

            System.out.println("Response code 200");

            BufferedReader b = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String readLine = null;

            while((readLine=b.readLine())!=null){
                apiData.append(readLine);
            }

            b.close();

            JSONObject jsonApiResponse = new JSONObject(apiData.toString());

            System.out.println(jsonApiResponse.names());
            System.out.println(jsonApiResponse);

        }
        else{
            System.out.println("API call not successful");
        }


    }
}