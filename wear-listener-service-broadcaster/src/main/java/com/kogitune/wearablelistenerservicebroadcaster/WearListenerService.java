package com.kogitune.wearablelistenerservicebroadcaster;


import android.content.Intent;
import android.util.Log;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Created by takam on 2014/09/07.
 */
public class WearListenerService extends WearableListenerService {

    private static final String TAG = "WearListenerService";

    public static final String ACTION_WEAR_LISTENER_RECEIVER = "WearListenerReceiver";

    public static final String MESSAGE_EVENT_PATH_KEY = "MESSAGE_EVENT_PATH_KEY";
    public static final String MESSAGE_EVENT_DATA_KEY = "MESSAGE_EVENT_DATA_KEY";
    public static final String MESSAGE_EVENT_REQUEST_ID_KEY = "MESSAGE_EVENT_REQUEST_ID_KEY";
    public static final String MESSAGE_EVENT_SOURCE_NODE_ID_KEY = "MESSAGE_EVENT_SOURCE_NODE_ID_KEY";

    public void onMessageReceived(MessageEvent messageEvent) {
        super.onMessageReceived(messageEvent);
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onMessageReceived");
        }

        final Intent intent = new Intent(ACTION_WEAR_LISTENER_RECEIVER);
        intent.setPackage(getPackageName());
        intent.putExtra(WearListenerService.MESSAGE_EVENT_PATH_KEY, messageEvent.getPath());
        intent.putExtra(WearListenerService.MESSAGE_EVENT_DATA_KEY, messageEvent.getData());
        intent.putExtra(WearListenerService.MESSAGE_EVENT_REQUEST_ID_KEY, messageEvent.getRequestId());
        intent.putExtra(WearListenerService.MESSAGE_EVENT_SOURCE_NODE_ID_KEY, messageEvent.getSourceNodeId());
        sendBroadcast(intent);
    }
}
