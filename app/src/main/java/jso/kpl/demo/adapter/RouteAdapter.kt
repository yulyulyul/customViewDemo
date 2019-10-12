package jso.kpl.demo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import jso.kpl.demo.R
import jso.kpl.demo.viewmodel.Route

class RouteAdapter()
//    : androidx.recyclerview.widget.RecyclerView.Adapter<RouteAdapter.RouteViewHolder>()
{
//    private var items : MutableList<Route> = mutableListOf<Route>()
//
//    constructor(_items: MutableList<Route>) : this()
//    {
//        this.items = _items;
//    }
//    override fun getItemCount() = items.size
//
//    fun addItems(_list : MutableList<Route>)
//    {
//        items.clear()
//        items.addAll(_list)
//        notifyDataSetChanged()
//    }
//    fun addItem(_Idol: Route)
//    {
//        items.add(_Idol)
//        Log.d(TAG, "position : " + (items.size-1))
////        notifyItemChanged(items.size-1)
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteViewHolder {
//        Log.d(TAG, "onCreateViewHolder")
//        return RouteViewHolder(
//            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.custom_node, parent,false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: RouteViewHolder, position: Int)
//    {
//        Log.d(TAG, "onBindViewHolder")
//        val item = items[position]
//        holder.apply {
//            bind(item)
//            itemView.tag = item
//        }
//    }
//
//    companion  object {
//        val TAG = "Demo.RouteAdapter"
//    }

//    class RouteViewHolder(
//        private val binding: CustomNodeBinding
//    ) : RecyclerView.ViewHolder(binding.root)
//    {
//        fun bind(item : Route)
//        {
//            Log.d(TAG, "RouteViewHolder.bind")
//            binding.apply {
//                routeModel = item
//            }
//        }
//    }
}