package co.tiagoaguiar.ganheinamega

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*
import kotlin.math.E

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtResult: TextView = findViewById(R.id.txt_result)
        val btn4Digit: Button = findViewById(R.id.btn4digit)
        val btn6Digit: Button = findViewById(R.id.btn6digit)
        val btn8Digit: Button = findViewById(R.id.btn8digit)
        val btnAlphaNum: Button = findViewById(R.id.btnAlpha)

        btn4Digit.setOnClickListener {

            val digit = 4
            passwordGenerator(digit, txtResult)
        }
        btn6Digit.setOnClickListener {

            val digit = 6
            passwordGenerator(digit, txtResult)
        }
        btn8Digit.setOnClickListener {

            val digit = 8
            passwordGenerator(digit, txtResult)
        }
        btnAlphaNum.setOnClickListener {
            val digit = 6
            txtResult.text = getRandomString(digit)

        }
    }

    private fun passwordGenerator(digit: Int, txtResult: TextView) {

        val numbers = mutableListOf<Int>()
        val random = Random()

        while(true) {
            val number = random.nextInt(10)
            numbers.add(number)

            if (numbers.size == digit) {
                break
            }
        }

        txtResult.text = numbers.joinToString(" ")

    }
    private fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString(" ")
    }

}