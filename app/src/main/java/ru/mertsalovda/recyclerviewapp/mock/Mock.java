package ru.mertsalovda.recyclerviewapp.mock;

public class Mock {
    private String mName;
    private int mValue;

    public Mock(String mName, int mValue) {
        this.mName = mName;
        this.mValue = mValue;
    }

    public String getmName() {
        return mName;
    }

    public String getmValue() {
        return String.valueOf(mValue);
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmValue(int mValue) {
        this.mValue = mValue;
    }
}
