package com.example.m5ind14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.m5ind14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var  mBinding: ActivityMainBinding
    private var total: Int = 0


    init {

        this.total = 0

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        var monto= mBinding.valorIngresado.text.toString()


        mBinding.enviar.setOnClickListener {

            if (mBinding.ingresar.isChecked){


                if (ingresar(monto)==true) {
                    Toast.makeText(this, "Ingresado correctamente", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Ingresado incorrectamente", Toast.LENGTH_SHORT).show()
                }
            }else if (mBinding.retirar.isChecked){

                if (retirar(monto)==true) {
                    Toast.makeText(this, "Retiro exitoso", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Retiro incorrectamente", Toast.LENGTH_SHORT).show()
                }
            }else if (mBinding.saldo.isChecked){

                mBinding.monto.setText(total.toString())
            }else if (mBinding.salir.isChecked){
                salir()
            }else{

                Toast.makeText(this, "Debe selecionar una opcion", Toast.LENGTH_SHORT).show()
            }

        }
    }


    fun ingresar(monto:String):Boolean{
        val amount = monto.toIntOrNull()
        if (amount != null && amount > 0) {

            total += amount
            return true
        }else{return false}

    }
    fun retirar(monto:String):Boolean{
        val amount = monto.toIntOrNull()
        if (amount != null && amount > 0) {

            total -= amount
            return true
        }else{return false}
    }
    fun verSaldo():Int{
        return total
    }
    fun salir(){
        finish()
    }



}