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
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContext;

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


public class JPushModule extends NativeJpushSpec {

    private final JPushModuleImpl delegate;

    public JPushModule(ReactApplicationContext reactContext) {
        super(reactContext);
        delegate = new JPushModuleImpl(reactContext);
    }

    @Override
    public String getName() {
        return JPushModuleImpl.NAME;
    }

    @Override
    public void setDebugMode(boolean enable) {
        delegate.setDebugMode(enable);
    }

    @Override
    public void setupWithConfig(ReadableMap readableMap) {
        delegate.init();
    }

    @Override
    public void stopPush() {
        delegate.stopPush();
    }

    @Override
    public void resumePush() {
        delegate.resumePush();
    }

    @Override
    public void isPushStopped(Callback callback) {
        delegate.isPushStopped(callback);
    }

    @Override
    public void setChannel(ReadableMap readableMap) {
        delegate.setChannel(readableMap);
    }

    @Override
    public void setChannelAndSound(ReadableMap readableMap) {
        delegate.setChannelAndSound(readableMap);
    }

    @Override
    public void setLinkMergeEnable(boolean enable) {
        delegate.setLinkMergeEnable(enable);
    }

    @Override
    public void setSmartPushEnable(boolean enable) {
        delegate.setSmartPushEnable(enable);
    }

    @Override
    public void setDataInsightsEnable(boolean enable) {
        delegate.setDataInsightsEnable(enable);
    }

    @Override
    public void setGeofenceEnable(boolean enable) {
        delegate.setGeofenceEnable(enable);
    }

    @Override
    public void setCollectControl(ReadableMap readableMap) {
        delegate.setCollectControl(readableMap);
    }

    @Override
    public void setBadgeNumber(ReadableMap readableMap) {
        delegate.setBadgeNumber(readableMap);
    }

    @Override
    public void setPushTime(ReadableMap readableMap) {
        delegate.setPushTime(readableMap);
    }

    @Override
    public void setSilenceTime(ReadableMap readableMap) {
        delegate.setSilenceTime(readableMap);
    }

    @Override
    public void getRegistrationID(Callback callback) {
        delegate.getRegistrationID(callback);
    }

    // @Override
    // public void getUdid(Callback callback) {
    //     delegate.getUdid(callback);
    // }

    @Override
    public void setLatestNotificationNumber(ReadableMap readableMap) {
        delegate.setLatestNotificationNumber(readableMap);
    }

    // @Override
    // public void setDefaultPushNotificationBuilder(ReadableMap readableMap) {
    //     delegate.setDefaultPushNotificationBuilder(readableMap);
    // }

    // @Override
    // public void filterValidTags(ReadableMap readableMap, Callback callback) {
    //     delegate.filterValidTags(readableMap, callback);
    // }

    @Override
    public void setProperties(ReadableMap readableMap) {
        delegate.setProperties(readableMap);
    }

    @Override
    public void deleteProperties(ReadableMap readableMap) {
        delegate.deleteProperties(readableMap);
    }

    @Override
    public void cleanProperties(ReadableMap readableMap) {
        delegate.cleanProperties(readableMap);
    }

    @Override
    public void setTags(ReadableMap readableMap) {
        delegate.setTags(readableMap);
    }

    @Override
    public void addTags(ReadableMap readableMap) {
        delegate.addTags(readableMap);
    }

    @Override
    public void deleteTags(ReadableMap readableMap) {
        delegate.deleteTags(readableMap);
    }

    @Override
    public void cleanTags(ReadableMap readableMap) {
        delegate.cleanTags(readableMap);
    }

    @Override
    public void getAllTags(ReadableMap readableMap) {
        delegate.getAllTags(readableMap);
    }

    @Override
    public void checkTagBindState(ReadableMap readableMap) {
        delegate.checkTagBindState(readableMap);
    }

    @Override
    public void setAlias(ReadableMap readableMap) {
        delegate.setAlias(readableMap);
    }

    @Override
    public void deleteAlias(ReadableMap readableMap) {
        delegate.deleteAlias(readableMap);
    }

    @Override
    public void getAlias(ReadableMap readableMap) {
        delegate.getAlias(readableMap);
    }

    @Override
    public void setMobileNumber(ReadableMap readableMap) {
        delegate.setMobileNumber(readableMap);
    }

    // @Override
    // public void onResume() {
    //     delegate.onResume();
    // }

    // @Override
    // public void onPause() {
    //     delegate.onPause();
    // }

    // @Override
    // public void onKillProcess() {
    //     delegate.onKillProcess();
    // }

    @Override
    public void pageEnterTo(String pageName) {
        // delegate.onKillProcess();
    }
    @Override
    public void pageLeave(String pageName) {
        // delegate.onKillProcess();
    }

    

    

    @Override
    public void initCrashHandler(ReadableMap readableMap) {
        delegate.initCrashHandler();
    }

    // @Override
    // public void stopCrashHandler() {
    //     delegate.stopCrashHandler();
    // }

    @Override
    public void addLocalNotification(ReadableMap readableMap) {
        delegate.addLocalNotification(readableMap);
    }

    @Override
    public void removeLocalNotification(ReadableMap readableMap) {
        delegate.removeLocalNotification(readableMap);
    }

    @Override
    public void clearLocalNotifications() {
        delegate.clearLocalNotifications();
    }

    @Override
    public void requestPermission() {
        delegate.requestPermission();
    }

    // @Override
    // public void setGeofenceInterval(ReadableMap readableMap) {
    //     delegate.setGeofenceInterval(readableMap);
    // }

    @Override
    public void setMaxGeofenceNumber(ReadableMap readableMap) {
        delegate.setMaxGeofenceNumber(readableMap);
    }

    @Override
    public void deleteGeofence(ReadableMap readableMap) {
        delegate.deleteGeofence(readableMap);
    }

    @Override
    public void clearAllNotifications() {
        delegate.clearAllNotifications();
    }

    @Override
    public void clearNotificationById(ReadableMap readableMap) {
        delegate.clearNotificationById(readableMap);
    }

    @Override
    public void setPowerSaveMode(boolean bool) {
        delegate.setPowerSaveMode(bool);
    }

    @Override
    public void isNotificationEnabled(Callback callback) {
        delegate.isNotificationEnabled(callback);
    }
}