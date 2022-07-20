package admiral.group.myapplication.fragments.list

import admiral.group.myapplication.R
import admiral.group.myapplication.model.User
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_row.view.*


class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    private var userList= emptyList<User>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): MyViewHolder {
     return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
      return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, payloads: MutableList<Any>) {
        val currentItem = userList[position]
        holder.itemView.id_txt.text=currentItem.id.toString()
        holder.itemView.firstName_txt.text=currentItem.firstName.toString()
        holder.itemView.lastName_txt.text=currentItem.lastName.toString()
        holder.itemView.age_txt.text=currentItem.age.toString()
    }

    fun saveData(user: List<User>){
        this.userList=user
        notifyDataSetChanged()
    }

}