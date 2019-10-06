package DataBase;

import android.provider.BaseColumns;


public final class SubjectMaster {

    private SubjectMaster(){}


    public  static  class Subjects implements BaseColumns{
        public static final String subTable = "SubTable";
        public static final String subID = "SubID";
        public static final String  user = "User";
        public static final String  subject = "Subject";
        public static final String  massage = "Massage";
    }
}
