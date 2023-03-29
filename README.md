# Draw Receipt with Multiline Text

Here is how to draw multiline receipt to fix issue of https://github.com/danielfelgar/DrawReceipt

By adding this code below: 

    val DEFAULT_TEXT_SIZE = 80f //set suitable size for your printer
    val MAXIMUM_CHARACTER_LINE = 26 //set suitable max based on your printer width

//write any text to print with multi line
        val receipt = splitItemText(
            "Trying to print Multiline to receipt POS Trying to print Multiline to receipt " +
                    "POS Trying to print Multiline to receipt POS",
            MAXIMUM_CHARACTER_LINE
        )
        
        
//Here you can send receipt to your POS printer like Sunmi devices or any external printers

        yourPrinter.print(bitmap)
        
        //OR show it inside imageview 
        
        val view = findViewById<ImageView>(R.id.receipt_image)
        view.setImageBitmap(receipt)

![Screenshot_20230329_114014](https://user-images.githubusercontent.com/4660684/228477337-0f09b630-de22-4aeb-9e3a-2dd5d674ed3c.png)

