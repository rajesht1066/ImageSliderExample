package com.example.imagesliderexample

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(
    private val imageId: Array<Int>,
    private val content: Array<String>
) : SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {
    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_slider_layout_item, parent, false)
        return SliderAdapterVH(view)
    }

    override fun onBindViewHolder(holder: SliderAdapterVH, position: Int) {
        holder.imageViewBackground.setImageResource(imageId[position])
        holder.textViewDescription.text = content[position]
        holder.itemView.setOnClickListener{
            Log.d("check","Clicked $position")
        }
    }

    override fun getCount(): Int {
        return imageId.size
    }

    class SliderAdapterVH(itemView: View) : ViewHolder(itemView) {
        var imageViewBackground = itemView.findViewById<ImageView>(R.id.iv_auto_image_slider)
        var textViewDescription = itemView.findViewById<TextView>(R.id.tv_auto_image_slider)
    }
}