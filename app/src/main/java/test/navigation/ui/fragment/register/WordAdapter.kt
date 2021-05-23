package test.navigation.ui.fragment.register

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import test.navigation.R
import test.navigation.dict.Word

class WordAdapter(private val listWord: ArrayList<Word>): RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
    class WordViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvWord: TextView?= null

        init {
            tvWord = itemView.findViewById(R.id.tvWord)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
       holder.tvWord?.text = listWord[position].word
    }

    override fun getItemCount(): Int {
        return listWord.size
    }

    fun updateList(list: List<Word>) {
        listWord.clear()
        listWord.addAll(list)
    }

}