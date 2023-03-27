package com.example.scrollveiw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.scrollveiw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LL.bringToFront()
        binding.appearTV.bringToFront()

        val songList = mutableListOf<Song>(
            Song(R.drawable.one, "팔레트", "김뮤지엄"),
            Song(R.drawable.eight, "Picnic", "오왠"),
            Song(R.drawable.nine, "파란섬", "공기남"),
            Song(R.drawable.two, "미쳤나봐", "마틴스미스,정성하"),
            Song(R.drawable.sevent, "Love this", "SLAY, AVIN"),
            Song(R.drawable.six, "우린 이미", "김뮤지엄"),
            Song(R.drawable.five, "Love song", "뎁트"),
            Song(R.drawable.four, "Pillow", "PL"),
            Song(R.drawable.ten, "우리 사이 은하수를 만들어", "오존"),
            Song(R.drawable.three, "Flying High With U", "빈첸"),
        )

        binding.RV.adapter = RVAdapter(songList)
        binding.RV.addItemDecoration(RVDecorator(this))

        binding.NSV.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            Log.d("tgyuu",scrollY.toString())

            binding.LL.alpha = (scrollY/100.0).toFloat()
            binding.appearTV.alpha = (scrollY/100.0).toFloat()
        }

    }
}