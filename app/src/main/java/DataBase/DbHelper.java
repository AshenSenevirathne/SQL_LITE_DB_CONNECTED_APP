package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DatabaseName = "UserApp.db";

    public DbHelper(Context context) {
        super(context, DatabaseName, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + UserMaster.User.userTable + " (" + UserMaster.User.userID + " INTEGER primary key autoincrement, "
                + UserMaster.User.userName + " TEXT, " + UserMaster.User.userPassword + " TEXT, " + UserMaster.User.userType +" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertData(String name, String password, String type){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserMaster.User.userName, name);
        contentValues.put(UserMaster.User.userPassword, password);
        contentValues.put(UserMaster.User.userType, type);
        long result = database.insert(UserMaster.User.userTable, null, contentValues);
        if (result == -1){
            return false;
        }
        else {
            return true;
        }

    }
}
