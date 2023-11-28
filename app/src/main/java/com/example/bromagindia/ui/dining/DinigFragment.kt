package com.example.bromagindia.ui.dining

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.example.bromagindia.R
import com.example.bromagindia.databinding.FragmentDiningBinding
import com.example.bromagindia.subcusine.SubCusineActivity
import com.example.bromagindia.ui.takeaway.TakeawayGridAdapter
import com.example.bromagindia.ui.takeaway.TakeawayGridList

class DinigFragment : Fragment() {

    var adapter: DiningGridAdapter?=null
    var gridView: GridView?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val root = inflater.inflate(R.layout.fragment_dining, container, false)


        gridView = root.findViewById(R.id.grid)

        val m = ArrayList<DiningGridList>()
        m.add(DiningGridList(R.drawable.indian,"Indian"))
        m.add(DiningGridList(R.drawable.arabian,"Arabian"))
        m.add(DiningGridList(R.drawable.mexican,"Mexican"))
        m.add(DiningGridList(R.drawable.american,"American"))
        m.add(DiningGridList(R.drawable.italian,"Italian"))
        m.add(DiningGridList(R.drawable.chinese,"Chinese"))
        m.add(DiningGridList(R.drawable.continental,"Continental"))
        m.add(DiningGridList(R.drawable.friedchicken,"Fried Chicken"))
        m.add(DiningGridList(R.drawable.dess,"Desserts & Beverages"))


        // on below line we are setting adapter to our grid view.
        gridView!!.adapter = adapter

        adapter = DiningGridAdapter(this, m)
        gridView?.adapter = adapter

        gridView!!.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val intent = Intent(context, SubCusineActivity::class.java)
                context?.startActivity(intent)
            }

        return root

    }


}