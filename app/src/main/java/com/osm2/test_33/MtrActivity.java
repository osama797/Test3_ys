package com.osm2.test_33;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MtrActivity extends AppCompatActivity {

    private Button btn;
    private ImageView imageView;
    private final int GALLERY = 1;
    private String upload_URL = "http://ahmed797-001-site1.ftempurl.com/test3.php";
    private RequestQueue rQueue;
    private ArrayList<HashMap<String, String>> arraylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mtr);
//        requestMultiplePermissions();
//
//        btn = findViewById(R.id.uploading);
//        imageView = (ImageView) findViewById(R.id.image_2);
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
//                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//
//                startActivityForResult(galleryIntent, GALLERY);
//            }
//        });

    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == this.RESULT_CANCELED) {
//            return;
//        }
//        if (requestCode == GALLERY) {
//            if (data != null) {
//                Uri contentURI = data.getData();
//                try {
//
//                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
//                     imageView.setImageBitmap(bitmap);
//                    uploadImage(bitmap);
//
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    Toast.makeText(MtrActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
//    }
//
//    private void uploadImage(final Bitmap bitmap){
//
//        VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST, upload_URL,
//                new Response.Listener<NetworkResponse>() {
//                    @Override
//                    public void onResponse(NetworkResponse response) {
//                        Log.d("ressssssoo",response.statusCode+"");
//                     /*   rQueue.getCache().clear();
//                        try {
//                            JSONObject jsonObject = new JSONObject(new String(response.data));
//                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
//
//                            jsonObject.toString().replace("\\\\","");
//
//                            if (jsonObject.getString("status").equals("true")) {
//
//                                arraylist = new ArrayList<HashMap<String, String>>();
//                                JSONArray dataArray = jsonObject.getJSONArray("data");
//
//                                String url = "";
//                                for (int i = 0; i < dataArray.length(); i++) {
//                                    JSONObject dataobj = dataArray.getJSONObject(i);
//                                    url = dataobj.optString("pathToFile");
//                                }
//                                Picasso.get().load(url).into(imageView);
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }٨؟*/
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }) {
//
//            /*
//             * If you want to add more parameters with the image
//             * you can do it here
//             * here we have only one parameter with the image
//             * which is tags
//             * */
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//             //   EditText txt=(EditText) findViewById(R.id.address);
//               //  params.put("tags", txt.toString()); //add string parameters
//                return params;
//            }
//
//            /*
//             *pass files using below method
//             * */
//            @Override
//            protected Map<String, DataPart> getByteData() {
//                Map<String, DataPart> params = new HashMap<>();
//                long imagename = System.currentTimeMillis();
//                params.put("documents[]", new DataPart(imagename + ".jpg", getFileDataFromDrawable(bitmap)));
//                return params;
//            }
//        };
//
//
//        volleyMultipartRequest.setRetryPolicy(new DefaultRetryPolicy(
//                0,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        rQueue = Volley.newRequestQueue(MtrActivity.this);
//        rQueue.add(volleyMultipartRequest);
//    }
//
//    public byte[] getFileDataFromDrawable(Bitmap bitmap) {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 5, byteArrayOutputStream);
//        return byteArrayOutputStream.toByteArray();
//    }
//
//    private void  requestMultiplePermissions(){
//        Dexter.withActivity(this)
//                .withPermissions(
//
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                        Manifest.permission.READ_EXTERNAL_STORAGE)
//                .withListener(new MultiplePermissionsListener() {
//                    @Override
//                    public void onPermissionsChecked(MultiplePermissionsReport report) {
//                        // check if all permissions are granted
//                        if (report.areAllPermissionsGranted()) {
//                            Toast.makeText(getApplicationContext(), "All permissions are granted by user!", Toast.LENGTH_SHORT).show();
//                        }
//
//                        // check for permanent denial of any permission
//                        if (report.isAnyPermissionPermanentlyDenied()) {
//                            // show alert dialog navigating to Settings
//
//                        }
//                    }
//
//                    @Override
//                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
//                        token.continuePermissionRequest();
//                    }
//                }).
//                withErrorListener(new PermissionRequestErrorListener() {
//                    @Override
//                    public void onError(DexterError error) {
//                        Toast.makeText(getApplicationContext(), "Some Error! ", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .onSameThread()
//                .check();
//    }

}