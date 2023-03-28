package com.example.multilinereceipt

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.text.TextUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.github.danielfelgar.drawreceiptlib.ReceiptBuilder

class MainActivity : AppCompatActivity() {
    val DEFAULT_TEXT_SIZE = 80f //set suitable size for your printer
    val MAXIMUM_CHARACTER_LINE = 26 //set suitable max based on your printer width

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //write any text to print with multi line
        val receipt = splitItemText(
            "Trying to print Multiline to receipt POS Trying to print Multiline to receipt " +
                    "POS Trying to print Multiline to receipt POS",
            MAXIMUM_CHARACTER_LINE
        )

        //Here you can send receipt to your POS printer like Sunmi devices or any external printers
        val view = findViewById<ImageView>(R.id.receipt_image)
        view.setImageBitmap(receipt)
    }

    private fun splitItemText(itemName: String?, maximumLineLength: Int): Bitmap? {
        val receipt = ReceiptBuilder(1200)
        receipt.setMargin(30, 40).setColor(Color.BLACK)
            .setTextSize(DEFAULT_TEXT_SIZE)

           if (!TextUtils.isEmpty(itemName)) {
               val linesList: List<String> =
                   itemName?.splitLongTextToMultipleLinesBasedOnLineCharLimit(
                       maximumLineLength
                   ) ?: emptyList()
               for (line in linesList) {
                   receipt.setAlign(Paint.Align.LEFT).addText(line, false)
                       .addParagraph()
               }
           }

        return receipt.build()
    }
}