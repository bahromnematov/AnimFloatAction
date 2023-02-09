package uz.gita.animfloataction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import uz.gita.animfloataction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var isOpen = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val fabOpen = AnimationUtils.loadAnimation(this, R.anim.tab_float_anim)
        val fabClose = AnimationUtils.loadAnimation(this, R.anim.tab_float_anim_close)
        val fabRClock=AnimationUtils.loadAnimation(this,R.anim.rotate_forward)
        val fabAntiRClock=AnimationUtils.loadAnimation(this,R.anim.rotate_forward_back)

        binding.Add.setOnClickListener {

            if(isOpen){
                binding.folder.startAnimation(fabClose)
                binding.camera.startAnimation(fabClose)
                binding.Add.startAnimation(fabRClock)
                isOpen=false
            }
            else{
                binding.folder.startAnimation(fabOpen)
                binding.camera.startAnimation(fabOpen)
                binding.Add.startAnimation(fabAntiRClock)

                binding.folder.isClickable
                binding.camera.isClickable
                isOpen=true

            }
            binding.folder.setOnClickListener {
                Toast.makeText(this,"folder click",Toast.LENGTH_LONG).show()
            }
            binding.camera.setOnClickListener {
                Toast.makeText(this,"click click",Toast.LENGTH_LONG).show()
            }
        }


    }


}