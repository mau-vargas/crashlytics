package com.android.crashlytics

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.huawei.agconnect.crash.AGConnectCrash
import com.huawei.hms.analytics.HiAnalytics
import com.huawei.hms.analytics.HiAnalyticsInstance
import com.huawei.hms.analytics.HiAnalyticsTools
import com.huawei.hms.analytics.type.HAEventType
import com.huawei.hms.analytics.type.HAParamType


class MainActivity : AppCompatActivity() {
    // TODO: Define a var for Analytics Instance
    var instance: HiAnalyticsInstance? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val aGConnectCrash=AGConnectCrash.getInstance()


        // TODO: Initiate Analytics Kit
        // Enable Analytics Kit Log

        // TODO: Initiate Analytics Kit
        // Enable Analytics Kit Log
        HiAnalyticsTools.enableLog()
        // Generate the Analytics Instance
        // Generate the Analytics Instance
        instance = HiAnalytics.getInstance(this)
        with(instance){
            this?.setAnalyticsEnabled(true)
            this?.regHmsSvcEvent()
        }




        val btn_crash = findViewById<Button>(R.id.btn_crash)
        btn_crash.setOnClickListener {
            //aGConnectCrash.testIt()
            hmsAnalytics()

        }

        findViewById<View>(R.id.enable_crash_off).setOnClickListener {
            aGConnectCrash.enableCrashCollection(false)
        }

        findViewById<View>(R.id.enable_crash_on).setOnClickListener {
            AGConnectCrash.getInstance().enableCrashCollection(true)
        }



    }


    private fun hmsAnalytics(){
        val bundle = Bundle()
        bundle.putString(HAParamType.CHANNEL, "Android")

        // Report a preddefined Event
        instance!!.onEvent("PRUEBA_ANDROID", bundle)
    }



}
