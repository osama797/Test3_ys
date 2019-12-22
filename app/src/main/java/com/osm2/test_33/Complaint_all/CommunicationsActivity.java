package com.osm2.test_33.Complaint_all;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.osm2.test_33.Complaint_all.model.Complaint;
import com.osm2.test_33.Complaint_all.model.Send_Data;
import com.osm2.test_33.Complaint_all.model.VolleyAppController;
import com.osm2.test_33.R;
import com.osm2.test_33.Send_Card;
import com.osm2.test_33.Send_Data_TEST;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import id.zelory.compressor.Compressor;
import me.drakeet.materialdialog.MaterialDialog;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class CommunicationsActivity extends AppCompatActivity {

    ImageView imgvPhoto_1, imgvPhoto_2, imgvPhoto_3, imgvPhoto_4, imgvPhoto_id_1, imgvPhoto_id_2;
    private final int SELECT_PHOTO = 101;
    private final int CAPTURE_PHOTO = 102;
    private final int SELECT_PHOTO2 = 103;
    private final int CAPTURE_PHOTO2 = 104;
    private final int SELECT_PHOTO3 = 105;
    private final int CAPTURE_PHOTO3 = 106;
    private final int SELECT_PHOTO4 = 107;
    private final int CAPTURE_PHOTO4 = 108;
    private final int SELECT_PHOTO_id_1 = 109;
    private final int CAPTURE_PHOTO_id_1 = 110;
    private final int SELECT_PHOTO_id_2 = 111;
    private final int CAPTURE_PHOTO_id_2 = 112;
    final private int REQUEST_CODE_WRITE_STORAGE = 1;
    public Uri uri;
    public URL url;

    // private static final String URL_PRODUCTS = "http://ahmed797-001-site1.ftempurl.com/uploadimage.php";
    EditText address, name_Product,mark, country, name_company
            , patch_number, day1, month1, year1, day2, month2, year2 ,
            note,name,email,phone;
    Spinner niceSpinner;
    CircularImageView image_2, image_1, image_3, image_4, image_id1, image_id2;
    RequestQueue requestQueue;
    String encoding1, encoding2, encoding3, encoding4, encoding_id1, encoding_id2;

    Bitmap bitmap;

    boolean check = true;

    Button SelectImageGallery, UploadImageServer;

    ImageView imageView;

    EditText imageName;

    ProgressDialog progressDialog;
    boolean isResumed = false;

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.communications);
        initViews();
        initViews_2();
        initViews_3();
        initViews_4();
        initViews_id1();
        initViews_id2();


        //EditText
        address = (EditText) findViewById(R.id.address);
        name_Product = (EditText) findViewById(R.id.name_pro);
        mark = (EditText) findViewById(R.id.name_mark);
        country = (EditText) findViewById(R.id.name_madin);
        name_company = (EditText) findViewById(R.id.name_company_comm);
        patch_number = (EditText) findViewById(R.id.name_no_number);
        day1 = (EditText) findViewById(R.id.tire_size_day);
        month1 = (EditText) findViewById(R.id.tire_size_M);
        year1 = (EditText) findViewById(R.id.tire_size_year);
        day2 = (EditText) findViewById(R.id.tire_size_day2);
        month2 = (EditText) findViewById(R.id.tire_size_M2);
        year2 = (EditText) findViewById(R.id.tire_size_year2);
        note = (EditText) findViewById(R.id.note);
        name = (EditText) findViewById(R.id.name_cust);
        email = (EditText) findViewById(R.id.email_cust);
        phone = (EditText) findViewById(R.id.phone_cust);

        //image
        image_2 = (CircularImageView) findViewById(R.id.image_2);
        image_1 = (CircularImageView) findViewById(R.id.image_1);
        image_3 = (CircularImageView) findViewById(R.id.image_3);
        image_4 = (CircularImageView) findViewById(R.id.image_4);
        image_id1 = (CircularImageView) findViewById(R.id.image_id1);
        image_id2 = (CircularImageView) findViewById(R.id.image_id2);
        //Button
        UploadImageServer = (Button) findViewById(R.id.uploading);



        Typeface mytypeface = Typeface.createFromAsset(getAssets(), "fonts/flat.ttf");
        TextView txtzz = (TextView) findViewById(R.id.text_d);
        txtzz.setTypeface(mytypeface);
        niceSpinner = (Spinner) findViewById(R.id.nice_spinner);


        List<String> dataset = new LinkedList<>(Arrays.asList("نوع البلاغ", "علامة الجوده", "جودة المنتج", "اخرى"));
        ArrayAdapter<String> adapters = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataset);
        adapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        niceSpinner.setAdapter(adapters);
        //niceSpinner.addt(dataset);

        niceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(CommunicationsActivity.this, "Selected: " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

//    public String getStringImage(Bitmap bmp) {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bmp.compress(Bitmap.CompressFormat.JPEG, 50, baos);
//        byte[] imageBytes = baos.toByteArray();
//        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
//        return encodedImage;
//    }
//
//    public void UploadTwoImages() {
//        image_2.buildDrawingCache();
//        image_1.buildDrawingCache();
//        image_3.buildDrawingCache();
//        image_4.buildDrawingCache();
//        image_id1.buildDrawingCache();
//        image_id2.buildDrawingCache();
//
//        Bitmap bitmap2 = image_2.getDrawingCache();
//        Bitmap bitmap1 = image_1.getDrawingCache();
//        Bitmap bitmap3 = image_3.getDrawingCache();
//        Bitmap bitmap4 = image_4.getDrawingCache();
//        Bitmap bitmap_id1 = image_id1.getDrawingCache();
//        Bitmap bitmap_id2 = image_id2.getDrawingCache();
//
//        final String imageOne = getStringImage(bitmap1);
//        final String imageTwo = getStringImage(bitmap2);
//        final String image3 = getStringImage(bitmap3);
//        final String image4 = getStringImage(bitmap4);
//        final String image_id_One = getStringImage(bitmap_id1);
//        final String image_id_Two = getStringImage(bitmap_id2);
//
//        Log.e("ImageTwo", imageTwo);
//        Log.e("ImageOne", imageOne);
//        Log.e("Image3", image3);
//        Log.e("Image4", image4);
//        Log.e("Imageid_1", image_id_One);
//        Log.e("Imageid_2", image_id_Two);
//
//        final ProgressDialog pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Registration is in Process Please wait...");
//        pDialog.show();
//
//        Response.Listener<String> responselistener =new Response.Listener<String>(){
//
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonResponse= new JSONObject(response);
//
//                    boolean success= jsonResponse.getBoolean("Result");
//                    if(success){
//                        pDialog.hide();
//                        Log.e("Result", response);
//                        Toast.makeText(CommunicationsActivity.this,"تم ارسال البيانات بنجاح",Toast.LENGTH_SHORT).show();
//                    }else {
//                        pDialog.hide();
//                        Log.e("Result", response);
//                        Toast.makeText(CommunicationsActivity.this,"لم يتم ارسال البيانات بنجاح",Toast.LENGTH_SHORT).show();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        Send_Data_TEST send_data_test=new Send_Data_TEST(imageTwo,imageOne,image3,image4,image_id_One,image_id_Two,responselistener);
//        RequestQueue queue=Volley.newRequestQueue(CommunicationsActivity.this);
//        queue.add(send_data_test);
////Adding request to request queue
//        // VolleyAppController.getInstance().addToRequestQueue(stringRequest);
//
//    }
//    @Override
//    public void onBackPressed(){
//        Log.d("AlarmAlert", "onBackPressed");
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        isResumed = true;
//        Log.d("AlarmAlert", "onResume");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        isResumed = false;
//        Log.d("AlarmAlert", "onPause");
//    }
//
//    @Override
//    protected void onStop(){
//        super.onStop();
//        if (this.isFinishing()) {
//
//        }
//        Log.d("AlarmAlert", "onStop");
//    }

    public  void btn_send_data(View view){

        Bitmap Bimg=((BitmapDrawable) image_2.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream2=new ByteArrayOutputStream();
        Bimg.compress(Bitmap.CompressFormat.JPEG,5,byteArrayOutputStream2);
        encoding2= Base64.encodeToString(byteArrayOutputStream2.toByteArray(),Base64.DEFAULT);

        //img1
        //   Bitmap Bimg1=((BitmapDrawable) image_1.getDrawable()).getBitmap();
        //  ByteArrayOutputStream byteArrayOutputStream1=new ByteArrayOutputStream();
        //  Bimg1.compress(Bitmap.CompressFormat.JPEG,5,byteArrayOutputStream1);
        // encoding1= Base64.encodeToString(byteArrayOutputStream1.toByteArray(),Base64.DEFAULT);

        //img3
        //  Bitmap Bimg3=((BitmapDrawable) image_3.getDrawable()).getBitmap();
        // ByteArrayOutputStream byteArrayOutputStream3=new ByteArrayOutputStream();
        // Bimg3.compress(Bitmap.CompressFormat.JPEG,5,byteArrayOutputStream3);
        // encoding3= Base64.encodeToString(byteArrayOutputStream3.toByteArray(),Base64.DEFAULT);
        //img4
        // Bitmap Bimg4=((BitmapDrawable) image_4.getDrawable()).getBitmap();
        // ByteArrayOutputStream byteArrayOutputStream4=new ByteArrayOutputStream();
        // Bimg4.compress(Bitmap.CompressFormat.JPEG,5,byteArrayOutputStream4);
        // encoding4= Base64.encodeToString(byteArrayOutputStream4.toByteArray(),Base64.DEFAULT);

        //img_id1
//        Bitmap Bimg_id1=((BitmapDrawable) image_id1.getDrawable()).getBitmap();
        //  ByteArrayOutputStream byteArrayOutputStream_id1=new ByteArrayOutputStream();
        //  Bimg_id1.compress(Bitmap.CompressFormat.JPEG,5,byteArrayOutputStream_id1);
        // encoding_id1= Base64.encodeToString(byteArrayOutputStream_id1.toByteArray(),Base64.DEFAULT);
        //img_id2
        //  Bitmap Bimg_id2=((BitmapDrawable) image_id2.getDrawable()).getBitmap();
        //  ByteArrayOutputStream byteArrayOutputStream_id2=new ByteArrayOutputStream();
        // Bimg_id2.compress(Bitmap.CompressFormat.JPEG,5,byteArrayOutputStream_id2);
        // encoding_id2= Base64.encodeToString(byteArrayOutputStream_id2.toByteArray(),Base64.DEFAULT);

        String sum;
        String xaddress=address.getText().toString();
        String xname_Product=name_Product.getText().toString();
        String xname_mark=mark.getText().toString();
        String xcountry=country.getText().toString();
        String xname_company=name_company.getText().toString();
        String xpatch_number=patch_number.getText().toString();
        String xday1=day1.getText().toString();
        String xmonth1=month1.getText().toString();
        String xyear1=year1.getText().toString();
        String xday2=day2.getText().toString();
        String xmonth2=month2.getText().toString();
        String xyear2=year2.getText().toString();
        String xniceSpinner=niceSpinner.getSelectedItem().toString();
        String xnote=note.getText().toString();
        String xname=name.getText().toString();
        String xemail=email.getText().toString();
        String xphone=phone.getText().toString();
        // Checking whether EditText value is empty or not.

        //sum=xtire_size_year+"/"+xtire_size_M+"/"+xtire_size_day;
// Showing progress dialog at user registration time.
        // final ProgressDialog progressDialog =new ProgressDialog(this);
        //  progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
        // progressDialog.show();

        Response.Listener<String> responselistener =new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse= new JSONObject(response);
                    boolean success= jsonResponse.getBoolean("yes");
                    if(success){
                        // Hiding the progress dialog after all task complete.
                        //  progressDialog.dismiss();
                        Toast.makeText(CommunicationsActivity.this,"تم ارسال البيانات بنجاح",Toast.LENGTH_SHORT).show();
                    }else {
                        // Hiding the progress dialog after all task complete.
                        // progressDialog.dismiss();
                        Toast.makeText(CommunicationsActivity.this,"لم يتم ارسال البيانات بنجاح",Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        // Send_Data send_data=new Send_Data(xaddress,xname_pro,xname_company_comm,sum,xniceSpinner,xnote,encoding2,encoding1,
        //     encoding3,encoding4,xname_cust,xemail_cust,xphone_cust,encoding_id1,encoding_id2,responselistener);
        // RequestQueue queue=Volley.newRequestQueue(CommunicationsActivity.this);
        // queue.add(send_data);

        // Send_Data_TEST send_data_test=new Send_Data_TEST(xaddress,encoding2,responselistener);
        // RequestQueue queue=Volley.newRequestQueue(CommunicationsActivity.this);
        // queue.add(send_data_test);
        Send_Data send_card=new Send_Data(xaddress,xname_Product,xname_mark
                ,xcountry,xname_company,xpatch_number
                ,xday1,xmonth1,xyear1
                ,xday2,xmonth2,xyear2
                ,xniceSpinner,xnote
                ,encoding2//,encoding2,encoding2,encoding2
                ,xname,xemail,xphone
                //,encoding2,encoding2
                ,responselistener);
        RequestQueue queue2=Volley.newRequestQueue(CommunicationsActivity.this);
        queue2.add(send_card);
    }



    public void initViews(){
        imgvPhoto_1 = (ImageView)findViewById(R.id.image_1);


        imgvPhoto_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                int hasWriteStoragePermission = 0;

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    hasWriteStoragePermission = checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
                }

                if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                REQUEST_CODE_WRITE_STORAGE);
                    }
                    //return;
                }

                listDialogue();
            }
        });


    }

    public void initViews_2(){
        imgvPhoto_2 = (ImageView)findViewById(R.id.image_2);

        imgvPhoto_2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                int hasWriteStoragePermission = 0;

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    hasWriteStoragePermission = checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
                }

                if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                REQUEST_CODE_WRITE_STORAGE);
                    }
                    //return;
                }

                listDialogue_2();
            }
        });
    }
    public void initViews_3(){
        imgvPhoto_3 = (ImageView)findViewById(R.id.image_3);

        imgvPhoto_3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                int hasWriteStoragePermission = 0;

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    hasWriteStoragePermission = checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
                }

                if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                REQUEST_CODE_WRITE_STORAGE);
                    }
                    //return;
                }

                listDialogue_3();
            }
        });
    }
    public void initViews_4(){
        imgvPhoto_4 = (ImageView)findViewById(R.id.image_4);

        imgvPhoto_4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                int hasWriteStoragePermission = 0;

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    hasWriteStoragePermission = checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
                }

                if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                REQUEST_CODE_WRITE_STORAGE);
                    }
                    //return;
                }

                listDialogue_4();
            }
        });
    }
    public void initViews_id1(){
        imgvPhoto_id_1 = (ImageView)findViewById(R.id.image_id1);

        imgvPhoto_id_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                int hasWriteStoragePermission = 0;

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    hasWriteStoragePermission = checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
                }

                if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                REQUEST_CODE_WRITE_STORAGE);
                    }
                    //return;
                }

                listDialogue_id1();
            }
        });
    }
    public void initViews_id2(){
        imgvPhoto_id_2 = (ImageView)findViewById(R.id.image_id2);

        imgvPhoto_id_2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                int hasWriteStoragePermission = 0;

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    hasWriteStoragePermission = checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
                }

                if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                REQUEST_CODE_WRITE_STORAGE);
                    }
                    //return;
                }

                listDialogue_id2();
            }
        });
    }

    public void listDialogue(){
        final ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        arrayAdapter.add("Take Photo");
        arrayAdapter.add("Select Gallery");

        ListView listView = new ListView(this);
        listView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        float scale = getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (8 * scale + 0.5f);
        listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
        listView.setDividerHeight(0);
        listView.setAdapter(arrayAdapter);

        final MaterialDialog alert = new MaterialDialog(this).setContentView(listView);

        alert.setPositiveButton("Cancel", new View.OnClickListener() {
            @Override public void onClick(View v) {
                alert.dismiss();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                    alert.dismiss();
                    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //Uri uri  = Uri.parse("file:///sdcard/photo.jpg");
                    String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + "propic.jpg";
                    uri = Uri.parse(root);
                    //i.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    startActivityForResult(i, CAPTURE_PHOTO);

                }else {

                    alert.dismiss();
                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                    photoPickerIntent.setType("image/*");
                    startActivityForResult(photoPickerIntent, SELECT_PHOTO);

                }}

        });

        alert.show();

    }
    public void listDialogue_2(){
        final ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        arrayAdapter.add("Take Photo");
        arrayAdapter.add("Select Gallery");

        ListView listView = new ListView(this);
        listView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        float scale = getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (8 * scale + 0.5f);
        listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
        listView.setDividerHeight(0);
        listView.setAdapter(arrayAdapter);

        final MaterialDialog alert = new MaterialDialog(this).setContentView(listView);

        alert.setPositiveButton("Cancel", new View.OnClickListener() {
            @Override public void onClick(View v) {
                alert.dismiss();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                    alert.dismiss();
                    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //Uri uri  = Uri.parse("file:///sdcard/photo.jpg");
                    String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + "propic2.jpg";
                    uri = Uri.parse(root);
                    //i.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    startActivityForResult(i, CAPTURE_PHOTO2);

                }else {

                    alert.dismiss();
                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                    photoPickerIntent.setType("image/*");
                    startActivityForResult(photoPickerIntent, SELECT_PHOTO2);

                }}

        });

        alert.show();

    }
    public void listDialogue_3(){
        final ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        arrayAdapter.add("Take Photo");
        arrayAdapter.add("Select Gallery");

        ListView listView = new ListView(this);
        listView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        float scale = getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (8 * scale + 0.5f);
        listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
        listView.setDividerHeight(0);
        listView.setAdapter(arrayAdapter);

        final MaterialDialog alert = new MaterialDialog(this).setContentView(listView);

        alert.setPositiveButton("Cancel", new View.OnClickListener() {
            @Override public void onClick(View v) {
                alert.dismiss();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                    alert.dismiss();
                    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //Uri uri  = Uri.parse("file:///sdcard/photo.jpg");
                    String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + "propic3.jpg";
                    uri = Uri.parse(root);
                    //i.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    startActivityForResult(i, CAPTURE_PHOTO3);

                }else {

                    alert.dismiss();
                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                    photoPickerIntent.setType("image/*");
                    startActivityForResult(photoPickerIntent, SELECT_PHOTO3);

                }}

        });

        alert.show();

    }
    public void listDialogue_4(){
        final ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        arrayAdapter.add("Take Photo");
        arrayAdapter.add("Select Gallery");

        ListView listView = new ListView(this);
        listView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        float scale = getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (8 * scale + 0.5f);
        listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
        listView.setDividerHeight(0);
        listView.setAdapter(arrayAdapter);

        final MaterialDialog alert = new MaterialDialog(this).setContentView(listView);

        alert.setPositiveButton("Cancel", new View.OnClickListener() {
            @Override public void onClick(View v) {
                alert.dismiss();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                    alert.dismiss();
                    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //Uri uri  = Uri.parse("file:///sdcard/photo.jpg");
                    String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + "propic4.jpg";
                    uri = Uri.parse(root);
                    //i.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    startActivityForResult(i, CAPTURE_PHOTO4);

                }else {

                    alert.dismiss();
                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                    photoPickerIntent.setType("image/*");
                    startActivityForResult(photoPickerIntent, SELECT_PHOTO4);

                }}

        });

        alert.show();

    }
    public void listDialogue_id1(){
        final ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        arrayAdapter.add("Take Photo");
        arrayAdapter.add("Select Gallery");

        ListView listView = new ListView(this);
        listView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        float scale = getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (8 * scale + 0.5f);
        listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
        listView.setDividerHeight(0);
        listView.setAdapter(arrayAdapter);

        final MaterialDialog alert = new MaterialDialog(this).setContentView(listView);

        alert.setPositiveButton("Cancel", new View.OnClickListener() {
            @Override public void onClick(View v) {
                alert.dismiss();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                    alert.dismiss();
                    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //Uri uri  = Uri.parse("file:///sdcard/photo.jpg");
                    String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + "propic4.jpg";
                    uri = Uri.parse(root);
                    //i.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    startActivityForResult(i, CAPTURE_PHOTO_id_1);

                }else {

                    alert.dismiss();
                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                    photoPickerIntent.setType("image/*");
                    startActivityForResult(photoPickerIntent, SELECT_PHOTO_id_1);

                }}

        });

        alert.show();

    }
    public void listDialogue_id2(){
        final ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        arrayAdapter.add("Take Photo");
        arrayAdapter.add("Select Gallery");

        ListView listView = new ListView(this);
        listView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        float scale = getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (8 * scale + 0.5f);
        listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
        listView.setDividerHeight(0);
        listView.setAdapter(arrayAdapter);

        final MaterialDialog alert = new MaterialDialog(this).setContentView(listView);

        alert.setPositiveButton("Cancel", new View.OnClickListener() {
            @Override public void onClick(View v) {
                alert.dismiss();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                    alert.dismiss();
                    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //Uri uri  = Uri.parse("file:///sdcard/photo.jpg");
                    String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + "propic4.jpg";
                    uri = Uri.parse(root);
                    //i.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    startActivityForResult(i, CAPTURE_PHOTO_id_2);

                }else {

                    alert.dismiss();
                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                    photoPickerIntent.setType("image/*");
                    startActivityForResult(photoPickerIntent, SELECT_PHOTO_id_2);

                }}

        });

        alert.show();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case SELECT_PHOTO:
                if (resultCode == RESULT_OK) {

                    Uri imageUri = imageReturnedIntent.getData();
                    String selectedImagePath = getPath(imageUri);
                    File f = new File(selectedImagePath);
                    Bitmap bmp = Compressor.getDefault(this).compressToBitmap(f);

                    imgvPhoto_1.setImageBitmap(bmp);


                }
                break;
            case SELECT_PHOTO2:
                if (resultCode == RESULT_OK) {

                    Uri imageUri = imageReturnedIntent.getData();
                    String selectedImagePath = getPath(imageUri);
                    File f = new File(selectedImagePath);
                    Bitmap bmp = Compressor.getDefault(this).compressToBitmap(f);

                    imgvPhoto_2.setImageBitmap(bmp);

                }
                break;
            case SELECT_PHOTO3:
                if (resultCode == RESULT_OK) {

                    Uri imageUri = imageReturnedIntent.getData();
                    String selectedImagePath = getPath(imageUri);
                    File f = new File(selectedImagePath);
                    Bitmap bmp = Compressor.getDefault(this).compressToBitmap(f);

                    imgvPhoto_3.setImageBitmap(bmp);

                }
                break;
            case SELECT_PHOTO4:
                if (resultCode == RESULT_OK) {

                    Uri imageUri = imageReturnedIntent.getData();
                    String selectedImagePath = getPath(imageUri);
                    File f = new File(selectedImagePath);
                    Bitmap bmp = Compressor.getDefault(this).compressToBitmap(f);

                    imgvPhoto_4.setImageBitmap(bmp);

                }
                break;
            case SELECT_PHOTO_id_1:
                if (resultCode == RESULT_OK) {

                    Uri imageUri = imageReturnedIntent.getData();
                    String selectedImagePath = getPath(imageUri);
                    File f = new File(selectedImagePath);
                    Bitmap bmp = Compressor.getDefault(this).compressToBitmap(f);

                    imgvPhoto_id_1.setImageBitmap(bmp);

                }
                break;
            case SELECT_PHOTO_id_2:
                if (resultCode == RESULT_OK) {

                    Uri imageUri = imageReturnedIntent.getData();
                    String selectedImagePath = getPath(imageUri);
                    File f = new File(selectedImagePath);
                    Bitmap bmp = Compressor.getDefault(this).compressToBitmap(f);

                    imgvPhoto_id_2.setImageBitmap(bmp);

                }
                break;


            case CAPTURE_PHOTO:
                if (resultCode == RESULT_OK) {

                    Bitmap bmp = imageReturnedIntent.getExtras().getParcelable("data");

                    imgvPhoto_1.setImageBitmap(bmp);
                }

                break;
            case CAPTURE_PHOTO2:
                if (resultCode == RESULT_OK) {

                    Bitmap bmp = imageReturnedIntent.getExtras().getParcelable("data");


                    imgvPhoto_2.setImageBitmap(bmp);
                }

                break;
            case CAPTURE_PHOTO3:
                if (resultCode == RESULT_OK) {

                    Bitmap bmp = imageReturnedIntent.getExtras().getParcelable("data");


                    imgvPhoto_3.setImageBitmap(bmp);
                }

                break;
            case CAPTURE_PHOTO4:
                if (resultCode == RESULT_OK) {

                    Bitmap bmp = imageReturnedIntent.getExtras().getParcelable("data");


                    imgvPhoto_4.setImageBitmap(bmp);
                }

                break;
            case CAPTURE_PHOTO_id_1:
                if (resultCode == RESULT_OK) {

                    Bitmap bmp = imageReturnedIntent.getExtras().getParcelable("data");


                    imgvPhoto_id_1.setImageBitmap(bmp);
                }

                break;
            case CAPTURE_PHOTO_id_2:
                if (resultCode == RESULT_OK) {

                    Bitmap bmp = imageReturnedIntent.getExtras().getParcelable("data");


                    imgvPhoto_id_2.setImageBitmap(bmp);
                }

                break;
        }
    }


    public String getPath(Uri uri) {
        // just some safety built in
        if (uri == null) {
            return null;
        }
        // try to retrieve the image from the media store first
        // this will only work for images selected from gallery
        String[] projection = {MediaStore.Images.Media.DATA};
        @SuppressWarnings("deprecation")
        Cursor cursor = managedQuery(uri, projection, null, null,
                null);
        if (cursor != null) {
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        // this is our fallback here
        return uri.getPath();
    }}


