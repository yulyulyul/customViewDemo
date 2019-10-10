package jso.kpl.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.baseline.view.*
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.annotation.Nullable
import androidx.core.view.marginTop
import kotlinx.android.synthetic.main.custom_node.view.*


class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var viewList : ArrayList<View> = ArrayList<View>()
        val view1 = LayoutInflater.from(this).inflate(R.layout.baseline,   null, false)
        //val view2 = LayoutInflater.from(this).inflate(R.layout.rightline,  null, false)
        val view3 = LayoutInflater.from(this).inflate(R.layout.baseline,   null, false)
        //val view4 = LayoutInflater.from(this).inflate(R.layout.leftline,   null, false)
        val view5 = LayoutInflater.from(this).inflate(R.layout.baseline,   null, false)

        viewList.add(view1)
        //viewList.add(view2)
        viewList.add(view3)
        //viewList.add(view4)
        viewList.add(view5)

        viewList.get(0).customLineF.visibility = View.INVISIBLE

        viewList.get(1).customLine.lineType = 1
        viewList.get(2).customLineF.lineType = 2

        viewList.get(2).lineview1.visibility = View.INVISIBLE
        viewList.get(2).lineview2.visibility = View.INVISIBLE

        viewList.get(2).rightb.visibility = View.INVISIBLE
        viewList.get(2).centerb.visibility = View.INVISIBLE
        viewList.get(2).customLine.visibility = View.INVISIBLE

        viewList.get(1).leftb.locationName = "Paris"
        viewList.get(1).centerb.locationName = "Barcelona"
        viewList.get(1).rightb.locationName = "Roma"

        viewList.get(2).leftb.locationName = "China"

//        viewList.get(1).customLine.lineType = 1

        for (v in viewList)
        {
            rootGrid.addView(v)
        }
    }
}
