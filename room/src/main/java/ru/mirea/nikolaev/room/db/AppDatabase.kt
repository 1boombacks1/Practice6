package ru.mirea.nikolaev.room.db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Employee::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao

    companion object{
        fun get(application: Application): AppDatabase{
            return Room.databaseBuilder(application,AppDatabase::class.java,"Database").allowMainThreadQueries().build()

//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getDatabase(context: Context): AppDatabase{
//            val tempInstance = INSTANCE
//            if(tempInstance!=null)
//                return tempInstance
//            synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                "database"
//                ).build()
//                INSTANCE =instance
//                return instance
//            }
        }
    }
}