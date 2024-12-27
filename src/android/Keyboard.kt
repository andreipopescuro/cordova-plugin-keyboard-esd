package com.esd.keyboard

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.view.View
import android.util.Log
import org.apache.cordova.CordovaPlugin
import org.apache.cordova.CallbackContext
import org.json.JSONArray

class Keyboard : CordovaPlugin() {
    override fun execute(action: String, args: JSONArray, callbackContext: CallbackContext): Boolean {
        Log.d("Keyboard", "Executing action: $action")
        val imm = cordova.activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = cordova.activity.currentFocus ?: cordova.activity.window.decorView.rootView

        cordova.activity.runOnUiThread {
            when (action) {
                "show" -> {
                    val result = imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
                    if (result) {
                        callbackContext.success()
                    } else {
                        callbackContext.error("Failed to show keyboard")
                    }
                }
                "hide" -> {
                    val result = imm.hideSoftInputFromWindow(view.windowToken, 0)
                    if (result) {
                        callbackContext.success()
                    } else {
                        callbackContext.error("Failed to hide keyboard")
                    }
                }
                else -> {
                    callbackContext.error("$action is not a valid action")
                }
            }
        }
        return true
    }
}
