package com.example.musicwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicwiki.adapters.TopGenreAdapter
import com.example.musicwiki.databinding.ActivityMainBinding
import com.example.musicwiki.repository.Repository
import com.example.musicwiki.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var genreAdapter: TopGenreAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.topTagResponse.observe(this) { tags ->
                setUpRecyclerView()
                genreAdapter.genres = tags
        }

    }

    private fun setUpRecyclerView()  = binding.genreRv.apply {
        genreAdapter = TopGenreAdapter(context)
        adapter = genreAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }
}