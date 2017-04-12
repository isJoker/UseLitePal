package com.jokerwan.uselitepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void create_database(View view){
        Connector.getDatabase();
    }

    public void add_data(View view){
        Book book = new Book();
        book.setName("The Da Vinci Code");
        book.setAuthor("Dan Brown");
        book.setPages(454);
        book.setPrice(16.96);
        book.setPress("Unknow");
        book.save();
    }

    public void update_data(View view){
        Book book = new Book();
        //方式一
//        book.setName("The Lost Symbol");
//        book.setAuthor("Dan Brown");
//        book.setPages(696);
//        book.setPrice(11.96);
//        book.setPress("Unknow");
//        book.save();
//        book.setPrice(18.96);
//        book.save();
        //将name 为 The Lost Symbol 和 author 为Dan Brown 的书的价格修改为14.95，出版社修改为Anchor
        //方式二
        book.setPrice(14.95);
        book.setPress("Anchor");
        book.updateAll("name = ? and author = ?", "The Lost Symbol", "Dan Brown");
    }

    public void delete_data(View view){
        //删除价格小于15的书
        DataSupport.deleteAll(Book.class, "price < ?","15");
    }

    public void query_data(View view){
        List<Book> books = DataSupport.findAll(Book.class);
        for (Book book : books) {
            Log.d(TAG, "query_data: " + book.getId());
            Log.d(TAG, "query_data: " + book.getName());
            Log.d(TAG, "query_data: " + book.getAuthor());
            Log.d(TAG, "query_data: " + book.getPrice());
            Log.d(TAG, "query_data: " + book.getPages());
            Log.d(TAG, "query_data: " + book.getPress());
        }
    }
}
