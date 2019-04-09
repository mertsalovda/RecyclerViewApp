package ru.mertsalovda.recyclerviewapp.mock;

public class Mock {
    private String mName;
    private int mValue;

    public Mock(String mName, int mValue) {
        this.mName = mName;
        this.mValue = mValue;
    }

    public String getName() {
        return mName;
    }

    public String getValue() {
        return String.valueOf(mValue);
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmValue(int mValue) {
        this.mValue = mValue;
    }
}
