package ipca.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

enum class Operator {
    add,
    divid,
    subtract,
    multiply
}

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Model
    var operand : Float = 0f
    var operator : Operator? = null
    var userIsInTheMiddleOfIntroduction = false

    var operatorFun : (view:View)->Unit = { view ->
        doOperation()
        val button : Button = view as Button
        operator = when (button.text) {
            "+" -> Operator.add
            "-" -> Operator.subtract
            "/" -> Operator.divid
            "*" -> Operator.multiply
            else -> null
        }
        operand = textViewDisplay.text.toString().toFloat()
    }

    fun doOperation(){
        operator?.let{ op->
            when (op){
                Operator.add -> operand += textViewDisplay.text.toString().toFloat()
                Operator.multiply -> operand *= textViewDisplay.text.toString().toFloat()
                Operator.subtract -> operand -= textViewDisplay.text.toString().toFloat()
                Operator.divid -> operand /= textViewDisplay.text.toString().toFloat()
            }
            textViewDisplay.text = operand.toString()
        }
        userIsInTheMiddleOfIntroduction = false
    }

    fun clear() {
        textViewDisplay.text = "0"
        operand = 0f
        operator = null
        userIsInTheMiddleOfIntroduction = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonPoint.setOnClickListener(this)

        buttonSum.setOnClickListener(operatorFun)
        buttonMin.setOnClickListener(operatorFun)
        buttonMul.setOnClickListener(operatorFun)
        buttonDiv.setOnClickListener(operatorFun)

        buttonEqual.setOnClickListener {
            doOperation()
        }

    }

    override fun onClick(view: View?) {
        val button : Button = view as Button
        if (userIsInTheMiddleOfIntroduction) {
            if(button.text.equals(".")){
                if(!textViewDisplay.text.contains(".")){
                    textViewDisplay.text = textViewDisplay.text.toString().plus(button.text)
                }
                return
            }
            if (textViewDisplay.text.equals("0")){
                textViewDisplay.text = button.text
            }
            else {
                textViewDisplay.text = textViewDisplay.text.toString().plus(button.text)
            }
        }else {
            textViewDisplay.text = button.text
            userIsInTheMiddleOfIntroduction = true
        }
    }


}