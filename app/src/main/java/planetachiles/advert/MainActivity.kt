package planetachiles.advert

import android.content.Intent

import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
//import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*
//import com.google.planetachilesads.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // on below line we are creating a
    // variable for ad view and ad request

    private lateinit var adView:  AdView
    private lateinit var button: Button
    private lateinit var adRequest: AdRequest
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
//adView = findViewById(R.id.adViewID)
//adViewButton = findViewById(R.id.adViewButtonID)
        // on below line we are initializing
        // our mobile ads.
        //MobileAds.initialize(this)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        // Load an ad into the AdMob banner view.

        // Load an ad into the AdMob banner view.
        //adView =  binding.adView


        // on below line we are initializing
        // our ad view with its id
        button = findViewById(R.id.btn1)
        adView = findViewById(R.id.adViewID)

        val textView1 = findViewById<TextView>(R.id.textview)


        val flag = 2
        textView1.text = Html.fromHtml(getString(R.string.html), flag)
        //textView2.setText(Html.fromHtml(getString(R.string.url),flag));
        //textView2.setText(Html.fromHtml(getString(R.string.url),flag));
        textView1.movementMethod = LinkMovementMethod.getInstance()

        // adView.adUnitId = "ca-app-pub-3940256099942544~3347511713"
        // AdSize.BANNER
        // on below line we are
        // initializing our ad request.
        adRequest = AdRequest.Builder()
            .setRequestAgent("android_studio:ad_template").build()

        // Load an ad into the AdMob banner view.

        // Load an ad into the AdMob banner view.
        // on below line we are loading our
        // ad view with the ad request
        adView.loadAd(adRequest)
        adView.adListener = object: AdListener() {
            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Toast.makeText(applicationContext,"ads clicked",Toast.LENGTH_SHORT).show()

            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Toast.makeText(applicationContext,"ads successfully closed",Toast.LENGTH_SHORT).show()


            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
                Toast.makeText(applicationContext,"ads failed to load",Toast.LENGTH_SHORT).show()


            }

            override fun onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
                Toast.makeText(applicationContext,"ads successfully show impression",Toast.LENGTH_SHORT).show()


            }

            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Toast.makeText(applicationContext,"ads successfully loaded",Toast.LENGTH_SHORT).show()


            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Toast.makeText(applicationContext,"ads successfully opened",Toast.LENGTH_SHORT).show()


            }
        }

        button.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "")
            startActivity(dialIntent)

        }
    }

}




