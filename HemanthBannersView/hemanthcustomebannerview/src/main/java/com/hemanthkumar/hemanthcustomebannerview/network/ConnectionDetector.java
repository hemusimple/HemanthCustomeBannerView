package com.hemanthkumar.hemanthcustomebannerview.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by SAFACS on 6/24/2018.
 */

public class ConnectionDetector {

  public  static  boolean checckNetwork(Context context){
      ConnectivityManager connectivityManager
              = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
      if(connectivityManager!=null) {
          NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
          return activeNetworkInfo != null && activeNetworkInfo.isConnected();
      }
     return  false;
  }
}