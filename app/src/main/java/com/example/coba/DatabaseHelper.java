package com.example.coba;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Nama database dan versi
    private static final String DATABASE_NAME = "UserDB";
    private static final int DATABASE_VERSION = 1;

    // Nama tabel dan kolom
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Query untuk membuat tabel
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_USERNAME + " TEXT, "
                + COLUMN_EMAIL + " TEXT, "
                + COLUMN_PASSWORD + " TEXT"
                + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Hapus tabel jika ada perubahan versi
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Tambah pengguna baru
    public boolean addUser(String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, password);

        long result = db.insert(TABLE_USERS, null, values);
        db.close();

        return result != -1; // return true jika berhasil
    }

    // Update hanya kolom username dan email
    public boolean updateUser(int id, String username, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_EMAIL, email);

        int result = db.update(TABLE_USERS, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();

        return result > 0; // return true jika update berhasil
    }

    // Cek apakah pengguna ada berdasarkan username dan password
    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " +
                COLUMN_USERNAME + "=? AND " + COLUMN_PASSWORD + "=?";

        Cursor cursor = db.rawQuery(query, new String[]{username, password});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();

        return exists; // return true jika ada
    }

    @SuppressLint("Range")
    public User getUserById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        User user = null;

        try {
            cursor = db.query(TABLE_USERS, new String[]{COLUMN_ID, COLUMN_USERNAME, COLUMN_EMAIL},
                    COLUMN_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                user.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
                // Password tidak perlu dikembalikan untuk tujuan edit profile
            }
        } finally {
            if (cursor != null) {
                cursor.close(); // Pastikan kursor ditutup
            }
            db.close(); // Pastikan database ditutup
        }
        return user; // Kembalikan objek pengguna atau null jika tidak ditemukan
    }
}
