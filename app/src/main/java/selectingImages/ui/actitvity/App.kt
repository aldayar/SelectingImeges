package selectingImages.ui.actitvity

import android.app.Application
import android.content.SharedPreferences
import selectingImages.room.ImageDataBase
import selectingImages.utils.Prefs

class App : Application() {

     companion object {
         lateinit var prefs: Prefs
         lateinit var db: ImageDataBase
     }
    override fun onCreate() {
        super.onCreate()
        val preferences: SharedPreferences=this.applicationContext.getSharedPreferences("settings", MODE_PRIVATE)
        prefs = Prefs(preferences)
        db = ImageDataBase(this.applicationContext)
    }
}