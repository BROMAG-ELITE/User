package com.example.bromagindia.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import androidx.recyclerview.widget.RecyclerView
import com.example.bromagindia.R

class TableActivity : AppCompatActivity() {

    var tableAdapter: TableAdapter? = null
    var tableRecyclerView: GridView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        tableRecyclerView=findViewById(R.id.table_grid)

        val tables = ArrayList<TableList>()
        tables.add(TableList(R.drawable.t2,"TABLE 1","2 Seater"))
        tables.add(TableList(R.drawable.t1,"TABLE 2","2 Seater"))
        tables.add(TableList(R.drawable.t3,"TABLE 3","4 Seater"))
        tables.add(TableList(R.drawable.t4,"TABLE 4","6 Seater"))
        tables.add(TableList(R.drawable.t2,"TABLE 5","8 Seater"))
        tables.add(TableList(R.drawable.t3,"TABLE 6","10 Seater"))
        tables.add(TableList(R.drawable.t1,"TABLE 7","2 Seater"))
        tables.add(TableList(R.drawable.t4,"TABLE 8","2 Seater"))
        tables.add(TableList(R.drawable.t5,"TABLE 9","4 Seater"))

        tableAdapter = TableAdapter(this, tables)
        tableRecyclerView?.adapter = tableAdapter

    }
}