package com.example.multilinereceipt

import android.text.TextUtils

fun String.splitLongTextToMultipleLinesBasedOnLineCharLimit(
    maximumLineLength: Int
): ArrayList<String> = run {
    val tokens: ArrayList<String> = ArrayList()
    val LINE_LIMIT_FOR_RECEIPT_NO_SPACE = 25
    if (this.contains(" ")) {
        try {
            if (!TextUtils.isEmpty(this)) {
                var result: String
                var remainingText: String = this
                var start = 0
                while (start < this.length) {
                    if (remainingText.length > maximumLineLength) {
                        if (remainingText.lastIndexOf(" ") == 0) {
                            return splitTextNotContainSpaces(
                                remainingText,
                                LINE_LIMIT_FOR_RECEIPT_NO_SPACE,
                                tokens
                            )
                        }
                        result = remainingText.substring(0, remainingText.lastIndexOf(" "))
                        while (result.length > maximumLineLength) {
                            result = result.substring(0, result.lastIndexOf(" "))
                        }
                        remainingText = remainingText.substring(result.length)
                        start += result.length
                        tokens.add(result)
                    } else {
                        tokens.add(remainingText)
                        start += this.length
                    }
                }
            }
        } catch (out: OutOfMemoryError) {
            print(out.message)
        } catch (e: Exception) {
            print(e.message)
        }
        return tokens
    } else {
        splitTextNotContainSpaces(this, LINE_LIMIT_FOR_RECEIPT_NO_SPACE, tokens)
    }
}

private fun splitTextNotContainSpaces(
    text: String,
    maximumLineLength: Int,
    tokens: ArrayList<String>
): ArrayList<String> {
    try {
        if (!TextUtils.isEmpty(text)) {
            var result: String
            var remainingText: String = text
            var start = 0
            while (start < text.length) {
                if (remainingText.length > maximumLineLength) {
                    result = remainingText.substring(0, maximumLineLength)
                    while (result.length > maximumLineLength) {
                        result = result.substring(0, maximumLineLength)
                    }
                    remainingText = remainingText.substring(result.length)
                    start += result.length
                    tokens.add(result)
                } else {
                    tokens.add(remainingText)
                    start += text.length
                }
            }
        }
    } catch (out: OutOfMemoryError) {
        print(out.message)
    } catch (e: Exception) {
        print(e.message)
    }
    return tokens
}
