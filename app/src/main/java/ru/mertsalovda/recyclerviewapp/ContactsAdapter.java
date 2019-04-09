package ru.mertsalovda.recyclerviewapp;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mertsalovda.recyclerviewapp.mock.Mock;
import ru.mertsalovda.recyclerviewapp.mock.MockHolder;

public class ContactsAdapter extends RecyclerView.Adapter<MockHolder> {

    private Cursor mCursor;
    private OnItemClickListener mListener;

    public void setmListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public OnItemClickListener getmListener() {
        return mListener;
    }

    public interface OnItemClickListener{
        void onItemClick(String id);
    }

    @NonNull
    @Override
    public MockHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Получаю LayoutInflater из контекста
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //Получаю элемент View с разметкой li_mock
        View view = inflater.inflate(R.layout.li_mock, parent, false);
        return new MockHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MockHolder holder, int position) {
        //Двигаем Cursor если есть куда двигать
        if (mCursor.moveToPosition(position)) {
            //Получаем имя и id
            String name = mCursor.getString(mCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            int id = mCursor.getInt(mCursor.getColumnIndex(ContactsContract.Contacts._ID));
            //Помецаем объект в строку RecyclerView
            holder.bind(new Mock(name, id));
            holder.setListener(mListener);
        }
    }

    @Override
    public int getItemCount() {
        return mCursor != null ? mCursor.getCount() : 0;
    }

    public void swapCursor(Cursor cursor) {
        if (cursor != null && cursor != mCursor) {
            if (mCursor != null) {
                mCursor.close();
            }
            mCursor = cursor;
            notifyDataSetChanged();
        }
    }
}
