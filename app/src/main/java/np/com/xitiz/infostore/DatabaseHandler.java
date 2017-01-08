package np.com.xitiz.infostore;

/**
 * Created by xitiz on 12/28/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import np.com.xitiz.infostore.Info;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "infoDatabase";
    private static final String TABLE_DETAILS = "personalDetails";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DATE_OF_BIRTH = "dateOfBirth";
    private static final String KEY_CITIZENSHIP_NUMBER = "citizenShipNumber";
    private static final String KEY_CITIZENSHIP_ISSUE_DATE = "citizenIssueDate";
    private static final String KEY_CITIZENSHIP_ISSUE_PLACE = "citizenIssuePlace";
    private static final String KEY_BANK_NAME = "bankName";
    private static final String KEY_ACC_NUMBER = "accNumber";
    private static final String KEY_FATHER_NAME = "fatherName";
    private static final String KEY_GRAND_FATHER_NAME = "grandFatherName";
    private static final String KEY_DP_ID = "dpID";
    private static final String KEY_CLIENT_ID = "clientID";
    private static final String KEY_ONLINE_PWD = "onlinePassword";
    private static final String KEY_PERMANENT_ADDRESS = "permanentAddress";
    private static final String KEY_CURRENT_ADDRESS = "currentAddress";
    private static final String KEY_IMAGE = "image";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACT_TABLE = "CREATE TABLE " + TABLE_DETAILS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_NAME + " TEXT, " +
                KEY_DATE_OF_BIRTH + " TEXT, " +
                KEY_CITIZENSHIP_NUMBER + " TEXT, " +
                KEY_CITIZENSHIP_ISSUE_DATE + " TEXT, " +
                KEY_CITIZENSHIP_ISSUE_PLACE + " TEXT, " +
                KEY_BANK_NAME + " TEXT, " +
                KEY_ACC_NUMBER + " TEXT, " +
                KEY_FATHER_NAME + " TEXT, " +
                KEY_GRAND_FATHER_NAME + " TEXT, " +
                KEY_DP_ID + " TEXT, " +
                KEY_CLIENT_ID + " TEXT, " +
                KEY_PERMANENT_ADDRESS + " TEXT, " +
                KEY_CURRENT_ADDRESS + " TEXT, " +
                KEY_ONLINE_PWD + " TEXT" +
                ")";
        sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DETAILS);

        onCreate(sqLiteDatabase);
    }

    /**
     * This is used to add a new contact to the database.
     *
     * @param info the data for the record.
     */
    public void addInfo(Info info) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, info.getName());
        contentValues.put(KEY_DATE_OF_BIRTH, info.getDateOfBirth());
        contentValues.put(KEY_CITIZENSHIP_NUMBER, info.getCitizenShipNumber());
        contentValues.put(KEY_CITIZENSHIP_ISSUE_DATE, info.getCitizenShipIssueDate());
        contentValues.put(KEY_CITIZENSHIP_ISSUE_PLACE, info.getCitizenShipIssuePlace());
        contentValues.put(KEY_BANK_NAME, info.getBankName());
        contentValues.put(KEY_ACC_NUMBER, info.getAccNumber());
        contentValues.put(KEY_FATHER_NAME, info.getFatherName());
        contentValues.put(KEY_GRAND_FATHER_NAME, info.getGrandFatherName());
        contentValues.put(KEY_DP_ID, info.getDpID());
        contentValues.put(KEY_CLIENT_ID, info.getClientID());
        contentValues.put(KEY_PERMANENT_ADDRESS, info.getPermanentAdd());
        contentValues.put(KEY_CURRENT_ADDRESS, info.getCurrentAdd());
        contentValues.put(KEY_ONLINE_PWD, info.getOnlinePWD());
        sqLiteDatabase.insert(TABLE_DETAILS, null, contentValues);
