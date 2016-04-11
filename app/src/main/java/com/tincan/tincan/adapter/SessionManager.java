package com.tincan.tincan.adapter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.sip.SipManager;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class SessionManager {
    Context context;
    public SessionManager(Context context){
        context = context;
    }

    /*Check if the device is connected to the Internet, getAllNetworkInfo()
    was deprecated and replaced with getActiveNetworkInfo() */
        public boolean isOnline(){
        ConnectivityManager cn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(cn != null){
            NetworkInfo ni = cn.getActiveNetworkInfo();
            if (ni != null && ni.getState() == NetworkInfo.State.CONNECTED){
                return true;
            }
        }
        return false;
    }

    public boolean isAPISupported(){
        return SipManager.isApiSupported(context);
    }

    /*Implement AES Encryption*/
    public static byte[] encrypt(String key, String value) throws GeneralSecurityException{
        byte[] raw = key.getBytes(Charset.forName("US-ASCII"));
        if (raw.length != 16) {
            throw new IllegalArgumentException("Invalid key size.");
        }
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(new byte[16]));
        return cipher.doFinal(value.getBytes(Charset.forName("US-ASCII")));
    }
}
