package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Modal.Subjects;
import Modal.User;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DatabaseName = "UserApp.db";

    public DbHelper(Context context) {
        super(context, DatabaseName, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + UserMaster.User.userTable + " (" + UserMaster.User.userID + " INTEGER primary key autoincrement, "
                + UserMaster.User.userName + " TEXT, " + UserMaster.User.userPassword + " TEXT, " + UserMaster.User.userType +" TEXT)");


        sqLiteDatabase.execSQL("CREATE TABLE " + SubjectMaster.Subjects.subTable + " (" + SubjectMaster.Subjects.subID + " INTEGER primary key autoincrement, "
                + SubjectMaster.Subjects.user + " TEXT, " + SubjectMaster.Subjects.subject + " TEXT, " + SubjectMaster.Subjects.massage +" TEXT)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertData(User user){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserMaster.User.userName, user.getName());
        contentValues.put(UserMaster.User.userPassword, user.getPassword());
        contentValues.put(UserMaster.User.userType, user.getType());
        long result = database.insert(UserMaster.User.userTable, null, contentValues);
        if (result == -1){
            return false;
        }
        else {
            return true;
        }

    }

    public List<User> readAll(){
        List<User> list = new ArrayList<>();

        String columns[] = {UserMaster.User.userID, UserMaster.User.userName, UserMaster.User.userPassword, UserMaster.User.userType};
        String sortOrder = UserMaster.User.userName + " desc";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(UserMaster.User.userTable, columns, null, null, null, null, sortOrder);

        while (cursor.moveToNext()){
            User user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndexOrThrow(UserMaster.User.userID)));
            user.setName(cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.User.userName)));
            user.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.User.userPassword)));
            user.setType(cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.User.userType)));

            list.add(user);
        }

        return list;
    }


    public boolean  addMessage (Subjects subjects){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SubjectMaster.Subjects.user, subjects.getUser());
        values.put(SubjectMaster.Subjects.subject, subjects.getSubject());
        values.put(SubjectMaster.Subjects.massage, subjects.getMassage());

        long result = db.insert(SubjectMaster.Subjects.subTable, null, values);
        if (result == -1){
            return false;
        }
        else {
            return true;
        }

    }

    public List<Subjects> readAllMassages(){
        List<Subjects> list = new ArrayList<>();

        String columns[] = {SubjectMaster.Subjects.subID, SubjectMaster.Subjects.user, SubjectMaster.Subjects.subject, SubjectMaster.Subjects.massage};
        String sortOrder = SubjectMaster.Subjects.subID + " desc";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(SubjectMaster.Subjects.subTable, columns, null, null, null, null, sortOrder);

        while (cursor.moveToNext()){
            Subjects subjects =  new Subjects();
            subjects.setId(cursor.getInt(cursor.getColumnIndexOrThrow(SubjectMaster.Subjects.subID)));
            subjects.setUser(cursor.getString(cursor.getColumnIndexOrThrow(SubjectMaster.Subjects.user)));
            subjects.setSubject(cursor.getString(cursor.getColumnIndexOrThrow(SubjectMaster.Subjects.subject)));
            subjects.setMassage(cursor.getString(cursor.getColumnIndexOrThrow(SubjectMaster.Subjects.massage)));

            list.add(subjects);
        }

        return list;
    }

    public User getDetailsByName(String name){

        User user = new User();
        String columns[] = {UserMaster.User.userID, UserMaster.User.userName, UserMaster.User.userPassword, UserMaster.User.userType};
        String sortOrder = UserMaster.User.userName + " desc";
        SQLiteDatabase db = getReadableDatabase();
        String selection = UserMaster.User.userName + " = ?";
        String[] argument = {name};
        Cursor cursor = db.query(UserMaster.User.userTable, columns, selection, argument, null, null, sortOrder);

        while (cursor.moveToNext()){

            user.setId(cursor.getInt(cursor.getColumnIndexOrThrow(UserMaster.User.userID)));
            user.setName(cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.User.userName)));
            user.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.User.userPassword)));
            user.setType(cursor.getString(cursor.getColumnIndexOrThrow(UserMaster.User.userType)));


        }
        return  user;


    }


}
