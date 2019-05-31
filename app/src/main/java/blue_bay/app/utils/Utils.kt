package blue_bay.app.utils

import android.os.Handler


class Utils {
    companion object {
        fun postToastDelayed(method : () -> Unit){
            Handler().postDelayed({method()}, 500)
        }
    }
}