package com.example.leadmanagementapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.leadmanagementapp.Data.DemoData
import com.example.leadmanagementapp.R
import de.hdodenhof.circleimageview.CircleImageView

class HomeAdapter(
    private val leadList:List<DemoData>,
    private val clickListener:OnItemClickListener
):RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView:CircleImageView=itemView.findViewById(R.id.lead_image)
        val leadName:TextView=itemView.findViewById(R.id.lead_name)
        val lastMsg:TextView=itemView.findViewById(R.id.last_msg)
        val time:TextView=itemView.findViewById(R.id.time)
    }

    interface OnItemClickListener{
        fun onItemClick(item: DemoData)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lead_card,parent,false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        val currentItem=leadList[position]
        holder.imageView.setImageResource(currentItem.image)
        holder.leadName.text=currentItem.project_name
        holder.lastMsg.text=currentItem.last_msg
        holder.time.text=currentItem.time

        holder.itemView.setOnClickListener {
            clickListener.onItemClick(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return leadList.size
    }


}