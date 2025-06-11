package com.example.art

import android.os.Bundle
import androidx.appcompat.app
    .AppCompatActivity
import androidx.recyclerview.widget
    .LinearLayoutManager
import androidx.recyclerview.widget
    .RecyclerView
import com.example.art
    .data.RetrofitClient
import com.example.art
    .databinding.ActivityMainBinding
import com.example.art
    .domain.Artwork
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = findViewById(R.id.arts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchArt(recyclerView)
    }
}
fun fetchArt(recycler: RecyclerView) {
    val call = RetrofitClient.artApi.getArt("mU10BOrS")//handling network responses
    call.enqueue(object : retrofit2.Callback<Artwork> {
        override fun onResponse(call: Call<Artwork>, response: Response<Artwork>) { if (response.isSuccessful) {
            val artData = response.body()//result
            val imAdapter = ImAdapter(artData!!.artObjects)
            recycler.adapter = imAdapter
        }
        }
        override fun onFailure(call: Call<Artwork>, t: Throwable) { }
    })
}