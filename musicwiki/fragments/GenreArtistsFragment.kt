package com.example.musicwiki.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicwiki.MainViewModelFactory
import com.example.musicwiki.adapters.GenreArtistsAdapter
import com.example.musicwiki.databinding.FragmentGenreArtistsBinding
import com.example.musicwiki.repository.Repository
import com.example.musicwiki.viewmodel.MainViewModel


class GenreArtistsFragment(var genreName: String) : Fragment() {

    private lateinit var binding: FragmentGenreArtistsBinding
    private lateinit var genreArtistsAdapter: GenreArtistsAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentGenreArtistsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getTagTopArtists(genreName.toString())
        viewModel.tagTopArtistsResposne.observe(viewLifecycleOwner) { topArtists ->
            setupRecyclerView()
            genreArtistsAdapter.genreArtists = topArtists
        }
    }

    private fun setupRecyclerView() =binding.artistsRv.apply {
        genreArtistsAdapter = GenreArtistsAdapter(context)
        adapter = genreArtistsAdapter
        layoutManager = LinearLayoutManager(context)
    }
}