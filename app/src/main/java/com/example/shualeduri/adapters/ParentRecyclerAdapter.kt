package com.example.shualeduri.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shualeduri.databinding.ParentItemViewBinding
import com.example.shualeduri.models.Summary

class ParentRecyclerAdapter() : RecyclerView.Adapter<ParentRecyclerAdapter.ParentViewHolder>() {

    private val items = mutableListOf<Summary>()

    inner class ParentViewHolder(binding: ParentItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var recycler1: RecyclerView = binding.childRecycler1
        var recycler2: RecyclerView = binding.childRecycler2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val parentItem =
            ParentItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParentViewHolder(parentItem)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val child1LayoutManager = LinearLayoutManager(holder.recycler1.context)
        val child2LayoutManager = LinearLayoutManager(holder.recycler2.context)
        holder.recycler1.apply {
            layoutManager = child1LayoutManager
            adapter = Team1RecyclerAdapter(items[position])
            setRecycledViewPool(recycledViewPool)
        }
        holder.recycler2.apply {
            layoutManager = child2LayoutManager
            adapter = Team2RecyclerAdapter(items[position])
            setRecycledViewPool(recycledViewPool)
        }
    }

    override fun getItemCount() = items.size

    fun setData(items: MutableList<Summary>): MutableList<Summary> {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
        return items
    }
}