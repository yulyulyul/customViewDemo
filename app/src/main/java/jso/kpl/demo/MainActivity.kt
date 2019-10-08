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


class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var viewList : ArrayList<View> = ArrayList<View>()
        val view1 = LayoutInflater.from(this).inflate(R.layout.baseline,   null, false)
        val view2 = LayoutInflater.from(this).inflate(R.layout.rightline,  null, false)
        val view3 = LayoutInflater.from(this).inflate(R.layout.baseline,   null, false)
        val view4 = LayoutInflater.from(this).inflate(R.layout.leftline,   null, false)

        viewList.add(view1)
        viewList.add(view2)
        viewList.add(view3)
        viewList.add(view4)

        viewList.get(2).leftb.text = "7"
        viewList.get(2).centerb.text = "6"
        viewList.get(2).rightb.text = "5"
        viewList.get(2).customLine.lineType = 1

        for (v in viewList)
        {
            rootGrid.addView(v)
        }
    }
}
