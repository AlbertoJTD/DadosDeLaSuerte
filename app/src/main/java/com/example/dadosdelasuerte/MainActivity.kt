package com.example.dadosdelasuerte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declaracion de variables
        val BJugar: Button = findViewById(R.id.btn1)
        val BSwitch: Switch = findViewById(R.id.sw1)

        val ResulD1: TextView = findViewById(R.id.tv1)
        val ResulD2: TextView = findViewById(R.id.tv2)
        val ResulD3: TextView = findViewById(R.id.tv3)

        val MsjContador: TextView = findViewById(R.id.tv4)
        val MsjResultado: TextView = findViewById(R.id.tv5)

        var valorSwitch=false
        var intentos=5
        val lados=6
        var valorIgual=false
        var reiniciar=false

        //Variables que almacenan el valor devuelto por las funciones
        var resul1=0
        var resul2=0
        var resul3=0


        //Esta funcion se activa cada vez que se da clic sobre el boton
        BJugar.setOnClickListener{

            //Si el switch esta activo se ejecuta el codigo
            if(valorSwitch == true){

                //Reinicar el juego
                if(reiniciar == true){
                    MsjResultado.text=""
                    reiniciar = false
                    intentos = 5

                    resul1=0
                    resul2=0
                    resul3=0

                    ResulD1.text="- -"
                    ResulD2.text="- -"
                    ResulD3.text="- -"

                    Toast.makeText(this,"Reiniciando juego ", Toast.LENGTH_SHORT).show()
                }else{

                    MsjContador.text="Tienes "+intentos+ " intento(s)"

                    //Obtener los valores de los numeros aleatorios para los dados
                    resul1=Dado1(lados)
                    resul2=Dado2(lados)
                    resul3=Dado3(lados)

                    //Mostrar los valores obtenidos
                    ResulD1.text=resul1.toString()
                    ResulD2.text=resul2.toString()
                    ResulD3.text=resul3.toString()

                    //Condicional para saber si los 3 numeros son iguales
                    if(resul1 == resul2 && resul1 == resul3){
                        valorIgual=true
                    }

                    /*
                    *Reiniciar el juego cuando se haya obtenido 3 numeros iguales
                    * o cuando el numero de intentos se haya terminado
                    */
                    if(valorIgual == true || intentos == 0){

                        if(valorIgual == true){
                            valorIgual=false
                            MsjResultado.text="EUREKA 🎉\n¡Ganaste!"
                        }else{
                            MsjResultado.text="Lo siento 😢\n¡Has perdido!"
                        }

                        reiniciar = true
                    }

                    //Restar intentos
                    intentos= intentos-1
                }

            }else{
                Toast.makeText(this,"Debes ser mayor de edad", Toast.LENGTH_LONG).show()
            }

        }


        //Saber si el switch esta encendido o apagado
        BSwitch.setOnCheckedChangeListener(){_,isChecked->
            if(isChecked){
                valorSwitch=BSwitch.isChecked()
            }else{
                valorSwitch=BSwitch.isChecked()
            }
        }

    }

    //Funcion para numeros aleatorios del dado 1
    fun Dado1(lados: Int):Int{
        return (1..lados).random()
    }

    //Funcion para numeros aleatorios del dado 2
    fun Dado2(lados: Int):Int{
        return (1..lados).random()
    }

    //Funcion para numeros aleatorios del dado 3
    fun Dado3(lados: Int):Int{
        return (1..lados).random()
    }
}