package cn.jiguang.plugins.push;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.net.Uri;
import android.os.Build;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableMap;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.lang.*;

import cn.jiguang.plugins.push.common.JConstants;
import cn.jiguang.plugins.push.common.JLogger;
import cn.jiguang.plugins.push.helper.JPushHelper;
import cn.jiguang.plugins.push.receiver.JPushBroadcastReceiver;
import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.data.JPushCollectControl;
import cn.jpush.android.data.JPushLocalNotification;

public class JPushModule extends ReactContextBaseJavaModule {

    private final JPushModuleImpl delegate;

    public JPushModule(ReactApplicationContext reactContext) {
        super(reactContext);
        delegate = new JPushModuleImpl(reactContext);
    }

    @Override
    public String getName() {
        return JPushModuleImpl.NAME;
    }

    @ReactMethod
    public void setDebugMode(boolean enable) {
        delegate.setDebugMode(enable);
    }

    @ReactMethod
    public void setupWithConfig(ReadableMap readableMap) {
        delegate.init();
    }

    @ReactMethod
    public void stopPush() {
        delegate.stopPush();
    }

    @ReactMethod
    public void resumePush() {
        delegate.resumePush();
    }

    @ReactMethod
    public void pageEnterTo(String pageName) {
        // delegate.onKillProcess();
    }

    @ReactMethod
    public void pageLeave(String pageName) {
        // delegate.onKillProcess();
    }

    

    @ReactMethod
    public void isPushStopped(Callback callback) {
        delegate.isPushStopped(callback);
    }

    @ReactMethod
    public void setChannel(ReadableMap readableMap) {
        delegate.setChannel(readableMap);
    }

    @ReactMethod
    public void setChannelAndSound(ReadableMap readableMap) {
        delegate.setChannelAndSound(readableMap);
    }

    @ReactMethod
    public void setLinkMergeEnable(boolean enable) {
        delegate.setLinkMergeEnable(enable);
    }

    @ReactMethod
    public void setSmartPushEnable(boolean enable) {
        delegate.setSmartPushEnable(enable);
    }

    @ReactMethod
    public void setDataInsightsEnable(boolean enable) {
        delegate.setDataInsightsEnable(enable);
    }

    @ReactMethod
    public void setGeofenceEnable(boolean enable) {
        delegate.setGeofenceEnable(enable);
    }

    @ReactMethod
    public void setCollectControl(ReadableMap readableMap) {
        delegate.setCollectControl(readableMap);
    }

    @ReactMethod
    public void setBadgeNumber(ReadableMap readableMap) {
        delegate.setBadgeNumber(readableMap);
    }

    @ReactMethod
    public void setPushTime(ReadableMap readableMap) {
        delegate.setPushTime(readableMap);
    }

    @ReactMethod
    public void setSilenceTime(ReadableMap readableMap) {
        delegate.setSilenceTime(readableMap);
    }

    @ReactMethod
    public void getRegistrationID(Callback callback) {
        delegate.getRegistrationID(callback);
    }

    // @ReactMethod
    // public void getUdid(Callback callback) {
    //     delegate.getUdid(callback);
    // }

    @ReactMethod
    public void setLatestNotificationNumber(ReadableMap readableMap) {
        delegate.setLatestNotificationNumber(readableMap);
    }

    // @ReactMethod
    // public void setDefaultPushNotificationBuilder(ReadableMap readableMap) {
    //     delegate.setDefaultPushNotificationBuilder(readableMap);
    // }

    // @ReactMethod
    // public void filterValidTags(ReadableMap readableMap, Callback callback) {
    //     delegate.filterValidTags(readableMap, callback);
    // }

    @ReactMethod
    public void setProperties(ReadableMap readableMap) {
        delegate.setProperties(readableMap);
    }

    @ReactMethod
    public void deleteProperties(ReadableMap readableMap) {
        delegate.deleteProperties(readableMap);
    }

    @ReactMethod
    public void cleanProperties(ReadableMap readableMap) {
        delegate.cleanProperties(readableMap);
    }

    @ReactMethod
    public void setTags(ReadableMap readableMap) {
        delegate.setTags(readableMap);
    }

    @ReactMethod
    public void addTags(ReadableMap readableMap) {
        delegate.addTags(readableMap);
    }

    @ReactMethod
    public void deleteTags(ReadableMap readableMap) {
        delegate.deleteTags(readableMap);
    }

    @ReactMethod
    public void cleanTags(ReadableMap readableMap) {
        delegate.cleanTags(readableMap);
    }

    @ReactMethod
    public void getAllTags(ReadableMap readableMap) {
        delegate.getAllTags(readableMap);
    }

    @ReactMethod
    public void checkTagBindState(ReadableMap readableMap) {
        delegate.checkTagBindState(readableMap);
    }

    @ReactMethod
    public void setAlias(ReadableMap readableMap) {
        delegate.setAlias(readableMap);
    }

    @ReactMethod
    public void deleteAlias(ReadableMap readableMap) {
        delegate.deleteAlias(readableMap);
    }

    @ReactMethod
    public void getAlias(ReadableMap readableMap) {
        delegate.getAlias(readableMap);
    }

    @ReactMethod
    public void setMobileNumber(ReadableMap readableMap) {
        delegate.setMobileNumber(readableMap);
    }

    // @ReactMethod
    // public void onResume() {
    //     delegate.onResume();
    // }

    // @ReactMethod
    // public void onPause() {
    //     delegate.onPause();
    // }

    // @ReactMethod
    // public void onKillProcess() {
    //     delegate.onKillProcess();
    // }

    @ReactMethod
    public void initCrashHandler(ReadableMap readableMap) {
        delegate.initCrashHandler();
    }

    // @ReactMethod
    // public void stopCrashHandler() {
    //     delegate.stopCrashHandler();
    // }

    @ReactMethod
    public void addLocalNotification(ReadableMap readableMap) {
        delegate.addLocalNotification(readableMap);
    }

    @ReactMethod
    public void removeLocalNotification(ReadableMap readableMap) {
        delegate.removeLocalNotification(readableMap);
    }

    @ReactMethod
    public void clearLocalNotifications() {
        delegate.clearLocalNotifications();
    }

    @ReactMethod
    public void requestPermission() {
        delegate.requestPermission();
    }

    // @ReactMethod
    // public void setGeofenceInterval(ReadableMap readableMap) {
    //     delegate.setGeofenceInterval(readableMap);
    // }

    @ReactMethod
    public void setMaxGeofenceNumber(ReadableMap readableMap) {
        delegate.setMaxGeofenceNumber(readableMap);
    }

    @ReactMethod
    public void deleteGeofence(ReadableMap readableMap) {
        delegate.deleteGeofence(readableMap);
    }

    @ReactMethod
    public void clearAllNotifications() {
        delegate.clearAllNotifications();
    }

    @ReactMethod
    public void clearNotificationById(ReadableMap readableMap) {
        delegate.clearNotificationById(readableMap);
    }

    @ReactMethod
    public void setPowerSaveMode(boolean bool) {
        delegate.setPowerSaveMode(bool);
    }

    @ReactMethod
    public void isNotificationEnabled(Callback callback) {
        delegate.isNotificationEnabled(callback);
    }
}