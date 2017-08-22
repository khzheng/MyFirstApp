package com.example.kzheng.myfirstapp
/**
 * Created by blee on 7/31/17.
 */

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import android.view.View
import kotlinx.android.synthetic.main.activity_tideinfoben.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class TideInfoActivityBen : AppCompatActivity () {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tideinfoben)

        etCity.setText("Oakland")
        etState.setText("CA")
        etWeatherResults.movementMethod = ScrollingMovementMethod()
    }

    protected fun GetTideInfo (view:View) {


        //TODO: create var of the city and state from etCityState and append toString
        var city = etCity.text.toString()
        // city names greater than one word require an underscore instead of space
        var cityUpdated = city.replace(" ", "_")
        var state = etState.text.toString()

        //TODO: create val of weatherUndeground link for tide api call
        //see: https://www.wunderground.com/weather/api/d/docs?d=data/tide
        // need to apply API key here
        val url="http://api.wunderground.com/api/32f6d2632973079d/tide/q/" + state + "/" + cityUpdated + ".json"
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
                // p0 is the first instance that was passed
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
                var tide = json.getJSONObject("tide")
                var tideInfo = tide.getJSONArray("tideInfo").getJSONObject(0)
                var tideSummary = tide.getJSONArray("tideSummary")

                var weatherResultString = "Location: " + tideInfo.get("tideSite") + "\n\n"

                for (i in 0..(tideSummary.length() - 1)) {
                    // TODO: create models for these
                    var tideSummaryItem = tideSummary.getJSONObject(i)
                    var date = tideSummaryItem.getJSONObject("date")
                    var dateString = date.get("pretty")

                    var data = tideSummaryItem.getJSONObject("data")
                    var height = data.get("height")
                    if (height.toString().length == 0)
                        height = "N/A"
                    var type = data.get("type")

                    weatherResultString += "" + dateString + " height: " + height + " type: " + type + "\n"
                }

                etWeatherResults.text = weatherResultString

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