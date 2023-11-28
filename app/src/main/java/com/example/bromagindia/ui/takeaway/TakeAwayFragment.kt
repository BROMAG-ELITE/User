package com.example.bromagindia.ui.takeaway

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.example.bromagindia.R
import com.example.bromagindia.subcusine.SubCusineActivity


class TakeAwayFragment : Fragment() {

    var adapter: TakeawayGridAdapter?=null
    var gridView: GridView?=null

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val root = inflater.inflate(R.layout.fragment_takeaway, container, false)


            gridView = root.findViewById(R.id.grid)

            val m = ArrayList<TakeawayGridList>()
            m.add(TakeawayGridList(R.drawable.indian,"Indian"))
            m.add(TakeawayGridList(R.drawable.arabian,"Arabian"))
            m.add(TakeawayGridList(R.drawable.mexican,"Mexican"))
            m.add(TakeawayGridList(R.drawable.american,"American"))
            m.add(TakeawayGridList(R.drawable.italian,"Italian"))
            m.add(TakeawayGridList(R.drawable.chinese,"Chinese"))
            m.add(TakeawayGridList(R.drawable.continental,"Continental"))
            m.add(TakeawayGridList(R.drawable.friedchicken,"Fried Chicken"))
            m.add(TakeawayGridList(R.drawable.dess,"Desserts & Beverages"))


            // on below line we are setting adapter to our grid view.
            gridView!!.adapter = adapter

            adapter = TakeawayGridAdapter(this, m)
            gridView?.adapter = adapter

            gridView!!.onItemClickListener =
                OnItemClickListener { _, _, position, _ ->
                    val intent = Intent(context, SubCusineActivity ::class.java)
                    context?.startActivity(intent)
                }

            return root
        }
}