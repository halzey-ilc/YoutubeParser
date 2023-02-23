package com.example.youtubeparser.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubeparser.data.models.HotVideo
import com.excample.youtubeparser.databinding.ItemHotBinding

class HotAdapter :
    PagingDataAdapter<HotVideo, HotAdapter.VideoViewHolder>(diffUtil) {

    inner class VideoViewHolder(private val binding: ItemHotBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: HotVideo) = with(binding) {
            Glide.with(imView.context)
                .load(item.snippet.thumbnails.standart.url)
                .into(imView)
            binding.tvName.text = item.snippet.channelTitle
            binding.tvTitle.text = item.snippet.title
        }

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition)?.apply {
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            ItemHotBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<HotVideo>() {
            override fun areItemsTheSame(oldItem: HotVideo, newItem: HotVideo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HotVideo, newItem: HotVideo): Boolean {
                return oldItem == newItem
            }
        }
    }
}