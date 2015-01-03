package com.kogitune.wearablelistenerservicebroadcaster;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by takam on 2014/09/07.
 */
public class WearListenerService extends WearableListenerService {

    private static final String TAG = "WearListenerService";

    public static final String MESSAGE_EVENT_PATH_KEY = "MESSAGE_EVENT_PATH_KEY";
    public static final String MESSAGE_EVENT_DATA_KEY = "MESSAGE_EVENT_DATA_KEY";
    public static final String MESSAGE_EVENT_REQUEST_ID_KEY = "MESSAGE_EVENT_REQUEST_ID_KEY";
    public static final String MESSAGE_EVENT_SOURCE_NODE_ID_KEY = "MESSAGE_EVENT_SOURCE_NODE_ID_KEY";
    public void onMessageReceived(MessageEvent messageEvent) {
        super.onMessageReceived(messageEvent);
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "WearableListenerService/onMessageReceived");
        }

        final Intent intent = new Intent();
        intent.setPackage(getPackageName());
        intent.putExtra(MESSAGE_EVENT_PATH_KEY, messageEvent.getPath());
        intent.putExtra(MESSAGE_EVENT_DATA_KEY, messageEvent.getData());
        intent.putExtra(MESSAGE_EVENT_REQUEST_ID_KEY, messageEvent.getRequestId());
        intent.putExtra(MESSAGE_EVENT_SOURCE_NODE_ID_KEY, messageEvent.getSourceNodeId());
        sendBroadcast(intent);
    }
}
