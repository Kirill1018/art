package com.example.art

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget
    .RecyclerView
import com.bumptech.glide
    .Glide
import com.example.art
    .domain.Data

class ImAdapter(private var imList: List<Data>) : RecyclerView.Adapter<ImAdapter.ViewHoldOfIm>() {
    inner class ViewHoldOfIm(private val binding: View) : RecyclerView.ViewHolder(binding.rootView) {
        fun bind(data: Data) {
            val titleText: TextView = this.binding.findViewById(R
                .id.name)
            val dateText: TextView = this.binding.findViewById(R
                .id.date)
            val imageView: ImageView = this.binding.findViewById(R
                .id.image)
            val url = data.webImage.url
            val imName = data.title
            val longName = data.longTitle
            val imTitle = "title: $imName"
            val longNameOfIm = "long title: $longName"
            titleText.text = imTitle
            dateText.text = longNameOfIm
            Glide.with(this.binding)
                .load(url).into(imageView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHoldOfIm {
        val binding = LayoutInflater.from(parent.context)
            .inflate(R.layout.im_data, parent,
                false)
        return ViewHoldOfIm(binding)
    }
    override fun onBindViewHolder(holder: ViewHoldOfIm, position: Int) = holder.bind(this.imList[position])
    override fun getItemCount(): Int = this.imList.size
}