import 'dart:async';
import 'dart:ffi';

import 'package:flutter/services.dart';

class FlutterGTPush {
  static const MethodChannel _channel = const MethodChannel('flutter_gtpush');

  static void init() async {
    _channel.setMethodCallHandler(_handler);
    await _channel.invokeMethod('init');
  }

  static Future<dynamic> _handler(MethodCall call) {
    String method = call.method;
    switch (method) {
      case 'receiveClientId':
        print('flutter收到了clientId============>>>>>>>${call.arguments}');
        break;
    }
    return new Future.value(null);
  }

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
