package com.example.musicwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicwiki.adapters.*
import com.example.musicwiki.databinding.ActivityArtistInfoBinding
import com.example.musicwiki.repository.Repository
import com.example.musicwiki.viewmodel.MainViewModel

class ArtistInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistInfoBinding
    lateinit var albumInfoGenreAdapter: AlbumInfoGenreAdapter
     lateinit var artistTopTracksAdapter: ArtistTopTracksAdapter
     lateinit var artistTopAlbumsAdapter: ArtistTopAlbumsAdapter
     private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
        setUpRecyclerView1()
        setUpRecyclerView2()

        val aints = intent

        val arname = aints.getStringExtra("AR-NAME")

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getArtistInfo(arname.toString())
        viewModel.artistInfoResponse.observe(this) { response ->

            setUpRecyclerView()
            albumInfoGenreAdapter.albumInfoGenre = response.tags.tag
            binding.artistTitle.text = response.name
            binding.artistPlaycount.text = response.stats.playcount
            binding.artistListeners.text = response.stats.listeners
            binding.artistImg.loadImage(response.image[0].text)

        }


        viewModel.getArtistTopTracks(arname.toString())
        viewModel.artistTopTracksResponse.observe(this) { topTracks ->
            setUpRecyclerView1()
            artistTopTracksAdapter.artistInfoTopTracks = topTracks
        }


        viewModel.getArtistTopAlbums(arname.toString())
        viewModel.artistTopAlbumsResponse.observe(this) { topAlbums ->
            setUpRecyclerView2()
            artistTopAlbumsAdapter.artistTopAlbums = topAlbums
        }
    }
    private fun setUpRecyclerView()  = binding.artistInfoGenreRv.apply {
        albumInfoGenreAdapter = AlbumInfoGenreAdapter(this@ArtistInfoActivity)
        adapter = albumInfoGenreAdapter
        layoutManager = LinearLayoutManager(this@ArtistInfoActivity, LinearLayoutManager.HORIZONTAL,false)
    }

    private fun setUpRecyclerView1() = binding.artistInfoToptracksRv.apply {
        artistTopTracksAdapter = ArtistTopTracksAdapter()
        adapter = artistTopTracksAdapter
        layoutManager = LinearLayoutManager(this@ArtistInfoActivity, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setUpRecyclerView2() = binding.artistInfoTopalbumsRv.apply {
       artistTopAlbumsAdapter = ArtistTopAlbumsAdapter(this@ArtistInfoActivity)
        adapter = artistTopAlbumsAdapter
        layoutManager = LinearLayoutManager(this@ArtistInfoActivity, LinearLayoutManager.HORIZONTAL, false)
    }
}