//        sqLiteDatabase.close();
    }

    public Info getSingleInfo(int id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //Columns to return;
        String[] query = {KEY_ID,
                KEY_NAME,
                KEY_DATE_OF_BIRTH,
                KEY_CITIZENSHIP_NUMBER,
                KEY_CITIZENSHIP_ISSUE_DATE,
                KEY_CITIZENSHIP_ISSUE_PLACE,
                KEY_BANK_NAME,
                KEY_ACC_NUMBER,
                KEY_FATHER_NAME,
                KEY_GRAND_FATHER_NAME,
                KEY_DP_ID,
                KEY_CLIENT_ID,
                KEY_PERMANENT_ADDRESS,
                KEY_CURRENT_ADDRESS,
                KEY_ONLINE_PWD
        };

        //SELECT * FROM TABLE_NAME WHERE KEY_ID = "String.valueOf(id)"
        String selection = KEY_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = sqLiteDatabase.query(
                TABLE_DETAILS,                         //Table to query
                query,                                  //Columns to return
                selection,                              //Columns for WHERE clause
                selectionArgs,                          //Values for WHERE clause
                null,                                   //don't group by rows
                null,                                   //don't filter by row groups
                null,
                null
        );

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Info info = new Info(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10),
                cursor.getString(11),
                cursor.getString(12),
                cursor.getString(13),
                cursor.getString(14)
        );

/*        cursor.close();
        sqLiteDatabase.close();*/
        return info;
    }

    public List<Info> getAllInfo() {
        List<Info> infoList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_DETAILS;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

//        if(cursor.moveToFirst()){
        while (cursor.moveToNext()) {
            Info info = new Info(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11),
                    cursor.getString(12),
                    cursor.getString(13),
                    cursor.getString(14)
            );
            infoList.add(info);
        }
//        }

        /*cursor.close();
        sqLiteDatabase.close();*/
        return infoList;
    }

    public int getInfoCount() {
        String selectQuery = "SELECT * FROM " + TABLE_DETAILS;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
//        cursor.close();

        return cursor.getCount();
    }

    public int updateInfo(Info info) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, info.getName());
        contentValues.put(KEY_DATE_OF_BIRTH, info.getDateOfBirth());
        contentValues.put(KEY_CITIZENSHIP_NUMBER, info.getCitizenShipNumber());
        contentValues.put(KEY_CITIZENSHIP_ISSUE_DATE, info.getCitizenShipIssueDate());
        contentValues.put(KEY_CITIZENSHIP_ISSUE_PLACE, info.getCitizenShipIssuePlace());
        contentValues.put(KEY_BANK_NAME, info.getBankName());
        contentValues.put(KEY_ACC_NUMBER, info.getAccNumber());
        contentValues.put(KEY_FATHER_NAME, info.getFatherName());
        contentValues.put(KEY_GRAND_FATHER_NAME, info.getGrandFatherName());
        contentValues.put(KEY_DP_ID, info.getDpID());
        contentValues.put(KEY_CLIENT_ID, info.getClientID());
        contentValues.put(KEY_PERMANENT_ADDRESS, info.getPermanentAdd());
        contentValues.put(KEY_CURRENT_ADDRESS, info.getCurrentAdd());
        contentValues.put(KEY_ONLINE_PWD, info.getOnlinePWD());

        String selection = KEY_ID + " = ?";
        String[] selectionArgs = {String.valueOf(info.getId())};

        return sqLiteDatabase.update(
                TABLE_DETAILS,
                contentValues,
                selection,
                selectionArgs
        );
    }



    public int deleteInfo(Info info) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String selection = KEY_ID + " = ?";
        String[] selectionArgs = {String.valueOf(info.getId())};

        return sqLiteDatabase.delete(
                TABLE_DETAILS,
                selection,
                selectionArgs
        );
    }

    public int deleteInfo(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String selection = KEY_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        return sqLiteDatabase.delete(
                TABLE_DETAILS,
                selection,
                selectionArgs
        );
    }
}
