package com.example.alerts

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.Arrays

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //basic alert Dialog
        val basic: Button
        basic = findViewById(R.id.btnBasicAlert)
        basic.setOnClickListener {
            //setting up alertDialog box
            val basicAlert = AlertDialog.Builder(this)
            //setting title
            basicAlert.setTitle("Title")
            //setting message
            basicAlert.setMessage("This is Basic Alert Dialog")
            basicAlert.setPositiveButton("Positive") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Positive Button", Toast.LENGTH_SHORT)
                    .show()
            }
            basicAlert.setNegativeButton("Negative") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Negative Button", Toast.LENGTH_SHORT)
                    .show()
            }
            basicAlert.setNeutralButton("Neutral") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Neutral Button", Toast.LENGTH_SHORT)
                    .show()
            }
            //creating alertDialog
            val alertDialog = basicAlert.create()
            alertDialog.show()
        }


        //customized alert dialog
        val custom: Button
        custom = findViewById(R.id.btnAlertWithIconsAndCustomize)
        custom.setOnClickListener {
            //setting up alertDialog box
            val customAlert = AlertDialog.Builder(this)
            //setting title
            customAlert.setTitle("Title")
            //setting message
            customAlert.setMessage("This is Custom Alert Dialog with Icons")
            //setting icon
            customAlert.setIcon(resources.getDrawable(R.drawable.bulb, theme))

            customAlert.setPositiveButtonIcon(resources.getDrawable(R.drawable.check, theme))
            customAlert.setNegativeButtonIcon(resources.getDrawable(R.drawable.remove, theme))
            customAlert.setNeutralButtonIcon(resources.getDrawable(R.drawable.info, theme))
            //creating alertDialog
            val alertDialog = customAlert.create()
            alertDialog.show()
        }

        //alert dialog with items
        val items = arrayOf("One", "Two", "Three")
        val itemButton: Button
        itemButton = findViewById(R.id.btnAlertWithItems)
        itemButton.setOnClickListener {
            //setting up alertDialog box
            val itemAlert = AlertDialog.Builder(this)
            //setting title
            itemAlert.setTitle("List of Items")
            itemAlert.setItems(items) { dialog, which ->
                Toast.makeText(applicationContext, items[which] + " is clicked", Toast.LENGTH_SHORT).show()
            };
            val alertDialog = itemAlert.create()
            alertDialog.show()
        }

        //alert dialog with radio button
        val radio : Button
        radio = findViewById(R.id.btnAlertWithRadio)
        radio.setOnClickListener{
            //setting up alertDialog box
            val radioAlert = AlertDialog.Builder(this)
            //setting title
            radioAlert.setTitle("Radio Button")
            radioAlert.setSingleChoiceItems(items,0) { dialog, which ->
                Toast.makeText(applicationContext, items[which] + " is clicked", Toast.LENGTH_SHORT).show()
            }
            radioAlert.setPositiveButton("Ok") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Positive Button", Toast.LENGTH_SHORT)
                    .show()
            }
            radioAlert.setNegativeButton("Cancel") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Negative Button", Toast.LENGTH_SHORT)
                    .show()
            }
            val alertDialog = radioAlert.create()
            alertDialog.show()
        }

        //alert dialog with multiple choice
        val multiChoice : Button
        val selectedList = ArrayList<Int>()
        multiChoice = findViewById(R.id.btnAlertWithMultiChoiceList)
        multiChoice.setOnClickListener{
            //setting up alertDialog box
            val multiAlert = AlertDialog.Builder(this)
            //setting title
           multiAlert.setTitle("Multi Choice List")
            multiAlert.setMultiChoiceItems(items,null){ dialog, which , isChecked->
                if (isChecked) {
                    selectedList.add(which)
                } else if (selectedList.contains(which)) {
                    selectedList.remove(Integer.valueOf(which))
                }
            }
            multiAlert.setPositiveButton("Ok") { dialogInterface, i ->
                val selectedStrings = ArrayList<String>()

                for (i in selectedList.indices) {
                    selectedStrings.add(items[selectedList[i]])
                }
                Toast.makeText(applicationContext, "Items selected are: $selectedStrings", Toast.LENGTH_SHORT).show()
            }
            multiAlert.setNegativeButton("Cancel") { dialogInterface, which ->
                Toast.makeText(applicationContext, "No options Selected", Toast.LENGTH_SHORT).show()
            }
            //creating dialog box
            val alertDialog = multiAlert.create()
            alertDialog.show()
        }

        //with style
        val style : Button
        style = findViewById(R.id.btnAlertWithStyle)
        style.setOnClickListener{
            val styleAlert = AlertDialog.Builder(ContextThemeWrapper(this, android.R.style.Holo_SegmentedButton))
            styleAlert.setTitle("Style")
            styleAlert.setMessage("This is a Alert Dialog with style")
            styleAlert.setPositiveButton("Positive") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Positive Button", Toast.LENGTH_SHORT)
                    .show()
            }
            styleAlert.setNegativeButton("Negative") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Negative Button", Toast.LENGTH_SHORT)
                    .show()
            }
            styleAlert.setNeutralButton("Neutral") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Neutral Button", Toast.LENGTH_SHORT)
                    .show()
            }
            //creating alertDialog
            val alertDialog = styleAlert.create()
            alertDialog.show()
        }

        //with custom style
        val customStyle : Button
        customStyle= findViewById(R.id.btnAlertWithCustomStyle)
        customStyle.setOnClickListener{
            val customAlert = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogCustom))
            customAlert.setTitle("Style")
            customAlert.setMessage("This is a Alert Dialog with custom style")
            customAlert.setPositiveButton("Positive") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Positive Button", Toast.LENGTH_SHORT)
                    .show()
            }
            customAlert.setNegativeButton("Negative") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Negative Button", Toast.LENGTH_SHORT)
                    .show()
            }
            customAlert.setNeutralButton("Neutral") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Neutral Button", Toast.LENGTH_SHORT)
                    .show()
            }
            //creating alertDialog
            val alertDialog = customAlert.create()
            alertDialog.show()
        }

        //with edit text
        val text : Button
        text = findViewById(R.id.btnAlertWithEditText)
        text.setOnClickListener{
            val textAlert = AlertDialog.Builder(this)
            textAlert.setTitle("Style")
            textAlert.setMessage("Enter text")
            val name = EditText(this)
            textAlert.setView(name)
            textAlert.setPositiveButton("Positive") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Hi "+name.text.toString(), Toast.LENGTH_SHORT)
                    .show()
            }
            textAlert.setNegativeButton("Negative") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Negative Button", Toast.LENGTH_SHORT)
                    .show()
            }
            textAlert.setNeutralButton("Neutral") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Neutral Button", Toast.LENGTH_SHORT)
                    .show()
            }
            //creating alertDialog
            val alertDialog = textAlert.create()
            alertDialog.show()
        }

        //with layout
        val layout : Button
        layout= findViewById(R.id.btnAlertWithLayout)
        layout.setOnClickListener{
            val layAlert = AlertDialog.Builder(this)
            layAlert.setTitle("With Layout")
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.alert_layout,null)
            layAlert.setView(dialogLayout)
            layAlert.setPositiveButton("Positive") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Positive Button ", Toast.LENGTH_SHORT)
                    .show()
            }
            layAlert.setNegativeButton("Negative") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Negative Button", Toast.LENGTH_SHORT)
                    .show()
            }
            layAlert.setNeutralButton("Neutral") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Clicked Neutral Button", Toast.LENGTH_SHORT)
                    .show()
            }
            //creating alertDialog
            val alertDialog = layAlert.create()
            alertDialog.show()
        }
    }
}