package com.example.coba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_PHONE = "phone";

    private static final String DATABASE_NAME = "userDatabase.db";
    private static final int DATABASE_VERSION = 2; // Update versi database

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT UNIQUE, " +
                COLUMN_PASSWORD + " TEXT, " + // Kolom password
                COLUMN_EMAIL + " TEXT, " +    // Kolom email
                COLUMN_ADDRESS + " TEXT, " +   // Kolom alamat
                COLUMN_PHONE + " TEXT)";       // Kolom nomor telepon
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Menambahkan pengguna baru
    public boolean addUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);

        long result = db.insert(TABLE_USERS, null, values); // Menyimpan data
        db.close();
        return result != -1; // Mengembalikan true jika berhasil, false jika gagal
    }

    // Memverifikasi pengguna
    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID};
        String selection = COLUMN_USERNAME + " = ? AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count > 0; // Kembali true jika pengguna ditemukan
    }

    // Cek apakah username sudah ada
    public boolean isUsernameExists(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID};
        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count > 0; // Kembali true jika username sudah ada
    }

    // Menyimpan atau memperbarui profil pengguna
    public boolean saveProfile(String username, String email, String address, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_PHONE, phone);

        // Update data berdasarkan username
        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        int count = db.update(TABLE_USERS, values, selection, selectionArgs);
        db.close();
        return count > 0; // Kembali true jika ada yang diupdate
    }
}