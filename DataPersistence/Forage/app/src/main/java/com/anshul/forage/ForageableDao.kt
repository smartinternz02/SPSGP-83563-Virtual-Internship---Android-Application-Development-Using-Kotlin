package com.anshul.forage
import androidx.room.*
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ForageableDao {

    @Query("SELECT * from forageable_database")
    fun getForageables(): Flow<List<Forageable>>

    @Query("SELECT * from forageable_database WHERE id = :id")
    fun getForageable(id: Long): Flow<Forageable>

    //  (use OnConflictStrategy.REPLACE)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insert(forageable: Forageable)

    @Update
    suspend fun update(forageable: Forageable)

    @Delete
    suspend fun delete(forageable: Forageable)
}
