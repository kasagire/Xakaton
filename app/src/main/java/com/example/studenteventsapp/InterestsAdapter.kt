import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studenteventsapp.R
class InterestsAdapter(
    private val interests: List<Interest>,
    private val clickListener: (Interest) -> Unit
) : RecyclerView.Adapter<InterestsAdapter.InterestViewHolder>() {

    inner class InterestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(interest: Interest) {
            itemView.findViewById<TextView>(R.id.interestName).text = interest.name
            itemView.setOnClickListener { clickListener(interest) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_interest, parent, false)
        return InterestViewHolder(view)
    }

    override fun onBindViewHolder(holder: InterestViewHolder, position: Int) {
        holder.bind(interests[position])
    }

    override fun getItemCount(): Int = interests.size
}