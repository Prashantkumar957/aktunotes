package com.prashantkumar957.aktunotes

import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.prashantkumar957.aktunotes.databinding.ActivityDetailsBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.io.InputStream

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)


        val subject: String? = intent.getStringExtra("subject")
        val link: String? = intent.getStringExtra("pdfLink")

        ShowPdf(link)


        binding.subject.setText(subject)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun ShowPdf(link: String?) {
        if (link.isNullOrEmpty()) {
            Toast.makeText(this, "PDF link is invalid", Toast.LENGTH_SHORT).show()
            return
        }

        val client = OkHttpClient()

        val request = Request.Builder()
            .url(link)
            .build()

//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                InputStream inputstream = response.body().bytetream():
//
//            }
//
//        }
//    }
    }
}