//     public  void btn_send_data(View view){
//
//        Bitmap Bimg=((BitmapDrawable) image_2.getDrawable()).getBitmap();
//        ByteArrayOutputStream byteArrayOutputStream2=new ByteArrayOutputStream();
//        Bimg.compress(Bitmap.CompressFormat.JPEG,5,byteArrayOutputStream2);
//        encoding2= Base64.encodeToString(byteArrayOutputStream2.toByteArray(),Base64.DEFAULT);
//
//        //img1
//     //   Bitmap Bimg1=((BitmapDrawable) image_1.getDrawable()).getBitmap();
//      //  ByteArrayOutputStream byteArrayOutputStream1=new ByteArrayOutputStream();
//      //  Bimg1.compress(Bitmap.CompressFormat.JPEG,5,byteArrayOutputStream1);
//       // encoding1= Base64.encodeToString(byteArrayOutputStream1.toByteArray(),Base64.DEFAULT);
//
//        //img3
//      //  Bitmap Bimg3=((BitmapDrawable) image_3.getDrawable()).getBitmap();
//       // ByteArrayOutputStream byteArrayOutputStream3=new ByteArrayOutputStream();
//       // Bimg3.compress(Bitmap.CompressFormat.JPEG,5,byteArrayOutputStream3);
//       // encoding3= Base64.encodeToString(byteArrayOutputStream3.toByteArray(),Base64.DEFAULT);
//        //img4
//       // Bitmap Bimg4=((BitmapDrawable) image_4.getDrawable()).getBitmap();
//       // ByteArrayOutputStream byteArrayOutputStream4=new ByteArrayOutputStream();
//       // Bimg4.compress(Bitmap.CompressFormat.JPEG,5,byteArrayOutputStream4);
//       // encoding4= Base64.encodeToString(byteArrayOutputStream4.toByteArray(),Base64.DEFAULT);
//
//        //img_id1
////        Bitmap Bimg_id1=((BitmapDrawable) image_id1.getDrawable()).getBitmap();
//      //  ByteArrayOutputStream byteArrayOutputStream_id1=new ByteArrayOutputStream();
//      //  Bimg_id1.compress(Bitmap.CompressFormat.JPEG,5,byteArrayOutputStream_id1);
//       // encoding_id1= Base64.encodeToString(byteArrayOutputStream_id1.toByteArray(),Base64.DEFAULT);
//        //img_id2
//      //  Bitmap Bimg_id2=((BitmapDrawable) image_id2.getDrawable()).getBitmap();
//      //  ByteArrayOutputStream byteArrayOutputStream_id2=new ByteArrayOutputStream();
//       // Bimg_id2.compress(Bitmap.CompressFormat.JPEG,5,byteArrayOutputStream_id2);
//       // encoding_id2= Base64.encodeToString(byteArrayOutputStream_id2.toByteArray(),Base64.DEFAULT);
//
//        String sum;
//        String xaddress=address.getText().toString();
//        String xname_pro=name_pro.getText().toString();
//        String xname_company_comm=name_company_comm.getText().toString();
//        String xtire_size_day=tire_size_day.getText().toString();
//        String xtire_size_M=tire_size_M.getText().toString();
//        String xtire_size_year=tire_size_year.getText().toString();
//        String xniceSpinner=niceSpinner.getSelectedItem().toString();
//        String xnote=note.getText().toString();
//        String xname_cust=name_cust.getText().toString();
//        String xemail_cust=email_cust.getText().toString();
//        String xphone_cust=phone_cust.getText().toString();
//        // Checking whether EditText value is empty or not.
//
//        sum=xtire_size_year+"/"+xtire_size_M+"/"+xtire_size_day;
//// Showing progress dialog at user registration time.
//       // final ProgressDialog progressDialog =new ProgressDialog(this);
//      //  progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
//       // progressDialog.show();
//
//        Response.Listener<String> responselistener =new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonResponse= new JSONObject(response);
//                    boolean success= jsonResponse.getBoolean("yes");
//                    if(success){
//                        // Hiding the progress dialog after all task complete.
//                      //  progressDialog.dismiss();
//                         Toast.makeText(CommunicationsActivity.this,"تم ارسال البيانات بنجاح",Toast.LENGTH_SHORT).show();
//                    }else {
//                        // Hiding the progress dialog after all task complete.
//                       // progressDialog.dismiss();
//                        Toast.makeText(CommunicationsActivity.this,"لم يتم ارسال البيانات بنجاح",Toast.LENGTH_SHORT).show();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//       // Send_Data send_data=new Send_Data(xaddress,xname_pro,xname_company_comm,sum,xniceSpinner,xnote,encoding2,encoding1,
//           //     encoding3,encoding4,xname_cust,xemail_cust,xphone_cust,encoding_id1,encoding_id2,responselistener);
//       // RequestQueue queue=Volley.newRequestQueue(CommunicationsActivity.this);
//       // queue.add(send_data);
//
//       // Send_Data_TEST send_data_test=new Send_Data_TEST(xaddress,encoding2,responselistener);
//       // RequestQueue queue=Volley.newRequestQueue(CommunicationsActivity.this);
//        // queue.add(send_data_test);
//        Send_Card send_card=new Send_Card(xaddress,xname_pro,xname_company_comm,sum,xniceSpinner,xnote,encoding2,xname_cust,xemail_cust,xphone_cust,responselistener);
//        RequestQueue queue2=Volley.newRequestQueue(CommunicationsActivity.this);
//        queue2.add(send_card);
//    }

