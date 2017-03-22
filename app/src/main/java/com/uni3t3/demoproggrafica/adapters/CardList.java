package com.uni3t3.demoproggrafica.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uni3t3.demoproggrafica.R;
import com.uni3t3.demoproggrafica.sqliteaccess.DBHelper;
import com.uni3t3.demoproggrafica.sqliteaccess.pojos.Noticias;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.CupboardFactory;

/**
 * Created by alvinbaltodano on 3/20/17.
 */

public class CardList extends RecyclerView.Adapter<CardList.ViewHolder> {

    Context context;
    List<Noticias> list;
    private DBHelper helper;
    private SQLiteDatabase db;

    public CardList(Context ctx){
        context = ctx;
        helper = new DBHelper(ctx);
        db = helper.getWritableDatabase();
        //list = getList();
        list = CupboardFactory.cupboard().withDatabase(db).query(Noticias.class).list();
    }

    private ArrayList<Noticias> getList(){
        ArrayList<Noticias> listVideos = new ArrayList<Noticias>();

        Noticias obj;
        obj = new Noticias();
        obj.setTitle("Noticia 1");
        obj.setContent("Content 1");
        obj.setImage_resource(R.drawable.image_test);

        listVideos.add(obj);

        obj = new Noticias();
        obj.setTitle("Noticia 2");
        obj.setContent("Content 2");
        obj.setImage_resource(R.drawable.image_test);

        listVideos.add(obj);

        obj = new Noticias();
        obj.setTitle("Noticia 3");
        obj.setContent("Content 3");
        obj.setImage_resource(R.drawable.image_test);

        listVideos.add(obj);
        return listVideos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.title_card.setText(list.get(position).getTitle());
        holder.content_card.setText(list.get(position).getContent());
        holder.img.setImageResource(list.get(position).getImage_resource());

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView img;
        public TextView title_card;
        public TextView content_card;
        public View card_view;
        public ViewHolder(View itemView){
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            title_card = (TextView) itemView.findViewById(R.id.title);
            content_card = (TextView) itemView.findViewById(R.id.content);
            card_view = itemView;
        }
    }

}
