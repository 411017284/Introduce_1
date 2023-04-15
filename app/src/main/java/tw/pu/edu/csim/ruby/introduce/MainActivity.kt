package tw.pu.edu.csim.ruby.introduce

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.GestureDetector.OnGestureListener
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity(), OnGestureListener {

    lateinit var txv: TextView
    lateinit var gDetector: GestureDetector
    var size: Float = 24f
    var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txv = findViewById(R.id.txv)
        txv.setTextColor(Color.parseColor("#FFC1E0"))
        txv.setBackgroundColor(Color.GRAY)
        txv.setTypeface(
            Typeface.createFromAsset(
                assets,
                "font/irohamaru-Medium.ttf"
            )
        )
        txv.getBackground().setAlpha(150)  //0~255透明度值
        gDetector = GestureDetector(this, this)

    }

    fun name(v: View) {
        val txv: TextView = findViewById(R.id.txv)
        if (size > 20)
            size--
        findViewById<TextView>(R.id.txv).setTextSize(size)
        var myname: String
        myname = "哈囉 大家好 我是陳柔涵"
        txv.setText(myname)
    }

    fun years(v: View) {
        val txv: TextView = findViewById(R.id.txv)
        if (size < 50)
            size++
        findViewById<TextView>(R.id.txv).setTextSize(size)
        var myname: String
        myname = "我的生日是2003年6月1日!目前19歲"
        txv.setText(myname)
    }

    fun habit(v: View) {
        val txv: TextView = findViewById(R.id.txv)
        if (size < 50)
            size++
        findViewById<TextView>(R.id.txv).setTextSize(size)
        var myname: String
        myname = "平常喜歡睡覺、聽音樂、唱歌和出去玩!"
        txv.setText(myname)
    }

    override fun onDown(e: MotionEvent): Boolean {
        txv.text = "按下"
        return true
    }

    override fun onShowPress(e: MotionEvent) {
        txv.text = "按下後無後續動作"
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        txv.text = "短按"
        return true
    }

    override fun onScroll(
        e1: MotionEvent,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        if (distanceY >= 0) {
            txv.text = "向上拖曳"
        } else {
            txv.text = "向下拖曳"
        }
        return true
    }


    override fun onLongPress(e: MotionEvent) {
        txv.text = "長按"
    }

    override fun onFling(
        e1: MotionEvent,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float): Boolean {
        txv.text = "快滑"
        if (e1.x < e2.x){
            txv.text = "往右快滑"
            count++
            if(count>5){count=0}
        }
        else{
            txv.text = "往左快滑"
            count--
            if(count<0){count=5}
        }
        var res:Int = getResources().getIdentifier("pu" + count.toString(),
            "drawable", getPackageName())
        findViewById<ConstraintLayout>(R.id.bg).setBackgroundResource(res)
        return true
    }
}