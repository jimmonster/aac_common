package com.jinhong.jhtv.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;

import java.util.List;

public class ServiceUtils {
	/**
	 * 判断服务是否运行 
	 * @param context
	 * @param serviceClassName
	 * @return
	 */
	public static boolean isServiceRunning(Context context,String serviceClassName){
		ActivityManager mam = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningServiceInfo> runningServices = mam.getRunningServices(200);
		for (RunningServiceInfo runningServiceInfo : runningServices) {
			if (runningServiceInfo.service.getClassName().equals(serviceClassName)){
				return true;
			}
		}
		return false;
	}
}
