package com.personal.techugoassignment.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.widget.Toast
import com.personal.techugoassignment.application.TechugoApplication


/**
 * Utility class
 */
class Utility {

    companion object {

        fun showToast(message: String) {
            Toast.makeText(TechugoApplication.instance, message, Toast.LENGTH_SHORT).show()
        }

        fun getActivity(context: Context?): Activity? {
            var context = context
            while (context is ContextWrapper) {
                if (context is Activity) {
                    return context
                }
                context = context.baseContext
            }
            return null
        }

    }
}