package com.example.kzheng.myfirstapp
/**
 * Created by blee on 7/31/17.
 */

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_tideinfo.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class TideInfoActivity: AppCompatActivity () {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tideinfo)
    }

    protected fun TideInfoActivity (view:View) {


        //TODO: create var of the city and state from etCityState and append toString
        var city = etCity.text.toString()
        var state = etState.text.toString()

        //TODO: create val of weatherUndeground link for tide api call
        //see: https://www.wunderground.com/weather/api/d/docs?d=data/tide
        // need to apply API key here
        // NOTE: Bug here... city names greater than one word require underscore
        val url="http://api.wunderground.com/api/32f6d2632973079d/tide/q/"+ state + "/"+city+".json"
        TideAsyncTask().execute(url)

    }

    inner class TideAsyncTask:AsyncTask<String, String, String>() {
        override fun onPreExecute() {
            //commenting below for now
            //super.onPreExecute()
        }

        override fun doInBackground(vararg p0: String?): String {
            //TODO: Implement a Try and Catch
            try {
                //TODO: Add val url and import URL from java
                val url=URL(p0[0])
                val urlConnect = url.openConnection() as HttpURLConnection
                //TODO: Add timeout for the connection
                urlConnect.connectTimeout = 7000

                var inString = ConvertStreamToString(urlConnect.inputStream)
                publishProgress(inString)
            }catch(ex:Exception){}

            return " "
        }

        override fun onProgressUpdate(vararg values: String?) {
            //commenting below for now
            //super.onProgressUpdate(*values)

            //TODO: Implement Try and Catch
            //TODO: Drill down on API to find tide info and set text to the correct element from the layout
            try {
                var json = JSONObject(values[0])
                val tideSummaryStats = json.getJSONObject("tideSummaryStats")
                //get the max min height
                var maxHeight = tideSummaryStats.getString("maxHeight")
                var minHeight = tideSummaryStats.getString("minHeight")

                etWeatherResults.text =
                        "Maxium Tide Height: " + maxHeight + "ft. \n"
                        "Minimum Tide Height: " + minHeight + "ft."


            }catch(ex:Exception){}
        }

        override fun onPostExecute(result: String?) {
            //commenting below for now
            //super.onPostExecute(result)
        }
    }

    fun ConvertStreamToString(inputStream: InputStream): String {
        //TODO: Create bufferReader
        val bufferReader = BufferedReader(InputStreamReader(inputStream))
        var line: String
        var AllString:String=""

        try {
            do {
                line = bufferReader.readLine()
                if(line != null){
                    AllString += line
                }
            }while (line!=null)
            inputStream.close()
        }catch (ex:Exception){}

        return AllString

    }
}