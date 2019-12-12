package com.example.dell.quanly.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager {
    public static final String DB_Name = "QuanLy";
    public static final String TB_KhoanYhu = "KhoanThu";
    public static final String TB_LoaiThu = "LoaiThu";
    public static final String TB_KhoanChi = "KhoanChi";
    public static final String TB_LoaiChi = "LoaiChi";
    public static final int DB_VERSION = 1;
    private SQLiteDatabase database;


    private class OpenHeler extends SQLiteOpenHelper {
        public OpenHeler(Context context) {
            super(context, DB_Name, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            String taoKhoanThu = "CREATE TABLE IF NOT EXISTS KhoanThu(_id INTEGER PRIMARY KEY AUTOINCREMENT, KhoanThu TEXT,LoaiThu TEXT,SoTien TEXT,NgayThang TEXT)";
            String taoLoaiThu = "CREATE TABLE IF NOT EXISTS LoaiThu(_id INTEGER PRIMARY KEY AUTOINCREMENT, LoaiThu TEXT)";
            String taoKhoanChi = "CREATE TABLE IF NOT EXISTS KhoanChi(_id INTEGER PRIMARY KEY AUTOINCREMENT, KhoanChi TEXT,LoaiChi TEXT,ChiPhi TEXT,NgayThang TEXT)";
            String taoLoaiChi = "CREATE TABLE IF NOT EXISTS LoaiChi(_id INTEGER PRIMARY KEY AUTOINCREMENT, LoaiChi TEXT)";
            db.execSQL(taoKhoanThu);
            db.execSQL(taoLoaiThu);
            db.execSQL(taoKhoanChi);
            db.execSQL(taoLoaiChi);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS KhoanThu");
            db.execSQL("DROP TABLE IF EXISTS LoaiThu");
            db.execSQL("DROP TABLE IF EXISTS KhoanChi");
            db.execSQL("DROP TABLE IF EXISTS LoaiChi");
            onCreate(db);
        }
    }

    public DatabaseManager(Context context) {
        OpenHeler heler = new OpenHeler(context);
        database = heler.getWritableDatabase();
    }

    public void insertKhoanThu(String KhoanThu, String LoaiThu, String SoTien, String NgayThang) {
        ContentValues values = new ContentValues();
        values.put("KhoanThu", KhoanThu);
        values.put("LoaiThu", LoaiThu);
        values.put("SoTien", SoTien);
        values.put("NgayThang", NgayThang);
        database.insert(TB_KhoanYhu, null, values);

    }


    public Cursor getLoaiThu() {
        return database.query(TB_LoaiThu, null, null, null, null, null, null);
    }

    public void insertLoaiThu(String LoaiThu) {
        ContentValues values = new ContentValues();
        values.put("LoaiThu", LoaiThu);
        database.insert(TB_LoaiThu, null, values);

    }

    public Cursor getKhoanThu() {
        return database.query(TB_KhoanYhu, null, null, null, null, null, null);
    }

    public void insertKhoanChi(String KhoanChi, String LoaiChi, String ChiPhi, String NgatThang) {
        ContentValues values = new ContentValues();
        values.put("KhoanChi", KhoanChi);
        values.put("LoaiChi", LoaiChi);
        values.put("ChiPhi", ChiPhi);
        values.put("NgayThang", NgatThang);
        database.insert(TB_KhoanChi, null, values);

    }

    public Cursor getKhoanChi() {
        return database.query(TB_KhoanChi, null, null, null, null, null, null);
    }

    public void insertLoaiChi(String LoaiChi) {
        ContentValues values = new ContentValues();
        values.put("LoaiChi", LoaiChi);
        database.insert(TB_LoaiChi, null, values);

    }


    public Cursor getLoaiChi() {

        return database.query(TB_LoaiChi, null, null, null, null, null, null);
    }


}



