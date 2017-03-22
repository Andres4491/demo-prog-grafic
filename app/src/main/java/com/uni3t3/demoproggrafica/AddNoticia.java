package com.uni3t3.demoproggrafica;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.uni3t3.demoproggrafica.sqliteaccess.DBHelper;
import com.uni3t3.demoproggrafica.sqliteaccess.pojos.Noticias;

import nl.qbusict.cupboard.CupboardFactory;

public class AddNoticia extends AppCompatActivity {

    EditText title, content;
    Button add;
    private Context context;
    private DBHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_noticia);

        context = this;
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();

        setTitle(null);
        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            topToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }


        title = (EditText) findViewById(R.id.txt_title);
        content = (EditText) findViewById(R.id.txt_content);

        add = (Button) findViewById(R.id.btn_save);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Noticias obj = new Noticias();
                obj.setTitle(title.getText().toString());
                obj.setContent(content.getText().toString());
                obj.setImage_resource(R.drawable.image_test);

                CupboardFactory.cupboard().withDatabase(db).put(obj);

                Intent intent = new Intent(context,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
