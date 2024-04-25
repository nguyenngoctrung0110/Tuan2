package com.example.tuan2.Tuan4

import android.content.Context
import android.widget.TextView
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class VolleyFn1 {
    var strJSON=""
    fun getAllData(context: Context, textview: TextView){
        //1. Tao request
        val queue= Volley.newRequestQueue(context);
        //2. truyen url
        val url="https://hungnttg.github.io/array_json_new.json";
        //3. Goi request
        //mang cua cac doi tuong -> goi mang truoc, goi doi tuong sau
        //jsonArrayRequest(url,thanhcong,thatbai)
        val request= JsonArrayRequest(url, {response ->
                                           for (i in 0 until response.length()){
                                               try{
                                                   val person=response.getJSONObject(i)
                                                   val id=person.getString("id")
                                                   val name=person.getString("name")
                                                   val email=person.getString("email")
                                                   // dua tat ca vao chuoi
                                                   strJSON +="Id:$id\n";
                                                   strJSON +="Name:$name\n";
                                                   strJSON +="Email:$email\n";
                                               }
                                               catch (e:Exception){
                                                   e.printStackTrace();
                                               }
                                           }
            textview.text=strJSON //hien thi ket qua len man hinh
        },{ error -> textview.text=error.message});
        //4. Thuc thi request
        queue.add(request)

    }
}