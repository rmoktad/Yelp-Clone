package edu.stanford.rmoktad.yelpclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.stanford.rmoktad.myapplication.R
import retrofit2.Retrofit

private const val  BASE_URL = "https://api.yelp.comm/v3"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //val retrofit = Retrofit.Builder().baseURL(BASE_URL).addConverterFactory(GsonConverterFactor.create).build();
    }
}
