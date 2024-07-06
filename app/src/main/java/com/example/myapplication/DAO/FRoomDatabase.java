package com.example.myapplication.DAO;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myapplication.Entities.Booking;
import com.example.myapplication.Entities.Category;
import com.example.myapplication.Entities.Customer;
import com.example.myapplication.Entities.Role;
import com.example.myapplication.Entities.Room;
import com.example.myapplication.Entities.User;

@Database(entities = {User.class, Role.class,Customer.class,Booking.class, Category.class, Room.class}, version = 2)
public abstract class FRoomDatabase extends RoomDatabase {
    public abstract UserDAO userDao();
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Migration strategy here
            // Add the 'role' column if it doesn't exist
            database.execSQL("ALTER TABLE User ADD COLUMN role TEXT");

            // Create the new table with the updated schema
            database.execSQL("CREATE TABLE User_new (uid INTEGER NOT NULL PRIMARY KEY, username TEXT, email TEXT, password TEXT, dob TEXT, address TEXT, role TEXT)");

            // Copy the data from the old table to the new table
            database.execSQL("INSERT INTO User_new (uid, username, email, password, dob, address, role) SELECT uid, username, email, password, dob, address, role FROM User");

            // Drop the old table
            database.execSQL("DROP TABLE User");

            // Rename the new table to the old table name
            database.execSQL("ALTER TABLE User_new RENAME TO User");
        }
    };
    public abstract RoleDAO roleDao();
    public abstract CustomerDAO customerDao();
    public abstract BookingDAO bookingDao();
    public abstract RoomDAO roomDao();
}
