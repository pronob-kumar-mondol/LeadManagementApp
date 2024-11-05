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
        val imageview:CircleImageView=itemView.findViewById(R.id.lead_image)
        val name:TextView=itemView.findViewById(R.id.lead_name)
        val mobile:TextView=itemView.findViewById(R.id.lead_number)
        val cost:TextView=itemView.findViewById(R.id.lead_cost)
        val lead_status:TextView=itemView.findViewById(R.id.lead_status)

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
        holder.imageview.setImageResource(currentItem.image)
        holder.name.text=currentItem.name
        holder.mobile.text=currentItem.number
        holder.cost.text=currentItem.install_charge
        holder.lead_status.text=currentItem.lead_status

        holder.itemView.setOnClickListener {
            clickListener.onItemClick(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return leadList.size
    }


}