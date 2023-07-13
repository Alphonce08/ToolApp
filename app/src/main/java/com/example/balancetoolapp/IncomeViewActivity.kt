package com.example.balancetoolapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Incomeview : AppCompatActivity() {

    //initilaise your listview
    lateinit var car_list: ListView

    //array list
    lateinit var income: ArrayList<Expenses>

    //declare adapter
    lateinit var adapter: CustomAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_income_view)


        car_list = findViewById(R.id.Mycarlist)


        income = ArrayList()

        adapter = CustomAdapter(this, income)

        var ref = FirebaseDatabase.getInstance().getReference().child("expense")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                income.clear()

                //loop to insert and display
                for (snap in snapshot.children){
                    var usercar = snap.getValue(Expenses::class.java)
                    income.add(usercar!!)
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

                Toast.makeText(this@Incomeview, "Database Inaccessible", Toast.LENGTH_SHORT).show()
            }
        })

        car_list.adapter = adapter














    }
}
