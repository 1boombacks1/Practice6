package ru.mirea.nikolaev.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.mirea.nikolaev.room.db.AppDatabase
import ru.mirea.nikolaev.room.db.Employee

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AppDatabase.get(application)
        val employeeDao = db.employeeDao()

        var employee = Employee(0,"",0)
        employee.name = "Bruce Banner"
        employee.salary = 200_000_000
        employeeDao.insert(employee)
        val employees = employeeDao.getALL()
        employee = employeeDao.getById(5)
//        employee.salary = 20000
        employeeDao.update(employee)
        Log.d("Info","${employee.name} - ${employee.salary}")
    }
}