package networking.test.adapter.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import networking.test.R
import networking.test.model.dict.Word

class WordListAdapter :
    ListAdapter<Word, WordListAdapter.ViewHolder>(RestaurantDiffUtilCallback()) {
    companion object {
        const val LINEAR_ITEM = 0
        const val GRID_ITEM = 1
    }

    var isLinearSwitched = true
    var listener: WordItemListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View? = if (viewType == LINEAR_ITEM) {
            inflater.inflate(R.layout.item_linear_word, parent, false)
        } else {
            inflater.inflate(R.layout.item_linear_word, parent, false)
        }
        return ViewHolder(view!!)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, listener!!)
    }

    override fun getItemViewType(position: Int): Int {
        return if (isLinearSwitched) {
            LINEAR_ITEM
        } else {
            GRID_ITEM
        }
    }

    fun toggleItemViewType(): Boolean {
        isLinearSwitched = !isLinearSwitched
        return isLinearSwitched
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvWord: TextView? = itemView.findViewById(R.id.tv_word)
        private val tvMeaning: TextView? = itemView.findViewById(R.id.tv_meaning)

        fun bind(word: Word, listener: WordItemListener) {
            itemView.setOnClickListener {
                listener.onItemClicked(word)
            }


            tvWord!!.text = word.word
            tvMeaning!!.text = word.meanings.toString()


            if (isLinearSwitched) {
                // do if switch layout
            }
        }

    }

    class RestaurantDiffUtilCallback : DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.word == newItem.word
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem == newItem
        }
    }

    interface WordItemListener {
        fun onItemClicked(movie: Word)
    }
}