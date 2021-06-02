package ru.mirea.nikolaev.room.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM employee")
    fun getALL(): List<Employee>
    @Query("SELECT * FROM employee WHERE id = :id")
    fun getById(id:Long): Employee
    @Insert
    fun insert(employee: Employee): Unit
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun update(employee: Employee): Unit
    @Insert
    fun delete(employee: Employee): Unit
}