package jso.kpl.demo.adapter

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.get
import androidx.core.view.size
import jso.kpl.demo.App
import jso.kpl.demo.R
import jso.kpl.demo.model.ViewTag
import jso.kpl.demo.viewmodel.Route
import kotlinx.android.synthetic.main.custom_node.view.*

class NodeAdapter
{
    private var itemList : ArrayList<Route>
    private var ctx: Context
    private var RootLinear:LinearLayout
    private val MaxColumnCnt:Int = 3
    private var CurrentColumn:Int = 0
    private var LinearParams : LinearLayout.LayoutParams

    private var tag_view : HashMap<Any, View>
    private var idx_viewTag : HashMap<Int, ViewTag>

    constructor(_ctx : Context, rootLinear : LinearLayout)
    {
        this.itemList = ArrayList<Route>()
        this.ctx = _ctx
        this.RootLinear = rootLinear

        this.tag_view = HashMap<Any, View>()
        this.idx_viewTag = HashMap<Int, ViewTag>()

        //CustomNode의 높이 값
        this.LinearParams = LinearLayout.LayoutParams(0, dpToPx(80f))
        this.LinearParams.weight = 1f

    }

    constructor(itemList: ArrayList<Route>, _ctx: Context ,rootLinear : LinearLayout)
    {
        this.itemList = itemList
        this.ctx = _ctx
        this.RootLinear = rootLinear

        this.tag_view = HashMap<Any, View>()
        this.idx_viewTag = HashMap<Int, ViewTag>()

        this.LinearParams = LinearLayout.LayoutParams(0, dpToPx(80f))
        this.LinearParams.weight = 1f
    }

    fun getItemSize() : Int
    {
        return this.itemList.size
    }

    fun putItem(_route:Route)
    {
        itemList.add(_route)
        drawView(itemList.indexOf(_route))
    }

    private fun drawView(index:Int)
    {
        // 행이 홀수든 짝수든 3으로 나눠떨어지는(나머지가 0인) index면 새로운 Linear를 RootLinear에 추가해줘야한다.
        if(index.rem(MaxColumnCnt) == 0)
        {
            var childLinear : (LinearLayout) = LayoutInflater.from(ctx).inflate(R.layout.skeleton,null, false) as LinearLayout
            childLinear.tag = View.generateViewId()
            tag_view.put(childLinear.tag, childLinear)

//            Log.d(TAG, "childLinear tag = " + childLinear.tag)
            RootLinear.addView(childLinear)
            CurrentColumn += 1
        }

        //홀수행인 경우
        if((CurrentColumn%2) == 1)
        {
            // node의 생성 및 초기 설정
            var node : View = LayoutInflater.from(ctx).inflate(R.layout.custom_node, null, false) as View
            node.tag = View.generateViewId()
            node.layoutParams = this.LinearParams
            node.tailLine.visibility = View.INVISIBLE

            //node의 지역, 비용을 설정해준다.
            node.locationText.text = itemList.get(index).location
            node.costtv.text = itemList.get(index).cost

            /*
                Tag를 통해서 내가 원하는 뷰를 추적할 수 있기 때문에 자신의 tag와 자기가 속하는 Linear의 tag를
                ViewTag라는 클래스에 담고 itemList의 index를 key로 HashMap에 저장한다.
            */
            idx_viewTag.put(index, ViewTag(node.tag, (RootLinear.get(RootLinear.size-1) as LinearLayout).tag))

            // 한줄에 들어가는 노드(3개) 중 제일 첫번째로 들어가는 노드(좌측 노드)
            if(index.rem(MaxColumnCnt) == 0)
            {
                //노드의 headline`s lineType 설정
                node.headLine.lineType = 2

                //첫번째 노드인 경우 => 첫번째 행인 경우 첫번째 노드의 headLine을 Invisible 해야한다.
                if(index == 0)
                {
                    node.headLine.visibility = View.INVISIBLE
                }
                else
                {
                    // 2번째 행부터는 LinearLayout의 가운데부터가 아닌 좌측, 우측부터 추가되어야 하기 때문에 weightSum을 설정해준다.
                    (RootLinear.get(RootLinear.size-1) as LinearLayout).weightSum = 3f
                    //이전 노드에서 invisible한 tailLine을 visible 해줘야한다.
                    visible_HeadLine_Previous_Node(index)
                }
            }
            //한줄에 들어가는 노드(3개) 중 두번째로 들어가는 노드(중간 노드)
            else if(index.rem(MaxColumnCnt) == 1)
            {
                //이전 노드에서 invisible한 tailLine을 visible 해줘야한다.
                visible_TailLine_Previous_Node(index)
            }
            //한줄에 들어가는 노드(3개) 중 세번째로 들어가는 노드(우측 노드)
            else if(index.rem(MaxColumnCnt) == 2)
            {
                node.tailLine.lineType = 0
                visible_TailLine_Previous_Node(index)
            }
            //노드를 Linear에 추가
            addNode(node)
        }
        //짝수행인 경우.
        else
        {
            /*
                2번째 행부터는 LinearLayout의 가운데부터 생성되는게 아니라 좌측, 우측부터 추가되어야 하기 때문에 weightSum을 설정해준다.
                LinearLayout.LAYOUT_DIRECTION_RTL = > RTL => Right To Left => 우측부터 좌측으로 추가된다.
             */
            (RootLinear.get(RootLinear.size-1) as LinearLayout).weightSum = 3f
            (RootLinear.get(RootLinear.size-1) as LinearLayout).layoutDirection = LinearLayout.LAYOUT_DIRECTION_RTL

            // node의 생성 및 초기 설정
            var node : View = LayoutInflater.from(ctx).inflate(R.layout.custom_node, null, false) as View
            node.tag = View.generateViewId()
            node.layoutParams = this.LinearParams
            node.headLine.visibility = View.INVISIBLE

            //node의 지역, 비용을 설정해준다.
            node.locationText.text = itemList.get(index).location
            node.costtv.text = itemList.get(index).cost

            /*
                Tag를 통해서 내가 원하는 뷰를 추적할 수 있기 때문에 자신의 tag와 자기가 속하는 Linear의 tag를
                ViewTag라는 클래스에 담고 itemList의 index를 key로 HashMap에 저장한다.
            */
            idx_viewTag.put(index, ViewTag(node.tag, (RootLinear.get(RootLinear.size-1) as LinearLayout).tag))

            // 한줄에 들어가는 노드(3개) 중 제일 첫번째로 들어가는 노드(우측 노드)
            if(index.rem(MaxColumnCnt) == 0)
            {
                //노드의 tailline`s lineType 설정
                node.tailLine.lineType = 1
                visible_TailLine_Previous_Node(index)
            }
            //한줄에 들어가는 노드(3개) 중 두번째로 들어가는 노드(중간 노드)
            else if(index.rem(MaxColumnCnt) == 1)
            {
                visible_HeadLine_Previous_Node(index)
            }
            //한줄에 들어가는 노드(3개) 중 세번째로 들어가는 노드(좌측 노드)
            else if(index.rem(MaxColumnCnt) == 2)
            {
                node.headLine.lineType = 3
                visible_HeadLine_Previous_Node(index)
            }

            //노드를 Linear에 추가
            addNode(node)
        }
    }

