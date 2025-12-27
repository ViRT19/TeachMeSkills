package ru.ksppoisk.shoppinglist.db
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.ksppoisk.shoppinglist.R
import ru.ksppoisk.shoppinglist.databinding.ListNameItemBinding
import ru.ksppoisk.shoppinglist.databinding.NoteListItemBinding
import ru.ksppoisk.shoppinglist.entities.NoteItem
import ru.ksppoisk.shoppinglist.entities.ShoppingListName
import ru.ksppoisk.shoppinglist.utils.HtmlManager


class ShopListNameAdapter(private val listener: Listener) : ListAdapter<ShoppingListName, ShopListNameAdapter.ItemHolder>(ItemComporator()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(
        holder: ItemHolder, position: Int) {
        holder.setData(getItem(position), listener)
    }
    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListNameItemBinding.bind(view)

        fun setData(shoppingListNameItem: ShoppingListName, listener: Listener) = with(binding) {
            tvListName.text = shoppingListNameItem.name
            tvTime.text = shoppingListNameItem.time
            itemView.setOnClickListener {
//                listener.onClickItem(shoppingListNameItem)
            }
            imDelete.setOnClickListener {
                listener.deleteItem(shoppingListNameItem.id!!)
            }
        }

        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.list_name_item, parent, false)
                )
            }
        }
    }

    class ItemComporator : DiffUtil.ItemCallback<ShoppingListName>() {
        override fun areItemsTheSame(oldItem: ShoppingListName, newItem: ShoppingListName): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShoppingListName, newItem: ShoppingListName): Boolean {
            return oldItem == newItem
        }
    }


    interface Listener {
        fun deleteItem(id: Int)
        fun onClickItem(note: NoteItem)
    }
}