package info.madless.tipplecocktails.utils

import android.util.Log
import java.util.*

/**
 * 16/2/2018.
 */
class Logger(private val cls: Class<*>) {

    fun v(message: String) {
        v(cls, message)
    }

    fun d(message: String) {
        d(cls, message)
    }

    fun i(message: String) {
        i(cls, message)
    }

    fun w(message: String) {
        w(cls, message)
    }

    fun e(message: String) {
        e(cls, message)
    }

    companion object {
        private val TAG = "TippleCocktailsApp"
        private val FILTER_BODY_NAME = "<body>"
        private val FILTER_MSG_NAME = " >> "
        private val CHUNK_FORMAT = "CHUNK %d OF %d:  %s"
        private val CONSOLE_LINE_MAX_LENGTH = 4000
        private val LOG_ENABLED = true

        fun v(cls: Class<*>, message: String) {
            print(Log.VERBOSE, cls.simpleName + FILTER_MSG_NAME + message)
        }

        fun d(cls: Class<*>, message: String) {
            print(Log.DEBUG, cls.simpleName + FILTER_MSG_NAME + message)
        }

        fun i(cls: Class<*>, message: String) {
            print(Log.INFO, cls.simpleName + FILTER_MSG_NAME + message)
        }

        fun w(cls: Class<*>, message: String) {
            print(Log.WARN, cls.simpleName + FILTER_MSG_NAME + message)
        }

        fun e(cls: Class<*>, message: String) {
            print(Log.ERROR, cls.simpleName + FILTER_MSG_NAME + message)
        }


        private fun print(priority: Int, message: String) {
            if (LOG_ENABLED) {
                val fullMsg = FILTER_BODY_NAME + message
                if (fullMsg.length > CONSOLE_LINE_MAX_LENGTH) {
                    val chunkCount = fullMsg.length / CONSOLE_LINE_MAX_LENGTH
                    for (i in 0..chunkCount) {
                        val max = CONSOLE_LINE_MAX_LENGTH * (i + 1)
                        val textToPrint: String
                        if (max >= fullMsg.length) {
                            textToPrint = String.format(Locale.ENGLISH, CHUNK_FORMAT, i, chunkCount, fullMsg.substring(CONSOLE_LINE_MAX_LENGTH * i))
                        } else {
                            textToPrint = String.format(Locale.ENGLISH, CHUNK_FORMAT, i, chunkCount, fullMsg.substring(CONSOLE_LINE_MAX_LENGTH * i, max))
                        }
                        Log.println(priority, TAG, textToPrint)
                    }
                } else {
                    Log.println(priority, TAG, FILTER_BODY_NAME + message)
                }
            }
        }
    }
}
