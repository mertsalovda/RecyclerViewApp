package ru.mertsalovda.recyclerviewapp;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

public class RecyclerFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener,
        LoaderManager.LoaderCallbacks<Cursor> {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private final ContactsAdapter mContactsAdapter = new ContactsAdapter();

    private View mErrorView;

    private Random random = new Random();

    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Надеваем на фрагмент layout с RecyclerView
        return inflater.inflate(R.layout.fr_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler);
        mSwipeRefreshLayout = view.findViewById(R.id.refresher);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mErrorView = view.findViewById(R.id.error_view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //Устанавливаю адаптер для RecyclerView
        recyclerView.setAdapter(mContactsAdapter);

    }

    @Override
    public void onRefresh() {
//        mSwipeRefreshLayout.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                //Эмитация дачного или неудачного события
//                int count = random.nextInt(4);
//
//                if (count == 0){
//                    showError();
//                } else {
//                    showData(count);
//                }
//                //Если тамп виден, то убрать
//                if (mSwipeRefreshLayout.isRefreshing()){
//                    mSwipeRefreshLayout.setRefreshing(false);
//                }
//            }
//        }, 2000);

        getLoaderManager().restartLoader(0, null, this);
    }

    //Показать данные
//    private void showData(int count) {
//        //Заполняю адаптер данными
//        mockAdapter.addData(MockGenerator.generate(count), true);
//        mErrorView.setVisibility(View.GONE);
//        recyclerView.setVisibility(View.VISIBLE);
//    }

    //Показать ошибку
//    private void showError() {
//        mErrorView.setVisibility(View.VISIBLE);
//        recyclerView.setVisibility(View.GONE);
//    }

    @NonNull
    @Override
    public Loader onCreateLoader(int i, @Nullable Bundle bundle) {
        //Получаем CursorLoader из двух колонок с сортировкой по имени
        return new CursorLoader(getActivity(),
                ContactsContract.Contacts.CONTENT_URI,
                new String[]{ContactsContract.Contacts._ID,
                        ContactsContract.Contacts.DISPLAY_NAME},
                null, null, ContactsContract.Contacts.DISPLAY_NAME);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
        mContactsAdapter.swapCursor(cursor);

        //Если тамп виден, то убрать
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader loader) {

    }
}
