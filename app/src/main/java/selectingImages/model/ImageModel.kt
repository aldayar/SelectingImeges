package selectingImages.model

import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity
    data class ImageModel(
        @PrimaryKey(autoGenerate = true)

        val itemImage:Int) {
    }