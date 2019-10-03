package DataBase;

import android.provider.BaseColumns;

public class UserMaster {

    private UserMaster(){}

    public  static  class User implements BaseColumns{
        public static final String userTable = "UserTable";
        public static final String userID = "UserID";
        public static final String  userName= "Name";
        public static final String  userPassword= "Password";
        public static final String  userType= "Type";
    }
}
