package com.android.crashlytics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.crashlytics.android.Crashlytics
import kotlinx.android.synthetic.gms.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        crash.setOnClickListener {
            Crashlytics.getInstance().crash() // Force a crash
        }
    }
}
