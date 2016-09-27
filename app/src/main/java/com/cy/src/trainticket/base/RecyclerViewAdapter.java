package com.cy.src.trainticket.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by CY on 2016/3/17.
 */
public abstract class RecyclerViewAdapter<T> extends RecyclerView.Adapter {

    protected List<T> mListData;
    private Object mLock = new Object();

    protected RecyclerViewAdapter() {
        mListData = new ArrayList<>();
    }

    public List<T> getListData() {
        return mListData;
    }

    public void add(int position, T item) {
        synchronized (mLock) {
            getListData().add(position, item);
            notifyItemInserted(position);
        }
    }

    public boolean add(T item) {
        synchronized (mLock) {
            if (getListData().add(item)) {
                int position = getListData().size();
                notifyItemInserted(position - 1);
                return true;
            }
            return false;
        }
    }

    public boolean addAll(T... items) {
        synchronized (mLock) {
            int size = getListData().size();
            if (Collections.addAll(getListData(), items)) {
                notifyItemRangeInserted(size, items.length);
                return true;
            }
            return false;
        }
    }

    public boolean addAll(Collection<T> items) {
        synchronized (mLock) {
            int size = getListData().size();
            if (getListData().addAll(items)) {
                notifyItemRangeInserted(size, items.size());
                return true;
            }
            return false;
        }
    }

    public boolean addAll(int position, Collection<T> items) {
        synchronized (mLock) {
            if (getListData().addAll(position, items)) {
                notifyItemRangeInserted(position, items.size());
                return true;
            }
            return false;
        }
    }

    public T getItem(int position) {
        return getListData().get(position);
    }


    public void clear() {
        synchronized (mLock) {
            int size = getItemCount();
            getListData().clear();
            notifyItemRangeRemoved(0, size);
        }

    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    @Override
    public int getItemCount() {
        return getListData().size();
    }

    public interface OnItemClickListener<T> {
        void onItemClick(View view, T t, int position);
    }
}
