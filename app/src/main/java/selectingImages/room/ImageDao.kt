package selectingImages.room

import androidx.room.*
import selectingImages.model.ImageModel

@Dao
interface ImageDao {

    @Query("select * from imagemodel")
    fun getAllNote(): List<ImageModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addImage(model:ImageModel)

    @Update
    fun updateNote(model: ImageModel)

    @Delete
    fun deleteNote(model:ImageModel)
}