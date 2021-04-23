package com.example.dapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class backgroundprocess extends AsyncTask<String, Void, String> {
    Context context;

    backgroundprocess(Context ctx) {
        this.context = ctx;
    }

    @Override
    protected String doInBackground(String... strings) {

        int type = Integer.parseInt(strings[0]);
        String ip_addr="192.168.43.170";
        switch(type)
        {
            case 1: {

                String login_url = "http://" + ip_addr + "/dapp/login.php";
                try {
                    String username = strings[1];
                    String password = strings[2];
                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&"
                            + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String result = "";

                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            break;
            case 2:
            {
                String login_url = "http://" + ip_addr + "/dapp/register.php";
                try {
                    //username,password,mobile_no,email,name,role

                    String password = strings[1];
                    String mobile_no = strings[2];
                    String email = strings[3];
                    String name = strings[4];
                    String role = strings[5];

                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data =URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                            +URLEncoder.encode("mobile_no","UTF-8")+"="+URLEncoder.encode(mobile_no,"UTF-8")+"&"
                            +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                            +URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"
                            +URLEncoder.encode("role","UTF-8")+"="+URLEncoder.encode(role,"UTF-8");
                    //+URLEncoder.encode("tid","UTF-8")+"="+URLEncoder.encode(tid,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String result="";
                    String line="";
                    while((line = bufferedReader.readLine())!= null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            break;
            case 3:
            {
//                3,product_id,product_name,manufaturing_date
                String login_url = "http://" + ip_addr + "/dapp/userproduct.php";
                try {
                    //username,password,mobile_no,email,name,role
                    String customermobileno=strings[1];
                    String product_id = strings[2];
                    String product_name = strings[3];
                    String manufacture_date = strings[4];

                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("product_id","UTF-8")+"="+URLEncoder.encode(product_id,"UTF-8")+"&"
                            +URLEncoder.encode("product_name","UTF-8")+"="+URLEncoder.encode(product_name,"UTF-8")+"&"
                            +URLEncoder.encode("manufacture_date","UTF-8")+"="+URLEncoder.encode(manufacture_date,"UTF-8")+"&"
                            +URLEncoder.encode("customermobileno","UTF-8")+"="+URLEncoder.encode(customermobileno,"UTF-8");
                    //+URLEncoder.encode("tid","UTF-8")+"="+URLEncoder.encode(tid,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String result="";
                    String line="";
                    while((line = bufferedReader.readLine())!= null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            break;
            case 4:
            {
                String login_url = "http://" + ip_addr + "/dapp/productinfo.php";
                try {
                    String customermobileno=strings[1];

                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("customermobileno","UTF-8")+"="+URLEncoder.encode(customermobileno,"UTF-8");
                    //+URLEncoder.encode("tid","UTF-8")+"="+URLEncoder.encode(tid,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String result="";
                    String line="";
                    while((line = bufferedReader.readLine())!= null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            break;
            case 5:
            {
                String login_url = "http://" + ip_addr + "/dapp/rewards.php";
                try {
                    String customermobileno=strings[1];

                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("customermobileno","UTF-8")+"="+URLEncoder.encode(customermobileno,"UTF-8");
                    //+URLEncoder.encode("tid","UTF-8")+"="+URLEncoder.encode(tid,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String result="";
                    String line="";
                    while((line = bufferedReader.readLine())!= null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            break;
            case 6:
            {
                String login_url = "http://" + ip_addr + "/dapp/fine.php";
                try {
                    String customermobileno=strings[1];

                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("customermobileno","UTF-8")+"="+URLEncoder.encode(customermobileno,"UTF-8");
                    //+URLEncoder.encode("tid","UTF-8")+"="+URLEncoder.encode(tid,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String result="";
                    String line="";
                    while((line = bufferedReader.readLine())!= null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            break;
            case 7:
            {
                String login_url = "http://" + ip_addr + "/dapp/notification.php";
                try {
                    String customermobileno=strings[1];

                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("customermobileno","UTF-8")+"="+URLEncoder.encode(customermobileno,"UTF-8");
                    //+URLEncoder.encode("tid","UTF-8")+"="+URLEncoder.encode(tid,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String result="";
                    String line="";
                    while((line = bufferedReader.readLine())!= null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String resulti) {
        Toast toamst = Toast.makeText(context, resulti, Toast.LENGTH_SHORT);
        toamst.show();
        if(resulti.contains("vin"))
        {
            Toast toast = Toast.makeText(context, "vind", Toast.LENGTH_SHORT);
            toast.show();
        }

        if (resulti == null) {
            Toast toast = Toast.makeText(context, "Network Error", Toast.LENGTH_SHORT);
            toast.show();
        } else if (resulti.contains("3@loginv")) {

            Toast toast = Toast.makeText(context, "collector_pass", Toast.LENGTH_SHORT);
            toast.show();

            context.startActivity(new Intent(context, collector_dashboard.class));
        } else if (resulti.contains("4@loginv")) {
            Toast toast = Toast.makeText(context, "customer_pass", Toast.LENGTH_SHORT);
            toast.show();


            context.startActivity(new Intent(context, customer_dashboard.class));
        } else if (resulti.contains("loginf")) {
            Toast toast = Toast.makeText(context, "fail", Toast.LENGTH_SHORT);
            toast.show();
            context.startActivity(new Intent(context, MainActivity.class));
        }else if (resulti.contains("insertv"))
        {
            Toast toast = Toast.makeText(context, "Inserted", Toast.LENGTH_SHORT);
            toast.show();
            context.startActivity(new Intent(context, MainActivity.class));

        }else if(resulti.contains("insertf"))
        {
            Toast toast = Toast.makeText(context, "Faild", Toast.LENGTH_SHORT);
            toast.show();
            
            context.startActivity(new Intent(context,registration.class));

        }else if (resulti.contains("userproductv"))
        {
            Toast toast = Toast.makeText(context, "userproductv", Toast.LENGTH_SHORT);
            toast.show();
            context.startActivity(new Intent(context, customer_dashboard.class));

        }else if(resulti.contains("userproductf"))
        {
            Toast toast = Toast.makeText(context, "userproductf", Toast.LENGTH_SHORT);
            toast.show();
            context.startActivity(new Intent(context,scanqr.class));

        }else if (resulti.contains("collectorproductv"))
        {
            Toast toast = Toast.makeText(context, "collectorproductv", Toast.LENGTH_SHORT);
            toast.show();
            context.startActivity(new Intent(context, collector_dashboard.class));

        }else if(resulti.contains("collectorproductf"))
        {
            Toast toast = Toast.makeText(context, "collectorproductf", Toast.LENGTH_SHORT);
            toast.show();
            context.startActivity(new Intent(context,scanqr.class));

        }
        else if(resulti.contains("selectproctf"))
        {
            Toast toast = Toast.makeText(context, "selectproctf", Toast.LENGTH_SHORT);
            toast.show();
        }else if (resulti.contains("product_id"))
        {
            Toast toast = Toast.makeText(context, "selectproctv", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
