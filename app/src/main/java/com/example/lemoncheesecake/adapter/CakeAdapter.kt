package com.example.lemoncheesecake.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lemoncheesecake.R
import com.example.lemoncheesecake.databinding.ActivityMainBinding
import com.example.lemoncheesecake.databinding.LemonCakeBinding
import com.example.lemoncheesecake.model.LemonIDcakeItem

class CakeAdapter:ListAdapter<LemonIDcakeItem,CakeAdapter.MyViewHolder>(SampleItemDiffCallback()) {

    class MyViewHolder (val itemBinding: LemonCakeBinding):RecyclerView.ViewHolder(itemBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = LemonCakeBinding.inflate(view,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val cakeList = getItem(position)

        holder.itemBinding.textView.text = cakeList.desc
        Glide.with(holder.itemView.context)
            .load(cakeList.image)
            .into(holder.itemBinding.imageView)

    }

}
class SampleItemDiffCallback : DiffUtil.ItemCallback<LemonIDcakeItem>() {
    override fun areItemsTheSame(oldItem: LemonIDcakeItem, newItem: LemonIDcakeItem): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: LemonIDcakeItem, newItem: LemonIDcakeItem): Boolean = oldItem == newItem

}