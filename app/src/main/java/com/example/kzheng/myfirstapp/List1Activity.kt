package com.example.kzheng.myfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class List1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list1)

        val listItems = arrayOf("This", "is", "a", "list", "view")
        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)

        val listView = findViewById(R.id.listView) as ListView
        listView.adapter = listAdapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val toast = Toast.makeText(this, listItems[i], Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}
