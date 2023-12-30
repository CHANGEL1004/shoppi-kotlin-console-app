package com.shoppi.app.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shoppi.app.databinding.ItemCategoryBinding
import com.shoppi.app.model.Category
import com.shoppi.app.ui.common.CategoryDiffCallback

class CategoryAdapter(private val viewModel: CategoryViewModel): ListAdapter<Category, CategoryAdapter.CategoryViewHolder >(
    CategoryDiffCallback()
) {
    inner class CategoryViewHolder(private val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(category: Category) {
            binding.viewModel = viewModel
            binding.category = category // 바인딩에 카테고리 데이터 할당
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent
        , false)
        return CategoryViewHolder(binding) // 이 바인딩을 카테고리 뷰 바인딩을 생성할 때 전달
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) { //홀더에서 레이아웃의 데이터를 바인딩함
        holder.bind(getItem(position))
    }

}

