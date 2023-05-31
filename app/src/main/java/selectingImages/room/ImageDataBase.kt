package selectingImages.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import selectingImages.model.ImageModel

@Database(entities = [ImageModel::class], version = 1)
abstract class ImageDataBase :RoomDatabase() {
    abstract fun getNoteDao(): ImageDao

    companion object {
        private var INSTANCE: ImageDataBase? = null
        private val LOCK = Any()

        private fun buildDataBase(context: Context) =
            Room.databaseBuilder(context, ImageDataBase::class.java, "DB_img")
                .fallbackToDestructiveMigration().allowMainThreadQueries().build()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: buildDataBase(context).also { INSTANCE = it }
        }

    }
}