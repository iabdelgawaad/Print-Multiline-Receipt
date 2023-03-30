# Draw Receipt with Multiline text in same line

By adding this code below: 

- Add to your dependancies 

       implementation 'com.github.danielfelgar:draw-receipt:0.1.3'


- write any text to print with multiline

       val DEFAULT_TEXT_SIZE = 80f //set suitable size for your printer
       val MAXIMUM_CHARACTER_LINE = 26 //set suitable max based on your printer width
    
        val receipt = splitItemText(
            "Trying to print Multiline to receipt POS Trying to print Multiline to receipt " +
                    "POS Trying to print Multiline to receipt POS",
            MAXIMUM_CHARACTER_LINE
        )
        
        
- Here you can send receipt to your POS printer like Sunmi devices, Newland or any external printers like epson...etc

        <yourPrinter>.print(bitmap)
        
        //OR show it inside imageview 
        
        val view = findViewById<ImageView>(R.id.receipt_image)
        view.setImageBitmap(receipt)


![IMG_20230330_123737](https://user-images.githubusercontent.com/4660684/228796254-353fdbb4-8b6f-44e8-92a4-368e0cbefad4.jpg)
