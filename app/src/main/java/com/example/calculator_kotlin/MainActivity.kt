package com.example.calculator_kotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var number1 = 0.0
    var number2 = 0.0
    var number3 = 0.0
    var operator = 0.toChar()
    var isCalculate = false
    var df = DecimalFormat("#.######")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screen!!.text = "0"
    }

    private fun textLengthCheck(): Boolean {
        return if (screen!!.length() == 100) {
            showToast("숫자는 100자리를 넘을 수 없습니다.")
            true
        } else {
            false
        }
    }

    private fun zeroCheck() {
        if (screen!!.text == "0") {
            screen!!.text = ""
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this.applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    fun ButtonClick(view: View) {
        try {
            when (view.id) {
                R.id.button1 -> if (!textLengthCheck()) {
                    zeroCheck()
                    screen!!.text = screen!!.text.toString() + "1"
                }
                R.id.button2 -> if (!textLengthCheck()) {
                    zeroCheck()
                    screen!!.text = screen!!.text.toString() + "2"
                }
                R.id.button3 -> if (!textLengthCheck()) {
                    zeroCheck()
                    screen!!.text = screen!!.text.toString() + "3"
                }
                R.id.button4 -> if (!textLengthCheck()) {
                    zeroCheck()
                    screen!!.text = screen!!.text.toString() + "4"
                }
                R.id.button5 -> if (!textLengthCheck()) {
                    zeroCheck()
                    screen!!.text = screen!!.text.toString() + "5"
                }
                R.id.button6 -> if (!textLengthCheck()) {
                    zeroCheck()
                    screen!!.text = screen!!.text.toString() + "6"
                }
                R.id.button7 -> if (!textLengthCheck()) {
                    zeroCheck()
                    screen!!.text = screen!!.text.toString() + "7"
                }
                R.id.button8 -> if (!textLengthCheck()) {
                    zeroCheck()
                    screen!!.text = screen!!.text.toString() + "8"
                }
                R.id.button9 -> if (!textLengthCheck()) {
                    zeroCheck()
                    screen!!.text = screen!!.text.toString() + "9"
                }
                R.id.button10 -> if (!isCalculate) {
                    number1 = screen!!.text.toString().toDouble()
                    operator = '+'
                    isCalculate = true
                    screen!!.text = "0"
                } else {
                    showToast("계산 종료 후 누르세요!")
                }
                R.id.button11 -> if (!isCalculate) {
                    number1 = screen!!.text.toString().toDouble()
                    operator = '-'
                    isCalculate = true
                    screen!!.text = "0"
                } else {
                    showToast("계산 종료 후 누르세요!")
                }
                R.id.button12 -> if (!textLengthCheck()) {
                    zeroCheck()
                    screen!!.text = screen!!.text.toString() + "0"
                }
                R.id.button13 -> if (!isCalculate) {
                    number1 = screen!!.text.toString().toDouble()
                    operator = '*'
                    isCalculate = true
                    screen!!.text = "0"
                } else {
                    showToast("계산 종료 후 누르세요!")
                }
                R.id.button14 -> if (!isCalculate) {
                    number1 = screen!!.text.toString().toDouble()
                    operator = '/'
                    isCalculate = true
                    screen!!.text = "0"
                } else {
                    showToast("계산 종료 후 누르세요!")
                }
                R.id.button15 -> if (screen!!.text.length != 0) {
                    screen!!.text = screen!!.text.subSequence(0, screen!!.text.length - 1)
                    if (screen!!.length() == 0) screen!!.text = "0"
                }
                R.id.button16 -> {
                    number2 = screen!!.text.toString().toInt().toDouble()
                    if (isCalculate) {
                        when (operator) {
                            '+' -> {
                                number3 = number1 + number2
                                screen!!.text = df.format(number3)
                            }
                            '-' -> {
                                number3 = number1 - number2
                                screen!!.text = df.format(number3)
                            }
                            '*' -> {
                                number3 = number1 * number2
                                screen!!.text = df.format(number3)
                            }
                            '/' -> if (number2 == 0.0) {
                                showToast("0으로 나눌 수 없습니다.")
                                return
                            } else {
                                number3 = number1 / number2
                                screen!!.text = df.format(number3)
                            }
                            else -> showToast("끔찍한 오류")
                        }
                        isCalculate = false
                    } else {
                        showToast("식을 입력 후 누르세요!")
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("ButtonClick", e.toString())
        }
    }
}