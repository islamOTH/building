package com.example.singinuo.db;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.singinuo.model.Office;
import com.example.singinuo.model.User;

public class MSP {
    public static final String KEYACTIVEOFFICE = "KEYACTIVEOFFICE";

    public static final String KEYADDRESSOFFICE = "KEYADDRESSOFFICE";

    public static final String KEYEMAILUSER = "KEYEMAILUSER";

    public static final String KEYIDOFFICE = "KEYIDOFFICE";

    public static final String KEYIDUSER = "KEYIDUSER";

    public static final String KEYNAMEOFFICE = "KEYNAMEOFFICE";

    public static final String KEYNAMEUSER = "KEYNAMEUSER";

    public static final String KEYPASSWORDOFFICE = "KEYPASSWORDOFFICE";

    public static final String KEYPASSWORDUSER = "KEYPASSWORD";

    public static final String KEYPHONEOFFICE = "KEYPHONEOFFICE";

    public static final String OFFICEPREF = "OFFICEPREF";

    public static final String USERPREF = "USERPREF";

    private SharedPreferences.Editor editor;

    private Context mContext;

    private SharedPreferences mSharedPreferences;

    public MSP(String paramString, Context paramContext) {
        if (paramString == "USERPREF") {
            this.mSharedPreferences = paramContext.getSharedPreferences(paramString, 0);
        } else if (paramString == "OFFICEPREF") {
            this.mSharedPreferences = paramContext.getSharedPreferences(paramString, 0);
        }
        this.editor = this.mSharedPreferences.edit();
        this.mContext = paramContext;
    }

    public void deleteOffice() {
        this.editor.putInt("KEYIDOFFICE", -1);
        this.editor.apply();
    }

    public void deleteUser() {
        this.editor.putInt("KEYIDUSER", -1);
        this.editor.apply();
    }

    public Office getOfficePref() {
        int i = this.mSharedPreferences.getInt("KEYIDOFFICE", -1);
        if (i != -1) {
            String str1 = this.mSharedPreferences.getString("KEYNAMEOFFICE", null);
            String str2 = this.mSharedPreferences.getString("KEYPASSWORDOFFICE", null);
            return new Office(i, str1, this.mSharedPreferences.getString("KEYADDRESSOFFICE", null), this.mSharedPreferences.getString("KEYPHONEOFFICE", null), str2, this.mSharedPreferences.getInt("KEYACTIVEOFFICE", -1));
        }
        return null;
    }

    public User getUserPref() {
        int i = this.mSharedPreferences.getInt("KEYIDUSER", -1);
        if (i != -1) {
            String str1 = this.mSharedPreferences.getString("KEYNAMEUSER", null);
            String str2 = this.mSharedPreferences.getString("KEYPASSWORD", null);
            return new User(i, this.mSharedPreferences.getString("KEYEMAILUSER", null), str2, str1);
        }
        return null;
    }

    public void setOffice(Office paramOffice) {
        this.editor.putString("KEYNAMEOFFICE", paramOffice.getName());
        this.editor.putString("KEYADDRESSOFFICE", paramOffice.getAddress());
        this.editor.putInt("KEYIDOFFICE", paramOffice.getId());
        this.editor.putString("KEYPHONEOFFICE", paramOffice.getPhone());
        this.editor.putInt("KEYACTIVEOFFICE", paramOffice.getActive());
        this.editor.putString("KEYPASSWORDOFFICE", paramOffice.getPassword());
        this.editor.apply();
    }

    public void setUser(User paramUser) {
        this.editor.putString("KEYNAMEUSER", paramUser.getName());
        this.editor.putString("KEYEMAILUSER", paramUser.getEmail());
        this.editor.putInt("KEYIDUSER", paramUser.getId());
        this.editor.putString("KEYPASSWORD", paramUser.getPassword());
        this.editor.apply();
    }
}
