package ipca.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Model
    var result : Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            val op1 = editTextOp1.text.toString().toFloat()
            val op2 = editTextOp2.text.toString().toFloat()
            result = op1 + op2

            textViewResult.text = result.toString()
        }

    }
}