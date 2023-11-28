package com.example.bromagindia.walkthrough

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.bromagindia.R
import com.example.bromagindia.auth.MobileNumberActivity
import com.example.bromagindia.auth.RegisterActivity
import java.util.ArrayList

class SliderActivity : AppCompatActivity() {


    private lateinit var models: ArrayList<Slider>
    var viewPager: ViewPager?=null
    var sliderDotspanel: LinearLayout? = null
    private var dotscount = 0

    var btnSliderNext: Button?=null
    var skip: TextView?=null
    var dialog: Dialog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)

        skip=findViewById(R.id.txtSkip)
        viewPager = findViewById(R.id.viewPager)
        sliderDotspanel = findViewById(R.id.sliderDots)

        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.progress_dialog,null)
        builder.setView(dialogView)
        builder.setCancelable(false)
        dialog = builder.create()


        btnSliderNext=findViewById(R.id.btnSliderNext)


        models= ArrayList()
        models.add(Slider(R.drawable.driverslide,"Driver","No need to worry about transportation when dining with us! Reserve your table and enjoy our free pick and drop service, making your experience seamless from start to finish."))
        models.add(Slider(R.drawable.pcslide,"Play Contest","Hungry for a delicious meal?  Order from us and get a chance to win surprising gifts from Bromag!  Our scratch cards are waiting for you with every order. Don't wait, order now and get lucky! "))
        models.add(Slider(R.drawable.deliveryslide,"Delivery","Say goodbye to third-party delivery services! With our own riders, we guarantee a seamless and secure delivery experience for your online orders. Trust BROMAG for reliable and professional service."))



        val adapter = SliderAdapter(this@SliderActivity,models)
        viewPager?.adapter = adapter

        dotscount = adapter.count

        val dots = arrayOfNulls<ImageView>(dotscount)
        btnSliderNext?.setOnClickListener {

            dialog?.show()
            if (viewPager?.currentItem==2)
            {
                skip?.visibility= View.GONE
            }
            if (viewPager?.currentItem==2){

                dialog?.dismiss()
                val intent= Intent(this, MobileNumberActivity ::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                dialog?.dismiss()
                viewPager?.currentItem?.plus(1)?.let { it1 -> viewPager?.setCurrentItem(it1, true) };

            }
        }
        skip?.setOnClickListener {
            dialog?.show()
            val intent= Intent(this, RegisterActivity ::class.java)
            startActivity(intent)
            finish()
            dialog?.dismiss()
        }

        for (i in 0 until dotscount) {
            dots[i] = ImageView(this)
            dots[i]!!.setImageDrawable(
                ContextCompat.getDrawable(this,
                    R.drawable.non_active_slider_bg
                ))
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            sliderDotspanel!!.addView(dots[i], params)
        }
        dots[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                this, R.drawable.active_slider_bg
            )
        )


        viewPager?.setOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int){

                if(position==2) {
                    skip?.visibility = View.INVISIBLE
                }
                else{
                    skip?.visibility = View.VISIBLE

                }

            }

            override fun onPageSelected(position: Int) {
                for (i in 0 until dotscount) {
                    dots[i]?.setImageDrawable(
                        ContextCompat.getDrawable(
                            this@SliderActivity, R.drawable.non_active_slider_bg
                        )
                    )
                }
                dots[position]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SliderActivity, R.drawable.active_slider_bg
                    )
                )
            }
        })
    }
}