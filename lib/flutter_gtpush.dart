import 'dart:async';
import 'dart:ffi';

import 'package:flutter/services.dart';

class FlutterGTPush {
  static const MethodChannel _channel = const MethodChannel('flutter_gtpush');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  /*
   *获取clientId
   */
  static Future<String> get clientId async {
    final String clientId = await _channel.invokeMethod('getClientId');
    return clientId;
  }

  static void showToast() async {
    await _channel.invokeMethod('showToast');
//    return clientId;
  }
}
