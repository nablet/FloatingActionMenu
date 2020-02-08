package com.nablet.floatingactionmenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class FloatingActionMenuAdapter(
    private val dataSet: ArrayList<ButtonData>,
    private val itemLayout: Int,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<FloatingActionMenuAdapter.FabViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FabViewHolder {
        return FabViewHolder(LayoutInflater.from(parent.context)
                .inflate(itemLayout, null, false))
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: FabViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class FabViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textView = view.findViewById<TextView>(R.id.tv)
        private val btnImg = view.findViewWithTag<ImageView>(R.id.iv)

        fun bind(position: Int) {
            textView.text = dataSet[position].text
            btnImg.setImageResource(dataSet[position].imageResource)

            /** Set the main fab button bigger */
            if (position != 0) {
                btnImg.scaleX = 0.8f
                btnImg.scaleY = 0.8f
            }

            btnImg.setOnClickListener {
                onItemClick(position)
            }
        }
    }
}