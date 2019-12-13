import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:flutter_gtpush/flutter_gtpush.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _clientId = 'Unknown';

  @override
  void initState() {
    super.initState();
//    initPlatformState();
    FlutterGTPush.init();
    getClientId();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> getClientId() async {
    String clientId;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      clientId = await FlutterGTPush.clientId;
    } on PlatformException {
      clientId = 'Failed to get platform version.';
    }

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _clientId = clientId;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('clientId is: $_clientId\n'),
        ),
      ),
    );
  }
}