    //어차피 추가되는것은 RootLinear의 마지막 Child에게 추가될 것이기 때문에.
    private fun addNode(_node :View)
    {
        (RootLinear.get(RootLinear.size-1) as LinearLayout).addView(_node)
    }

    /*
       홀수행의 노드들은 새로 추가할때 이전 노드의 tailLine의 visibility를 Invisible에서 Visible로 바꿔줘야한다.

       (RootLinear.findViewWithTag<LinearLayout>(idx_viewTag.get(index-1)?.parent_view_Tag))
           => 내가 찾으려는 노드(추가하려는 노드의 이전 노드)가 속한 LinearLayout를 parent_view_tag를 통해서 찾는다.
       .findViewWithTag<View>(idx_viewTag.get(index-1)?.node_tag).tailLine.visibility
           => 찾은 LinearLayout에서 내가 찾으려는 노드(추가하련느 노드의 이전 노드)의 tailLine의 visibility를 바꿔준다.
     */
    private fun visible_TailLine_Previous_Node(index: Int)
    {
        (RootLinear.findViewWithTag<LinearLayout>(idx_viewTag.get(index-1)?.parent_view_Tag)).findViewWithTag<View>(idx_viewTag.get(index-1)?.node_tag).tailLine.visibility = View.VISIBLE
    }

    private fun visible_HeadLine_Previous_Node(index: Int)
    {
        (RootLinear.findViewWithTag<LinearLayout>(idx_viewTag.get(index-1)?.parent_view_Tag)).findViewWithTag<View>(idx_viewTag.get(index-1)?.node_tag).headLine.visibility = View.VISIBLE
    }

    companion  object {
        val TAG = "Demo.NodeAdapter"
    }

    fun dpToPx(dp: Float): Int {
        return dpToPx(dp, App.INSTANCE.resources)
    }

    private fun dpToPx(dp: Float, resources: Resources): Int {
        val px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
        return px.toInt()
    }

}
