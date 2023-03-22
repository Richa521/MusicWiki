package com.example.musicwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicwiki.adapters.AlbumInfoGenreAdapter
import com.example.musicwiki.databinding.ActivityAlbumInfoBinding
import com.example.musicwiki.repository.Repository
import com.example.musicwiki.viewmodel.MainViewModel

class AlbumInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumInfoBinding
    lateinit var albumInfoGenreAdapter: AlbumInfoGenreAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()

        val aints = intent
        val aname = aints.getStringExtra("ANAME")
        val arname = aints.getStringExtra("ARNAME")


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getAlbumInfo(arname.toString(), aname.toString())
        viewModel.albumInfoResponse.observe(this) { info ->

            setUpRecyclerView()
            albumInfoGenreAdapter.albumInfoGenre = info.tags.tag
            binding.albumTitle.text = info.name
            binding.artistTitle.text = info.artist
            binding.albumDesc.text = info.wiki.summary
            binding.albumImg.loadImage(info.image[0].text)

        }
    }

    private fun setUpRecyclerView()  = binding.albumInfoGenreRv.apply {
        albumInfoGenreAdapter = AlbumInfoGenreAdapter(this@AlbumInfoActivity)
        adapter = albumInfoGenreAdapter
        layoutManager = LinearLayoutManager(this@AlbumInfoActivity, LinearLayoutManager.HORIZONTAL,false)
    }
}