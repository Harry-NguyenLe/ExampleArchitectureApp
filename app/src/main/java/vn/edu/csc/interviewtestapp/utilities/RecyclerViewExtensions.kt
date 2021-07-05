package vn.edu.csc.interviewtestapp.utilities

import androidx.recyclerview.widget.RecyclerView

fun <T : RecyclerView.ViewHolder> T.listen(listener: (any: Any) -> Unit): T {
    itemView.setOnClickListener {
        listener.invoke(adapterPosition)
    }
    return this
}