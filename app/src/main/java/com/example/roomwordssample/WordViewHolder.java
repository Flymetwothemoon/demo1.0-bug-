package com.example.roomwordssample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordViewHolder extends RecyclerView.Adapter<WordViewHolder.wordViewHolder> {
    private List<stringword>mList;

    public WordViewHolder(List<stringword> list) {
        mList = list;
    }

    @NonNull
    @Override
    public WordViewHolder.wordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new wordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder.wordViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position).word);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class WordDiff extends DiffUtil.ItemCallback<stringword> {

        @Override
        public boolean areItemsTheSame(@NonNull stringword oldItem, @NonNull stringword newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull stringword oldItem, @NonNull stringword newItem) {
            return oldItem.getWord().equals(newItem.getWord());
        }
    }

    public class wordViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView ;
        public wordViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView);
        }
    }
}
