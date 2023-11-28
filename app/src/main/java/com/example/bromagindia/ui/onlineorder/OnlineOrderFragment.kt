package com.example.bromagindia.ui.onlineorder

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import com.example.bromagindia.R
import com.example.bromagindia.subcusine.SubCusineActivity

class OnlineOrderFragment : Fragment() {

    var adapter: OnlineOrderGridAdapter?=null
    var gridView: GridView?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_online_order, container, false)

        gridView = view.findViewById(R.id.grid)

        val m = ArrayList<OnlineOrderGridList>()
        m.add(OnlineOrderGridList(R.drawable.indian,"Indian"))
        m.add(OnlineOrderGridList(R.drawable.arabian,"Arabian"))
        m.add(OnlineOrderGridList(R.drawable.mexican,"Mexican"))
        m.add(OnlineOrderGridList(R.drawable.american,"American"))
        m.add(OnlineOrderGridList(R.drawable.italian,"Italian"))
        m.add(OnlineOrderGridList(R.drawable.chinese,"Chinese"))
        m.add(OnlineOrderGridList(R.drawable.continental,"Continental"))
        m.add(OnlineOrderGridList(R.drawable.friedchicken,"Fried Chicken"))
        m.add(OnlineOrderGridList(R.drawable.dess,"Desserts & Beverages"))


        adapter = OnlineOrderGridAdapter(this, m)
        gridView?.adapter = adapter

        gridView!!.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val intent = Intent(context, SubCusineActivity::class.java)
                context?.startActivity(intent)
            }

        return view
    }

}