package com.shoppi.app.ui.categorydetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shoppi.app.databinding.ItemTitleBinding
import com.shoppi.app.model.Title


class CategorySectionTitleAdapter: ListAdapter<Title, CategorySectionTitleAdapter.CategorySectionTitleViewHolder>(TitleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorySectionTitleViewHolder {
        val binding = ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategorySectionTitleViewHolder(binding) // 이 바인딩을 카테고리 뷰 바인딩을 생성할 때 전달
    }

    override fun onBindViewHolder(holder: CategorySectionTitleViewHolder, position: Int) { //홀더에서 레이아웃의 데이터를 바인딩함
        holder.bind(getItem(position))
    }

    class CategorySectionTitleViewHolder(private val binding: ItemTitleBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(title: Title) {
            binding.title = title
            binding.executePendingBindings()
        }

    }

}

class TitleDiffCallback : DiffUtil.ItemCallback<Title>(){
    override fun areItemsTheSame(oldItem: Title, newItem: Title): Boolean {
        return oldItem.text == newItem.text
    }

    override fun areContentsTheSame(oldItem: Title, newItem: Title): Boolean {
       return oldItem == newItem
    }

}