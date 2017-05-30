package com.example.kashif.jussay;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kashif.jussay.APIClasses.ShowMyUsersLists;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by kashif on 29/5/17.
 */

public class AllUserListAdapter extends RecyclerView.Adapter<AllUserListAdapter.AllUserListViewHolder> {


    ArrayList<ShowMyUsersLists> showMyUsersLists = new ArrayList<ShowMyUsersLists>();

    @Override
    public AllUserListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.all_users_list, parent, false);
        return new AllUserListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AllUserListViewHolder holder, int position) {
        holder.setUsersListData(showMyUsersLists.get(position));
    }

    @Override
    public int getItemCount() {
        return showMyUsersLists.size();
    }

    public void setUsersList(ArrayList<ShowMyUsersLists> showMyUsersLists) {
        this.showMyUsersLists = showMyUsersLists;
        notifyDataSetChanged();
    }


// ViewHolder class

    public class AllUserListViewHolder extends RecyclerView.ViewHolder{

        TextView userName_tv;
        TextView userPhone_tv;
        ShowMyUsersLists showMyUsersLists;

        public AllUserListViewHolder(final View itemView) {
            super(itemView);

            userName_tv = (TextView) itemView.findViewById(R.id.user_name_tv);
            userPhone_tv = (TextView) itemView.findViewById(R.id.user_phone_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), GiveRatingActivity.class);
                    Gson gson = new Gson();
                    String parsedArticlesList = gson.toJson(showMyUsersLists);
                    intent.putExtra("intent_extras", parsedArticlesList);
                    itemView.getContext().startActivity(intent);
                }
            });
        }


        public void setUsersListData(ShowMyUsersLists showMyUsersLists) {

            userName_tv.setText(showMyUsersLists.getuserName());
            userPhone_tv.setText(showMyUsersLists.getPhone());
            this.showMyUsersLists = showMyUsersLists;
        }
    }
}
