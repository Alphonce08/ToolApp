package com.example.balancetoolapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.database.FirebaseDatabase

class CustomAdapter(var context: Context, var data:ArrayList<Expenses>):BaseAdapter() {
    private class ViewHolder(row:View?){

        var txtamount:TextView
        var txtdescription:TextView
        //var txtdate:Date
        var btn_update:Button
        var btn_delete:Button


        init {

            this.txtamount = row?.findViewById(R.id.mTxtamount) as TextView
            this.txtdescription = row?.findViewById(R.id.mTxtdescription) as TextView
            //this.txtdate = row?.findViewById(R.id.mTxtDate) as Date
            this.btn_update = row?.findViewById(R.id.btnUpdate) as Button
            this.btn_delete = row?.findViewById(R.id.btnDelete) as Button

        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.expense_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:Expenses = getItem(position) as Expenses
        viewHolder.txtamount.text = item.amount  //coming from your model
        viewHolder.txtdescription.text = item.description
        //viewHolder.txtdate.toLocaleDateString() = item.date

//        viewHolder.btn_update.setOnClickListener {
//
//            //grab data and pass as PutEXTRA
//            var intent = Intent(context, UpdateCar_Record::class.java)
//
//            intent.putExtra("car_make", item.carmake)
//            intent.putExtra("car_model", item.carmodel)
//            intent.putExtra("car_price", item.carprice)
//            intent.putExtra("car_id", item.car_id)
//
//            context.startActivity(intent)
//
//
//            // var ref = FirebaseDatabase.getInstance().getReference().child("cars/"+item.car_id)
//
//        }

        viewHolder.btn_delete.setOnClickListener {

            var ref = FirebaseDatabase.getInstance().getReference().child("cars/"+item.rec_id)

            //toast a message to delete item
            ref.removeValue().addOnCompleteListener {
                if (it.isSuccessful) {

                    Toast.makeText(context, "Item has been Deleted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Failed to delete item", Toast.LENGTH_SHORT).show()
                }

            }

        }


        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}
