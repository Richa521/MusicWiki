package com.example.musicwiki.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.ArtistInfoActivity
import com.example.musicwiki.databinding.CardItemBinding
import com.example.musicwiki.dataclasses.ArtistX
import com.example.musicwiki.loadImage

class GenreArtistsAdapter(var mContext: Context) : RecyclerView.Adapter<GenreArtistsAdapter.GenreArtistsViewHolder>() {
    inner class GenreArtistsViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root)
    var genreArtists : List<ArtistX> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreArtistsViewHolder {
        return GenreArtistsViewHolder(CardItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: GenreArtistsViewHolder, position: Int) {
        holder.binding.apply {
            itemTitle.text = genreArtists[position].name
            itemImg.loadImage(genreArtists[position].image[0].text)
        }
        holder.binding.root.setOnClickListener {
            val mIntent = Intent(mContext, ArtistInfoActivity::class.java)
            mIntent.putExtra("AR-NAME",genreArtists[position].name)
            mContext.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
       return genreArtists.size
    }
}