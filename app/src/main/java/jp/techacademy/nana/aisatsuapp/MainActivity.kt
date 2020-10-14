package jp.techacademy.nana.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.text.Typography.times

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button) {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            { view, hour, minute -> //アロー：関数を宣言しなくても式としてすぐに渡すことができる
                // hourを判定
                var aisatsu = when (hour) { //変数の中に処理を書くことが可能
                    in 2..9 -> "おはよう"
                    in 10..17 -> "こんにちは"
                    else ->  "こんばんは" //whenを使用するときは必ずelseつき

                }
                    textView.text="$aisatsu" //id=TextViewに代入
                    Log.d("UI_PARTS", "$hour:$minute")  //値を渡してログに時刻を表示
            },
            13, 0, true)
        timePickerDialog.show()

    }
}