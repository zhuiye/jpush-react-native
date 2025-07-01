import type { TurboModule } from "react-native";
import { TurboModuleRegistry } from "react-native";

export interface Spec extends TurboModule {
  setDebugMode: (enable: boolean) => void;
  setupWithConfig: (obj: Object) => void;
  stopPush(): void;
  resumePush(): void;
  isPushStopped: (cb: () => void) => void;
  setChannel: (obj: Object) => void;
  setChannelAndSound: (obj: Object) => void;
  setLinkMergeEnable: (enable: boolean) => void;
  setSmartPushEnable: (enable: boolean) => void;
  setDataInsightsEnable: (enable: boolean) => void;
  setGeofenceEnable: (enable: boolean) => void;
  setCollectControl: (obj: Object) => void;
  setBadgeNumber: (obj: Object) => void;
  setPushTime: (obj: Object) => void;
  setSilenceTime: (obj: Object) => void;
  getRegistrationID(callback: (id: string) => void): void;
  // getUdid: (cb: () => void) => void;
  setLatestNotificationNumber: (ob: Object) => void;
  // setDefaultPushNotificationBuilder: (ob: Object) => void;
  // filterValidTags: (map: Object, cb: () => void) => void;
  setProperties: (map: Object) => void;
  deleteProperties: (map: Object) => void;
  cleanProperties: (map: Object) => void;
  setTags: (readableMap: Object) => void;
  addTags: (readableMap: Object) => void;
  deleteTags: (readableMap: Object) => void;
  getAllTags: (map: Object) => void;
  checkTagBindState: (map: Object) => void;
  cleanTags: (map: Object) => void;
  setAlias: (map: Object) => void;
  deleteAlias: (map: Object) => void;
  getAlias: (map: Object) => void;
  setMobileNumber: (map: Object) => void;
  pageEnterTo: (pageName: string) => void;
  pageLeave: (pageName: string) => void;

  // onResume: () => void;
  // onPause: () => void;

  // onKillProcess: () => void;

  initCrashHandler: (obj: Object) => void;
  // stopCrashHandler: () => void;

  addLocalNotification: (map: Object) => void;
  removeLocalNotification: (map: Object) => void;
  clearLocalNotifications: () => void;
  requestPermission(): void;

  // setGeofenceInterval: (map: Object) => void;
  setMaxGeofenceNumber: (map: Object) => void;
  deleteGeofence: (map: Object) => void;
  clearAllNotifications: () => void;
  clearNotificationById: (map: Object) => void;
  setPowerSaveMode: (enabled: boolean) => void;

  isNotificationEnabled: (cb: () => void) => void;
}

export default TurboModuleRegistry.getEnforcing<Spec>("JPushModule");
