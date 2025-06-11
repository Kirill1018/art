package com.example.art

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget
    .RecyclerView
import com.example.art
    .domain.Data

class ImAdapter(private var imList: List<Data>) : RecyclerView.Adapter<ImAdapter.ViewHoldOfIm>() {
    inner class ViewHoldOfIm(private val binding: View) : RecyclerView.ViewHolder(binding.rootView) {
        fun bind(data: Data) {
            val titleText: TextView = this.binding.findViewById(R
                .id.name)
            val dateText: TextView = this.binding.findViewById(R
                .id.date)
            val imName = data.title
            val icDate = data.dateEnd
            val imTitle = "title: $imName"
            val imDate = "date: $icDate"
            titleText.text = imTitle
            dateText.text = imDate
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