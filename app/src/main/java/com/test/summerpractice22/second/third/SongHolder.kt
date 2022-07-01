package com.test.summerpractice22.second.third

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.test.summerpractice22.R
import com.test.summerpractice22.databinding.ItemSongBinding

class SongHolder(
    private val binding: ItemSongBinding,
    private val glide: RequestManager,
    private val onItemClick: (Song) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

    fun onBind(song: Song) {
        with(binding) {
            tvName.text = song.name
            tvAuthor.text = song.author
            root.setOnClickListener {
                onItemClick(song)
            }

            glide
                .load(song.url)
                .placeholder(R.drawable.test_cat)
                .error(R.drawable.test_cat)
                .into(ivCover)
        }
    }
}
