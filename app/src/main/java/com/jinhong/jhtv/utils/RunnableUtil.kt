package com.jinhong.jhtv.utils

import android.os.SystemClock
import android.view.View

/**
 * @author :  Jim
 * @date :  2019-09-03
 * @description :
 *
 */
class RunnableUtil {
    companion object {
        @JvmStatic  fun start(view: View) {
            kotlin.run {
                SystemClock.sleep(2000)
                view.performClick()

            }
        }
    }


}