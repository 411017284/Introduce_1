package tw.pu.edu.csim.ruby.introduce

import android.graphics.Color
import android.graphics.Rect
import android.graphics.Typeface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.GestureDetector.OnGestureListener
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

@GlideModule
public final class MyAppGlideModule : AppGlideModule()



class MainActivity : AppCompatActivity(), OnGestureListener, View.OnTouchListener {

    lateinit var txv: TextView
    lateinit var gDetector: GestureDetector
    var size: Float = 24f
    var count:Int = 0
    lateinit var img1: ImageView
    lateinit var img2: ImageView
    lateinit var img3: ImageView
    lateinit var mper: MediaPlayer
    private lateinit var button: Button
    private lateinit var imageView: ImageView


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
        img1 = findViewById(R.id.img1)
        img2 = findViewById(R.id.img2)
        img1.setOnTouchListener(this)
        img2.setOnTouchListener(this)

        img3 = findViewById(R.id.img3)
        img3.visibility = View.GONE
        Glide.with(this)
            .load(R.drawable.me)
            .into(img3)

        mper = MediaPlayer()
        mper = MediaPlayer.create(this, R.raw.lucky)
        mper.start()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gDetector.onTouchEvent(event)
        return true
    }
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if (v==img1){
            txv.text = "這是我爸爸"
        }
        else{
            txv.text = "這是我媽媽"
        }
        if (event?.action == MotionEvent.ACTION_MOVE){
            v?.x = event.rawX- v!!.width/2
            v?.y = event.rawY- v!!.height/2
        }
        var r1: Rect = Rect(img1.x.toInt(), img1.y.toInt(),
            img1.x.toInt() + img1.width, img1.y.toInt() + img1.height)
        var r2: Rect = Rect(img2.x.toInt(), img2.y.toInt(),
            img2.x.toInt() + img2.width, img2.y.toInt() + img2.height)

        if(r1.intersect(r2)) {
            txv.text = "這是我!嘻嘻哈哈哈哈"
            img3.visibility = View.VISIBLE
        }
        else{
            img3.visibility = View.GONE
        }

        return true
    }


    fun name(v: View) {
        val txv: TextView = findViewById(R.id.txv)
        if (size > 5)
            size--
        findViewById<TextView>(R.id.txv).setTextSize(size)
        var myname: String
        myname = "哈囉 大家好 我是陳柔涵\n" +
                "我的英文名字是Ruby\n" + "大家通常都叫我露比、嚕比或鹿比"
        txv.setText(myname)
    }

    fun years(v: View) {
        val txv: TextView = findViewById(R.id.txv)
        if (size < 100)
            size++
        findViewById<TextView>(R.id.txv).setTextSize(size)
        var myname: String
        myname = "2003年6月1日"
        txv.setText(myname)
    }

    fun school(v: View) {
        val txv: TextView = findViewById(R.id.txv)
        if (size < 100)
            size++
        findViewById<TextView>(R.id.txv).setTextSize(size)
        var myname: String
        myname = "台南市和順國小\n" + "台南市私立港明國中\n" + "台南市私立港明高中"
        txv.setText(myname)
    }

    fun habit(v: View) {
        val txv: TextView = findViewById(R.id.txv)
        if (size > 5)
            size--
        findViewById<TextView>(R.id.txv).setTextSize(size)
        var myname: String
        myname = "平常喜歡睡覺、聽音樂、唱歌和出去玩!"
        txv.setText(myname)
    }

    fun food(v: View) {
        val txv: TextView = findViewById(R.id.txv)
        if (size > 5)
            size--
        findViewById<TextView>(R.id.txv).setTextSize(size)
        var myname: String
        myname = "我最喜歡的食物是冰淇淋!"
        txv.setText(myname)
    }

    fun myself(v: View) {
        val txv: TextView = findViewById(R.id.txv)
        if (size > 5)
            size--
        findViewById<TextView>(R.id.txv).setTextSize(size)
        var myname: String
        myname = "外向、活潑、負責\n" + "我認為求學過程\n不僅可以學到課本的知識\n也可以在生活中尋找自己的方向"
        txv.setText(myname)
    }

    fun talk(v: View) {
        val txv: TextView = findViewById(R.id.txv)
        if (size < 100)
            size++
        findViewById<TextView>(R.id.txv).setTextSize(size)
        var myname: String
        myname = "在努力和擺爛之間，選擇努力擺爛"
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